<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <link rel="icon" href="/Content/public/images/it_spkt.png" type="image/x-icon" />
    <link rel="shortcut icon" href="/Content/public/images/it_spkt.png" />
    <title>::. Th&#244;ng b&#225;o .::</title>
    <link rel="stylesheet" media="all" type="text/css" href="/Content/public/css/bootstrap.min.css" />
    <link rel="stylesheet" media="all" type="text/css" href="/Content/public/css/style.css" />
    <link rel="stylesheet" media="all" type="text/css" href="/Content/public/css/footable.core.css" />
    <link rel="stylesheet" media="all" type="text/css" href="/Content/public/css/footable.standalone.css" />
    <link href="/Content/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" />
    <link href="/Content/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" />

    <script type="text/javascript" src="/Content/public/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/Content/public/js/footable.js"></script>
    <script type="text/javascript" src="/Content/public/js/my_script.js"></script>
    <script src="/Content/public/ckeditor/ckeditor.js"></script>
    <link href="/Content/public/datepicker/jquery.simple-dtpicker.css" rel="stylesheet" />
    <script src="/Content/public/datepicker/jquery.simple-dtpicker.js"></script>
 
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!--[if gt IE 8]>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" >
    <![endif]-->
    <!-- Font Awesom core -->
    <!--[if IE 7]>
      <link rel="stylesheet" href="http://dkdt.fit.hcmute.edu.vn/public/font-awesome/css/font-awesome-ie7.min.css">
      <link rel="stylesheet" href="http://dkdt.fit.hcmute.edu.vn/public/font-awesome/css/bootstrap-ie7.css">
    <![endif]-->
</head>
<body>
    <div id="menu">
       <li class="list-group-item" style="text-align: right;font-weight:bold;font-family:verdana;background-color:#efefef;">Danh Má»¥c</li>
        <a href="/Home/Index" class="list-group-item"><img src="/Content/public/images/house-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Trang Chá»§</a>
        <a href="/Home/LoaiDeTai" class="list-group-item "><img src="/Content/public/images/Actions-view-calendar-list-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Danh sÃ¡ch Äá» tÃ i</a>
        <a href="/Home/ThongTinGiangVien" class="list-group-item "><img src="/Content/public/images/Teacher-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> ThÃ´ng tin giáº£ng viÃªn</a>
        <a href="/Home/ThongTinSinhVien" class="list-group-item "><img src="/Content/public/images/Student-3-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> ThÃ´ng tin sinh viÃªn</a>
        <a href="/Home/HuongDanDangKy" class="list-group-item "><img src="/Content/public/images/Actions-help-contents-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> HÆ°á»ng dáº«n ÄÄng kÃ½</a>
        <a href="/Home/ThongKe" class="list-group-item "><img src="/Content/public/images/chart-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Thá»ng kÃª</a>
        <a data-toggle="modal" href="#seach_box" class="list-group-item"><img src="/Content/public/images/Search-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> TÃ¬m kiáº¿m</a>
        <hr />

        


      
    </div>
    <div id="container">
        
        

<div id="mobile-bar">
    <span style="cursor: pointer;" class="pull-left" href="javascript:;" onclick="slideMenu(); return false;" id="slideicon"><i class="icon-reorder"></i></span>
        <span data-toggle="modal" href="#dang_nhap" class="pull-right btn btn-default btn-sm" id="#">Sign In</span>
        <p style="text-align: center;font-weight:bold;">ÄÄng kÃ½ Äá» tÃ i</p>
