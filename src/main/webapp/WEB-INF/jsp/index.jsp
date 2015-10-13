<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
   <title>Smava Homework</title>
   <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.js"></script>
   <script type="text/javascript" src="<c:url value="/swagger-ui.js" />"></script>
   <link rel="stylesheet" href="<c:url value="/docs/css/print.css"/>" type="text/css" media="print" />
   <link rel="stylesheet" href="<c:url value="/docs/css/apache-maven-fluido-1.3.0.min.css"/>" />
   <link rel="stylesheet" href="<c:url value="/docs/css/site.css"/>" />
</head>

<body class="topBarDisabled">
<div class="container-fluid">
   <div id="banner">
      <div class="pull-left">
         <div id="bannerLeft">
            <h2>Smava Homework Project</h2>
         </div>
      </div>
      <div class="pull-right">  </div>
      <div class="clear"><hr/></div>
   </div>

   <div id="breadcrumbs">
      <ul class="breadcrumb">
         <li class="">
            <a href="http://localhost:9999" class="externalLink" title="Homework">
               Homework</a>
         </li>
         <li id="publishDate" class="pull-right">Last Published: 2014-12-22</li>
         <li class="divider pull-right">|</li>
         <li id="projectVersion" class="pull-right">Version: 1.0</li>

      </ul>
   </div>

   <div class="row-fluid">
      <div id="leftColumn" class="span3">
         <div class="well sidebar-nav">
            <ul class="nav nav-list">
               <li class="nav-header">Menu</li>
               <li>
                  <a href="./docs/homework-webapp/restapi/bankAccount.html" title="RestAPI"><i class="none"></i>RestAPI</a>
               </li>
               <li>
                  <a href="./docs/index.html" title="Documentation"><i class="none"></i>Documentation</a>
               </li>
            </ul>
         </div>
      </div>

   <div id="bodyColumn"  class="span9" >
      <div class="section">
         <h2>Bank Accounts<a name="Project_Information"></a></h2>
         <p>Press <b>send</b> to push bank account details to JMS topic.</p>
         <hr class="divider" />
         <div class="section">
            <button id="btnAdd">add</button> <button id="btnSend">send</button>
            <table border="0" class="table table-striped" id="tblData">
               <thead>
                  <tr>
                     <th>IBAN</th>
                     <th>BIC</th>
                     <th></th>
                  </tr>
               </thead>
                  <tbody>
                     <c:forEach items="${accounts}" var="account" varStatus="loop">
                        <tr>
                           <td>
                              <c:out value="${account.iban}" />
                           </td>
                           <td>
                              <c:out value="${account.bic}" />
                           </td>
                           <td>
                              <img src='<c:url value="/docs/images/fix.gif"/>' class='btnEdit'><img src='<c:url value="/docs/images/remove.gif"/>' class='btnDelete'/>
                           </td>
                        </tr>
                     </c:forEach>
                  </tbody>
            </table>
         </div>
         </div>
      </div>
   </div>
</div>
</body>

   <script>
      $( document ).ready(function() {
         $('.btnEdit').bind('click', Edit);
         $('.btnDelete').bind('click', Delete);
         $('#btnAdd').bind('click', Add);
         $('#btnSend').bind('click', Send);
      });
   </script>

</html>