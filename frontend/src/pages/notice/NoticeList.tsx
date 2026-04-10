import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { communityApi } from "../../api/communityApi";
import type { NoticeDTO } from "../../types/Community";
import "./NoticeList.css";

const NoticeList = () => {
  const [list, setList] = useState<NoticeDTO[]>([]);
  const navigate = useNavigate();

  useEffect(() => {
    communityApi
      .getList()
      .then((res) => setList(res))
      .catch((err) => console.error("목록 로딩 실패:", err));
  }, []);

  return (
    <div className="list-container">
      <h2 className="list-title">공지사항</h2>
      <table className="board-table">
        <thead>
          <tr>
            <th style={{ width: "10%" }}>번호</th>
            <th style={{ width: "50%" }}>제목</th>
            <th style={{ width: "20%" }}>작성자</th>
            <th style={{ width: "20%" }}>날짜</th>
          </tr>
        </thead>

        <tbody>
          {list.length > 0 ? (
            list.map((item) => (
              <tr
                key={item.id}
                onClick={() => navigate(`/notice/detail/${item.id}`)}
                style={{ cursor: "pointer" }}
              >
                <td>{item.id}</td>
                <td>
                  <span className="title-link">{item.title}</span>
                </td>
                <td>{item.writer}</td>
                <td>{item.regDate ? item.regDate.substring(0, 10) : "-"}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan={4}>등록된 게시글이 없습니다.</td>
            </tr>
          )}
        </tbody>
      </table>

      <div className="btn-area">
        <button className="btn-write" onClick={() => navigate("/notice/write")}>
          글쓰기
        </button>
      </div>
    </div>
  );
};

export default NoticeList;