</div>
        <div id="navigation">
            <div id="banner-desktop">
                <div class="container">
                    <div id="banner">
                        <div id="login-area">
                                   <a data-toggle="modal" href="#dang_nhap"><img src="/Content/public/images/Login-icon.png" width="24" height="24" /> ÄÄng nháº­p</a>



                        </div>
                    </div>
                </div>
            </div>
            <!-- ############################ ÄÄng nháº­p ############################## -->
            <div class="modal fade" id="dang_nhap">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <!-- <h4 class="modal-title">ÄÄng nháº­p</h4> -->
                        </div>
                        <form method="post" action="/Home/DangNhap" id="frm-login">
                            <div class="modal-body">
                                <div id="err_login"></div>
                                <div id="login_here">
                                    <label>Username : </label>
                                    <input type="text" class="form-control" name="username" id="username" />
                                    <label>Password : </label>
                                    <input type="password" class="form-control" name="password" id="password" />
                                    <br />
                                    <a href="/Home/QuenMatKhau" class="text-danger">QuÃªn máº­t kháº©u</a>
                                </div>
                                <br />
                                <div id="waiting" style="display: none;">
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" id="login_btn">ÄÄng nháº­p</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!-- ===================================ThÃ´ng tin ngÆ°á»i dÃ¹ng=========================-->
            <div class="modal fade" id="thong_tin">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">ThÃ´ng tin ngÆ°á»i dÃ¹ng</h4>
                        </div>

                    

                    


                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!-- ===================================Ajax Login=========================-->
            <script>
                $(document).ready(function () {
                    $("#frm-login").submit(function (e) {
                        if ($("#username").val() == '') {
                            $('#err_login').html('<div class="alert alert-danger">Username chÆ°a nháº­p</div>');
                            $("#username").focus();
                            return false;
                        }
                        else if ($("#password").val() == '') {
                            $('#err_login').html('<div class="alert alert-danger">Password chÆ°a nháº­p</div>');
                            $("#password").focus();
                            return false;
                        }
                        else {
                            var form_data_login = {
                                username: $("#username").val(),
                                password: $("#password").val()
                            };
                            $.ajax({
                                url: '/Home/DangNhap',
                                type: 'POST',
                                async: true,
                                data: form_data_login,
                                success: function (msg_login) {
                                    //alert(msg);
                                    if (msg_login == 'false') {
                                        $('#err_login').html('<div class="alert alert-danger">TÃªn hoáº·c máº­t kháº©u khÃ´ng chÃ­nh xÃ¡c</div>');
                                        $("#password").val("");
                                        $("#password").focus();
                                        return false;
                                    }
                                    else if(msg_login=='er_block')
                                    {
                                        $('#err_login').html('<div class="alert alert-danger">TÃ i khoáº£n Äang bá» khÃ³a</div>');
                                    }
                                    else {
                                        $("#login_here").hide();
                                        $(".modal-footer").hide();

                                        $('#err_login').html('<div class="alert alert-success"><strong>ÄÄng nháº­p thÃ nh cÃ´ng</strong><span> Há» thá»ng tá»± chuyá»n sau vÃ i giÃ¢y ...</span></div>');
                                        setTimeout(
                                           //chuyá»n Äáº¿n Äá»a chá» msg_login cá»§a controler gá»­i qua
                                          function () {
                                              window.location.href = '' + msg_login + '';
                                          }, 2000);
                                    }
                                }
                            });
                            return false;
                        }
                    });
                })
                //Load wating bar
                $(document).ajaxStart(function () {
                    $("#waiting").show();
                }).ajaxStop(function () {
                    $("#waiting").hide();
                });
            </script>

        </div>
        <div id="wrapper">
            <div class="container">
                <div class="row">
                    <div id="left-content">
                        <div class="col-md-3">
                            <!-- Menu desktop -->
                            <div id="desktop-menu">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 id="mobile_home">Danh Má»¥c</h4>
                                    </div>
                                    
                                    <a href="/Home/Index" class="list-group-item"><img src="/Content/public/images/house-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Trang Chá»§</a>
                                    <a href="/Home/LoaiDeTai" class="list-group-item "><img src="/Content/public/images/Actions-view-calendar-list-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Danh sÃ¡ch Äá» tÃ i</a>
                                    <a href="/Home/ThongTinGiangVien" class="list-group-item "><img src="/Content/public/images/Teacher-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> ThÃ´ng tin giáº£ng viÃªn</a>
                                    <a href="/Home/ThongTinSinhVien" class="list-group-item "><img src="/Content/public/images/Student-3-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> ThÃ´ng tin sinh viÃªn</a>
                                    <a href="/Home/HuongDanDangKy" class="list-group-item "><img src="/Content/public/images/Actions-help-contents-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> HÆ°á»ng dáº«n ÄÄng kÃ½</a>
                                    <a href="/Home/ThongKe" class="list-group-item "><img src="/Content/public/images/chart-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Thá»ng kÃª</a>
                                    <a data-toggle="modal" href="#seach_box" class="list-group-item"><img src="/Content/public/images/Search-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> TÃ¬m kiáº¿m</a>
                                </div><!-- /panel-default -->

                                



                                <!--============================Bench==================-->
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 id="mobile_thongke">Thá»ng kÃª</h4>
                                    </div>
                                    
                                    <a class="list-group-item"><img src="/Content/public/images/user-group-icon (1).png" width="24" height="24" /> LÆ°á»£t truy cáº­p : <span class="badge">110607</span></a>
                                    <a style="text-decoration: underline;" data-toggle="modal" data-target="#who_online" title="Who is online ?" href="javascript:void();" class="list-group-item"><img src="/Content/public/images/online-icon.png" width="24" height="24" /> Äang trá»±c tuyáº¿n: <span class="badge">8</span></a>
                                </div>
                            </div>
                            <!-- Modal Who online -->
                            <div class="modal fade" id="who_online" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Online Users</h4>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <td>STT</td>
                                                        <td>TÃªn SV</td>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- ########################### Form ###########################-->
                            <!-- =========================TÃ¬m kiáº¿m box================================ -->
                            <div class="modal fade" id="seach_box">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title">TÃ¬m kiáº¿m</h4>
                                        </div>
                                        <form action="/Home/TimKiem" method="get" id="cpa-form">
                                            <div class="modal-body">
                                                <div id="err_tk"></div>
                                                <select class="form-control text-center" name="param_option" id="tim_kiem_tong_hop">
                                                    <option value="timkiemgiangvien">TÃ¬m kiáº¿m giáº£ng viÃªn</option>
                                                    <option value="timkiemsinhvien">TÃ¬m kiáº¿m sinh viÃªn</option>
                                                    <option value="timkiemdetai">TÃ¬m kiáº¿m Äá» tÃ i</option>
                                                </select>
                                                <br />
                                                <label>Nháº­p tá»« khoÃ¡ :</label>
                                                <input type="text" class="form-control" id="parameter1" name="param_textbox" value="" placeholder="Má»i thá»©..." />
                                                <div class="clear"></div>
                                                <div id="search_advance">
                                                    <br />
                                                    <div id="type_detai" style="display: none;">
                                                        
                                                        <fieldset>
    <legend>Chá»n loáº¡i Äá» tÃ i</legend>
        <input type="radio" name="group_loaidt" value="1" /> <span>Tiá»u luáº­n chuy&#234;n ng&#224;nh | K 14 <br /></span>
        <input type="radio" name="group_loaidt" value="3" /> <span>Äá» t&#224;i tá»t nghiá»p | K 14 <br /></span>
        <input type="radio" name="group_loaidt" value="4" /> <span>Tiá»u luáº­n chuy&#234;n ng&#224;nh | K 17 <br /></span>
        <input type="radio" name="group_loaidt" value="8" /> <span>Tiá»u luáº­n chuy&#234;n ng&#224;nh | K 19 <br /></span>
    
