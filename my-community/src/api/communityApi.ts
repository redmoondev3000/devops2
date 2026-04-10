import axios from "axios";
import type { MemberDTO, NoticeDTO } from "../types/Community";

const instance = axios.create({
  baseURL: "http://localhost:8080/api",
  withCredentials: true, //세션공유
});

export const communityApi = {
  //member
  login: (data: MemberDTO) => instance.post("/member/login", data),
  join: (data: MemberDTO) => instance.post("/member/join", data),
  logout: () => instance.get("/member/logout"),
  idCheck: (userid: string) =>
    instance
      .get<number>(`/member/idCheck?userid=${userid}`)
      .then((res) => res.data),

  //notice
  getList: () =>
    instance.get<NoticeDTO[]>("/notice/list").then((res) => res.data),
  getDetail: (id: number) =>
    instance.get<NoticeDTO>(`/notice/detail/${id}`).then((res) => res.data),
  write: (data: Partial<NoticeDTO>) => instance.post("/notice/write", data),
  update: (data: NoticeDTO) => instance.put("/notice/update", data),
  delete: (id: number) => instance.delete(`/notice/delete/${id}`),
};
