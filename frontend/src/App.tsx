import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Layout from "./components/Layout";
import Join from "./pages/member/Join";
import Login from "./pages/member/Login";
import NoticeList from "./pages/notice/NoticeList";
import NoticeDetail from "./pages/notice/NoticeDetail";
import NoticeForm from "./pages/notice/NoticeForm";

function App() {
  return (
    <Router>
      <Routes>
        <Route element={<Layout />}>
          <Route path="/" />
          <Route path="/login" element={<Login />} />
          <Route path="/join" element={<Join />} />
          <Route path="/notice/list" element={<NoticeList />} />
          <Route path="/notice/detail/:id" element={<NoticeDetail />} />
          <Route path="/notice/write" element={<NoticeForm />} />
          <Route path="/notice/update/:id" element={<NoticeForm />} />
        </Route>
      </Routes>
    </Router>
  );
}

export default App;