</fieldset>;
                                                    </div><!-- End #search_advance -->
                                                </div><!--End body -->
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-primary" id="timkiem_btn">TÃ¬m kiáº¿m</button>
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                </div>
                                            </div><!-- /.modal-content -->
                                        </form>
                                    
                                </div><!-- /.modal-dialog -->
                            </div><!-- /.modal -->
                        </div><!-- ===================================Ajax========================= -->
                        <script>
                            $(document).ready(function () {
                                $("#cpa-form").submit(function (e) {
                                    if ($("#parameter1").val() == '') {
                                        $('#err_tk').html('<div class="alert alert-danger">Vui lÃ²ng nháº­p tá»« khoÃ¡ tÃ¬m kiáº¿m</div>');
                                        $("#parameter1").focus();
                                        return false;
                                    }
                                    if ($('#tim_kiem_tong_hop').val() == "timkiemdetai")
                                    {
                                        //$('*[name=group_loaidt]').is(":not(:checked)") kiá»m tra radio chÆ°a check

                                        if ($("*[name=group_loaidt]").is(":checked")) {
                                            return true;
                                        }
                                        else //radio chÆ°a check
                                        {
                                            $('#err_tk').html('<div class="alert alert-danger">Vui lÃ²ng chá»n loáº¡i Äá» tÃ i</div>');
                                            return false;
                                        }
                                    }
                                });
                            })
                        </script>
                        
                    </div>
                </div>
                <div class="col-md-9">
                    <ol class="breadcrumb">
                        <li><a href="/Home/Index">Home</a></li>
                        
                    </ol>    <div class="well-sm">
                        <span>
                            <span id="random_tin">
                                <i class="icon-bullhorn"></i>&nbsp;
                                <img src="/Content/public/images/bullet-blue-icon.png" />
                                      <small>
        <a href="/Home/TinTuGiaoVu?id=9">

            Th&#244;ng b&#225;o ÄÄng k&#253; chuy&#234;n ng&#224;nh kh&#243;a 2018 <small style="color: rgb(87,87,87);">(30/11/2020 10:15:04)</small>
        </a>
    </small>


                            </span>
                            <span id="time_bar">

                                <span id="time" class="label label-primary pull-right"><i class="icon-time"></i> 17 giá» 29 phÃºt, ngÃ y 8 thÃ¡ng 12, 2022</span><br>                             
                            </span>
                        </span>
                    </div>
                        
<div class="panel panel-default">
    <div style="color: rgb(7, 132, 163);" class="panel-heading">
        <h4 style="font-family: verdana;color:rgb(87,87,87);">ThÃ´ng bÃ¡o</h4>
    </div>
    <div class="panel-body">
        <ul class="list-unstyled">
                <a href="/Home/TinTuGiaoVu?id=9">
                    <li class="article-area">
                        <p>
                            <span class="btn btn-primary btn-sm">
                                

                                30/11/2020 10:15:04
                            </span>
                            Th&#244;ng b&#225;o ÄÄng k&#253; chuy&#234;n ng&#224;nh kh&#243;a 2018

                        </p>
                 </li>
                </a>
                <a href="/Home/TinTuGiaoVu?id=7">
                    <li class="article-area">
                        <p>
                            <span class="btn btn-primary btn-sm">
                                

                                03/09/2020 10:28:40
                            </span>
                             ÄÄng k&#253; m&#244;n Tiá»u luáº­n chuy&#234;n ng&#224;nh kh&#243;a 2017

                        </p>
                 </li>
                </a>
                <a href="/Home/TinTuGiaoVu?id=6">
                    <li class="article-area">
                        <p>
                            <span class="btn btn-primary btn-sm">
                                

                                12/11/2018 20:01:16
                            </span>
                            Th&#244;ng b&#225;o ÄÄng k&#253; chuy&#234;n ng&#224;nh

                        </p>
                 </li>
                </a>
                <a href="/Home/TinTuGiaoVu?id=5">
                    <li class="article-area">
                        <p>
                            <span class="btn btn-primary btn-sm">
                                

                                08/09/2018 22:39:25
                            </span>
                            ÄÄng k&#253; tiá»u luáº­n chuy&#234;n ng&#224;nh kh&#243;a 2015

                        </p>
                 </li>
                </a>
                <a href="/Home/TinTuGiaoVu?id=1">
                    <li class="article-area">
                        <p>
                            <span class="btn btn-primary btn-sm">
                                

                                08/09/2018 16:00:46
                            </span>
                            ÄÄng k&#253; Tiá»u luáº­n chuy&#234;n ng&#224;nh kho&#225; 14

                        </p>
                 </li>
                </a>
                <a href="/Home/TinTuGiaoVu?id=4">
                    <li class="article-area">
                        <p>
                            <span class="btn btn-primary btn-sm">
                                

                                27/02/2018 07:31:09
                            </span>
                            ÄÄng k&#253; kh&#243;a luáº­n tá»t nghiá»p kh&#243;a 2014 há»c ká»³ 2 nÄm há»c 2017 - 2018

                        </p>
                 </li>
                </a>
        </ul>
        <div class="pagination-container"><ul class="pagination"><li class="active"><a>1</a></li><li><a href="/?page=2">2</a></li><li class="PagedList-skipToNext"><a href="/?page=2" rel="next">Â»</a></li></ul></div>
    </div>
</div>

                        <ol class="breadcrumb">
                            <li><a href="/Home/Index">Home</a></li>
                            
                        </ol>                    
                    <div class="panel panel-default" id="thongke_right">
                            <div class="panel-heading">
                                <h4 id="mobile_thongke">Thá»ng kÃª</h4>
                            </div>
                        <a class="list-group-item"><img src="/Content/public/images/user-group-icon (1).png" width="24" height="24" /> LÆ°á»£t truy cáº­p : <span class="badge">110607</span></a>
                        <a style="text-decoration: underline;" data-toggle="modal" data-target="#who_online" title="Who is online ?" href="javascript:void();" class="list-group-item"><img src="/Content/public/images/online-icon.png" width="24" height="24" /> Äang trá»±c tuyáº¿n: <span class="badge">8</span></a>
                        </div>
                    </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div id="footer">
            <hr />
            <h5 class="text-center text-danger">Khoa CÃ´ng nghá» ThÃ´ng tin - Äáº¡i há»c SÆ° pháº¡m Ká»¹ thuáº­t TP. Há» ChÃ­ Minh</h5>
            <h5 class="text-center text-danger">Sá» 1, VÃµ VÄn NgÃ¢n, Thá»§ Äá»©c, TP. Há» ChÃ­ Minh</h5>
        </div>
    </div>
    </div><!-- End #container -->
    <div id="loading">
        <span>Äang xá»­ lÃ½</span>
    </div>
    <script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
    <script type="text/javascript" src="/Content/public/js/bootstrap.min.js"></script>
</body>
</html>

