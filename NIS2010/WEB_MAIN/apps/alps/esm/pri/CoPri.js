/**
===============================================================================
프로그램  명  : PRI 공통 자바스크립트
프로그램개요  : PRI모듈내 공통 메시지 및 스크립트 함수를 정의한다.
작   성   자  : 박성수.
작   성   일  : 2009-04-16
===============================================================================
수정일     수정자  수정사유/내역 
2009.04.17 박성수  ComPriXml2Array, ComPriXml2ComboItem, ComPriXml2ComboString 함수 추가
2010.11.10 송호진  [CHM-201006982-01] SC의 Excel load기능 사용시 actual customer data 처리 방법 수정 요청 관련 메시지 추가
2011.03.29 김민아  [CHM-201109656-01] SC의 Quick Accept 기능 추가에 따른 PRI01137 MSG 추가
2011.03.30 이행지  [CHM-201109659-01] Attach 기능 추가에 따른 File Size 제한 MSG 추가
2011.04.06 김민아  [CHM-201109786-01] SC의 DEM/DET(DAR) 승인 관련 기능 개선에 따른 MSG 추가
2011.05.16 이행지  [CHM-201110773-01] [PRI] Tariff Rule - Publish Cancel 기능 보완에 따른 MSG 추가
2011.12.05 이석준  [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
조회 가능토록 수정 - checkRfaNobyBaOfc Function,PRI70001 Message 추가
* 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만
                                   자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
* 2013.02.18 전윤주 [CHM-201323103] RFA Rate search 조회 시 메시지 추가(PRI07046)
* 2013.02.25 전윤주 [CHM-201323199] PRI07013 메시지 수정 - 정석환 차장 요청
* 2013.06.18 이혜민 [CHM-201324516] PRI01144, PRI01145 메시지 추가
* 2013.06.20 송호진 [CHM-201324516] PRI01146 메시지 추가
* 2013.06.27 송호진 [CHM-201324720] Special Cargo Quotation System 수정 - C/Offer 확인 메시지 표시. ( PRI09023 메시지 추가 ) 
* 2014.09.01 최성환 [CHM-201431588] Surcharge Inquiry 화면의 surcharge 개정 이력 관리 추가 PRI02022 PRI02023
* 2014.09.17 송호진 [CHM-201430558] FMC Auto-filing 개발 요청
* 2014.09.26 최성환  [CHM-201431899] Guideline RFA 생성 요청 * 
* 2014.12.22 송호진 [CHM-201432563] S/C Standard Note Validation 로직 보완
* 2014.12.22 송호진 [CHM-201432564] 승인 중 S/C Amd#0의 Cancel 로직 보완.
* 2014.12.29 최성환 [CHM-201432700]  Retroactive RFA Minimization관련 시스템 개발요청 (PRI00022 메세지 추가)
* 2015.02.03 송호진 [CHM-201533882] S/C New Filing Date 관련 과거 60일 Block validation 추가 - ( PRI01160 메시지 추가 )
* 2015.04.28 송호진 [CHM-201535631] 43 SDD Close 관련 S/C system block 요청 - message 변경 ( PRI01153 )
* 2015.04.29 전지예 [CHM-201535165] RFA match back 팝업화면 추가에 다른 message 변경 (PRI03027)
* 2015.06.02 전지예 [CHM-201536176] [RFA] Retroactive RFA일 경우 팝업메세지 삽입 (PRI07056)
* 2015.06.16 최성환 [CHM-201536349] S/C 다운로드 보안 강화 (다운로드 버튼 접근 제한) (PRI01163)(PRI01164)
* 2015.08.18 현성길 [CHM-201537109] Split19-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
* 2016.01.13 [CHM-201539514] SSE Agreement Filing 상 Surcharge 추가 요청 Requested By SELCMA / Kim GyungUk (PRI07057 메세지 추가)
* 2016.05.27 [CHM-201641700] [해수부 운임공표 및 신고제] 운임신고 관련 시스템 개발 
* 2016.07.18 이민경 [CHM-201642492] Contract RFA 수정 Logic 변경 요청의 건
===============================================================================
*/

    /*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 메시지코드와 각종 메시지 처리 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    // var msgs = new Array();
    // PRI공통
    msgs['PRI00001'] = 'Do you want to save?';
    msgs['PRI00002'] = 'Do you want to delete?';
    msgs['PRI00003'] = 'Do you want to confirm?';
    msgs['PRI00004'] = 'Do you want to cancel confirmation?';
    msgs['PRI00005'] = 'Deleting will delete sub-data as well. Do you want to continue?';
    msgs['PRI00006'] = 'Data was changed. Do you want to save?';
    msgs['PRI00007'] = 'It can not be saved without input of detailed information.';
    msgs['PRI00008'] = 'Do you want to accept?';
    msgs['PRI00009'] = 'Do you want to cancel acceptance?';
    msgs['PRI00010'] = 'Data was changed. Do you want to proceed without saving the changes?';
    msgs['PRI00011'] = 'Selected row does not exist.';
    msgs['PRI00012'] = 'Do you want to copy?';
    msgs['PRI00013'] = 'Data does not exist.';
    msgs['PRI00014'] = 'Do you want to Apply?';
    msgs['PRI00015'] = 'Do you want to Cancel?';
    msgs['PRI00016'] = 'Do you want to paste?';
    msgs['PRI00017'] = 'Detail data does not exist .\nDo you want to delete?';
    msgs['PRI00018'] = 'There is no data to search.';
    msgs['PRI00019'] = 'Please check [{?msg1}] row and [{?msg2}] row.';
    msgs['PRI00020'] = 'All contents have been deleted.\nDo you also want to delete Title?';
    msgs['PRI00021'] = 'All detail codes have been deleted.\nDo you also want to delete Group code?';
    msgs['PRI00022'] = "{?msg1} must not be over {?msg2} characters long.\nYou Input {?msg3} Characters."

    msgs['PRI00101'] = 'Data saved successfully.';
    msgs['PRI00102'] = 'Data deleted successfully.';
    msgs['PRI00103'] = 'Data confirmed successfully.';
    msgs['PRI00104'] = 'Confirmation has been canceled successfully.';
    msgs['PRI00105'] = 'Data has been confirmed already.';
    msgs['PRI00106'] = 'Confirmation has been canceled already.';
    msgs['PRI00108'] = 'Data accepted successfully.';
    msgs['PRI00109'] = 'Canceled accept request successfully.';
    msgs['PRI00110'] = 'Data copied successfully.';
    msgs['PRI00114'] = 'Apply has been completed.';
    msgs['PRI00115'] = 'Cancel has been completed.';
    msgs['PRI00116'] = 'Paste completed.';
    msgs['PRI00117'] = 'For code inquiry, Please input minimum {?msg1} alpha.';
    msgs['PRI00118'] = 'Are you sure to send a mail?';

    msgs['PRI00201'] = 'Problem occurred while saving data.';
    msgs['PRI00202'] = 'Problem occurred while deleting data.';
    msgs['PRI00203'] = 'Failed to confirm.';
    msgs['PRI00204'] = 'Failed to cancel confirmation.';
    msgs['PRI00205'] = 'Problem occurred while openning report (history). ';

    msgs['PRI00301'] = 'There is no data to save.';
    msgs['PRI00302'] = 'Duplicate data found, please recheck.';
    msgs['PRI00303'] = 'Duplicate data found in seq. no. {?msg2} in [{?msg1}].';
    msgs['PRI00304'] = 'Data already exist for period entered.';
    msgs['PRI00305'] = '{?msg1} start date can not be greater than end date.';
    msgs['PRI00306'] = 'Effective date can not be greater than expiry date.';
    msgs['PRI00307'] = '{?msg1} exceeds the field length.';
    msgs['PRI00308'] = 'Please {?msg1} {?msg2}.';
    msgs['PRI00309'] = 'Changed {?msg1} sheet data must be saved first.';
    msgs['PRI00310'] = 'Please select 1 row only.';
    msgs['PRI00311'] = 'Only numeric value is allowed.';
    msgs['PRI00312'] = 'Please upload excel file.';
    msgs['PRI00313'] = 'This sequence can not be selected.';
    msgs['PRI00314'] = '{?msg1} alphabets only allowed for input.';
    msgs['PRI00315'] = 'This is an unvalid code, please check again.';
    msgs['PRI00316'] = 'Mandatory items [{?msg1}] are required.';
    msgs['PRI00317'] = 'Only 4 alpha is allowed for Group code input.';
    msgs['PRI00318'] = 'Only 5 alpha is allowed for Location code input';
    msgs['PRI00319'] = 'Please input the details under {?msg1}.';
    msgs['PRI00320'] = '{?msg1} alphabets or digits only allowed for input.';
    msgs['PRI00321'] = '[{?msg1}] should be greater than {?msg2}.';
    msgs['PRI00322'] = 'Please enter valid date format for {?msg1} : YYYY-MM-DD.';
    msgs['PRI00323'] = 'Please enter the year within duration.';
    msgs['PRI00324'] = 'Please input duration including the year.';
    msgs['PRI00325'] = 'Please choose between [{?msg1}] and [{?msg2}] for input.';
    msgs['PRI00326'] = 'You can not select [<] or [>].';
    msgs['PRI00327'] = 'Please select more than 1 sequence to copy.';
    msgs['PRI00328'] = 'There is no data to paste.';
    msgs['PRI00329'] = 'All data have been accepted already.';
    msgs['PRI00330'] = 'None of data is accepted.';
    msgs['PRI00331'] = '[{?msg1}] Subject data does not exist.';
    msgs['PRI00332'] = 'Duplicate {?msg1} exists.';
    msgs['PRI00333'] = '{?msg1} can not be selected.';
    msgs['PRI00334'] = 'Please input at [{?msg1}] [{?msg2}].';
    msgs['PRI00335'] = '[{?msg1}] has not been inputted.';
    msgs['PRI00336'] = '[{?msg1}] should be smaller than {?msg2}.';
    msgs['PRI00337'] = '[{?msg1}] has not been selected.';
    msgs['PRI00338'] = 'Failed to download. Please try again.';
    msgs['PRI00339'] = 'Data was downloaded successfully.';
    msgs['PRI00342'] = 'Duplicate data exist in [{?msg1}], Please check it again.';
    msgs['PRI00343'] = 'Duplicate data exist in [{?msg1}], are you sure to proceed this proposal?';
    msgs['PRI00344'] = 'Duplicate data exist in [{?msg1}], are you sure to approve this proposal?';
    msgs['PRI00345'] = 'Expiration date must be later than effective date.';
    msgs['PRI00346'] = 'Effective date must be earlier than Expiration date.';
    msgs['PRI00347'] = '[New Publication Date] must be earlier than Expiration date.';
    msgs['PRI00348'] = 'You may not update [Exclude] condition without any GRI application. Please update GRI [Include] condition first.';
    msgs['PRI00349'] = 'If there is no commodity group saved, it will be deleted. Do you want to input commodity group?';
    msgs['PRI00350'] = 'If there is no route detail saved, it will be deleted. Do you want to input route detail?';
    msgs['PRI00351'] = 'There is no data to apply';
    msgs['PRI00352'] = 'There is no data to be canceled';
    msgs['PRI00353'] = 'Effective date must be earlier than [{?msg1}]';
    msgs['PRI00354'] = 'Effective date must be later than [{?msg1}]';
    msgs['PRI00355'] = 'Effective date must be later than [{?msg1}]';
    msgs['PRI00356'] = 'Publication Date must be later than [{?msg1}]';
    msgs['PRI00357'] = 'This CMDTY is not possible to use for BCO contract.';
	msgs['PRI00358'] = 'Do you want to cost interface?';
	msgs['PRI00359'] = '[setFileUpload] The file path is not correct.';
    msgs['PRI00360'] = 'Max 30 contracts can be selected for Multi-Download.\n: You\'ve selected {?msg1} contracts.';
    msgs['PRI00361'] = 'Download file sent to Webmail : Korea.Filing@smlines.com';

    msgs['PRI00362'] = 'NOT restricts all applicable surcharges.\nPlease check if all surcharges are not applicable.';
    msgs['PRI00363'] = 'Do you want to delete?';
    
    // PRIMasterData
    msgs['PRI04001'] = 'Please input more than {?msg1}digit, when you inquire by code.';
    msgs['PRI04002'] = 'Please input more than {?msg1}digit, when you inquire by code name.';
    msgs['PRI04003'] = 'You can input [{?msg1}] after inputting {?msg2}.';
    msgs['PRI04004'] = 'You should insert [{?msg1}] in {?msg2} with no more than {?msg3}.';
    msgs['PRI04005'] = 'You have to input more than one item between [{?msg1}] and [{?msg2}]';
    msgs['PRI04006'] = 'There is no selected data.';
    msgs['PRI04007'] = 'You should select [{?msg1}].';

    // SCGuideline
    msgs['PRI08001'] = 'Please select [Service Scope] and [Duration] first.';
    msgs['PRI08002'] = 'Please select Service Scope first.';
    msgs['PRI08003'] = '[Awkward] can be selected only when [Per] is A,F,O,Q,S,P type.';
    msgs['PRI08004'] = 'Guideline Copy is available when there is no Commodity Group.';
    msgs['PRI08005'] = 'There is no data to be confirmed under tabs.';
    msgs['PRI08006'] = 'Do you want to copy selected guideline?';
    // SCGuideline - MQC Popup
    msgs['PRI08008'] = '[MAX] should be bigger than [MIN]';
    msgs['PRI08009'] = '[Max] should be [MIN] value minus 1 in next row.';
    // 그리드 필수입력 체크를 수동으로 할 경우 메세지
    msgs['PRI08010'] = '{?msg1} Record [{?msg2}]is mandatory item.';
    msgs['PRI08011'] = 'You can not amend cargo type, please check per type first.';
    msgs['PRI08012'] = 'You can not save. Please check cargo type first.';
    msgs['PRI08013'] = 'There are same location codes btwn Point and B.Port.';
    msgs['PRI08014'] = 'Please check VIA information.';
    msgs['PRI08015'] = 'Please save first to use.';
    msgs['PRI08016'] = 'You can not exceed the main duration.';
    msgs['PRI08017'] = 'This is used data in Rate Tab, Please delete it in Rate Tab first.';
    msgs['PRI08018'] = 'Your inserted duration is over-lapped with existing guideline,\nplease re-check your duration date.';
    msgs['PRI08019'] = 'It is using data, please delete it first. \n {?msg1}';
    msgs['PRI08020'] = 'There exist Commodity Group with no route detail in Rate tab.';

    // SCProposal
    msgs['PRI01001'] = 'Mandatory items are needed.';
    msgs['PRI01002'] = 'Please check valid row.';
    msgs['PRI01003'] = 'The duration of this {?msg3} is {?msg1} ~ {?msg2}.\nIndividual SVC Scope’s duration cannot exceed the main duraion';
    msgs['PRI01004'] = 'Please create master data first.';
    msgs['PRI01005'] = '[Guideline copy] can be performed only when there is no data to be inputted.';
    msgs['PRI01006'] = 'Data is not currently registered. \nDo you want to copy guideline?';
    msgs['PRI01007'] = 'Please select Service Scope first.';
    msgs['PRI01008'] = 'MQC sum of SVC Scope(s) should be less than main MQC.';
    msgs['PRI01009'] = 'Do you want to copy guideline?';
    msgs['PRI01010'] = 'Do you want to cancel accept all data?';
    msgs['PRI01011'] = 'Row has been amended already.';
    msgs['PRI01012'] = 'Row was not amended.';
    msgs['PRI01013'] = 'Customer name and address should be inputted in {?msg1}row.';
    msgs['PRI01014'] = 'Customer code should be inputted in {?msg1}row.';
    msgs['PRI01015'] = 'Do you want to accept all data?';
    msgs['PRI01016'] = 'There is no guideline available.\nPlease inquire guideline first.'; //There is no guideline available.
    msgs['PRI01017'] = 'Guideline copied successfully.'; //The Guideline has been copied successfully.
    msgs['PRI01018'] = 'Amend date should be between {?msg1} \nand {?msg2} on main screen.';
    msgs['PRI01019'] = 'You can not copy because there is no boiler plate guideline for contract year.';
    msgs['PRI01020'] = 'You can not input base port same as point.';
    msgs['PRI01021'] = 'Proposal number does not exist';
    msgs['PRI01022'] = 'You can not modity/delete data in use. {?msg1}';
    msgs['PRI01023'] = 'Please select location type.';
    msgs['PRI01024'] = 'Please check duration.';
    msgs['PRI01025'] = 'Do you also want to change the main duration?';
    msgs['PRI01026'] = 'Save is canceled.';
    msgs['PRI01027'] = 'Location group code does not exist on Location Group code in guideline to be copied. \nPlease register location group code first.';
    msgs['PRI01028'] = 'Commodity group code does not exist on Commodity group code in guideline to be copied. \nPlease register commodity group code first.';
    msgs['PRI01029'] = 'Please input service scope.';
    msgs['PRI01030'] = 'Please input main duration.';
    msgs['PRI01031'] = 'There is service scope which is not accepted.';
    msgs['PRI01032'] = 'Do you want to proceed {?msg1}?';
    msgs['PRI01033'] = 'You have no authority. [{?msg1}]';
    msgs['PRI01034'] = 'Please check status.';
    msgs['PRI01035'] = 'Do you want to accept all data?';
    msgs['PRI01036'] = 'Service scope only added under the current amendment sequence can be deleted.';
    msgs['PRI01037'] = 'Row has been accepted already.';
    msgs['PRI01038'] = 'Row was not accepted.';
    msgs['PRI01039'] = 'There is initial data.';
    msgs['PRI01040'] = 'You can not copy because there is no arbitrary guideline for contract year.';
    msgs['PRI01041'] = 'You can not copy because there is no GOH guideline for contract year.';
    msgs['PRI01042'] = 'Please input {?msg1}.';
    msgs['PRI01043'] = 'Selected item does not exist.';
    msgs['PRI01044'] = 'C.Offered rate is the same as proposal rate.';
    msgs['PRI01045'] = '{?msg1} is completed.';
    msgs['PRI01046'] = 'Do you want to cancel and return to previous status?';
    msgs['PRI01047'] = 'The status is changed';

    msgs['PRI01048'] = '{?msg1} should start from {?msg2}';
    msgs['PRI01049'] = '[{?msg1}] should be continous numbers.';
    msgs['PRI01050'] = 'All data in current Amend Sequence will be deleted completely.\nDo you want to continue?';
    msgs['PRI01051'] = 'Please delete data in Terms first.';
    msgs['PRI01052'] = 'You should input more than 1 data in [{?msg1}].';
    msgs['PRI01053'] = 'Please check filing Date.';
    msgs['PRI01054'] = 'Filing Date is 10 days greater than the Amendment Effective Date. \nDo you want to proceed?';
    msgs['PRI01055'] = 'There is no Proposal number or Amendment Number.';
    msgs['PRI01056'] = 'Do you want to create S/C number?';
    msgs['PRI01057'] = 'Updated data exists, Please save it first.';
    msgs['PRI01058'] = 'Added data exist, Please proceed button click.';
    msgs['PRI01059'] = 'Amendment effective date is later than Filing date, \nDo you want to update Effective date as Filing date?';
    msgs['PRI01060'] = 'There is no data to copy';
    msgs['PRI01061'] = 'Please check S/C number.';
    msgs['PRI01062'] = 'S/C No is duplicated. Please input S/C No again.';
    msgs['PRI01063'] = 'There is no Standard Note to copy in guideline. \nPlease register Standard Note in advance.';
    msgs['PRI01064'] = 'Master data does not exist.';
    msgs['PRI01065'] = 'You can input [{?msg1}] after inputting {?msg2}';
    msgs['PRI01066'] = 'GRI Calculation cannot be applied.';
    msgs['PRI01067'] = 'GRI application cannot be canceled.';
    msgs['PRI01068'] = 'Detailed data dose not exist. GRI calculation cannot be applied/canceled.';
    msgs['PRI01069'] = 'Please select application item.';
    msgs['PRI01070'] = 'Please input amount.';
    msgs['PRI01071'] = 'Please input percentage(%).';
    msgs['PRI01072'] = 'Applied successfully.';
    msgs['PRI01073'] = 'Canceled successfully.';
    msgs['PRI01074'] = 'Please select among {?msg1}.';
    msgs['PRI01075'] = 'Please check [{?msg1}] Duration.';
    msgs['PRI01076'] = 'There is no OTI information.';
    msgs['PRI01077'] = 'The duration of each SVC scope has not been changed.';
    msgs['PRI01078'] = 'Same [Point] and [Base Port] cannot be inputted.';
    msgs['PRI01079'] = 'Please delete Real Customer first.';
    msgs['PRI01080'] = 'Please select Excel file format. [Yes : Vertical, No : Horizontal]';
    msgs['PRI01081'] = 'Filing Date is ahead of current date.';
    msgs['PRI01082'] = 'Do you want to create proposal?';
    msgs['PRI01083'] = 'Main Duration do not cover Scope Duration.';
    msgs['PRI01084'] = 'This is unvalid S/C No format.(Alphabet 3 digit + Number 6 digit)';
    msgs['PRI01085'] = 'This is an unvalid S/C Prefix. Please check again.';
    msgs['PRI01086'] = 'Do you want to Change Duration?';
    msgs['PRI01087'] = 'New Duration can not be longer than 1 year.';
    msgs['PRI01088'] = 'Amend EFF must be between {?msg1}.';
    msgs['PRI01089'] = 'New Duration Date can not earlier than Possible Effective Date.';
    msgs['PRI01090'] = 'Please create DEM/DET Conversion.';
    msgs['PRI01091'] = 'Free Time term is Exception. Please create Before BKG DAR.';
    msgs['PRI01092'] = 'RFA Duration is amended. Please amend related DAR Duration as well.';
    msgs['PRI01094'] = 'The duration of {?msg1} scope is {?msg2} ~ {?msg3}. \nPlease input filing date no later than {?msg3}.';
    msgs['PRI01095'] = 'Please register Location Group first. Location Group is used in G/L to be copied.';
    msgs['PRI01096'] = 'Please check duration of each service scope.';
    msgs['PRI01097'] = 'There is no arbitrary to apply GRI.';
    msgs['PRI01098'] = 'Please select Org/Dst column.';
    msgs['PRI01099'] = '[{?msg1}] cannot be used at [{?msg2}] side in this SVC scope.';
    msgs['PRI01100'] = 'Please input more than 1 item among S/C No, Proposal No, Effective date.';
    msgs['PRI01101'] = 'Please input more than 1 item among RFA No, Proposal No, Access Date, SVC scope, Customer.';
    msgs['PRI01102'] = 'Please check your entered date.';
    msgs['PRI01103'] = 'You are not authorized for retroactive approval.\nThis can be approved by the relevant pricing staff only in each regional HQ.(ASG,WSG,NSG,USG)';
    msgs['PRI01104'] = 'Expiration date must be later than effective date.';
    msgs['PRI01105'] = 'There is no amended data.';
    msgs['PRI01106'] = 'Please approve DAR for DEM/DET exception clause firstly.';
    msgs['PRI01107'] = 'It can not be canceled since this RFA no [{?msg1}] is used in BKG data.';
    msgs['PRI01108'] = 'Please delete DAR first.';
    msgs['PRI01109'] = 'Do you also want to change the scope duration?';
    msgs['PRI01110'] = 'This is not registered surcharge code in [{?msg1}] scope. Please check again.';
    msgs['PRI01111'] = 'Please copy again for Commodity Group, Rate and Standard Note if copied from guideline.';
    msgs['PRI01112'] = 'Do you also want to accept duration of the scope?';
    msgs['PRI01113'] = 'This is used data in S/C Prefix & Scope Mapping Creation. Please delete it first.';

    msgs['PRI01114'] = 'There is no valid DAR. Please change the free time term or update DAR again.';
    msgs['PRI01115'] = 'There is valid DAR, Pleaes change the free time term again.';
    msgs['PRI01116'] = 'This Proposal no is used in DAR, you can not cancel  this Proposal.';
    msgs['PRI01117'] = 'This is wrong type of excel format. please select it again.';
    msgs['PRI01118'] = 'Have you updated all conversion data form this amendment?';
    msgs['PRI01119'] = 'Effective Date should be later than the previous Amendment Effective Date.';
    msgs['PRI01120'] = 'Please create DEM/DET conversion.';
    msgs['PRI01121'] = 'There is DAR under this proposal.Please check DEM/DET conversion.';
    msgs['PRI01122'] = 'There is DAR(DEM/DET) under this proposal.\n{?msg1}';
    msgs['PRI01123'] = 'Do you want to cancel this proposal ? please delete DAR first.';
    msgs['PRI01124'] = 'The whole proposal will be deleted completely.\nAll approved/unapproved data will be deleted and the deleted data will be unrecoverable.\nDo you want to continue?';
    msgs['PRI01125'] = 'Please input rate(s) of this route.';
    msgs['PRI01126'] = 'This code has been used in [{?msg1}] tab,\nplease delete it in [{?msg1}] tab first.';
    msgs['PRI01127'] = 'Please register the group code in [{?msg1}] first.';
    msgs['PRI01128'] = 'Please check contract parties information by clicking [Customer] button in main page.\nYou need to change [please input] data.';
    msgs['PRI01129'] = 'Approver has already started accepting your proposal.\nYou may not cancel the request.';
    msgs['PRI01130'] = 'You can not amend this transited RFA.\nPlease create new RFA with copying this.';
    msgs['PRI01131'] = 'It can not be canceled since this RFA is used in BKG data. ({?msg1})';
    msgs['PRI01132'] = 'There is already accepted data under this item. You may not delete it. \n {?msg1}';
    msgs['PRI01133'] = 'Do you also want to change the main MQC?';
    msgs['PRI01134'] = 'Do you also want to change the scope MQC?';
    msgs['PRI01135'] = 'Please retrieve this [{?msg1}] again as other user changed the data.';    
    msgs['PRI01136'] = 'In general rate, actual customer cannot be exist. Pls recheck it.';
    msgs['PRI01137'] = 'Do you want to Accept 5 Tab (Ori/Dest, LOC Group, CMDT Group, Arbitrary, GOH)?';
    msgs['PRI01138'] = "File size can't not exceeds 1MB."
    msgs['PRI01139'] = 'There is DAR(DEM/DET) under this proposal. Please check DEM/DET conversion in special note.\n{?msg1}';
    msgs['PRI01140'] = 'You should select one Main customer.';
    msgs['PRI01141'] = 'In case of TPW,ACW,TAE,ASE,MME,SAS scope, you can input more than 2 customers.';
    msgs['PRI01142'] = 'Real customer location code should be related with Affilate / Loading agent code.';
    msgs['PRI01143'] = 'Calling port is only available in this column.\nPlease check the locatioin code you update.';
    msgs['PRI01144'] = '{?msg1} is invaild {?msg2} code.'; 
    msgs['PRI01145'] = 'If the number of total B/Ls are more than 10,000 count, BL inquiry  button is not available. Please use [BL Inquiry Down Excel] button.'; 
    msgs['PRI01146'] = 'If the number of total B/Ls are more than 25,000 count, BL Inquiry Down Excel button is not available due to file size. please split search options in detail.';
    msgs['PRI01147'] = 'Do you want to cancel this proposal? \nPlease delete chassis conversion first.';
    msgs['PRI01148'] = 'There is chassis exception under this proposal.\n{?msg1}';
    msgs['PRI01149'] = 'There is chassis exception under this proposal.\nPlease check chassis conversion in special note.\n{?msg1}';
    msgs['PRI01150'] = 'Please create chassis conversion.';
    msgs['PRI01151'] = 'There is chassis exception under this proposal.\nPlease check chassis conversion.';    
    msgs['PRI01152'] = 'After you copy G/L, you cannot go back to status before you delete.\nDelete Cancel button will be deactivated.\nIn order to activate Delete Cancel, you should cancel the whole amendment to reset the status to Filed, and then need to re-raise the amendment.\nDo you want to proceed?';
    msgs['PRI01153'] = 'No service available - USSAT(CY), USLRD(CY), USLEW(CY), USELP(CY) & 9 SDD via WC,\nPlease remove locations in problem in Rate tab or LOC Group tab : {?msg1}';
    msgs['PRI01154'] = 'Please double check the Effective Date and for any typos.';
    msgs['PRI01155'] = 'Please double check the Effective Date and for any typos.\nFiling Eff. Date that you input is retroactive, do you want to continue?';
    msgs['PRI01156'] = 'It has been passed the 10 days period from initial amendment filing, do you want to continue?';
    msgs['PRI01157'] = 'Filing Effective Date cannot exceed 60 days from current EST Date ({?msg1}).';
    msgs['PRI01158'] = 'Please input more than 1 item among RFA No, Proposal No, Access Date, SVC scope.';
    msgs['PRI01159'] = 'Please check Customer type for Standard Note ({?msg1})';
    msgs['PRI01160'] = 'Retroactive Filing is not allowed.';
    msgs['PRI01161'] = 'Mixed type of Affiliate!!!';
    msgs['PRI01162'] = 'Affiliate type not match to S/C type!!!';
    msgs['PRI01163'] = 'You are not the authorized user.';
    msgs['PRI01164'] = 'You are not the authorized user. \n{?msg1}';
    msgs['PRI01165'] = 'Duration cannot exceed the original duration for Basic RFA.';
    msgs['PRI01166'] = 'You can not delete data in use.';
        
    // SCSurcharge
    msgs['PRI02001'] = 'Unchecking will delete sub-data as well. Do you want to continue?';
    msgs['PRI02002'] = 'When you select [Percentage], [Currency Code] will be deleted, \nDo you want to proceed?';
    msgs['PRI02003'] = 'There is [0] value in amount column, Do you want proceed?';
    msgs['PRI02004'] = 'Please select Trade and Charge.';
    msgs['PRI02005'] = 'Pleae select Percentage Type.';
    msgs['PRI02006'] = '[{?msg1}]should not be less than 2 characters.';
    msgs['PRI02007'] = 'Please select [Trade] and [Charge].';
    msgs['PRI02008'] = 'You can proceed it after inquiry.';
    msgs['PRI02009'] = 'Please input Effective Date.';
    msgs['PRI02010'] = 'Please select at least one column among [Service Scope], [Location] or [Charge code]';
    msgs['PRI02011'] = '[Cargo Type] Awkward can be selected, only if [Per] is A,F,O,Q,S,P,20,40,HC,BX Type.';
    msgs['PRI02012'] = 'Update Date is greater than Access Date.';
    msgs['PRI02013'] = 'You should input 9 digits for S/C and RFA no.';
    msgs['PRI02014'] = 'This S/C no does not exist.';
    msgs['PRI02015'] = 'This RFA no does not exist.';
    msgs['PRI02016'] = 'Row {?msg1} and row {?msg2} are duplicated in this sheet.';
    msgs['PRI02017'] = '{?msg1} row is duplicated with pre-existing data in this sheet.';
    msgs['PRI02018'] = '[{?msg1}] will be unregistered from [{?msg2}].\nDo you want to continue?';
    msgs['PRI02019'] = 'You are required to choose \'Days\', \'Period Type\', \'Period Criteria\' ';
    msgs['PRI02020'] = 'There is an effective date earlier than today. \nDo you still want to continue?';
    msgs['PRI02021'] = 'There is an expiration date earlier than the day before today. \nDo you still want to continue?';
    msgs['PRI02022'] = 'Please select EFF Date.'; 
    msgs['PRI02023'] = 'Please input Expire Date.';
    msgs['PRI02024'] = 'Do you want to {?msg1}?';
    

    // PRS
    msgs['PRI03001'] = 'Sub-data was changed. Do you want to save with it?';
    msgs['PRI03002'] = 'Please select download mode. [Yes:Quick Mode, No:Standard Mode]';
    msgs['PRI03003'] = 'There is {?msg1} inputted. Do you want to create a new Quotation?';
    msgs['PRI03004'] = 'Inputted {?msg1} does not exist.';
    msgs['PRI03005'] = 'Only 4 alpha is allowed for Group code input.';
    msgs['PRI03006'] = 'Do you want to copy guideline?';
    msgs['PRI03007'] = 'Do you want to {?msg1}?';

    msgs['PRI03009'] = 'Please save {?msg1} first.';
    msgs['PRI03010'] = 'CMPB Guide1line has been already created earlier than 1 year.\nPlease make sure it from CMPB Guideline Inquiry.';
    msgs['PRI03011'] = '[{?msg1}] date should be included in [{?msg2}] period.';
    msgs['PRI03012'] = '[Actual PFMC for estimate] date should be included in Summary period but shouldn\'t be greater than this week.';
    msgs['PRI03013'] = 'Simulation date should be between {?msg1}(Year-Week) and {?msg2}(Year-Week).';
    msgs['PRI03014'] = 'Please input region code only for US.';
    msgs['PRI03015'] = 'Simulation period can not exceed duration period.({?msg1})';
    msgs['PRI03017'] = 'Please save first and click "OK" for calculation.';
    msgs['PRI03018'] = '[{?msg1}] doesn\'t exist. Please check duration(Year-Week).';
    msgs['PRI03020'] = 'Please click [Calculate] under [Rate] tab in advance to check estimated CMPB(OPB)/CM(OP).\nThen, [{?msg1}] will be active.';
    msgs['PRI03021'] = '[Route Detail] doesn\'t exist. Please check.';
    msgs['PRI03022'] = 'Please click [Calculate] in advance to check estimated CMPB(OPB)/CM(OP).\nThen, [{?msg1}] will be active.';  
    msgs['PRI03023'] = 'In case you input the same data in [{?msg1}] except other columns for each simulation data ,system  recognizes it as duplicated. \n\nBefore system  is upgraded, please input simulation data not to be duplicated';
    msgs['PRI03024'] = 'This is an invalid code. Please input country code except US(United states, Region code only).';
    msgs['PRI03025'] = 'Calculation is completed successfully.';
    msgs['PRI03026'] = 'Changed data must be saved first for calculation.';    
    msgs['PRI03027'] = '** Subject to Calculation and M/B ** {?msg1}\n\n1. Please click [Calculate] under [Rate] tab firstly, to check estimated CMPB(OPB)/CM(OP).\nThen [M/B] will be active.\n2. And please click [M/B] next to [Calculate] to check EQ status of each POL/POD.\nThen [{?msg2}] will be active.';
    msgs['PRI03028'] = 'Please select Service Scope first.';
    msgs['PRI03029'] = 'SVC Scope doesn\'t cover for [Origin] or [Destination] you inputted.\nPlease check input data.';
    msgs['PRI03030'] = '** Subject to Calculation and M/B ** {?msg1}\n\nPlease click [Calculate] under [Rate] tab in advance to check estimated CMPB(OPB)/CM(OP).\nThen, [{?msg2}] will be active.';
    
    // TRI
    msgs['PRI05001'] = '[{?msg1}] is(are) invalid with TAA duration.\nPlease delete [{?msg1}] or amend TAA duration.';
    msgs['PRI05002'] = 'There is no TRI to be confirmed. Please input TRI.';
    msgs['PRI05003'] = 'It can not be canceled since this TAA is used in BKG data. ({?msg1})';
    msgs['PRI05004'] = 'TRI No. Assigned.';
    msgs['PRI05005'] = 'Do you want to cancel and return to previous status?';
    msgs['PRI05006'] = 'Amend effective date should be later than {?msg1}.';
    msgs['PRI05007'] = 'TRI published successfully.';
    msgs['PRI05008'] = 'There is(are) TRI [{?msg1}] in initial status which has(have) been applied this GRI. Please proceed or cancel the current status for [{?msg1}] before applying new GRI Calc.';
    msgs['PRI05009'] = 'Duplicate data exist in [{?msg1}], you can not assign new TRI No.';
    msgs['PRI05010'] = 'If you want to change scope, please delete registered TRIs first.';
    msgs['PRI05011'] = 'Do you want to create new GRI?';
    msgs['PRI05012'] = 'Duration should not be less than 30 days for Tariff Rate Publishing.';
    msgs['PRI05013'] = 'There is(are) TRI(s) which has(have) validity period less than 30 days';
    msgs['PRI05014'] = 'Tariff Rate should be valid at least 30 days, Please update actual filed expiry date in ‘New Expiration Date‘ column.';    
    
    // TARIFF AUTOMATION
    msgs['PRI06001'] = 'Do you want to Request?';
    msgs['PRI06002'] = 'Do you want to Approve?';
    msgs['PRI06003'] = 'Tariff Code is not available';
    msgs['PRI06004'] = 'Selected Tariff Code No. is currently used, please check detail ';
    msgs['PRI06005'] = 'Do you want to publish the selected {?msg1}?';
    msgs['PRI06006'] = 'Please check effective date (30 day validation)';
    msgs['PRI06007'] = 'Amendment effective date is earlier than publish date, \nDo you want to update effective date as publish date?';
    msgs['PRI06008'] = 'Publish date must be later than [{?msg1}].';
    msgs['PRI06009'] = 'Please input publish date within 9 days of creation date';
    msgs['PRI06010'] = 'Selected service scope [$s] is used other Tariff Code. Please select another service scope.';    
    msgs['PRI06011'] = 'If there is Location Information data , it will be deleted. Do you want to load Excel?';
    msgs['PRI06012'] = 'Please select 2 rows to compare.'
    msgs['PRI06013'] = 'Processing may take several minutes depending upon size of the data.'
    msgs['PRI06014'] = 'Selected Inland Rates Name does not exist. Please select another Inland Rates Name.'
    msgs['PRI06015'] = '{?msg1} Date should be later than previous amendment {?msg2}';
    msgs['PRI06016'] = 'Do you want to cancel publishing selected Tariff Rule?';
    
    // RFA
    msgs['PRI07001'] = 'You are not allowed to search this RFA# or Proposal#.';
    msgs['PRI07002'] = 'The route should be matched DRY route';
    msgs['PRI07003'] = 'This country does not exist';
    msgs['PRI07004'] = 'Please recreate the RFA at new tab for AEW, AEE scope';
    msgs['PRI07005'] = 'This service scope does not exist';
    msgs['PRI07006'] = 'Please check latest cost tariff No.';
    msgs['PRI07007'] = 'Please check {?msg2} tariff amount for [{?msg1}]';
    msgs['PRI07008'] = 'Please check guideline amount for [{?msg1}]';
    msgs['PRI07009'] = 'RFA will apply new system for AEW, AEE scope from 1st, July \nPlease check the Duration & Effective date';
    msgs['PRI07010'] = 'There is no data selected.';    
    msgs['PRI07011'] = 'Already Interfaced [{?msg1}] data. Are you sure interface again?';    
    msgs['PRI07012'] = 'RFA will apply new system for AEW, AEE scope from 1st, July \nPlease check the Expiration date';
    msgs['PRI07013'] = 'Please input at "Rate of including IHC".';
    msgs['PRI07014'] = 'Please check the status.';
    msgs['PRI07015'] = 'Please click the {?msg1} Tariff Tuning button.';
    msgs['PRI07016'] = 'Do you want to Tariff Tuning?';
    msgs['PRI07017'] = 'Data interfaced successfully.';
    msgs['PRI07018'] = '[{?msg1}] is not valid. Please enter an correct format.';
    msgs['PRI07019'] = 'Please check the location group code.';
    msgs['PRI07020'] = 'Please check the Location code / Term.';
    msgs['PRI07021'] = 'Please do not input the Door Term.';
    msgs['PRI07022'] = 'Please input the IHC amount.';
    msgs['PRI07023'] = 'Please amend Location code grouping at Route Details [[Scope]-CMDT bullet [{?msg1}]].';
    msgs['PRI07024'] = 'Please input the IHC amount on Door term.\n[Scope-CMDT bullet-Origin or Destination]\n[{?msg1}].';
    msgs['PRI07025'] = 'Please interface cost tariff firstly.';
    msgs['PRI07026'] = 'The confirmed IHC tariff can be copied to other service scope only. Please check the status of IHC tariff.';
    msgs['PRI07027'] = 'The system is reading that it’s currently on the process of IHC tariff updates for below  countries/service scopes as its status is “Initial”. The IHC tariff can be copied when the status is “confirmed” or ‘not existing for relevant service scopes.  Please double-check the status of below IHC tariffs.\n\n{?msg1}';
    msgs['PRI07028'] = 'The effective date of new IHC should be later than the effective date of current tariff. Please double-check the effective date of below IHC guideline.\n\n{?msg1}';
    msgs['PRI07029'] = 'Please check the Term. Couldn’t insert the CY/CY Term in this screen.';
    msgs['PRI07030'] = 'Please check the Term. Couldn’t insert the Door Term in this screen.';
    msgs['PRI07031'] = 'Below {?msg1} tariffs cannot be copied as two different service scopes. Please select one service scope for copying it to other service scope';
    msgs['PRI07032'] = 'Duplicated…..The IHC tariff you are trying to copy is already existed in the system. Please double-check whether correct county code is selected.';
    msgs['PRI07033'] = 'From Origin to POL will be moved via inland haulage service. Please create RFA in “Include IHC” module';
    msgs['PRI07034'] = 'The confirmed Add-on tariff can be copied to other service scope only. Please check the status of Add-on tariff.';
    msgs['PRI07035'] = 'The effective date of new Add-on should be later than the effective date of current tariff. Please double-check the effective date of below Add-on guideline.\n\n{?msg1}';
    msgs['PRI07036'] = 'The system is reading that it’s currently on the process of Add-on tariff updates for below service scopes as its status is “Initial”. The Add-on tariff can be copied when the status is “confirmed” or ‘not existing for relevant service scopes.  Please double-check the status of below Add-on tariffs.\n\n{?msg1}';
    msgs['PRI07037'] = 'Updated route is not available. Please check again.';
    msgs['PRI07038'] = "Please check the Term. Couldn't insert the different condition Term \nin the same location column.";
    msgs['PRI07039'] = 'RFA will apply new system from 1st, January 2013 \nPlease check the Duration & Effective date';    
    msgs['PRI07040'] = 'RFA will apply new system from 1st, January 2013 \nPlease check the Expiration date';    
    msgs['PRI07041'] = 'Please input the {?msg1} amount.';
    msgs['PRI07042'] = 'There is ‘0’ as tariff amount.\nPlease check route of below SVC mode.\n\n{?msg1}';
    msgs['PRI07043'] = 'Effective date should be later than [{?msg1}]';
    msgs['PRI07044'] = 'RFA autorating will apply new system from 19th, January 2013 \nPlease check the Expiration date';
    msgs['PRI07045'] = 'Do you want to retrieve selected Inland service mode?';
    msgs['PRI07046'] = 'At least, one of below columns should be filled out to retrieve rate properly.\n ‘Origin’, ‘Destination’, ‘Request office’';
    msgs['PRI07047'] = 'Please check the amount at "TRO inquiry" or "Web page".';
    msgs['PRI07048'] = 'Are the RATEs confirmed by HO?';
    msgs['PRI07049'] = 'Are you sure that spot rate?';
    msgs['PRI07050'] = 'BCO customer cannot have actual customer. Please recheck it.';
    msgs['PRI07051'] = '> After you select RFA Type as Contract from Basic, you cannot go\n   back  to Basic if you click save.\n\n> Contract Customer : whose contract has\n   1) fixed rate\n   2) MQC/Award during the contract period. \n\n> When you select the "CONTRACT"\n   A. Creation wise\n       1. "Target MVC" & "Target MQC" are mandatory items. \n       2. Able to put the same Actual Customer in several rows at\n          commodity group for inputting various commodity.\n           - However, various actual customers cannot put in at\n             commodity group. \n\n   B. Amendment wise\n       3. Cannot make extention on EXP. Date.\n           - After completion of the contract period, we must re-create\n             the RFA.\n       4. Cannot make amendment on RFA type, Target MVC, once\n          confirmed.';
//    msgs['PRI07051'] = '> Contract Customer : whose contract has\n   1) fixed rate\n   2) MQC/Award during the contract period. \n\n> When you select the "CONTRACT"\n   A. Creation wise\n       1. "Target MVC" & "Target MQC" are mandatory items. \n       2. Able to put the same Actual Customer in several rows at\n          commodity group for inputting various commodity.\n           - However, various actual customers cannot put in at\n             commodity group. \n\n   B. Amendment wise\n       3. Cannot make extention on EXP. Date.\n           - After completion of the contract period, we must re-create\n             the RFA.\n       4. Cannot make amendment on RFA type, Target MVC, once\n          confirmed.';
    msgs['PRI07052'] = '> After you select RFA Type as Spot from Basic, you cannot go back \n   to Basic if you click save.\n\n> Spot customer : R/R(or PSC) target customer whose rate\n                         is moving in line with the market.\n\n> When you select the "Spot" : Same as current RFA logic.';
//    msgs['PRI07052'] = '> Spot customer : R/R(or PSC) target customer whose rate\n                         is moving in line with the market.\n\n> When you select the "Spot" : Same as current RFA logic.';
    msgs['PRI07053'] = 'Please check the rate and effective/expired date once again before you accept all.';
    msgs['PRI07054'] = 'Please input the Location term.\n[Scope-Origin or Destination-Location or Location Group]{?msg1}';
    msgs['PRI07055'] = 'Please check effective date ({?msg1} day validation)'; 
    msgs['PRI07056'] = 'This is a Retroactive RFA case, \nbecause Creation date is later than Effective date.\nThis Retroactive RFA data will be transmitted to \n‘Retroactive RFA monitoring Report’ automatically.\nTake steps to ensure that retroactive RFA does not happen again.';
    msgs['PRI07057'] = 'Maximum Retrieval Period : {?msg1} days. \nPlease check period.';
	msgs['PRI07058'] = 'Put the OTF line at the top of each route.';
	msgs['PRI07059'] = 'It is prohibited to enter data.';
	//msgs['PRI07060'] = 'Duration should not be more than 14 days for Master RFA Publishing.';
	//20180219일 정하나 과장님 요청으로 1개월로 변경
	msgs['PRI07060'] = 'Duration should not be more than 1 month for Master RFA Publishing.';
	msgs['PRI07061'] = 'Please select the Spot or CONTRACT Type.';
	msgs['PRI07062'] = 'You can not amend APP Charge Code';
	msgs['PRI07063'] = 'Amend Eff date must be same or later than requested date.';
	msgs['PRI07064'] = 'Amend Eff date can’t be over 3months from current expiration date.';
	//msgs['PRI07065'] = 'M RFA AMD No. {?msg1} has children B RFA. Need to sync them with M RFA too. \nPls go to B RFA amendment or Multi B RFA auto amendment.';
	msgs['PRI07065'] = 'M RFA AMD No. {?msg1} has children B RFA. You can not cancel approve.';

	msgs['PRI07066'] = 'Please cancel Basic RFA initial status and go to Basic RFA Auto Amend.';
    msgs['PRI07067'] = 'DEM/DET Auto Update First!';

    // Special Cargo Quotation
    msgs['PRI09001'] = 'Attached File is deleted due to storage server capacity';
    msgs['PRI09002'] = "File size can not exceeds 5MB.";
    msgs['PRI09003'] = 'Make FlatFile Failed!!';
    msgs['PRI09004'] = 'Please select data to save.';
    msgs['PRI09005'] = 'If you want to open "Awkward Cargo Pricing Application", click Confirm button.';
    msgs['PRI09006'] = '"Awkward Cargo Rate Application" - Confirm button.\n"Breakbulk Cargo Rate Application" - Cancel button.';
    msgs['PRI09007'] = 'Mandatory field is missing.';
    msgs['PRI09008'] = 'Cargo Information is Mandatory.';
    msgs['PRI09009'] = 'Invalid duration';
    msgs['PRI09010'] = 'Over length exists. Please contact awkward cargo approval staff and make sure if this shipment is acceptable.';
    msgs['PRI09011'] = 'Mandatory field of Cargo Sheet is missing.';
    msgs['PRI09012'] = 'Container Information is Mandatory.';
    msgs['PRI09013'] = 'Mandatory field of Container Sheet is missing.';
    msgs['PRI09014'] = 'Request No / Request Ver is Invalid.';
    msgs['PRI09015'] = 'Remark is mandatory item when {?msg1}.';
    msgs['PRI09016'] = 'Data not changed. Do you want Count Offer with this data ?';
    msgs['PRI09017'] = 'Invaild Office Code.';
    msgs['PRI09018'] = 'Extra Handling Cost by Route is Mandatory.\n Select Product Catalog First.';
    msgs['PRI09019'] = 'POL/POD Changed. Select Product Catalog again.';
    msgs['PRI09020'] = 'Calculate Extra Handling Cost First.';
    msgs['PRI09021'] = 'Cargo Information Changed. Calculate again.';
    msgs['PRI09022'] = '{?msg1} not same. So Request can not Approved.';
    msgs['PRI09023'] = 'There is no data modified. Will you proceed it without change?';
    msgs['PRI09024'] = 'The length of {?msg1} over its limit ( 4000 Digit ).';
    
    
    //Group Location 을 구분하는  전역 변수
    PRI_RG          = 0;  // RFA Guideline
    PRI_RP_SCP      = 1;  // RFA Proposal
    PRI_SG          = 2;  // S/C Guideline
    PRI_SP_SCP      = 3;  // S/C Proposal
    PRI_SCG         = 4;  // Surcharge
    PRI_CMPB        = 5;  // CMPB Guideline
    PRI_SQ          = 6;  // SQ Guideline
    PRI_RQ          = 7;  // RQ Guideline

    var LOCATION_TYPE1 = new Array();
    LOCATION_TYPE1[0] = " |L|C";
    LOCATION_TYPE1[1] = " |Location|Country";

    var LOCATION_TYPE2 = new Array();
    LOCATION_TYPE2[0] = " |L|G";
    LOCATION_TYPE2[1] = " |Location|Location Group";

    var LOCATION_TYPE3 = new Array();
    LOCATION_TYPE3[0] = " |L|C|R";
    LOCATION_TYPE3[1] = " |Location|Country|Region";

    var LOCATION_TYPE4 = new Array();
    LOCATION_TYPE4[0] = " |L|G|C";
    LOCATION_TYPE4[1] = " |Location|Location Group|Country";
    
    //---------------------------------------------------------------------------------------------------------------
    //RFA 효율화를 위한 요청 (1차) (CHM-201640671)
    var LOCATION_TYPE5 = new Array();
    LOCATION_TYPE5[0] = " |L|C";
    LOCATION_TYPE5[1] = " |Location|Country";    
    
    // Master RFA Route Point Popup
    var LOCATION_TYPE6 = new Array();
    LOCATION_TYPE6[0] = " |L";
    LOCATION_TYPE6[1] = " |Location";
    //---------------------------------------------------------------------------------------------------------------

    var COMODITY_TYPE1 = new Array();
    COMODITY_TYPE1[0] = " |C|G";
    COMODITY_TYPE1[1] = " |Commodity|Commodity Group";

    var COMODITY_TYPE2 = new Array();
    COMODITY_TYPE2[0] = "R|C";
    COMODITY_TYPE2[1] = "Rep. Commodity|Commodity";

    var COMODITY_TYPE3 = new Array();
    COMODITY_TYPE3[0] = " |C|R|G";
    COMODITY_TYPE3[1] = " |Commodity|Rep. Commodity|Commodity Group";

    // Text입력시 영문을 제외하고 허용가능한 character
    var PRI_VALID_CHAR = "01234567890 !@#$%^&*()-=\\_+|[]{},.<>/?;':`~\"\r\n\t";

    // IE6 에서 팝업을 호출할 경우 height 값을 더하여 팝업호출
    var IE6_ADD_HEIGHT = 25;
    // IE6 에서 팝업을 호출할때 하단 status 를 감안할 경우 값을 더하여 팝업호출
    var IE6_ADD_STATUS_HEIGHT = 20;
    // IE6 에서 팝업을 호출할때 Thema 에 따라 달라지는 사이즈를 감안하여 추가로 값을 더하여 팝업호출
    var IE6_ADD_THEMA_HEIGHT = 5;
    // IE6 에서 팝업을 호출할 경우 width 값을 더하여 팝업호출
    var IE6_ADD_WIDTH = 5;
    
    //구주 Hinterland Expired Date
    var endExpDt = "20120630";
    
    //구주 Hinterland Expired Date    
	var addOnEndExpDt = "20130101";
	
	var guideExcepSvcScpCd = new Array('TPE','TPW','ACE','ACW','TAE','TAW','ASE','ASW','MMW','MME','SAN','SAS','CAN','CAS','CSE','CME','MWS','MWN','CCS','CCN','CLN','CLS');
	
	/**
	 * Add-On Tariff 프로젝트에서 Guide Line 예외 Service Scope.
	 * 존재하면 True
	 * 존재하지 않으면 False
	 */
	function ComCheckGuideExcepSvcScpCd(inSvcScpCd) {
		if(guideExcepSvcScpCd.toString().indexOf(inSvcScpCd) > -1) {
			return true;
		}
		return false;
	}
    /**
     * scrollBar를 초기화 한다 <br>
     * @author 문동규
     * @version 2009.11.09
     **/
//    try {
//        top.showFlashMenu();
//        top.document.body.scrollTop = 0;
//    } catch(err) { }

    /**
     * IBSheet에서 Amend를 고려한 중복체크를 실행한다.
     * 이전 Amend Sequence를 가진 행이나, Amend Delete(AD)된 행은 제외하고 체크한다.
     * 중복된 행이 없으면 -1을, 중복된 행이 있으면 해당 행의 row Index를 반환한다.(0 이상 값)  <br>
     * <br><b>Example :</b>
     * <pre>
     *     var dupRow = ComPriAmendDupCheck(sheetObj, "prc_cmdt_tp_cd|prc_cmdt_def_cd", formObj.amdt_seq.value);
     *     if (dupRow >= 0) {
     *         sheetObj.SelectRow = dupRow;
     *         ComShowCodeMessage("PRI00302");
     *         return false;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj    필수,IBSheet Object
     * @param {string}  sCol        필수, 중복검사시 기준이 되는 컬럼의 SaveName. "|"로 연결
     * @param {string}  amdtSeq     필수, 현재 amend sequence.(document.form.amdt_seq.value)
     * @return int <br>
     *         -1   : 중복된 행이 없을 경우
     *         0이상 : 중복된 Row의 Row Index
     * @author 박성수
     * @version 2009.06.10
     */
    function ComPriAmendDupCheck(sheetObj, sCol, amdtSeq) {
        try {
            if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
                return;
            }
            if (sCol == undefined || sCol == null || sCol == "") {
                return;
            }
            if (sheetObj.RowCount <= 0) {
                return -1;
            }

            var dupRow = sheetObj.ColValueDupRows(sCol, false, true);
            if (dupRow == null || dupRow == "") {
                return -1;
            }

            var arrCol = sCol.split("|");
            var arrTemp = dupRow.split("|");

            var arrBaseRow = arrTemp[0].split(",");
            var arrDesRow = arrTemp[1].split(",");

            for (var i = arrDesRow.length - 1; i >= 0; i--) {
                if (sheetObj.CellValue(arrDesRow[i], "amdt_seq") != amdtSeq
                        || sheetObj.CellValue(arrDesRow[i], "src_info_cd") == "AD") {
                    arrDesRow.splice(i, 1);
                }
            }

            for (var i = arrBaseRow.length - 1; i >= 0; i--) {
                if (sheetObj.CellValue(arrBaseRow[i], "amdt_seq") != amdtSeq
                        || sheetObj.CellValue(arrBaseRow[i], "src_info_cd") == "AD") {

                    for (var j = 0; j < arrDesRow.length; j++) {
                        var isSame = true;
                        for (var k = 0; k < arrCol.length; k++) {
                            if (sheetObj.CellValue(arrBaseRow[i], arrCol[k]) != sheetObj.CellValue(arrDesRow[j], arrCol[k])) {
                                isSame = false;
                                break;
                            }
                        }

                        if (isSame) {
                            arrDesRow.splice(j, 1);
                            break;
                        }
                    }

                    arrBaseRow.splice(i, 1);
                }
            }

            if (arrDesRow.length > 0) {
                return arrDesRow[0];
            } else {
                return -1;
            }

        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
     * IBSheet에서 Amend를 고려한 중복체크를 실행한다.
     * 이전 Amend Sequence를 가진 행이나, Amend Delete(AD)된 행은 제외하고 체크한다.
     * 중복된 행이 없으면 -1을, 중복된 행이 있으면 해당 행의 row Index를 모두 반환한다.(0 이상 값)  <br>
     * <br><b>Example :</b>
     * <pre>
     *     var dupRow = ComPriAmendDupCheck(sheetObj, "prc_cmdt_tp_cd|prc_cmdt_def_cd", formObj.amdt_seq.value);
     *     if (dupRow >= 0) {
     *         sheetObj.SelectRow = dupRow;
     *         ComShowCodeMessage("PRI00302");
     *         return false;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj  필수,IBSheet Object
     * @param {string}  sCol        필수, 중복검사시 기준이 되는 컬럼의 SaveName. "|"로 연결
     * @param {string}  amdtSeq   필수, 현재 amend sequence.(document.form.amdt_seq.value)
     * @return int <br>
     *        					 -1   : 중복된 행이 없을 경우
     *         				   0이상 : 중복된 Row의 Row Index  (ex. 123,124,125,)
     * @author 서미진
     * @version 2012.122.12
     */
    function ComPriAmendDupCheckAllRow(sheetObj, sCol, amdtSeq) {
        try {
            if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
                return;
            }
            if (sCol == undefined || sCol == null || sCol == "") {
                return;
            }
            if (sheetObj.RowCount <= 0) {
                return -1;
            }

            var dupRow = sheetObj.ColValueDupRows(sCol, false, true);
            if (dupRow == null || dupRow == "") {
                return -1;
            }

            var arrCol = sCol.split("|");
            var arrTemp = dupRow.split("|");

            var arrBaseRow = arrTemp[0].split(",");
            var arrDesRow = arrTemp[1].split(",");

            for (var i = arrDesRow.length - 1; i >= 0; i--) {
                if (sheetObj.CellValue(arrDesRow[i], "amdt_seq") != amdtSeq
                        || sheetObj.CellValue(arrDesRow[i], "src_info_cd") == "AD") {
                    arrDesRow.splice(i, 1);
                }
            }

            for (var i = arrBaseRow.length - 1; i >= 0; i--) {
                if (sheetObj.CellValue(arrBaseRow[i], "amdt_seq") != amdtSeq
                        || sheetObj.CellValue(arrBaseRow[i], "src_info_cd") == "AD") {

                    for (var j = 0; j < arrDesRow.length; j++) {
                        var isSame = true;
                        for (var k = 0; k < arrCol.length; k++) {
                            if (sheetObj.CellValue(arrBaseRow[i], arrCol[k]) != sheetObj.CellValue(arrDesRow[j], arrCol[k])) {
                                isSame = false;
                                break;
                            }
                        }

                        if (isSame) {
                            arrDesRow.splice(j, 1);
                            break;
                        }
                    }

                    arrBaseRow.splice(i, 1);
                }
            }

            if (arrDesRow.length > 0) {
                return arrDesRow+",";
            } else {
                return -1;
            }

        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * IBSheet에서 주어진 조건에 맞는 행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
     * saveColName 파라미터를 이용하여 원하는 컬럼을 지정할수 있고, <br>
     * sCol, sValue 파라미터를 이용하여 원하는 행의 조건을 줄수 있다.(필터링) <br>
     * saveColName의 값이 없으면 전체 컬럼을 대상으로 진행되고, <br>
     * sCol, sValue 값이 없으면 전체 행을 대상으로 진행된다. <br>
     * Sheet의 전체 데이터에 대해 스캔이 이루어지므로, 데이터양이 너무 많을 경우 속도가 저하될수 있음에 유의한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sXml = ComPriSheet2Xml(sheetObj);
     *     sXml = ComPriSheet2Xml(sheetObj, "col1|col2|col3|col4");
     *     sXml = ComPriSheet2Xml(sheetObj, null, "svc_scp_cd|gline_seq", "ACE|1", true);
     * </pre>
     * @param {ibsheet} sheetObj    필수,IBSheet Object
     * @param {string}  saveColName 선택,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
     *                              지정하지 않으면, 전체 컬럼을 대상으로 한다.
     * @param {string}  sCol        선택, 행조회시 기준이 되는 컬럼의 SaveName. "|"로 연결
     *                              지정하지 않으면, 전체 행을 대상으로 한다.
     * @param {string}  sValue      선택, 행조회시 기준이 되는 컬럼의 값(Value). "|"로 연결
     *                              지정하지 않으면, 전체 행을 대상으로 한다.
     * @param {bool}    bRowDel     선택, 원본행삭제여부, default=false.
     * @param {bool}    bIsStyled   선택, 열과 행의 색상 Editable정보 포함 여부, default=false. ComPriSheet2StyledXml 참조
     * @return string,  Sheet의 데이터를 조회XML로 구성한 문자열
     * @author 박성수
     * @version 2009.05.07
     */
    function ComPriSheet2Xml(sheetObj, saveColName, sCol, sValue, bRowDel, bIsStyled)  {
        try {
            if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
                return "";
            }

            var allXml = "";
            var sColSep = "☜☞";
            var allRows = false;
            var arrPrcdRow = new Array();

            if (saveColName == undefined || saveColName == null || saveColName == "") {
                saveColName = IBS_ConcatSaveName(sheetObj);
            }

            var arrCol = saveColName.split("|");

            var condNames = new Array();
            var condValues = new Array();
            if (sCol == undefined || sCol == null || sCol == "" || sValue == undefined || sValue == null || sValue == "") {
                allRows = true;
            } else {
                condNames = sCol.split("|");
                condValues = sValue.split("|");
            }

            var aryTR  = new Array();
            var aryTD = new Array(arrCol.length);

            if (sheetObj.RowCount > 0) {
                for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
                    var isMatch = true;
                    if (!allRows) {
                        for (var j = 0; j < condNames.length; j++) {
                            isMatch = true;
                            if (sheetObj.CellValue(i, condNames[j]) != condValues[j]) {
                                isMatch = false;
                                break;
                            }
                        }
                    }

                    if (!isMatch) {
                        continue;
                    }

                    if (bIsStyled) {
                        var sheetFontColor = sheetObj.SysColor2WebColor(sheetObj.DataFontColor);
                        var sheetBackColor = sheetObj.SysColor2WebColor(sheetObj.DataBackColor);
                        var sheetBackColorAlt = sheetObj.SysColor2WebColor(sheetObj.DataAltanateBackColor);

                        var sTr = "";
                        sTr += "\t<TR";
                        var rowFontColor = sheetObj.SysColor2WebColor(sheetObj.RowFontColor(i));
                        if (rowFontColor !=  "" && rowFontColor != sheetFontColor) {
                            var radixVal = parseInt(rowFontColor.substring(0, 2), 16) + "," + parseInt(rowFontColor.substring(2, 4), 16) + "," + parseInt(rowFontColor.substring(4, 6), 16);
                            sTr += " COLOR=\"" + radixVal + "\"";
                        }

                        var rowBackColor = sheetObj.SysColor2WebColor(sheetObj.RowBackColor(i));
                        if (rowBackColor !=  "" && rowBackColor != sheetBackColor && rowBackColor != sheetBackColorAlt) {
                            var radixVal = parseInt(rowBackColor.substring(0, 2), 16) + "," + parseInt(rowBackColor.substring(2, 4), 16) + "," + parseInt(rowBackColor.substring(4, 6), 16);
                            sTr += " BGCOLOR=\"" + radixVal + "\"";
                        }

                        var rowEditable = new String(sheetObj.RowEditable(i)).toUpperCase();
                        sTr += " EDIT=\"" + rowEditable + "\"";

                        for (var j = 0; j < arrCol.length; j++) {
                            aryTD[j] = "";
                            aryTD[j] += "\t\t<TD";

                            var cellFontColor = sheetObj.SysColor2WebColor(sheetObj.CellFontColor(i, arrCol[j]));
                            if (cellFontColor !=  "" && cellFontColor != sheetFontColor && cellFontColor != rowFontColor) {
                                var radixVal = parseInt(cellFontColor.substring(0, 2), 16) + "," + parseInt(cellFontColor.substring(2, 4), 16) + "," + parseInt(cellFontColor.substring(4, 6), 16);
                                aryTD[j] += " COLOR=\"" + radixVal + "\"";
                            }

                            var cellBackColor = sheetObj.SysColor2WebColor(sheetObj.CellBackColor(i, arrCol[j]));
                            if (cellBackColor !=  "" && cellBackColor != sheetBackColor
                                    && cellBackColor != sheetBackColorAlt && cellBackColor != rowBackColor) {
                                var radixVal = parseInt(cellBackColor.substring(0, 2), 16) + "," + parseInt(cellBackColor.substring(2, 4), 16) + "," + parseInt(cellBackColor.substring(4, 6), 16);
                                aryTD[j] += " BGCOLOR=\"" + radixVal + "\"";
                            }

                            var cellEditable = new String(sheetObj.CellEditable(i, arrCol[j])).toUpperCase()
                            if (cellEditable !=  "" && cellEditable != rowEditable) {
                                aryTD[j] += " EDIT=\"" + cellEditable + "\"";
                            }

                            if (sheetObj.ToolTipText(i, arrCol[j]) != "") {
                                var sTxt = sheetObj.ToolTipText(i, arrCol[j]).replace(/&/g, "&amp;").replace(/\"/g, "&quot;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
                                aryTD[j] += " TOOL-TIP=\"" + sTxt + "\"";
                            }

                            aryTD[j] += "><![CDATA[" + new String(sheetObj.CellValue(i, arrCol[j])) + "]]></TD>";
                        }

                        sTr += ">\n" + aryTD.join("\n")+ "\t</TR>";

                        aryTR.push(sTr);
                    } else {
                        for (var j = 0; j < arrCol.length; j++) {
                            aryTD[j] = String(sheetObj.CellValue(i, arrCol[j]));
                        }
                        aryTR.push("\t<TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>");
                    }

                    arrPrcdRow.push(i);
                }
            }

            allXml += "<?xml version='1.0'  ?>\n";
            allXml += "<SHEET>\n";
            allXml += "  <DATA TOTAL='" + arrPrcdRow.length + "' COLORDER='" + saveColName + "'";
            if (!bIsStyled) {
                allXml += " COLSEPARATOR='" + sColSep + "'";
            }
            allXml += ">\n";
            allXml += aryTR.join("\n");
            allXml += "  </DATA>\n";
            allXml += "</SHEET>";

            if (bRowDel) {
                if (allRows) {
                    sheetObj.RemoveAll();
                } else {
                    sheetObj.Redraw = false;
                    sheetObj.RedrawSum = false;
                    for(var i = arrPrcdRow.length - 1; i >= 0; i--){
                        sheetObj.RowDelete(arrPrcdRow[i], false);
                    }
                    sheetObj.RedrawSum = true;
                    sheetObj.Redraw = true;
                }
            }

            return allXml;
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * IBSheet에서 주어진 조건에 맞는 행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
     * ComPriSheet2Xml함수에서 StyledXML 이용을 쉽게하기 위해 추가된 함수.<br>
     * 기본적인 사용법은 ComPriSheet2Xml함수를 참조하도록 한다. <br>
     * Sheet의 XML을 가져올때 기본형태인 TR-COLSEPARATOR 조합의 형태가 아닌 <br>
     * TR-TD형태로 만들어준다. 따라서 각 ROW이나 CELL별로 색상, 배경색, 수정가능여부 등의 설정이 가능하다.<br>
     * IBSheet도움말의 조회XML부분을 참조하라. IBSheet의 특성상 모든 기능을 사용할 수는 없고,
     * 현재 TR요소에서 BGCOLOR, COLOR, EDIT가 사용가능하고,<br>
     * TD요소에서 BGCOLOR, COLOR, EDIT, TOOL-TIP 속성이 사용가능하다.<br>
     * 추후 IBSheet패치여부에 따라 FontStrike도 적용 예정임.
     * <br><b>Example :</b>
     * <pre>
     *     sXml = ComPriSheet2StyledXml(sheetObj);
     *     sXml = ComPriSheet2StyledXml(sheetObj, "col1|col2|col3|col4");
     *     sXml = ComPriSheet2StyledXml(sheetObj, null, "svc_scp_cd|gline_seq", "ACE|1", true);
     * </pre>
     * @param {ibsheet} sheetObj    필수,IBSheet Object
     * @param {string}  saveColName 선택,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
     *                              지정하지 않으면, 전체 컬럼을 대상으로 한다.
     * @param {string}  sCol        선택, 행조회시 기준이 되는 컬럼의 SaveName. "|"로 연결
     *                              지정하지 않으면, 전체 행을 대상으로 한다.
     * @param {string}  sValue      선택, 행조회시 기준이 되는 컬럼의 값(Value). "|"로 연결
     *                              지정하지 않으면, 전체 행을 대상으로 한다.
     * @param {bool}    bRowDel     선택, 원본행삭제여부, default=false.
     * @return string,  Sheet의 데이터를 조회XML로 구성한 문자열
     * @author 박성수
     * @version 2009.05.07
     */
    function ComPriSheet2StyledXml(sheetObj, saveColName, sCol, sValue, bRowDel)  {
        return ComPriSheet2Xml(sheetObj, saveColName, sCol, sValue, bRowDel, true);
    }

    /**
     * 주어진 sheetObj에 IBSheet의 SearchXM을 로드한다. <br>
     * AppendMode에 따라 원본sheet 내용의 전체 또는 일부분을 클리어하고 로드하거나, Append할 수 있다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     sXml = ComPriXml2Sheet(sheetObj, sXml);
     *     sXml = ComPriXml2Sheet(sheetObj, sXml, 2);
     *     sXml = ComPriXml2Sheet(sheetObj, sXml, 1, "svc_scp_cd|gline_seq", "ACE|1");
     * </pre>
     * @param {ibsheet} sheetObj    필수, IBSheet Object
     * @param {string}  sXml        필수, Sheet에 로드할 Search XML.
     * @param {int}    bAppendMode  선택, 원본Sheet(sheetObj)의 내용의 처리방법. default=0<br>
     *                              0 : Clear, 원본Sheet의 내용을 모두 삭제하고 sXml의 내용을 sheetObj에 Load한다.<br>
     *                              1 : Replace, 원본Sheet의 내용 중, sCol/sValue의 조건에 해당하는 부분만 삭제하고 Load.<br>
     *                              2 : Append, 원본Sheet의 내용을 변경하지 않고, 뒷부분에 Append한다.
     * @param {string}  sCol        선택, bAppendMode가 1일 경우, 삭제 대상이 되는 조건 컬럼의 SaveName. "|"로 연결.
     * @param {string}  sValue      선택, bAppendMode가 1일 경우, 삭제 대상이 되는 조건의 값. "|"로 연결.
     * @return 없음.
     * @author 박성수
     * @version 2009.05.13
     */
    function ComPriXml2Sheet(sheetObj, sXml, bAppendMode, sCol, sValue)  {
        try {
            if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT"  || sXml == undefined || sXml == null || sXml == "") {
                return;
            }
            if (bAppendMode == undefined || bAppendMode == null || bAppendMode == "") {
                bAppendMode = 0;
            }

            if (bAppendMode == 0) {
                sheetObj.RemoveAll();
            } else if (bAppendMode == 1) {
                var arrCol = sCol.split("|");
                var arrValue = sValue.split("|");

                for (var i = sheetObj.LastRow; i >= sheetObj.HeaderRows; i--) {
                    var isMatch = true;
                    for (var j = 0; j < arrCol.length; j++) {
                        if (sheetObj.CellValue(i, arrCol[j]) != arrValue[j]) {
                            isMatch = false;
                            break;
                        }
                    }
                    if (isMatch) {
                        sheetObj.RowDelete(i, false);
                    }
                }
            }

            sheetObj.LoadSearchXml(sXml, true);

        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * 한 화면에 여러개의 Sheet가 있는 경우, SaveString에 prefix를 붙여준다 <br>
     *
     * @param {string} sStr 필수, QueryString from IBSheet.GetSaveString().
     * @param {string} sPrefix 필수, Prefix.
     * @return string 쿼리스트링의 각 name앞에, 주어진 prefix가 붙여진 쿼리스트링.
     * @author 박성수
     * @version 2009.04.22
     */
    function ComPriSetPrifix(sStr, sPrefix) {
        if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
            return sStr;
        }

        var regexp = RegExp(/&/g);
        sStr = sPrefix + sStr.replace(regexp, "&" + sPrefix);
        return sStr;
    }

    /**
     * IBSheet의 row들을 주어진 값과 일치하는 row의 Index를 배열형태로 반환한다 <br>
     *
     * @param {object} sheetObj 필수, IBSheet Object.
     * @param {string} sCol 필수, 키 컬럼명(Savename). "|"로 연결한다.
     * @param {string} sValue 필수, 키 데이터. "|"로 연결한다.
     * @return array 주어진 조건에 일치하는 행의 Index로 이루어진 배열.
     * @author 박성수
     * @version 2009.04.22
     */
    function ComPriSheetFilterRows(sheetObj, sCol, sValue) {
        if (sheetObj == null || sCol == null || sCol == "" || sValue == null || sValue == "") {
            return;
        }

        var rtnArr = new Array();
        var arrCol = sCol.split("|");
        var arrValue = sValue.split("|");


        for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            var isMatch = true;
            for (var j = 0; j < arrCol.length; j++) {
                if (sheetObj.CellValue(i, arrCol[j]) != arrValue[j]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                rtnArr.push(i);
            }
        }

        return rtnArr;
    }

    /**
     * IBSheet의 row들을 주어진 값과 일치하는 row만 보이도록 필터링 한다. <br>
     * 필터링 후 필터된 row중 첫번째 row를 select해 준다. <br>
     *
     * @param {object} sheetObj 필수, IBSheet Object.
     * @param {string} sCol 필수, 키 컬럼명(Savename). "|"로 연결한다.
     * @param {string} sValue 필수, 키 데이터. "|"로 연결한다.
     * @return 없음
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriSheetFilter(sheetObj, sCol, sValue, bSelectLast) {
        if (sheetObj == null || sCol == null || sCol == "" || sValue == null || sValue == "") {
            return;
        }

        var arrCol = sCol.split("|");
        var arrValue = sValue.split("|");
        var firstRow = -1;

        for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
            if (sheetObj.RowStatus(i) == "D") {
                continue;
            }

            var doHide = false;
            for (var j = 0; j < arrCol.length; j++) {
                if (sheetObj.CellValue(i, arrCol[j]) != arrValue[j]) {
                    doHide = true;
                    break;
                }
            }
            if (!doHide && (bSelectLast || firstRow == -1)) {
                firstRow = i;
            }
            sheetObj.RowHidden(i) = doHide;
        }

        if (firstRow > 0) {
            sheetObj.SelectRow = firstRow;
        }
    }

    /**
     * Master/Detail로 이루어진 2개의 IBSheet에서 Master에서 선택된 row에 해당하는 내용만 Detail에 보이도록 필터링 한다. <br>
     *
     * @param {object} sheetObjM 필수, Master IBSheet Object.
     * @param {object} sheetObjD 필수, Detail IBSheet Object.
     * @param {string} sCol 필수, 키 컬럼명(Savename). "|"로 연결한다.
     * @return 없음
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriMDSheetFilter(sheetObjM, sheetObjD, sCol) {
        if (sheetObjM == null || sheetObjD == null || sCol == null || sCol == "") {
            return;
        }
        var idx = sheetObjM.SelectRow;
        var arrCol = sCol.split("|");
        var sValue = "";

        for (var i = 0; i < arrCol.length; i++) {
            sValue += sheetObjM.CellValue(idx, arrCol[i]);
            if (i < arrCol.length - 1) {
                sValue += "|";
            }
        }

        ComPriSheetFilter(sheetObjD, sCol, sValue);
    }

    /**
     * SHEET에서 CHECK된 ROW의 INDEX를 배열로 리턴한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *  var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
     *  for(var i=0;i < chkArr.length;i++){
     *      ComDebug(sheetObj.CellValue(Number(chkArr[i]), "note_seq"));
     *  }
     * </pre>
     * @param  {ibsheet} sheetObj 필수 IBSheet Object
     * @param  {string} Column Index(SaveName)
     * @return chkArr Array
     * @author 최성민
     * @version 2009.08.13
     */
    function ComPriSheetCheckedRows(sheetObj, selChk) {
     var chkArr = new Array();
     var iCheckRow = sheetObj.FindCheckedRow(selChk).slice(0, -1);

     if(iCheckRow != "") {
         chkArr = iCheckRow.split("|");
     }

     return chkArr;
    }

    /**
     * 주어진 컬럼의 Max값 구하기 <br>
     *
     * @param {object} sheetObj 필수, IBSheet Object.
     * @param {string} sCol 필수, Max값을 구할 컬럼명(Savename).
     * @return int Max값
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriGetMax(sheetObj, sCol) {
        var max = 0;
        for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
            if (parseInt(sheetObj.CellValue(i, sCol)) > max) {
                max = sheetObj.CellValue(i, sCol);
            }
        }
        return max;
    }


    /**
     * 삭제된 row를 제외한 컬럼의 Max값 구하기 <br>
     *
     * @param {object} sheetObj 필수, IBSheet Object.
     * @param {string} sCol 필수, Max값을 구할 컬럼명(Savename).
     * @return int Max값
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriGetMaxExceptDelete(sheetObj, sCol) {
        var max = 0;
        for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
            if(sheetObj.RowStatus(i) == "D") continue;

            if (parseInt(sheetObj.CellValue(i, sCol), 10) > max) {
                max = sheetObj.CellValue(i, sCol);
            }
        }
        return max;
    }


    /**
     * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 Array형태로 변환한다. <br>
     * <b>Example :</b>
     *
     * <pre>
     * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
     * var arrData = ComPriXml2Array(xmlStr, &quot;user_id|user_nm|status&quot;);
     *
     * 결과: 35X 3 크기의 결과 Array.
     * </pre>
     *
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열
     * @param {string} colList 필수, XML문자열에서 추출하고자하는 컬럼명(Savename). "|"로 연결한다.
     * @return array   [조회된row수 X 컬럼수] 크기의 string array.
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriXml2Array(xmlStr, colList) {
        var rtnArr = new Array();

        if (xmlStr == null || xmlStr == "" || colList == null || colList == "") {
            return;
        }

        try {
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.loadXML(xmlStr);

            var xmlRoot = xmlDoc.documentElement;
            if (xmlRoot == null) {
                return;
            }

            var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
            if (dataNode == null || dataNode.attributes.length < 2) {
                return;
            }

            var col = dataNode.getAttribute("COLORDER");
            var colArr = col.split("|");
            var sep = dataNode.getAttribute("COLSEPARATOR");
            var total = dataNode.getAttribute("TOTAL");

            var dataChildNodes = dataNode.childNodes;
            if (dataChildNodes == null) {
                return;
            }

            var colListArr = colList.split("|");
            var colListIdx = Array();
            for (var i = 0; i < colListArr.length; i++) {
                for (var j = 0; j < colArr.length; j++) {
                    if (colListArr[i] == colArr[j]) {
                        colListIdx[i] = j;
                        break;
                    }
                }
            }

            for (var i = 0; i < dataChildNodes.length; i++) {
                if (dataChildNodes[i].nodeType != 1) {
                    continue;
                }

                var arrData = null;
                if (sep == null || sep == "") {
                    arrData = new Array();
                    var trChildNodes = dataChildNodes[i].childNodes;
                    for (var j = 0; j < trChildNodes.length; j++) {
                        if (trChildNodes[j].nodeType != 1) {
                            continue;
                        }
                        arrData.push(trChildNodes[j].firstChild.nodeValue);
                    }
                } else {
                    arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
                }

                var subDataArr = new Array();
                for (var j = 0; j < colListIdx.length; j++) {
                    subDataArr[j] = arrData[colListIdx[j]];
                }
                rtnArr[i] = (subDataArr);
            }

        } catch (err) {
            ComFuncErrMsg(err.message);
        }

        return rtnArr;
    }

    /**
     * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
     * IBMultiCombo의 item으로 insert 해준다.<br>
     * <b>Example :</b>
     *
     * <pre>
     * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
     * var arrData = ComPriXml2ComboItem(xmlStr, combo1, &quot;cd&quot;, &quot;nm&quot;);
     *
     * </pre>
     *
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
     * @param {object} cmbObj 필수, insert하고자 하는 IBMultiCombo Object.
     * @param {string} codeCol 필수, Combo의 Code컬럼명.
     * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
     * @param {boolean} bClear 선택, Combo의 기존 내용을 Clear할지 여부(combo.RemoveAll()). 기본값=true.
     * @param {string} excludeCols 선택, 콤보에서 빼고 싶은 Code명, 다수일 경우 '|' 로 연결. ( ex. "TAE|TAW|ASE|ASW" )
     * @return 없음.
     * @author 박성수
     * @version 2009.04.22
     */
    function ComPriXml2ComboItem(xmlStr, cmbObj, codeCol, textCol, bClear, excludeCols) {
        if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
            return;
        }
        if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
            return;
        }

        try {
            if (bClear != false) {
                cmbObj.RemoveAll();
            }

            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.loadXML(xmlStr);

            var xmlRoot = xmlDoc.documentElement;
            if (xmlRoot == null) {
                return;
            }

            var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
            if (dataNode == null || dataNode.attributes.length < 3) {
                return;
            }

            var col = dataNode.getAttribute("COLORDER");
            var colArr = col.split("|");
            var sep = dataNode.getAttribute("COLSEPARATOR");
            var total = dataNode.getAttribute("TOTAL");

            var dataChildNodes = dataNode.childNodes;
            if (dataChildNodes == null) {
                return;
            }

            var colListIdx = Array();
            var arrText = textCol.split("|");
            for (var i = 0; i < colArr.length; i++) {
                if (colArr[i] == codeCol) {
                    colListIdx[0] = i;
                }
                for (var j = 0; j < arrText.length; j++) {
                    if (colArr[i] == arrText[j]) {
                        colListIdx[j+1] = i;
                    }
                }
            }
            
            var excludeColList = Array();
            if(!ComIsNull(excludeCols)) {
                   var arrExcludeCols = excludeCols.split("|");
                   for (var i = 0; i < arrExcludeCols.length; i++) {
                      excludeColList[i] = arrExcludeCols[i];
                   }  
            }         

            for (var i = 0; i < dataChildNodes.length; i++) {
                if (dataChildNodes[i].nodeType != 1) {
                    continue;
                }

                var arrData = null;
                if (sep == null || sep == "") {
                    arrData = new Array();
                    var trChildNodes = dataChildNodes[i].childNodes;
                    for (var j = 0; j < trChildNodes.length; j++) {
                        if (trChildNodes[j].nodeType != 1) {
                            continue;
                        }
                        arrData.push(trChildNodes[j].firstChild.nodeValue);
                    }
                } else {
                    arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
                }
                var e = true;
                for(var x=0; x < excludeColList.length; x++) {
                	if(excludeColList[x] == arrData[colListIdx[0]]) {
                		e = false;
                        break;
                	}
                }
                if(!e) continue;
                
                var item = "";
                for (var j = 1; j < colListIdx.length; j++) {
                    item += arrData[colListIdx[j]];
                    if (j < colListIdx.length - 1) {
                        item += "|";
                    }
                }
                cmbObj.InsertItem(-1, item, arrData[colListIdx[0]]);
            }

        } catch (err) {
            ComFuncErrMsg(err.message);
        }
    }

    /**
     * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
     * IBSheet의 Combo에 연결할수 있는 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
     * Return되는 배열의 0번째는 Code문자열, 1번째는 Text문자열이 담겨있다.
     * <b>Example :</b>
     *
     * <pre>
     * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
     * var arrData = ComPriXml2ComboString(xmlStr, &quot;cd&quot;, &quot;nm&quot;);
     *
     * </pre>
     *
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
     * @param {string} codeCol 필수, Combo의 Code컬럼명.
     * @param {string} textCol 필수, Combo의 Text컬럼명.
     * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriXml2ComboString(xmlStr, codeCol, textCol) {
        var rtnArr = new Array();

        if (xmlStr == null || xmlStr == "") {
            return;
        }
        if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
            return;
        }

        try {
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.loadXML(xmlStr);

            var xmlRoot = xmlDoc.documentElement;
            if (xmlRoot == null) {
                return;
            }

            var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
            if (dataNode == null || dataNode.attributes.length < 3) {
                return;
            }

            var col = dataNode.getAttribute("COLORDER");
            var colArr = col.split("|");
            var sep = dataNode.getAttribute("COLSEPARATOR");
            var total = dataNode.getAttribute("TOTAL");

            var dataChildNodes = dataNode.childNodes;
            if (dataChildNodes == null) {
                return;
            }

            var colListIdx = Array();
            for (var i = 0; i < colArr.length; i++) {
                if (colArr[i] == codeCol) {
                    colListIdx[0] = i;
                }
                if (colArr[i] == textCol) {
                    colListIdx[1] = i;
                }
            }

            var sCode = "";
            var sText = "";
            for (var i = 0; i < dataChildNodes.length; i++) {
                if (dataChildNodes[i].nodeType != 1) {
                    continue;
                }

                var arrData = null;
                if (sep == null || sep == "") {
                    arrData = new Array();
                    var trChildNodes = dataChildNodes[i].childNodes;
                    for (var j = 0; j < trChildNodes.length; j++) {
                        if (trChildNodes[j].nodeType != 1) {
                            continue;
                        }
                        arrData.push(trChildNodes[j].firstChild.nodeValue);
                    }
                } else {
                    arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
                }

                sCode += arrData[colListIdx[0]];
                sText += arrData[colListIdx[1]];

                if (i != dataChildNodes.length - 1) {
                    sCode += "|";
                    sText += "|";
                }
            }
            rtnArr.push(sCode);
            rtnArr.push(sText);
        } catch (err) {
            ComFuncErrMsg(err.message);
        }

        return rtnArr;
    }

    /**
     * IBSheet의 GetSearchXml함수를 통해 가져온 XML String에서 데이터 Row Count를 구한다.(TOTAL) <br>
     * <b>Example :</b>
     *
     * <pre>
     * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
     * var cnt = ComPriGetRowCountFromXML(xmlStr);
     *
     * </pre>
     *
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열
     * @return int   XML String에 포함된 데이터행의 갯수
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriGetRowCountFromXML(xmlStr) {
        var rtn = -1;

        if (xmlStr == null || xmlStr == "") {
            return rtn;
        }

        try {
            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.loadXML(xmlStr);

            var xmlRoot = xmlDoc.documentElement;
            if (xmlRoot == null) {
                return rtn;
            }

            var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
            if (dataNode == null || dataNode.attributes.length < 3) {
                return rtn;
            }

            rtn = dataNode.getAttribute("TOTAL");

        } catch (err) {
            ComFuncErrMsg(err.message);
        }

        return rtn;
    }

    /**
     * Save 전, 확인 메시지<br>
     *
     * @param 없음
     * @returns bool <br>
     *          true : 확인메시지에서 "확인"을 누른 경우<br>
     *          false : 확인메시지에서 "취소"을 누른 경우<br>
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriConfirmSave() {
        return ComShowCodeConfirm('PRI00001');
    }

      /**
       * 변경내역 Proceed 전, 확인 메시지<br>
       *
       * @param 없음
       * @returns bool <br>
       *          true : 확인메시지에서 "확인"을 누른 경우<br>
       *          false : 확인메시지에서 "취소"을 누른 경우<br>
        * @author 변영주
        * @version 2009.06.02
       */
      function ComPriClearChange() {
          return ComShowCodeConfirm('PRI00010');
      }

    /**
     * Delete 전, 확인 메시지<br>
     *
     * @param 없음
     * @returns bool <br>
     *          true : 확인메시지에서 "확인"을 누른 경우<br>
     *          false : 확인메시지에서 "취소"을 누른 경우<br>
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriConfirmDelete() {
        return ComShowCodeConfirm('PRI00002');
    }

    /**
     * Delete 전, 확인 메시지<br>
     *
     * @param 없음
     * @returns bool <br>
     *          true : 확인메시지에서 "확인"을 누른 경우<br>
     *          false : 확인메시지에서 "취소"을 누른 경우<br>
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriConfirmDeleteAll() {
        return ComShowCodeConfirm('PRI00005');
    }

    /**
     * Confirm 전, 확인 메시지<br>
     *
     * @param 없음
     * @returns bool <br>
     *          true : 확인메시지에서 "확인"을 누른 경우<br>
     *          false : 확인메시지에서 "취소"을 누른 경우<br>
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriConfirmConfirm() {
        return ComShowCodeConfirm('PRI00003');
    }

    /**
     * Cancel Confirm 전, 확인 메시지<br>
     *
     * @param 없음
     * @returns bool <br>
     *          true : 확인메시지에서 "확인"을 누른 경우<br>
     *          false : 확인메시지에서 "취소"을 누른 경우<br>
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriConfirmCancelConfirm() {
        return ComShowCodeConfirm('PRI00004');
    }

    /**
     * Save 후, 성공 메시지<br>
     *
     * @param 없음
     * @return 없음
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriSaveCompleted() {
        ComShowCodeMessage('PRI00101');
    }

    /**
     * Delete 후, 성공 메시지<br>
     *
     * @param 없음
     * @return 없음
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriDeleteCompleted() {
        ComShowCodeMessage('PRI00102');
    }

    /**
     * Confirm 후, 성공 메시지<br>
     *
     * @param 없음
     * @return 없음
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriConfirmCompleted() {
        ComShowCodeMessage('PRI00103');
    }

    /**
     * Confirm Cancel 후, 성공 메시지<br>
     *
     * @param 없음
     * @return 없음
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriCancelConfirmCompleted() {
        ComShowCodeMessage('PRI00104');
    }

    /**
     * Save 후, 실패 메시지<br>
     *
     * @param 없음
     * @return 없음
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriSaveFailed() {
        ComShowCodeMessage('PRI00201');
    }


    /**
     * 진행여부 체크 메세지<br>
     *
     * @param 메시지1 object
     * @return 없음
      * @author 이승준
      * @version 2009.05.11
     */
    function ComPriProcessYn(msg1) {
        return ComShowCodeConfirm("PRI03007",msg1);
    }

    /**
     * 성공 메세지<br>
     *
     * @param 메시지1 object
     * @return 없음
      * @author 이승준
      * @version 2009.05.11
     */
    function ComPriProcessSuccess(msg1) {
        ComShowCodeMessage("PRI01045",msg1);
    }


    /**
     * Delete 후, 실패 메시지<br>
     *
     * @param 없음
     * @return 없음
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriDeleteFailed() {
        ComShowCodeMessage('PRI00202');
    }

    /**
     * Confirm 후, 실패 메시지<br>
     *
     * @param 없음
     * @return 없음
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriConfirmFailed() {
        ComShowCodeMessage('PRI00203');
    }

    /**
     * Confirm Cancel 후, 실패 메시지<br>
     *
     * @param 없음
     * @return 없음
      * @author 박성수
      * @version 2009.04.22
     */
    function ComPriCancelConfirmFailed() {
        ComShowCodeMessage('PRI00204');
    }

    /**
     * input box  등 필수 값 입력 메세지<br>
     *
     * @param 메시지1, 메시지2, input box 등 object
     * @return 없음
      * @author 이승준
      * @version 2009.05.11
     */
    function ComPriInputValueFailed(msg1,msg2,input) {
        ComShowCodeMessage("PRI00308",msg1,msg2);
        if(input != "")
            input.focus();
        return;
    }


    /**
     * 날짜 포멧 실패 메세지 - IBCOMBO 용<br>
     *
     * @param 메시지1
     * @return 없음
      * @author 이승준
      * @version 2009.06.15
     */
    function ComPriDateFormatFailed(msg1) {
        ComShowCodeMessage("PRI00322",msg1);
    }


    /**
     * IBSheet의 중복컬럼을 체크한다. <br>
     * 중복이 되었다면 중복된 row 를 return 하고 중복된 row가 없다면 <br>
     * -1을  return 한다.
     *
     * <b>Example :</b>
     *
     * <pre>
     * var dupRow = jsDupCheck(col);  // 중복 체크할 컬럼을 | 로구분하여 입력한다.
     * </pre>
     *
     * @param {string} col 필수
     * @return int   -1 이면 중복 없음, 중복된 row
     * @author
     * @version 2009.04.22
     */
    function jsDupCheck(ColStr)
    {

        var sText,ir, ic;
        var Row, Col, aryCol, bNext;
        var sheetObject1 = sheetObjects[0];

        Col = -1;
        aryCol = ColStr.split("|");
        ColStr = "";

        //첫번째 컬럼을 찾고, 나머지 가능한 유효 컬럼을 찾는다
        for (ic=0; ic < aryCol.length; ic++) {
            if (aryCol[ic] >= 0 && aryCol[ic] <= sheetObject1.LastCol)
            {
                if (Col == -1)
                    Col = aryCol[ic];
                else
                    ColStr += (ColStr==""?"":"|") + aryCol[ic];
            }
        }

        //한개 컬럼의 중복 여부를 확인하는 경우
        if (ColStr == "") {
            if (Col != -1) return sheetObject1.ColValueDup(Col);

            //다중 컬럼의 중복 여부를 확인하는 경우
        } else {
            aryCol = ColStr.split("|")

            for (ir = 1; ir<= sheetObject1.LastRow; ir++) {
                //첫번째 컬럼의 값으로 중복된 행번호를 가져옴
                sText = sheetObject1.CellText(ir, Col);
                Row = sheetObject1.FindText(Col, sText, ir + 1, true);

                //해당 값으로 중복된 모든 행을 확인
                while (Row > 0) {
                    bNext = false;

                    //중복된 행이 있는 경우 나머지 컬럼 값 일치 여부 확인
                    for (ic=0; ic<aryCol.length; ic++){
                        if (sheetObject1.CellText(ir, aryCol[ic]) != sheetObject1.CellText(Row, aryCol[ic]) ){
                            //하나라도 값이 다르면 그냥 처리 중단, 다음 중복 확인
                            bNext = true;
                            break;
                        }
                    }

                    //모든 컬럼 값이 같으므로 중복 행번 반환
                    if (bNext == false) return Row;

                    Row = sheetObject1.FindText(Col, sText, Row + 1, true);
                }

            }
        }
        return -1;
    }

    /**
     * 전체 Row 중에 Checkbox의 체크가 되어있는 Row들을 숨기고 상태를 삭제로 변경한다.<br>
     * isSelectDel 파라메터를 주면 check된 Checkbox가 없을 경우 현재 선택된 row를 삭제한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     deleteRowCheck(sheetObj);
     *     deleteRowCheck(sheetObj, "chk");
     *     deleteRowCheck(sheetObj, "chk", true);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} selColName 선택 화면에 보여지는 checkbox의 SaveName.
     *                               default="sel_chk"
     * @param {bool} isSelectDel 선택 현재 선택되어있는 row를 삭제할지 여부
     *                                 true : 체크된 row가 없으면 선택되어 있는 row를 삭제
     *                                 그 외 : 체크된 row 만 삭제
     * @return ComRowHideDelete() 함수 return 값
     * @author 문동규
     * @version 2009.04.22
     */
    function deleteRowCheck(sheetObj, selColName, isSelectDel) {
        if (arguments.length == 1) {
            selColName = "sel_chk";
        }

        var checkRow = sheetObj.FindCheckedRow(selColName);
        var selRow = sheetObj.SelectRow;
        var delRowCount = 0;
        var nextVisibleRow = sheetObj.SelectRow;
        var fireEventPostDelete = false;

        // 삭제대상중에 현재 로우가 포함되어있는지 체크
        if ((checkRow == "" && isSelectDel)
                || ("|" + checkRow).indexOf("|" + sheetObj.SelectRow + "|") >= 0) {
            fireEventPostDelete = true;
        }
        // IBSheet의 마지막 로우를 Delete하면(중간 Row를 Delete하는 경우와는 다르게) 이벤트가 발생한다.
        // X같은 IBSheet의 넘치는 버그 중 하나... 따라서 이런 경우 이벤트를 강제로 발생시키지 않도록 처리.
        if (sheetObj.RowStatus(selRow) == "I" && sheetObj.SelectRow == sheetObj.LastRow) {
            fireEventPostDelete = false;
        }

        if (checkRow == "") {
            if (isSelectDel) {
                // check된 row가 없고 선택된 row 상태가 Delete가 아니면 선택된 row를 삭제
                if (selRow != 0 && sheetObj.RowStatus(selRow) != "D") {
                    // 선택된 row를 삭제하기위해 checkbox를 check한다.
                    sheetObj.CellValue2(sheetObj.SelectRow, selColName) = 1;
                    delRowCount = ComRowHideDelete(sheetObj, selColName);
                }
            } else {
                return;
            }
        } else {
            delRowCount = ComRowHideDelete(sheetObj, selColName);
        }

        nextVisibleRow = sheetObj.SelectRow;

        if (sheetObj.RowCount > 0 && delRowCount > 0) {
            if (sheetObj.RowStatus(sheetObj.SelectRow) == "D" && sheetObj.RowHidden(sheetObj.SelectRow)) {
                nextVisibleRow = -1;
//              for (var i = sheetObj.SelectRow; i <= sheetObj.LastRow; i++) {
//                  if (!sheetObj.RowHidden(i) && sheetObj.RowStatus(i) != "D") {
//                      nextVisibleRow = i;
//                      break;
//                  }
//              }
//              if (nextVisibleRow < 0) {
//                  for (var i = sheetObj.SelectRow; i >= sheetObj.HeaderRows; i--) {
//                      if (!sheetObj.RowHidden(i) && sheetObj.RowStatus(i) != "D") {
//                          nextVisibleRow = i;
//                          break;
//                      }
//                  }
//              }
// IBSheet 버그가 해결될때까지 Row를 삭제 후,아래 행이 아닌 윗 행으로 이동한다. 2010-01-05.
                for (var i = sheetObj.SelectRow; i >= sheetObj.HeaderRows; i--) {
                    if (!sheetObj.RowHidden(i) && sheetObj.RowStatus(i) != "D") {
                        nextVisibleRow = i;
                        break;
                    }
                }
                if (nextVisibleRow < 0) {
                    for (var i = sheetObj.SelectRow; i <= sheetObj.LastRow; i++) {
                        if (!sheetObj.RowHidden(i) && sheetObj.RowStatus(i) != "D") {
                            nextVisibleRow = i;
                            break;
                        }
                    }
                }
            }

            if (fireEventPostDelete && nextVisibleRow > 0) {
                try {
                    eval(sheetObj.id + "_OnSelectCell(sheetObj, -2, " + sheetObj.SelectCol + ", " + nextVisibleRow + ", " + sheetObj.SelectCol + ")");
                } catch (err) {
                }
            }

//          nextVisibleRow = nextVisibleRow > sheetObj.LastRow ? sheetObj.LastRow : nextVisibleRow;
// IBSheet 버그가 해결될때까지 Row를 삭제 후,아래 행이 아닌 윗 행으로 이동한다. 2010-01-05.
            nextVisibleRow = nextVisibleRow < sheetObj.HeaderRows ? sheetObj.HeaderRows : nextVisibleRow;
            if (nextVisibleRow > 0) {
                sheetObj.SelectRow = nextVisibleRow;
            }
        }

        return delRowCount;
    }

    /**
     * IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
     * <b>Example :</b>
     * <pre>
     * setIBCombo(sheetObj,sXml,"rcv_de_term_cd",false,1);
     * </pre>
     *
     * @param {string} sheetObj 필수
     * @param {string} sXml 필수, Combo에 채울 데이터(IBSheet를 통해 받아온 xml 문자열.)
     * @param {string} title 필수, Combo field명(IBSheet SaveName).
     * @param {string} iBlank 선택, Combo의 첫번째로우를 블랭크로 설정
     * @param {string} sCol 선택, 멀티콤보일경우 콤보를 선택하면 콤보에 보여질 순서설정(0:코드 or 1:description)
     * @param {string} dCode 선택, 신규 "입력" 상태일 때 기본으로 선택되어야 할 Item에 대한 Code값
     * @param {string} dText 선택, 신규 "입력" 상태일 때 기본으로 선택되어야 할 Item에 대한 Text값
     * @param {string} bFlag multicombo 용 XML 파일을 Sheet 내에서 Combo 형태로 사용할 경우, Text 에 Code+"\t"+Text 형태로 만들어 사용할 수 있게 해 줌
     * (코드|디스크립션 형태가 아닐 경우는 0으로 설정해야함)
     * @return
     * @author 공백진
     * @version 2009.04.30
     */
    function setIBCombo(sheetObj, sXml, title, iBlank, sCol, dCode, dText, bFlag){
        var showCol = 0;
        if (bFlag == undefined || bFlag == ""){
            bFlag = false;
        }
        if (sCol != undefined && sCol !=""){
            showCol = sCol;
        }
        if (iBlank == undefined || iBlank == ""){
            iBlank = false;
        }
        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
        if (bFlag == true && arrData != null){
            var arrCode = arrData[0].split("|");
            var arrName = arrData[1].split("|");
            var conData = "";
            for(i=0; i < arrName.length;i++){
                if(i==0){
                    arrName[i] = arrCode[i]+"\t"+arrName[i];
                }else{
                    arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
                }
                conData = conData.concat(arrName[i]);
            }

            arrData[1] = conData;
        }

        if(iBlank){
            if (arrData != null){
                arrData[0] = " |" + arrData[0];
                arrData[1] = " |" + arrData[1];
            }

        }

        if (arrData != null){
            sheetObj.InitDataCombo(0,title, arrData[1], arrData[0],dText, dCode, showCol);
        }

    }

    /**
     * IBSheet에서 선택된 멀티콤보의 Text 중 Description의 내용을 해당 컬럼에 보여준다. <br>
     * Text 내용은 Code [Tab] Description으로 구성되어있다.
     * 멀티콤보의 SaveName과 Description이 들어가는 Cell의 SaveName을 각각 "|"로 연결하여 조합한다.
     * <br><b>Example :</b>
     * <pre>
     *     getSheetMultiComboText(sheetObj, 3, "svc_scp_cd", "svc_scp_nm");
     *     getSheetMultiComboText(sheetObj, 2, "svc_scp_cd|sconti_cd", "svc_scp_nm|sconti_nm");
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 Cell의 Row Index
     * @param {string} CodeCols 필수 멀티콤보의 SaveName
     * @param {string} DescCols 필수 Description이 보여지는 Cell의 SaveName
     * @return 없음
     * @author 문동규
     * @version 2009.04.22
     */
    function getSheetMultiComboText(sheetObj, Row, CodeCols, DescCols)
    {
        var arrCode = CodeCols.split("|");
        var len = arrCode.length;
        if (len > 0) {
            var arrDesc = DescCols.split("|");
            var sText = "";
            var arrText;
            var idx = 0;
            var selectedText = "";

            for (var i = 0; i < len; i++) {
                // 콤보텍스트를 가져온다.
                sText = sheetObj.GetComboInfo(0, arrCode[i], "Text");

                // 각각 배열로 구성한다.
                arrText = sText.split("|");

                idx = sheetObj.GetComboInfo(Row, arrCode[i], "SelectedIndex");

                // 선택된 행이 없으면 입력된 값을 지움.
                if (idx < 0) {
                    sheetObj.CellValue2(Row, arrCode[i]) = "";
                    sheetObj.CellValue2(Row, arrDesc[i]) = " ";
                    continue;
                }
                selectedText = arrText[idx];

                sheetObj.CellValue2(Row, arrDesc[i]) = selectedText.substring(selectedText.indexOf("\t")+1);
            }
        }
    }

    /**
     * Status가 D가 아닌 이전 Row의 Row Index를 가져온다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     validRow = getPrevValidRow(sheetObj, 3);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 기준 Row의 Row Index
     * @return int <br>
     *         0   : 유효한 이전 Row가 없을 경우
     *         int : 유효한 이전 Row의 Row Index
     * @author 문동규
     * @version 2009.04.28
     */
    function getPrevValidRow(sheetObj, Row) {
        var cnt = Row;
        var rtn = 0;

        for (var i = cnt-1; i > 0; i--) {
            if (sheetObj.RowStatus(i) != "D") {
                rtn = i;
                break;
            }
        }
        return rtn;
    }


    /**
     * Status가 D가 아닌 다음 Row의 Row Index를 가져온다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     validRow = getNextValidRow(sheetObj, 3);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 기준 Row의 Row Index
     * @return int <br>
     *         0   : 유효한 다음 Row가 없을 경우
     *         int : 유효한 다음 Row의 Row Index
     * @author 문동규
     * @version 2009.04.29
     */
    function getNextValidRow(sheetObj, Row) {
        var cnt = sheetObj.RowCount;
        var rtn = 0;

        for (var i = Row+1; i <= cnt; i++) {
            if (sheetObj.RowStatus(i) != "D") {
                rtn = i;
                break;
            }
        }
        return rtn;
    }

    /**
     * Status가 "D"가 아닌 row의 갯수를 가져온다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     rowCnt = getValidRowCount(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return int sheet내의 유효한 row수
     * @author 박성수
     * @version 2009.05.13
     */
    function getValidRowCount(sheetObj) {
        return (sheetObj.RowCount - sheetObj.RowCount("D"));
    }

    /**
     * Sheet의 row의 갯수를 가져온다 <br>
     * Status가 "D"이거나, 이전 Amend Sequence인 경우, AmendDelete된 경우는 제외한다.
     * <br><b>Example :</b>
     * <pre>
     *     rowCnt = getAmendValidRowCount(sheetObj, formObj.amdt_seq.value);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return int sheet내의 유효한 row수
     * @author 박성수
     * @version 2009.05.13
     */
    function getAmendValidRowCount(sheetObj, amdtSeq) {
        var cnt = getValidRowCount(sheetObj);

        for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            if (sheetObj.CellValue(i, "amdt_seq") != amdtSeq
                    || sheetObj.CellValue(i, "src_info_cd") == "AD") {
                cnt--;
            }
        }

        return cnt;
    }

    /**
     * 주어진 조건에 맞고, Status가 D가 아닌 이전 Row의 Row Index를 가져온다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     validRow = getPrevValidRowCond(sheetObj, 3, "rout_seq|rat_ut_cd", "1|DR");
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 기준 Row의 Row Index
     * @param {string} sCol 필수, 조회조건이 되는 키 컬럼명(Savename). "|"로 연결한다.
     * @param {string} sValue 필수, 조회조건이 되는 데이터. "|"로 연결한다.
     * @return int <br>
     *         0   : 유효한 이전 Row가 없을 경우
     *         int : 유효한 이전 Row의 Row Index
     * @author 박성수
     * @version 2009.05.13
     */
    function getPrevValidRowCond(sheetObj, Row, sCol, sValue) {
        if (sheetObj == null || Row == null || sCol == null || sCol == "" || sValue == null || sValue == "") {
            return 0;
        }

        var rtn = 0;
        var arrCol = sCol.split("|");
        var arrValue = sValue.split("|");

        for (var i = Row - 1; i >= sheetObj.HeaderRows; i--) {
            if (sheetObj.RowStatus(i) == "D") {
                continue;
            }

            var isMatch = true;
            for (var j = 0; j < arrCol.length; j++) {
                if (sheetObj.CellValue(i, arrCol[j]) != arrValue[j]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                rtn = i;
                break;
            }
        }

        return rtn;
    }

    /**
     * 주어진 조건에 맞고, Status가 D가 아닌 다음 Row의 Row Index를 가져온다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     validRow = getNextValidRowCond(sheetObj, 3, "rout_seq|rat_ut_cd", "1|DR");
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 기준 Row의 Row Index
     * @param {string} sCol 필수, 조회조건이 되는 키 컬럼명(Savename). "|"로 연결한다.
     * @param {string} sValue 필수, 조회조건이 되는 데이터. "|"로 연결한다.
     * @return int <br>
     *         0   : 유효한 다음 Row가 없을 경우
     *         int : 유효한 다음 Row의 Row Index
     * @author 박성수
     * @version 2009.05.13
     */
    function getNextValidRowCond(sheetObj, Row, sCol, sValue) {
        if (sheetObj == null || Row == null || sCol == null || sCol == "" || sValue == null || sValue == "") {
            return 0;
        }

        var rtn = 0;

        var arrCol = sCol.split("|");
        var arrValue = sValue.split("|");

        for (var i = Row + 1; i <= sheetObj.LastRow; i++) {
            if (sheetObj.RowStatus(i) == "D") {
                continue;
            }

            var isMatch = true;
            for (var j = 0; j < arrCol.length; j++) {
                if (sheetObj.CellValue(i, arrCol[j]) != arrValue[j]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                rtn = i;
                break;
            }
        }

        return rtn;
    }

    /**
     * 주어진 조건에 맞고, Status가 D가 아닌 다음 Row의 갯수를 반환한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     validRow = getNextValidRowCond(sheetObj, 3, "rout_seq|rat_ut_cd", "1|DR");
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} sCol 필수, 조회조건이 되는 키 컬럼명(Savename). "|"로 연결한다.
     * @param {string} sValue 필수, 조회조건이 되는 데이터. "|"로 연결한다.
     * @return int 조건에 맞고, 유효한 Row갯수.
     * @author 박성수
     * @version 2009.05.13
     */
    function getValidRowCountCond(sheetObj, sCol, sValue) {
        if (sheetObj == null || sCol == null || sCol == "" || sValue == null || sValue == "") {
            return 0;
        }

        var rtn = 0;

        var arrCol = sCol.split("|");
        var arrValue = sValue.split("|");

        for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            if (sheetObj.RowStatus(i) == "D") {
                continue;
            }

            var isMatch = true;
            for (var j = 0; j < arrCol.length; j++) {
                if (sheetObj.CellValue(i, arrCol[j]) != arrValue[j]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                rtn++;
                break;
            }
        }

        return rtn;
    }


    /**
     * 주어진 조건에 맞고, 유효한 Row의 갯수를 반환한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     validRow = getNextValidRowCond(sheetObj, 3, "rout_seq|rat_ut_cd", "1|DR");
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} sCol 필수, 조회조건이 되는 키 컬럼명(Savename). "|"로 연결한다.
     * @param {string} sValue 필수, 조회조건이 되는 데이터. "|"로 연결한다.
     * @param {string} amdtSeq 필수, 현재 Amend Seq.
     * @return int 조건에 맞고, 유효한 Row갯수.
     * @author 박성수
     * @version 2009.05.13
     */
    function getAmendValidRowCountCond(sheetObj, sCol, sValue, amdtSeq) {
        if (sheetObj == null || sCol == null || sCol == "" || sValue == null || sValue == "") {
            return 0;
        }

        var rtn = 0;

        var arrCol = sCol.split("|");
        var arrValue = sValue.split("|");

        for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
            if (sheetObj.RowStatus(i) == "D"
                || sheetObj.CellValue(i, "amdt_seq") != amdtSeq
                || sheetObj.CellValue(i, "src_info_cd") == "AD") {
                continue;
            }

            var isMatch = true;
            for (var j = 0; j < arrCol.length; j++) {
                if (sheetObj.CellValue(i, arrCol[j]) != arrValue[j]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                rtn++;
                break;
            }
        }

        return rtn;
    }

    /**
     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
     * 하위sheet가 check/uncheck 될때는, sheet내의 모든 행이 대상이 되고, <br>
     * 상위sheet의 check가 풀릴때는, 현재 선택된 행이 대상이 된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    if (colName == "chk") {
     *        ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
     *    }
     * </pre>
     * @param {ibsheet[]} arrSheetObjs 필수 IBSheet Object 배열, 상위sheet부터 하위sheet까지 순차적으로 모두 담아준다.<br>
     *                    화면에서 제외해야할 sheet가 있다면 slice함수 등을 이용하여 필요한 부분만 넘겨준다.
     * @param {int}       curIdx 필수, 사용자가 클릭한 현재 sheet index.
     * @param {int}       Row 필수, OnBeforeCheck이벤트에서 Row로 받은 값을 그대로 넘겨준다.
     * @param {int}       Col 필수, OnBeforeCheck이벤트에서 Col로 받은 값을 그대로 넘겨준다.<br>
     *                    Savename도 사용가능하다. Check컬럼의 위치가 sheet마다 다를 경우, savename을 통일한 후 이용가능하다.
     * @param {int}       skipReadonly 선택, Editable된 checkbox는 제외할지 여부. default = true(제외)
     * @author 박성수
     * @version 2009.05.19
     */
    function ComPriCheckWithPnS(arrSheetObjs, curIdx, Row, Col, skipReadonly) {
        if (arrSheetObjs == null || arrSheetObjs.length <= 0) {
            return;
        }
        if (skipReadonly == null || skipReadonly == "") {
            skipReadonly = true;
        }

        var iValue = arrSheetObjs[curIdx].CellValue(Row, Col) == 1 ? 0 : 1;

        // 하위 sheet가 있는경우, 하위 쉬트를 모두 체크해준다.
        if (arrSheetObjs.length > curIdx + 1) {
            for (var i = curIdx + 1; i < arrSheetObjs.length; i++) {
                for (var j = arrSheetObjs[i].HeaderRows; j <= arrSheetObjs[i].LastRow; j++) {
                    if (skipReadonly && !arrSheetObjs[i].CellEditable(j, Col)) {
                        continue;
                    }
                    arrSheetObjs[i].CellValue(j, Col) = iValue;
                }
            }
        }

        // 상위 sheet가 있고, 현재sheet의 전체체크가 풀어진경우, 상위sheet도 uncheck한다.
        if (iValue == 0 && curIdx > 0) {
            if (arrSheetObjs[curIdx].CheckedRows(Col) == arrSheetObjs[curIdx].RowCount) {
                for (var i = curIdx - 1; i >= 0; i--) {
                    if (skipReadonly && !arrSheetObjs[i].CellEditable(j, Col)) {
                        continue;
                    }
                    arrSheetObjs[i].CellValue(arrSheetObjs[i].SelectRow, Col) = iValue;
                }
            }
        }
    }


    /**
     * Button Name으로 Button을 감싸고 있는 table element 를 찾는다. <br>
     *  <br>
     * <br><b>Example :</b>
     * <pre>
     *     tblObj = getButtonTable("btn_Save");
     * </pre>
     * @param {string} btnName 필수, Button의 name
     * @return object, table element. 못찾을 경우 null을 return
     * @author 문동규
     * @version 2009.05.19
     */
     function getButtonTable(btnName) {

         var coll = document.all;
         var obj = null;
         var pobj = null;
         obj = getButtonObj(btnName);

         if (obj != null) {
             for (var i = 0; i < 10; i++) {
                 if (obj == null) {
                     return null;
                 } else if (obj.parentNode.tagName == "TABLE") {
                     pobj = obj.parentNode;
                     break;
                 } else {
                     obj = obj.parentNode;
                 }
             }
         }
         return pobj;
     }

//    function getButtonTable(btnName) {
//        var pobj = null;
//        // button name에 해당하는 element를 찾는다
//        var obj = getButtonObj(btnName);
//        var tobj = null;
//
//        // button이 들어있는 table element를 찾는다
//        if (obj != null) {
//            if (obj.tagName == "TD") {
//                tobj = obj;
//            } else if (obj.tagName == "IMG") {
//                tobj = obj.parentElement;
//            } else {
//                return null;
//            }
//            if (tobj.parentElement.parentElement.tagName == "TBODY") {
//                if (tobj.parentElement.parentElement.parentElement.tagName == "TABLE") {
//                    pobj = tobj.parentElement.parentElement.parentElement;
//                }
//            } else if (tobj.parentElement.parentElement.tagName == "TABLE") {
//                pobj = tobj.parentElement.parentElement;
//            }
//        }
//        return pobj;
//    }

    /**
     * Button Name으로 Button에 해당하는 td element 를 찾는다. <br>
     *  <br>
     * <br><b>Example :</b>
     * <pre>
     *     tdObj = getButtonObj("btn_Save");
     * </pre>
     * @param {string} btnName 필수, Button의 name
     * @return object, td element. 못찾을 경우 null을 return
     * @author 문동규
     * @version 2009.05.19
     */
     function getButtonObj(btnName) {

         var coll = document.all;
         var obj = null;
         // button name
         if (coll != null) {
             for (var i = 0; i < coll.length; i++) {
                 if (coll.item(i).getAttribute("name") == btnName) {
                     obj = coll.item(i);
                     break;
                 }
             }
         }
         return obj;
     }

    /**
     * Button의 Text를 비활성화(회색)처리해서 Disable <br>
     * 이 function에서는 디자인만 비활성화처리 해주는것으로 click 이벤트를 막는것은
     * processButtonClick()에서 따로 처리를 해주어야 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     disableButton("btn_Save");
     * </pre>
     * @param {string} btnName 필수 disable 처리할 Button의 name
     * @return 없음
     * @author 문동규
     * @version 2009.05.19
     */
    function disableButton(btnName) {
        var tobj = getButtonTable(btnName);
        if (tobj != null) {
            if( tobj.disabled != true){
                tobj.disabled = true;
                var btnObj = getButtonObj(btnName)
                btnObj.style.cursor = "default";
            }
        }
    }

    /**
     * 비활성화(회색)처리된 Button을 Enable <br>
     * 이 function에서는 디자인만 활성화처리 해주는것으로 click 이벤트를 풀어주는 것은
     * processButtonClick()에서 따로 처리를 해주어야 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     enableButton("btn_Save");
     * </pre>
     * @param {string} btnName 필수 enable 처리할 Button의 name
     * @return 없음
     * @author 문동규
     * @version 2009.05.19
     */
    function enableButton(btnName) {
        var tobj = getButtonTable(btnName);
        if (tobj != null) {
            if( tobj.disabled != false){
                tobj.disabled = false;
                var btnObj = getButtonObj(btnName)
                btnObj.style.cursor = "hand";
            }
        }

//        //////////////////////
//        var b = true;
//        var tdObj = null;
//        var tdObjs = document.getElementsByTagName("td");
//        for (var i = 0; i < tdObjs.length; i++) {
//            tdObj = tdObjs[i];
//            if (tdObj.name == btnName){
//                ComBtnEnable(btnName);
//                b = false;
//            }
//        }
//
//        if (b) {
//            tdObjs = document.getElementsByTagName("img");
//            for (var i = 0; i < tdObjs.length; i++) {
//                tdObj = tdObjs[i];
//                if (tdObj.name == "no_"+btnName){
//                    tdObj.name = btnName;
//                    btnStyle.cursor = "hand";
//                    btnStyle.filter="";
//                }
//            }
//        }
    }

    /**
     * Button을 Hidden처리해서 Disable <br>
     * <br><b>Example :</b>
     * <pre>
     *     hiddenButton("btn_Save");
     * </pre>
     * @param {string} btnName 필수 disable 처리할 Button의 name
     * @return 없음
     * @author 문동규
     * @version 2009.05.19
     */
    function hiddenButton(btnName) {
        var tobj = getButtonTable(btnName);
        if (tobj != null) {
            tobj.style.display = "none";
        }
    }

    /**
     * Hidden처리된 Button을 Enable <br>
     * <br><b>Example :</b>
     * <pre>
     *     showButton("btn_Save");
     * </pre>
     * @param {string} btnName 필수 enable 처리할 Button의 name
     * @return 없음
     * @author 문동규
     * @version 2009.05.19
     */
    function showButton(btnName) {
        var tobj = getButtonTable(btnName);
        if (tobj != null) {
            tobj.style.display = "inline";
        }
    }

    /**
     * Button의 상태를 가져온다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     getButtonDisableStatus("btn_Save");
     * </pre>
     * @param {string} btnName 필수 disabled 의 상태값을 가져올 Button의 name
     * @return 없음
     * @author 공백진
     * @version 2009.06.12
     */
    function getButtonDisableStatus (clickObj){
        var btnObj = getButtonTable(clickObj);
        if (btnObj != null){
            return btnObj.disabled;
        }else{
            return false;
        }
    }

    /**
     * sheet 조회 후 font 설정을 변경한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     *     searchEndFontChange(sheetObj, "ctrt_exp_dt","Y");
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} colName 필수, 조회조건이 되는 키 컬럼명(Savename). "|"로 연결한다.
     * @param {string} colName 선택, 메인의 lgcy_if_flg 값.
     * @return 없음
     * @author 공백진
     * @version 2009.06.12
     */
    function searchEndFontChange(sheetObj, sCols,lgcyIfFlg){
        var arrCols  = sCols.split("|");
        var amdt_seq = document.form.amdt_seq.value;

        if(amdt_seq==0 || lgcyIfFlg == "Y"){
            return;
        }

        for(i = 1 ; i < sheetObj.Rows; i++){
            if(sheetObj.CellValue(i, "amdt_seq") != amdt_seq){
                sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol) = true;
                for (j = 0; j < arrCols.length; j++){
                    sheetObj.CellEditable(i,arrCols[j]) = false;
                }
            }
            else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
                sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
                if (sheetObj.CellValue(i, "src_info_cd") != "AD"){
                    for (j = 0; j < arrCols.length; j++){
                        sheetObj.CellEditable(i,arrCols[j]) = true;
                    }
                }
            }
        }
    }


    /**
     * 주어진 조건에 맞는 row 에 대해서 특정 컬럼들을 일괄 업데이트 한다.
     * <br><b>Example :</b>
     * <pre>
     *     validRow = comChangeValue(sheetObj, "amdt_seq|svc_cp_cd", "1|TES", "prc_prog_sts_cd|src_info_cd", "I|NW");
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} colName 필수, 변경을 원하는 키 컬럼명(Savename). "|"로 연결한다.
     * @param {string} colValue 필수, 변경 대상의 데이터. "|"로 연결한다.
     * @param {string} conCol 필수, 조회조건이 되는 키 컬럼명(Savename). "|"로 연결한다.
     * @param {string} conVal 필수, 조회조건이 되는 데이터. "|"로 연결한다.
     * @return void
     * @author 변영주
     * @version 2009.05.20
     */
    function comChangeValue(sheetObj, colName, colValue, conCol, conVal) {

        if (sheetObj == null || colName == null || colName == "" || colValue == null || colValue == "" ) {
            return;
        }

        if (conCol == null || conCol == "" || conVal == null || conVal == "" ) {
            conCol = "";
            conVal = "";
        }

        var arrColName = colName.split("|");
        var arrColValue = colValue.split("|");
        var arrConCol = conCol.split("|");
        var arrConVal = conVal.split("|");
        var isValid = true;
        
        for (var i = sheetObj.HeaderRows, n = sheetObj.LastRow; i <= n; i++) {
            isValid = true;

            for (var j = 0, m = arrConCol.length ; j < m ; j++) {
                if (((arrConCol[j] == "ibflag") ? sheetObj.RowStatus(i) : sheetObj.CellValue(i, arrConCol[j])) != arrConVal[j]) {
                	isValid = false;
                    break;
                }
            }

            if (!isValid) {
                continue;
            } else {
                for (var k = 0, l = arrColName.length ; k < l ; k++) {
                    if (arrColName[k] == "ibflag") {
                        sheetObj.RowStatus(i) = arrColValue[k];
                    } else {
                        sheetObj.CellValue2(i, arrColName[k]) = arrColValue[k];
                    }
                }
            }
        }
    }

    /**
     * 팝업 가로 size를 IE 버전에 따라 조정한다. <br>
     * IE버전에 따라 팝업창 사이즈 계산방식이 달라 팝업 사이즈가 다르게 나오는 문제해결. <br>
     * parameter는 IE6에 맞는 width를 넘기면 IE버전에 따라 계산된 width를 리턴한다.
     * <br><b>Example :</b>
     * <pre>
     *     win = window.open('sample.jsp', 'sample', 'width='+getWidth(600)+'px');
     * </pre>
     * @param {int} wth 필수 IE6에 맞는 팝업 width
     * @return {int} IE버전에 맞는 팝업 width
     * @author 문동규
     * @version 2009.05.27
     */
    function getWidth(wth) {
        if (getIEVersion() == "IE7") {
            wth = Number(wth) - 2;
        }
        return wth;
    }

    /**
     * 팝업 세로 size를 IE 버전에 따라 조정한다. <br>
     * IE버전에 따라 팝업창 사이즈 계산방식이 달라 팝업 사이즈가 다르게 나오는 문제해결. <br>
     * parameter는 IE6에 맞는 height를 넘기면 IE버전에 따라 계산된 height를 리턴한다.
     * <br><b>Example :</b>
     * <pre>
     *     win = window.open('sample.jsp', 'sample', 'height='+getHeight(300)+'px');
     * </pre>
     * @param {int} hgt 필수 IE6에 맞는 팝업 height
     * @return {int} IE버전에 맞는 팝업 height
     * @author 문동규
     * @version 2009.05.27
     */
    function getHeight(hgt) {
        if (getIEVersion() == "IE7") {
            hgt = Number(hgt) - 50;
        }
        return hgt;
    }

    /**
     * Internet Explorer 버전을 가져온다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     iever = getIEVersion();
     * </pre>
     * @return {string} IE버전. default 는 "".
     *         IE6 : Internet Explorer 6.x
     *         IE7 : Internet Explorer 7.x 이상
     *         ""  : 그 외 버전
     * @author 문동규
     * @version 2009.05.27
     */
    function getIEVersion() {

        var iever = "";
        if (navigator.appName.indexOf("Microsoft") > -1) { // IE?
            if (navigator.appVersion.indexOf("MSIE 6") > -1) { // IE6?
                iever = "IE6";
            }
            else if (navigator.appVersion.indexOf((navigator.appVersion.indexOf( "MSIE 7") > -1))) { // IE7?
                iever = "IE7";
            }
        }
        return iever;
    }

     /**
     * 대상 ROW 를 Amend 처리한다. <br>
     * sheetObj    : 처리 대상 sheet object
     * formObj     : 처리 대상 form object
     * sRow        : 처리 대상 Row
     * sAction     : M : Update Amend, D : Delete Amend
     * sCols       : n1st_cmnc_amdt_seq, src_info_cd, prc_prog_sts_cd 를 제외한 copy 대상 입력 column. "|"로 연결된 형태
     *          ex) comSheetAmendRow(sheetObjects[1],document.form,sheetObjects[1].SelectRow,"A", "loc_cd|ofc_cd");
     * @return {string}
     * @author 변영주
     * @version 2009.05.29
     */

    function comSheetAmendRow(sheetObj,formObj,sRow,sAction, sCols){

        var prop_no      = formObj.prop_no.value;
        var amdt_seq     = formObj.amdt_seq.value;
        var pre_amdt_seq = formObj.pre_amdt_seq.value;
        var eff_dt       = formObj.eff_dt.value;
        var exp_dt       = formObj.exp_dt.value;
        var pre_exp_dt   = formObj.pre_exp_dt.value;
        var dur_dup_flg  = formObj.dur_dup_flg.value;
        var arrCols      = sCols.split("|");

        // chebox 를 이용할 경우 해당 chk 를 제거
        sheetObj.CellValue(sRow,"chk")=0;

        // delete / modify Amend 중 이미 amend 된 과거 row 는 제외
        if(sheetObj.CellValue(sRow,"amdt_seq")!= amdt_seq || sheetObj.CellValue(sRow,"n1st_cmnc_amdt_seq")== amdt_seq){
            ComShowCodeMessage("PRI00313");
            return false;
        }

        // DataCopy/ Insert 기준 row 를 잡기 위해 sRow 설정
        sheetObj.SelectRow=sRow;

        var idx = sheetObj.DataCopy();     // 신규 row
        var idx2 = idx-1;                  // 기존 row

        // A/M/D 공통 신규 row 생성
        sheetObj.CellValue2(idx,"eff_dt")= eff_dt;
        sheetObj.CellValue2(idx,"n1st_cmnc_amdt_seq")= amdt_seq;
        sheetObj.CellValue2(idx,"prc_prog_sts_cd")= "I";
        sheetObj.CellValue2(idx,"src_info_cd")= "AM";
//        sheetObj.CellValue2(idx,"ibflag")="U";
        sheetObj.RowStatus(idx) = "U";
        for(x=0;x<arrCols.length;x++){
            sheetObj.CellEditable(idx,arrCols[x]) = true;
        }
        sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
        sheetObj.CellFont("FontStrikethru", idx2, 1, idx2, sheetObj.LastCol)=true;
        if(dur_dup_flg=="Y"){
            sheetObj.CellValue2(idx2,"exp_dt")=pre_exp_dt;
        }
        sheetObj.CellValue2(idx2,"amdt_seq")=pre_amdt_seq;
        sheetObj.RowEditable(idx2) = false;

        // D, A 일 경우  신규 Row 를 update
        if(sAction=="D"){
            sheetObj.CellValue2(idx,"src_info_cd")= "AD";
            for(z=0;z<arrCols.length;z++){
                sheetObj.CellEditable(idx,arrCols[z]) = false;
            }
        }
        sheetObj.RowStatus(idx2) = "R"; // 기존 Row 의 상태를 R로 변경해서 저장되지 않도록 함

        changeSelectBackColor(sheetObj, sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        return true;
    }

    /**
     * 대상 ROW 를 Amend Cancel 처리한다.
     * sheetObj    : 처리 대상 sheet object
     * formObj     : 처리 대상 form object
     * sRow        : 처리 대상 Row
     * sAction     : A : Insert Amend, M : Update Amend, D : Delete Amend
     * sCols       : n1st_cmnc_amdt_seq, src_info_cd, prc_prog_sts_cd 를 제외한 copy 대상 입력 column. "|"로 연결된 형태
     *           ex) comSheetAmendCancelRow(sheetObjects[1],document.form,sheetObjects[1].SelectRow,"A", "loc_cd|ofc_cd");
     * @return {string}
     * @author 변영주
     * @version 2009.05.29
     */
    function comSheetAmendCancelRow(sheetObj,formObj,sRow,sAction, sCols){
        var amdt_seq     = formObj.amdt_seq.value;
        var eff_dt       = formObj.eff_dt.value;
        var exp_dt       = formObj.exp_dt.value;
        var arrCols      = sCols.split("|");
        var pre_amdt_seq = formObj.pre_amdt_seq.value;
        var dur_dup_flg  = formObj.dur_dup_flg.value;

        sheetObj.CellValue(sRow,"chk")=0;

        //  A/M/D 동일하게 n1st_cmnc_amdt_seq == amdt_seq 일 경우에만 처리해줌
        if(sheetObj.CellValue(sRow,"n1st_cmnc_amdt_seq")!= amdt_seq || sheetObj.CellValue(sRow,"prc_prog_sts_cd")!= "I"){
            ComShowCodeMessage("PRI00313");
            return false;
        }

        var idx  = sRow-1;
        var idx2 = sRow;

        if(sAction=="A"&&(sheetObj.CellValue(sRow,"src_info_cd")=="NW"||sheetObj.CellValue(sRow,"src_info_cd")=="GM"||sheetObj.CellValue(sRow,"src_info_cd")=="GC")){
//            sheetObj.CellValue(sRow,"ibflag")="D";
            sheetObj.RowStatus(sRow) = "D";
            sheetObj.RowEditable(sRow)=false;
            sheetObj.RowHidden(sRow) = true;
            return false;
        }else{
            if(sheetObj.CellValue(sRow,"src_info_cd")!="AD"&&sheetObj.CellValue(sRow,"src_info_cd")!="AM"){
                ComShowCodeMessage("PRI00313");
                return false;
            }
            if(dur_dup_flg=="Y"){
                sheetObj.CellValue2(idx,"exp_dt")=exp_dt;
            }
            sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol)=false;
            sheetObj.CellFont("FontItalic", idx, 1, idx, sheetObj.LastCol)=false;
            sheetObj.CellValue2(idx,"amdt_seq")= sheetObj.CellValue(idx2,"amdt_seq");
            sheetObj.RowEditable(idx) = true;
            sheetObj.RowStatus(idx) = "U";
            sheetObj.SelectCell(idx,"chk");
            sheetObj.RowDelete(idx2, false);
        }

        return true;
    }
/*
    // TODO : Old Function
    function comSheetAmendCancelRow(sheetObj,formObj,sRow,sAction, sCols){

        var amdt_seq     = formObj.amdt_seq.value;
        var eff_dt       = formObj.eff_dt.value;
        var exp_dt       = formObj.exp_dt.value;
        var arrCols      = sCols.split("|");
        var pre_amdt_seq = formObj.pre_amdt_seq.value;
        var dur_dup_flg  = formObj.dur_dup_flg.value;

        sheetObj.CellValue(sRow,"chk")=0;

        //  A/M/D 동일하게 n1st_cmnc_amdt_seq == amdt_seq 일 경우에만 처리해줌
        if(sheetObj.CellValue(sRow,"n1st_cmnc_amdt_seq")!= amdt_seq){
            ComShowCodeMessage("PRI00313");
            return false;
        }

        var idx  = sRow-1;
        var idx2 = sRow;

        if(sAction=="A"&&(sheetObj.CellValue(sRow,"src_info_cd")=="NW"||sheetObj.CellValue(sRow,"src_info_cd")=="GM"||sheetObj.CellValue(sRow,"src_info_cd")=="GC")){
            sheetObj.CellValue(sRow,"ibflag")="D";
            sheetObj.RowEditable(sRow)=false;
            sheetObj.RowHidden(sRow) = true;
            return false;
        }else{
            if(sheetObj.CellValue(sRow,"src_info_cd")!="AD"&&sheetObj.CellValue(sRow,"src_info_cd")!="AM"){
                ComShowCodeMessage("PRI00313");
                return false;
            }
            if(dur_dup_flg=="Y"){
                sheetObj.CellValue2(idx,"exp_dt")=exp_dt;
            }
            sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol)=false;
            sheetObj.CellFont("FontItalic", idx, 1, idx, sheetObj.LastCol)=false;
            sheetObj.CellValue2(idx,"amdt_seq")= sheetObj.CellValue(idx2,"amdt_seq");
            sheetObj.CellValue2(idx2,"amdt_seq")= pre_amdt_seq;
            sheetObj.RowEditable(idx) = true;
            sheetObj.CellValue(idx2,"ibflag")="D";
            sheetObj.RowEditable(idx2)=false;
            sheetObj.RowHidden(idx2) = true;
            sheetObj.SelectCell(idx,"chk");
        }

        return true;
    }
*/

    /**
     * sheet 에 대하여 check 된 Row 를 Accept 처리한다.
     * sheetObj    : 처리 대상 sheet object
     * formObj     : 처리 대상 form object
     * sUrl        : 처리 대상 Row
     * isAll       : 대상 Row 전체에 적용할 것인지 여부
     *           ex) comSheetAcceptCheckedRows(sheetObjects[1],document.form,"ESM_PRI_0003GS.do",true);
     * @return {string}
     * @author 변영주
     * @version 2009.05.29
     */
    function comSheetAcceptCheckedRows(sheetObj,formObj,sUrl, isAll){
        var amdt_seq    = formObj.amdt_seq.value;
        var prop_sts_cd = formObj.prop_sts_cd.value;
        var eff_dt      = formObj.eff_dt.value;

        if(isAll == undefined || isAll ==""){
            isAll = false;
        }

        if(prop_sts_cd == "R") {
            if(isAll){
                comChangeValue(sheetObj, "chk", "0");
                comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|R");
                if(sheetObj.CheckedRows("chk") == 0) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
            }

            var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")

            if(chkArr.length == 0){
                sheetObj.CellValue2(sheetObj.SelectRow,"chk") = "1";
                chkArr[0] = sheetObj.SelectRow;
            }
            for(i=0;i<chkArr.length;i++){
                if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="R" || sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                    sheetObj.CellValue2(chkArr[i],"chk") = "0";
                    ComShowCodeMessage("PRI00313");
                    return false;
                }
            }

            comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "A|Accepted|U", "chk", "1");

            var sParam = FormQueryString(formObj);
            var sParamSheet = sheetObj.GetSaveString(false, true, "chk");
            sParam = sParam + "&" + sParamSheet;
            var sXml = sheetObj.GetSaveXml(sUrl, sParam);
            sheetObj.LoadSaveXml(sXml, false, "chk");

            comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");
        } else {
            if(isAll){
                comChangeValue(sheetObj, "chk", "0");
                comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|I");
                if(sheetObj.CheckedRows("chk")==0){
                    //ComShowCodeMessage("PRI00301");
                    ComShowCodeMessage("PRI00329");
                    return false;
                }
            }
            
            var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
            
            if(chkArr.length == 0){
                sheetObj.CellValue2(sheetObj.SelectRow,"chk") = "1";
                chkArr[0] = sheetObj.SelectRow;
            }
            for(i=0;i<chkArr.length;i++){
                /*
                if((sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="I" && sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="R") || sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                    sheetObj.CellValue2(chkArr[i],"chk") = "0";
                    ComShowCodeMessage("PRI00313");
                    return false;
                }
                */
                if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="I"){
                    sheetObj.CellValue2(chkArr[i],"chk") = "0";
                    ComShowCodeMessage("PRI01037");
                    return false;
                }
            
                if(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                    sheetObj.CellValue2(chkArr[i],"chk") = "0";
                    ComShowCodeMessage("PRI00313");
                    return false;
                }
            }
            
            comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "A|Accepted|U", "chk", "1");
            
            var sParam = FormQueryString(formObj);
            var sParamSheet = sheetObj.GetSaveString(false, true, "chk");
            sParam = sParam + "&" + sParamSheet;
            var sXml = sheetObj.GetSaveXml(sUrl, sParam);
            sheetObj.LoadSaveXml(sXml, false, "chk");
            
            comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");
        }
        return true;

    }

    /**
     * sheet 에 대하여 check 된 Row 를 Accept Cancel 처리한다.
     * sheetObj    : 처리 대상 sheet object
     * formObj     : 처리 대상 form object
     * sUrl        : 처리 대상 Row
     * isAll       : 대상 Row 전체에 적용할 것인지 여부
     *           ex) comSheetAcceptCancelCheckedRows(sheetObjects[1],document.form,"ESM_PRI_0003GS.do",true);
     * @return {string}
     * @author 변영주
     * @version 2009.05.29
     */
    function comSheetAcceptCancelCheckedRows(sheetObj,formObj,sUrl,isAll){
        var eff_dt       = formObj.eff_dt.value;
        var amdt_seq     = formObj.amdt_seq.value;

        if(isAll == undefined || isAll ==""){
            isAll = false;
        }

        if(isAll){
            comChangeValue(sheetObj, "chk", "0");
            comChangeValue(sheetObj, "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|A");
            if(sheetObj.CheckedRows("chk")==0){
                ComShowCodeMessage("PRI00301");
                return false;
            }
        }

        var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")

        if(chkArr.length == 0){
            sheetObj.CellValue2(sheetObj.SelectRow,"chk") = "1";
            chkArr[0] = sheetObj.SelectRow;
        }

        for(i=0;i<chkArr.length;i++){
            if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="A" || sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")!=amdt_seq){
                sheetObj.CellValue2(chkArr[i],"chk") = "0";
                ComShowCodeMessage("PRI00313");
                return false;
            }
        }

        comChangeValue(sheetObj, "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "I|Initial|U", "chk", "1");

        var sParam = FormQueryString(formObj);
        var sParamSheet = sheetObj.GetSaveString(false, true, "chk");
        sParam = sParam + "&" + sParamSheet;
        var sXml = sheetObj.GetSaveXml(sUrl, sParam);
        sheetObj.LoadSaveXml(sXml, false, "chk");

        comChangeValue(sheetObj, "chk|ibflag", "0|R", "chk", "1");

        return true;
    }

    /**
     * IE 버전별 팝업사이즈를 조절하기위한 함수. 사이즈를 조절한 후에 ComOpenWindowCenter 공통함수를 호출한다.<br>
     * <br>
     * <b>Example :</b>
     *
     * <pre>
     * ComPriOpenWindowCenter(&quot;ESM_PRI_0001.do&quot;, &quot;ESD_TPB_911&quot;, 755, 460);
     * ComPriOpenWindowCenter(&quot;ESM_PRI_0001.do&quot;, null, 755, 460);
     * pWin = ComPriOpenWindowCenter(&quot;ESM_PRI_0001.do&quot;, null, 755, 460); //pWin은 팝업창 window object이다.
     * </pre>
     *
     * @param {string}
     *            sUrl 선택,팝업창의 Url, default="about:blank"
     * @param {string}
     *            sWinName 선택,팝업창의 name 또는 dialogArguments, default=null
     * @param {string}
     *            iWidth 선택,팝업창의 넓이로 픽셀단위이며 최소100이상 설정
     * @param {string}
     *            iHeight 선택,IE7 이상에서 팝업창의 높이로 픽셀단위이며 최소100이상 설정
     * @param {bool}
     *            bModal 선택,팝업의 Modal 여부 (true:Modal, false:일반팝업), default=false
     * @param {String}
     *            sScroll 선택, 스크롤바 생성 여부 (no | yes), default=no
     * @returns object<br>
     *          bModal=false로 오픈된 경우 리턴값 : 팝업창의 window Object bModal=true로 오픈된 경우
     *          리턴값 : 팝업창의 window.returnValue값
     * @see #ComOpenWindow
     */
    function ComPriOpenWindowCenter(sUrl,sWinName,iWidth,iHeight, bModal, sScroll) {
        if (iHeight != null) {
            var idx = window.navigator.userAgent.indexOf("MSIE");
            if (idx != -1 && bModal == true && parseInt(window.navigator.userAgent.charAt(idx + 5)) < 7) {
//                iWidth += IE6_ADD_WIDTH;
                iHeight += IE6_ADD_HEIGHT;
                // 하단 status 부분
                iHeight += IE6_ADD_STATUS_HEIGHT;
                // Thema 차이에 의한 크기 감안
                iHeight += IE6_ADD_THEMA_HEIGHT;
            }
        }

        return ComOpenWindowCenter(sUrl,sWinName,iWidth,iHeight, bModal, sScroll);
    }

    /**
     * IE 버전별 팝업사이즈를 조절하기위한 함수. 사이즈를 조절한 후에 ComOpenWindow 공통함수를 호출한다.<br>
     * height를 별도로 지정하므로 option값에서 height는 제외해야 한다.
     * <br>
     * <b>Example :</b>
     *
     * <pre>
     * ComPriOpenWindow(
     *      &quot;ESM_PRI_0001.do&quot;,
     *      &quot;ESM_PRI_0001&quot;,
     *      &quot;toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=755,height=460&quot;);
     * ComPriOpenWindow(&quot;ESM_PRI_0001.do&quot;, null, &quot;width=755,height=460&quot;);
     * pWin = ComPriOpenWindow(&quot;ESM_PRI_0001.do&quot;, null, &quot;width=755,height=460&quot;); //pWin은 팝업창 window object이다.
     * </pre>
     *
     * @param {string}
     *            sUrl 선택,팝업창의 Url, default="about:blank"
     * @param {string}
     *            sWinName 선택,팝업창의 name 또는 dialogArguments, default=null
     * @param {string}
     *            sFeatures 선택,height를 제외한 팝업창의 세부 설정, default=""
     * @param {string}
     *            iHeight 선택,IE7 이상에서 팝업창의 높이로 픽셀단위이며 최소100이상 설정.
     * @param {bool}
     *            bModal 선택,팝업의 Modal 여부 (true:Modal, false:일반팝업), default=false
     * @returns object<br>
     *          bModal=false로 오픈된 경우 리턴값 : 팝업창의 window Object bModal=true로 오픈된 경우
     *          리턴값 : 팝업창의 window.returnValue값
     * @see #ComOpenWindow
     */
    function ComPriOpenWindow(sUrl, sWinName, sFeatures, iHeight, bModal) {
        if (iHeight != null) {
            var idx = window.navigator.userAgent.indexOf("MSIE");
            if (idx != -1 && bModal == true && parseInt(window.navigator.userAgent.charAt(idx + 5)) < 7) {
//                iWidth += IE6_ADD_WIDTH;
                iHeight += IE6_ADD_HEIGHT;
                // 하단 status 부분
                iHeight += IE6_ADD_STATUS_HEIGHT;
                // Thema 차이에 의한 크기 감안
                iHeight += IE6_ADD_THEMA_HEIGHT;
            }
            if (bModal) {
                if (sFeatures == null || sFeatures == "") {
                    sFeatures = "dialogHeight:" + iHeight;
                } else {
                    sFeatures += "; dialogHeight:" + iHeight + ";";
                }
            } else {
                if (sFeatures == null || sFeatures == "") {
                    sFeatures = "height=" + iHeight;
                } else {
                    sFeatures += ", height=" + iHeight
                }
            }
        }

        return ComOpenWindow(sUrl, sWinName, sFeatures, bModal);
    }
    
    /**
     * 공통 팝업창 호출하고, 팝업창에서 마지막 처리는 부모페이지(opener)의 특정함수를 호출하도록 지정한다. <br>
     * 부모페이지(opener)의 특정함수는 첫번째 인자는 팝업창에서 선택된 데이터의 배열이다. <br>
     * bModal 인자값에 따라 팝업창이 Modal 인지 Modaless(일반팝업) 인지 선택하며
     * {@link #ComOpenWindowCenter} 함수를 이용한다. <br>
     * 부모창(opener)의 Sheet의 특정 Cell에서 공통 팝업을 호출하는 경우 iRow, iCol, iSheetIdx 인자를 설정하여
     * 호출한다. <br>
     * 1) iRow, iCol 인자 : 해당 Cell 정보(row, col)로 팝업URL에 "&row=iRow인자값&col=iCol인자값"으로
     * 전달된다. <br>
     * 2) iSheetIdx 인자 : Sheet의 sheetObjects 배열 Index로 팝업URL에
     * "&sheetIdx=iSheetIdx인자값"으로 전달된다. <br>
     * 인자를 설정하면 url에 다음 querystring이 추가되어 조회된다. <br>
     * url?pop_mode=1&display=sDisplay인자값&func=sFunc
     * 인자값&sheet=2&row=iRow인자값&col=iCol인자값&sheetIdx=iSheetIdx인자값 <br>
     * row와 col인자를 설정하여 호출하는 경우 부모페이지(opener)의 특정함수는 첫번째 인자는 팝업창에서 선택된 데이터의 배열이고,
     * 2번째인자는 row, 3번째 인자는 col, 4번째 인자는 sheetIdx이다. <br>
     * <b>Example :</b>
     * 
     * <pre>
     *     //Modaless(일반팝업)로 팝업이 표시되고, 팝업이 닫힐때 부모(opener)의 getVVD 함수를 호출한다.
     *     ComOpenPopup('/hanjin/COM_ENS_0B2.do?sdate=20080901&amp;edate=20081231', 770, 470, 'getVVD', '1,0,1,1,1,1,1,1');
     *     function getVVD(aryPopupData)
     *     //부모창(opener)의 sheetObjects[0] Sheet의 Cell(3,10)에서 팝업을 열었다. Modal로 팝업을 표시하고, 팝업이 닫힐때 부모(opener)의 setCntInfoInSheet함수를 호출한다.
     *     ComOpenPopup('/hanjin/COM_ENS_0M1.do?cnt_cd=123&amp;classId=cls', 565, 480, 'setCntInfoInSheet', &quot;1,0,1,1,1,1,1&quot;, true, false, 3, 10, 0);
     *     function setCntInfoInSheet(aryPopupData, row, col, sheetIdx)
     * </pre>
     * 
     * @param {string}
     *            sUrl 필수,호출될 팝업 주소
     * @param {int}
     *            iWidth 필수,팝업 창의 넓이
     * @param {int}
     *            iHeight 필수,팝업 창의 높이
     * @param {string}
     *            sFunc 필수,팝업에서 최종 확인을 했을때 데이터를 받을 부모창(opener)의 자바스크립트 함수명
     * @param {string}
     *            sDisplay 필수,팝업창에 있는 그리드의 컬럼 히든여부 설정(1:보임, 0:숨김)
     * @param {bool}
     *            bModal 선택,팝업의 Modal 여부 (true:Modal, false:일반팝업), default=false
     * @param {bool}
     *            b2ndSheet 선택,Sheet 2개인 팝업 오픈시 true 1개인 팝업 오픈시 false, default=false
     * @param {int}
     *            iRow 선택,Sheet의 Cell의 Row Index
     * @param {int}
     *            iCol 선택,Sheet의 Cell의 Col Index
     * @param {int}
     *            iSheetIdx 선택,Sheet의 sheetObjects 배열 Index
     * @param {string}
     *            sWinName 선택,팝업창의 name 또는 dialogArguments, default=compopup
     * @param {String}
     *            sScroll 선택, 스크롤바 생성 여부 (no | yes), default=no
     * @returns object<br>
     *          bModal=false로 오픈된 경우 리턴값 : 팝업창의 window Object bModal=true로 오픈된 경우
     *          리턴값 : 팝업창의 window.returnValue값
     * @see #ComOpenWindowCenter
     * @see #ComOpenPopupWithTarget
     */
    function ComPriOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal,
    		 b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll) {
        if (iHeight != null) {
            var idx = window.navigator.userAgent.indexOf("MSIE");
            if (idx != -1 && bModal == true && parseInt(window.navigator.userAgent.charAt(idx + 5)) < 7) {
                iHeight += IE6_ADD_HEIGHT;
                // 하단 status 부분
                iHeight += IE6_ADD_STATUS_HEIGHT;
                // Thema 차이에 의한 크기 감안
                iHeight += IE6_ADD_THEMA_HEIGHT;
            }
        }

        return ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal,
       		 b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
     }
     
  

    /**
     * <form>에 Radio Button을 value의 값으로 check해주는 메소드.
     *
     * 사용 예 )
     * ComPriCheckRadioButton(formObj.loc_type,arrParams["loc_type"]);
     *
     * radioObj    : 처리 대상 Radio Object
     * value  : check를 하고자 하는 value
     *
     * @author 송민석
     * @version 2009.07.10
     */
    function ComPriCheckRadioButton(radioObj,value){
        if( radioObj.length == undefined ){
            if( radioObj.value == value ){
                radioObj.checked = true;
            }
        }else{
            for(var i = 0 ; i < radioObj.length ; i++){
                if(radioObj[i].value == value){
                    radioObj[i].checked = true;
                    break;
                }
            }
        }
    }
    /**
     * <form>에 Radio Button의 check된 value를 return
     *
     * 사용 예 )
     * var value = ComPriCheckRadioButton(formObj.loc_type);
     *
     * @param radioObj    : 처리 대상 Radio Object
     * @return  : check된 value
     *
     * @author 송민석
     * @version 2009.07.10
     */
    function ComPriGetCheckedRadioButtonValue(radioObj){
        var rtnValue = "";
        if( radioObj.length == undefined ){
            if( radioObj.checked ==  true){
                rtnValue = radioObj.value;
            }
        }else{
            for(var i = 0 ; i < radioObj.length ; i++){
                if(radioObj[i].checked == true){
                    rtnValue = radioObj[i].value;
                    break;
                }
            }
        }
        return rtnValue;
    }

    /**
     * 버튼이 3개인 MsgBox를 보여주고 '예(Yes)'일경우 sheet의 SpeedDown2Excel을 실행하고
     * '아니오(No)'일경우 Down2Excel을 실행해 format이 있는 Excel을 Download한다.
     * '취소(Cancel)'일경우 아무 동작하지 않는다.
     * 사용 예 )
     * ComPriShowDialogExcel(sheetObject1,ComGetMsg("PRI03002"));
     *
     * sheetObj    : Excel로 Download하고자 하는 sheet
     * msgStr  : 보여주고자 하는 메시지
     *
     * @author 송민석
     * @version 2009.08.06
     */
    function ComPriShowDialogExcel(sheetObj,msgStr){
       if(sheetObj.RowCount == 0 )
           return;
       execScript("rtn = Msgbox(\"" + ComReplaceStr(msgStr,"\n","\" & Chr(13) & \"") + "\", 3, \"Download Excel\")", "vbscript");
       if (rtn == 6) {
           sheetObj.SpeedDown2Excel(-1, false, false);
       } else if (rtn == 7) {
           sheetObj.Down2Excel(-1, false, false, true);
       }
    }

    /**
     * 화면 로딩시 가져온 데이터를 IBMultiCombo의 item으로 insert 해준다.<br>
     * <b>Example :</b>
     *
     * <pre>
     * ComPriTxt2ComboItem(xmlStr, combo1, &quot;cd&quot;, &quot;nm&quot;);
     *
     * </pre>
     *
     * @param {string} txtStr 필수 Combo item으로 사용할 데이터. code
     * @param {object} cmbObj 필수 insert하고자 하는 IBMultiCombo Object.
     * @param {string} codeCol 필수 Combo의 Code컬럼명.
     * @param {string} textCol 필수 Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
     * @param {string} dim1 선택 Combo item의 code와 name을 구분하는 delimiter.
     *                           default : "Φ"
     *                           "" : "Φ"
     *                           그외 : 해당값
     * @param {string} dim2 선택 Combo item을 구분하는 delimiter.
     *                           default : "Ω"
     *                           "" : "Ω"
     *                           그외 : 해당값
     * @return 없음.
     * @author 문동규
     * @version 2009.07.17
     */
    function ComPriTxt2ComboItem(txtStr, cmbObj, codeCol, textCol, dim1, dim2) {
        if (txtStr == null || txtStr == "" || cmbObj == null || cmbObj == "") {
            return;
        }
        if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
            return;
        }

        try {
            cmbObj.RemoveAll();

            if (dim1 == null || dim1 == "") {
                dim1 = "Φ";
            }
            if (dim2 == null || dim2 == "") {
                dim2 = "Ω";
            }

            var arr = txtStr.split("Φ");
            var item;

            for (var i = 0, n = arr.length ; i < n ; i++) {
                if (arr[i].length == 2) {
                    item = arr[i].split("Ω");
                    cmbObj.InsertItem(-1, item[0], item[1]);
                }
            }

        } catch (err) {
            ComFuncErrMsg(err.message);
        }
    }

    /**
     * ComboObjects Array에서 Object ID로 Combo Object를 가져온다.<br>
     * <b>Example :</b>
     * <pre>
     * comboObj = getComboObject(comboObjects, "combo1");
     * </pre>
     *
     * @param {array} comboObjs 필수 ComboObject 배열
     * @param {string} objId 필수 해당 ComboObject의 id
     * @return {object} comboObject 해당 ComboObject
     * @author 문동규
     * @version 2009.07.17
     */
    function getComboObject(comboObjs, objId) {
        if (comboObjs != null) {
            for (var i = 0, n = comboObjs.length ; i < n ; i++) {
                if (comboObjs[i].id == objId) {
                    return comboObjs[i];
                }
            }
        }
        return null;
    }

    /**
     * Oracle의 NVL 함수와 같이 변수의 값이 null일경우 대치할수 있는 값을 return한다.
     *
     * <pre>
     * var v = "";
     * comboObj = ComPriNvl(v, "NULL");
     * </pre>
     *
     * @param {string} value
     * @param {string} repValue
     * @return {object} comboObject 해당 ComboObject
     * @author 송민석
     * @version 2009.07.27
     */
    function ComPriNvl(value,repValue){
        if(value == ""){
            return repValue;
        }
        return value;
    }

    /**
     *   jsp에서 페이지 최초 로딩시 아래와 같이 combo를 위한 값을 구성하고 script에서 multi combo에 값을 assign 하고자 할경우
     *   그 값을 파싱해 multi combo에 assign 해준다.
     *   JSP의 Value 예시)
     *    var appOfcCdComboText = "HAMRU  EUROPE REGIONAL HEADQUARTERS|NYCRA  AMERICA REGIONAL HEADQUARTERS|SAOSC San Paulo Branch Office|SELSKM  KEY ACCOUNT GROUP|SELSTA    Trans-pacific Trade Group|SELSTE    European Trade Group|SELSTI Intra-Asia Trade Group|SHARC    ASIA REGIONAL HEADQUARTERS";
     *    var appOfcCdComboValue = "HAMRU|NYCRA|SAOSC|SELSKM|SELSTA|SELSTE|SELSTI|SHARC";
     *
     *    var profitViewComboText = "Trade Profit|Office Profit";
     *    var profitViewComboValue = "P|R";
     *  사용 예시
     * <pre>
     *    ComPriTextCode2ComboItem(appOfcCdComboValue,appOfcCdComboText, formObj.frm_svc_scp_cd ,"|","\t" );
     *    ComPriTextCode2ComboItem(profitViewComboValue,profitViewComboText, formObj.prop_apro_ofc_cd);
     * </pre>
     *
     * @param {string} codeStr MultiCombo에 assign될 rowSeparator(아래 예제에서는 '|')로 구분된 Code String
     *                 <BR> 예) "HAMRU|NYCRA|SAOSC|SELSKM|SELSTA|SELSTE|SELSTI|SHARC";
     * @param {string} textStr MultiCombo에 assign될 rowSeparator과 colSeparator로 구분된 Text String
     *                 <BR> combo를 다중컬럼으로 보여줄경우 colSeparator로 구분해서 값을 구성한다.
     *                 <BR> 예) 1. 하나의 컬럼일경우 textStr값
     *                            "Trade Profit|Office Profit";
     *                 <BR>     2. 다중컬럼으로 구성했을경우 textStr값
     *                 <BR>       이때의 rowSeparator는 '|'이되고 colSeparator는 '\t"가 된다.
     *                              "HAMRU    EUROPE REGIONAL HEADQUARTERS|NYCRA  AMERICA REGIONAL HEADQUARTERS|SAOSC San Paulo Branch Office|SELSKM  KEY ACCOUNT GROUP|SELSTA    Trans-pacific Trade Group|SELSTE    European Trade Group|SELSTI Intra-Asia Trade Group|SHARC    ASIA REGIONAL HEADQUARTERS";
     *
     * @param {object} cmbObj 해당 ComboObject
     * @param (stirng) rowSeparator code,text에서 공통으로 쓰이는 구분자로 combo의 row를 구분하는 구분자 default : '|'
     * @param (stirng) colSeparator combo의 text에서만 사용하는 구분자로 다중컬럼을 보여줄때 각 컬럼의 값을 구분하는 구분자다 default : '\t'
     * @param (stirng) showCellIdx  textStr의 값은 colSeparator로 구분된 여러 값이 들어 있으나 다중컬럼으로 보여주지 않고
     *                 <BR>  showCellIdx번째 cell을 보여주고자 할때 사용한다., 0부터 시작,  default : 넘어온 textStr의 컬럼 갯수만큼 컬럼을 보여줌
     * @author 송민석
     * @version 2009.08.14
     */
    function ComPriTextCode2ComboItem(codeStr,textStr, cmbObj,rowSeparator,colSeparator,showCellIdx ){
        if( rowSeparator  == undefined ){
            rowSeparator = "|"
        }
        if( colSeparator  == undefined ){
            colSeparator = "\t"
        }
        var isSplit = true;
        var isShowSpclCol = false;
        var arrCode = codeStr.split(rowSeparator);
        var arrText = textStr.split(rowSeparator);
        if( colSeparator == "|"){
            isSplit = false;
        }
        if( showCellIdx != undefined && ( ComIsNumber(showCellIdx) ||  showCellIdx == "0")
                && showCellIdx < (arrText[0].split(colSeparator)).length ){
            isShowSpclCol = true;
        }
        for(var idx=0;idx < arrCode.length; idx++ ){
            var text = arrText[idx];
            //특정 Text값을 보여준다.
            if( isShowSpclCol ){
                text =  text.split(colSeparator)[showCellIdx];
            }else if( isSplit ){
                    text=text.replace(colSeparator,"|");
            }
            cmbObj.InsertItem(-1, text, arrCode[idx]);
        }
    }

    /**
     *   image button 또는 table로 만든 버튼의 활성화 비활성화 여부를 return한다.
     *
     * <pre>
     *    if( !ComPriGetButtonStatus(window.event.srcElement) ){
     *        return false;
     *    }
     *
     * </pre>
     *
     * @param {object} obj 필수, 검사하고자 하는 Button Object
     * @return boolean, true : 버튼이 활성화 돼 있음. false : 버튼이 비활성화 돼 있음.
     * @author 송민석
     * @version 2009.11.11
     */
    function ComPriGetButtonStatus(obj){
        var srcName = obj.getAttribute("name");
        var returnValue = true;;

        if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            var tableObj = getButtonTable(srcName);
            //image button일때
            if( tableObj == null || tableObj == undefined){
                if( obj.disabled ){
                    returnValue = false;
                }
            }else if (tableObj.disabled) {
                returnValue = false;
            }
        }
        return returnValue ;
    }


    /**
     * StringBuffer 기능을 스크립트로 구현함. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sbStr = new StringBuffer();  // 선언
     *     sbStr.append("Sample");      // append
     *     sbStr.toString();            // 문자열로 변환
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.06.26
     */
    function StringBuffer(){
        this.buffer = [];
    }

    StringBuffer.prototype.append=function append(str){
        this.buffer.push(str);
        return this;
    }

    StringBuffer.prototype.toString=function toString(){
        return this.buffer.join("");
    }

    /**
     * sheet에서 delete된 로우가 있는지 체크한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     isDeleted(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return bool <br>
     *          true  :  delete된 로우가 있는 경우<br>
     *          false :  delete된 로우가 없는 경우
     * @author 이승준
     * @version 2009.04.17
     */
    function isDeleted(sheetObj) {

        var isDeleted = false;

        for(var i=1; i<=sheetObj.RowCount; i++) {

            if(sheetObj.RowStatus(i) == "D") {
                isDeleted = true;
                break;
            }
        }

        return isDeleted;
    }

    var baseSelectBackColor = null; // 기존 Highlight 색
    var newSelectBackColor = null;  // 변경된 Highlight 색

    /**
     * Highlight 변경시 사용하는 색상값을 가져온다.<br>
     * <b>Example :</b>
     * <pre>
     *     color = getPriHighlightColor(sheetObj, "basic");
     * </pre>
     *
     * @param {sheet} sheetObj 필수, SheetObject
     * @param {string} type 필수, 색상종류. basic:기존 Highlight 색 new:변경된 Highlight 색
     * @return number, 해당 색상값
     * @author 문동규
     * @version 2010.01.07
     */
    function getPriHighlightColor(sheetObj, type) {
        if (type == "basic") {
            return sheetObj.SelectBackColor;  // 기존 Highlight 색 : sheetObj.RgbColor(231,250,246)
        } else if (type == "new") {
            return sheetObj.WebColor("#FFFFCC");  // 변경된 Highlight 색
        } else {

        }
    }

    /**
     * Amend Row의 Highlight 색상을 다르게 표시한다.<br>
     * <b>Example :</b>
     * <pre>
     *     changeSelectBackColor(sheetObj, source, target);
     * </pre>
     *
     * @param {sheet} sheetObj 필수, SheetObject
     * @param {string} source 필수, 색상변경 기준이 되는 데이터
     * @param {string} target 필수, 색상변경 기준과 비교하는 데이터
     * @return 없음
     * @author 문동규
     * @version 2009.11.13
     */
    function changeSelectBackColor(sheetObj, source, target) {
        if (baseSelectBackColor == null) {
            baseSelectBackColor = getPriHighlightColor(sheetObj, "basic");
        }
        if (newSelectBackColor == null) {
            newSelectBackColor = getPriHighlightColor(sheetObj, "new");
        }

        var lgcyIfFlg = null;
        if (document.form.lgcy_if_flg == null) {
            lgcyIfFlg = "N";
        } else {
            lgcyIfFlg = document.form.lgcy_if_flg.value;
        }

        if (Number(target) > 0 && source == target && lgcyIfFlg == "N") {
            if (sheetObj.SelectBackColor != newSelectBackColor) {
                sheetObj.SelectBackColor = newSelectBackColor;
            }
        } else {
            if (sheetObj.SelectBackColor == newSelectBackColor) {
                sheetObj.SelectBackColor = baseSelectBackColor;
            }
        }
    }

    /**
     * Amend Row의 Highlight 색상을 다르게 표시한다.<br>
     * Rate용 버전입니다. 물론 다른 화면에서도 쓸 수 있습니다.<br>
     * 선택된 Row의 RowFontColor나 CellFontColor Property를 읽어 색상을 변경합니다.<br>
     * <b>Example :</b>
     * <pre>
     *     changeSelectBackColor4Rate(sheetObj);
     * </pre>
     *
     * @param {sheet} sheetObj 필수, SheetObject
     * @return 없음
     * @author 박성수
     * @version 2009.12.31
     */
    function changeSelectBackColor4Rate(sheetObj) {
        if (baseSelectBackColor == null) {
            baseSelectBackColor = getPriHighlightColor(sheetObj, "basic");
        }
        if (newSelectBackColor == null) {
            newSelectBackColor = getPriHighlightColor(sheetObj, "new");
        }

        if (sheetObj.RowFontColor(sheetObj.SelectRow) != 0 || sheetObj.CellFontColor(sheetObj.SelectRow, 1) != 0) {
            sheetObj.SelectBackColor = newSelectBackColor;
        } else {
            sheetObj.SelectBackColor = baseSelectBackColor;
        }
    }

    /**
     * Amend Row의 Highlight 색상을 다르게 표시한다.<br>
     * Master / Detail 화면에서 Master에 적용할때 사용한다. <br>
     * 선택된 Row의 RowFontColor나 CellFontColor Property를 읽어 색상을 변경합니다.<br>
     * <b>Example :</b>
     * <pre>
     *     changeSelectBackColor4Master(sheetObj, formObj);
     * </pre>
     *
     * @param {sheet} sheetObj 필수, SheetObject
     * @param {form}  formobj   필수,html의 Form 오브젝트 Name
     * @return 없음
     * @author 최성민
     * @version 2009.12.31
     */
    function changeSelectBackColor4Master(sheetObj, formObj) {
        var amdtSeq = formObj.amdt_seq.value;

        if (baseSelectBackColor == null) {
            baseSelectBackColor = getPriHighlightColor(sheetObj, "basic");
        }
        if (newSelectBackColor == null) {
            newSelectBackColor = getPriHighlightColor(sheetObj, "new");
        }

        if (sheetObj.RowFontColor(sheetObj.SelectRow) != 0 || sheetObj.CellFontColor(sheetObj.SelectRow, 1) != 0
            || (amdtSeq > 0 && sheetObj.RowStatus(sheetObj.SelectRow) == "I")){
            sheetObj.SelectBackColor = newSelectBackColor;
        } else {
            sheetObj.SelectBackColor = baseSelectBackColor;
        }
    }

    /**
     * Amend Row의 Highlight 색상을 다르게 표시한다. S/C, RFA 메인에서 사용한다.<br>
     * <b>Example :</b>
     * <pre>
     *     changeSelectBackColor4Main(sheetObj);
     * </pre>
     *
     * @param {sheet} sheetObj 필수, SheetObject
     * @return 없음
     * @author 공백진
     * @version 2009.11.13
     */
    function changeSelectBackColor4Main(sheetObj) {
        var lgcyIfFlg =  sheetObjects[0].CellValue(1, "lgcy_if_flg");

        if (baseSelectBackColor == null) {
            baseSelectBackColor = getPriHighlightColor(sheetObj, "basic");
        }
        if (newSelectBackColor == null) {
            newSelectBackColor = getPriHighlightColor(sheetObj, "new");
        }
        var amdtSeq = document.form.amdt_seq.value;
//        var cellValue = sheetObj.CellValue(sheetObj.SelectRow,"pre_ext_scp");
        if (sheetObj.RowFontColor(sheetObj.SelectRow) != 0 || sheetObj.CellFontColor(sheetObj.SelectRow, 1) != 0
               || (amdtSeq > 0 && sheetObj.RowStatus(sheetObj.SelectRow) == "I") && lgcyIfFlg == "N"){
                sheetObj.SelectBackColor = newSelectBackColor;
        } else {
           sheetObj.SelectBackColor = baseSelectBackColor;
        }

//      if((amdtSeq != "0" &&amdtSeq !="" )&& (cellValue == "N" || cellValue =="" ) && lgcyIfFlg == "N"){
//          sheetObj.SelectBackColor = newSelectBackColor;
//          alert("new lgcyIfFlg="+lgcyIfFlg)
//      } else {
//          sheetObj.SelectBackColor = baseSelectBackColor;
//          alert("base lgcyIfFlg="+lgcyIfFlg)
//      }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Sheet의 특정행의 값을 Form의 각 컨트롤에 값을 복사한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     IBS_CopyRowToForm(mySheet, document.mainForm);
     *     IBS_CopyRowToForm(mySheet, document.mainForm, mySheet.SelectedRow);
     *     IBS_CopyRowToForm(mySheet, document.mainForm, 1, "str_");
     *
     *     &lt;script for="mySheet" event="OnSelectCell(or,oc,nr,nc)"&gt;
     *       if(nr &lt; HeaderRows || nr &gt; LastRow||RowCount  == 0) return mainForm.reset();
     *       if(or==nr) return;
     *
     *       IBS_CopyRowToForm(mySheet, mainForm);
     *     &lt;/script&gt;
     * </pre>
     * @param   {ibsheet} sheetobj  필수,IBSheet Object ID
     * @param   {form}    formobj   필수,html의 Form 오브젝트 Name
     * @param   {int}     row       선택,IBSheet의 복사할 행번호, 인자를 설정하지 않으면 현재 선택된 행이 됨
     * @param   {string}  prefix    선택,Form 안에 있는 컨트롤의 이름앞에 붙는 문자열, 예)"obj_CardNo"이면 이인자는 "obj_"임, 인자를 설정하지 않으면 "frm_"가 기본임
     * @return  없음
     * @version 2009.11.27
     */
    function ComPriCopyRowToForm(sheetobj, formobj, row, prefix){
        //함수의 인자 유효성 확인-시작
        if (sheetobj==null || typeof sheetobj != "object" || sheetobj.tagName != "OBJECT") {
            return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 sheetobj 인자는 IBSheet 태그가 아닙니다.");
        } else if (formobj==null || typeof formobj != "object" || formobj.tagName != "FORM") {
            return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 formobj 인자는 FORM 태그가 아닙니다.");
        } else if (row!=null && (isNaN(row) || row < 0 || row > sheetobj.LastRow)) {
            return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 row 인자값이 잘못되었습니다.");
        }
        //함수의 인자 유효성 확인-종료

        // HTML컨트롤의 name 앞에 붙는 글자
        if (prefix == null) prefix = "";
        if (row == null) row=sheetobj.SelectRow;

        // Sheet의 컬럼개수만큼 찾아서 HTML의 Form 각 Control에 값을 설정한다.
        // 컬럼개수만큼 루프 실행
        for(var col=0;col<=sheetobj.LastCol ;col++){
            //컬럼의 별명을 문자열로 가져온다.
            var col_alias = sheetobj.ColSaveName(col)
            if (col_alias=="") continue;
            var sheetvalue = sheetobj.CellValue(row,col);

            // 폼에 있는 해당 이름의 컨트롤을 가져온다.예)"frm_CardNo"
            var frmchild = formobj.elements(prefix +col_alias);

            // 폼에 해당하는 이름의 컨트롤이 없는 경우는 계속 진행한다.
            if(frmchild==null) continue;

            var sType = frmchild.type;
            // radio의 경우 frmchild가 배열형태가 되므로, frmchild.type으로는 타입을 알수 없다.
            if (sType==undefined && frmchild.length>0) sType=frmchild[0].type;

            // 타입별로 값을 설정한다.
            switch(sType) {
                case "button":
                case "reset":
                case "submit":
                    break;
                case "radio":
                    for (idx=0; idx<frmchild.length; idx++) {
                        if(frmchild[idx].value == sheetvalue) {
                            frmchild[idx].checked=true;
                            break;
                        }
                    }
                    break;
                case "checkbox":
                    frmchild.checked = (sheetvalue==1);
                    break;
                default :
                    frmchild.value = sheetvalue;
            }//end of switch
        }//end of for(col)
    }


    /**
     * 주어진 컬럼의 값과 일치하는 row를 리턴한다.
     * 없으면 -1을 리턴한다.
     * <br><b>Example :</b>
     * <pre>
     *     validRow = ComGetValidRow(sheetObj, "cmdt_seq", "5");
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} colName 필수, 조회조건이 되는 키 컬럼명(Savename).
     * @param {string} colValue 필수, 찾고자 하는 값.
     * @return int
     * @author 이승준
     * @version 2009.12.22
     */
    function ComGetValidRow(sheetObj, colName, colValue) {

        if (sheetObj == null || colName == null || colName == "") {
            return -1;
        }

        var row = -1;

        for (var i = sheetObj.LastRow; i >= 0; i--) {

            if(sheetObj.CellValue(i,colName) == colValue) {
                row = i;
                break;
            }
        }

        return row;
    }


    /**
     * com.hanjin.syscommon.common.util.ScheduleUtil.getJobStatus(String id, String pgmNo)에서 return된
     * 수행상태코드값을 text로 변환
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {string} status,상태코드
     * @return string, text
     * @author 송민석
     * @version 2009.10.01
     */
    function getScheduleUtilStatusStr(status){
        switch(status){
            case "0" :
                return "Nothing";
                break;
            case "80" : // 기존에 nothing으로 표현 하던 내용으로 pri_prs_bat에는 데이터가 있으나 batch에서 null을 return할때
                return "Running..";
                break;                
            case "1" :
                return "Running";
                break;
            case "3" :
                return "Starting";
                break;
            case "4" :
                return "Success";
                break;
            case "5" :
                return "Failure";
                break;
            case "6" :
                return "Terminated";
                break;
            case "7" :
                return "ON_ICE";
                break;
            case "8" :
                return "Inactive";
                break;
            case "9" :
                return "Activated";
                break;
            case "10" :
                return "Restart";
                break;
            case "11" :
                return "ON_HOLD";
                break;
            case "12" :
                return "Que Wait";
                break;
            case "90" : // 배치 프로그램 상의 Exception에 의한 Failure
                return "Failure";
                break;                
            case "99" : // 일정시간이 지나도록 배치에서 응답이 없는 것에 의한 Failure
                return "Failure";
                break;
            default :
                return "Unknown";
        }
    }

    /**
     * html 의 object중 id로 이름이 주어진 object에 대한
     * 이벤트를 실행시킨다.
     * <br><b>Example :</b>
     * <pre>
     *  ComPriFireEvent("btn1_Retrieve", "onclick");
     * </pre>
     * @param {string} obj, Event를 fire시키고자 하는 object의 name또는 Object
     * @param {string} eventNm, Event Name ex) onclick
     * @return boolean, false : event 실행 실패, true : event 실행 성공,
     * @author 송민석
     * @version 2010.01.22
     */
    function ComPriFireEvent(obj, eventNm){
        var isSuccess = false;
        if( obj.constructor == String ){
            obj = document.getElementById(obj);
        }
        if (obj){
            try{
                obj.fireEvent(eventNm);
                isSuccess = true;
            }catch(e){

            }
        }
        return isSuccess
    }


    /*****************************************************************
     *
     *                Wait Begin
     *
     ******************************************************************/

    var waitPriW   = 249;
    var waitPriH   = 76;
    var waitPriImage = "/hanjin/img/waiting.gif";

    var WAIT_PRI_DIV_NAME = "_DivPriWait_";
    var WAIT_PRI_FRAME_NAME = "_iFramePriWait_";
    var waitPriDoc = null;
    var isOpenWaitWindow = false;
    //Top의 WAS와 현재페이지의 WAS가 다른 경우가 있어서 아래와 같이 처리한다.
    try {
        waitPriDoc = top.document
    } catch(err) {
        waitPriDoc = document;
    }

    //2008.12.01-이미지가 잘 로드되지 않거나 보이지 않는 문제를 해결하기 위해 페이지가 로드되면 대기이미지Frame을 미리 로드시켜두기 위해 아래 코드 사용
    document.onreadystatechange = initPriWaitFrame;

    /**
     * 임시함수로 대체. 로컬에서 테스트시 아래 함수 주석을 풀고 테스트하시기 바랍니다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    ComPriOpenWait(true);          // doActionIBSheet함수가 완료될때 까지 대기상태 유지
     *    doActionIBSheet(sheetObject,formObject,COMMAND01)
     *    ComPriOpenWait(false);
     * </pre>
     * @param {bool}   flag         필수,키보드나 마우스를 대기상태(true)/일반상태(false)
     * @param {bool}   bOpenLayer   선택,대기이미지(Waiting) 표시 여부, default=true
     * @return 없음
     * @see #ComPriOpenWaitCallFunc
     */
    function ComPriOpenWait(flag, bOpenLayer) {
//        ComPriOpenWait2 (flag, bOpenLayer);
    }
    
    /**
    * 임시함수로 대체. 로컬에서 테스트시 아래 함수 주석을 풀고 테스트하시기 바랍니다.<br>
    * PopUp화면에서 호출<br>
    * <br><b>Example :</b>
    * <pre>
    *    ComPriPopUpOpenWait(true);          // doActionIBSheet함수가 완료될때 까지 대기상태 유지
    *    doActionIBSheet(sheetObject,formObject,COMMAND01)
    *    ComPriPopUpOpenWait(false);
    * </pre>
    * @param {bool}   flag         필수,키보드나 마우스를 대기상태(true)/일반상태(false)
    * @param {bool}   bOpenLayer   선택,대기이미지(Waiting) 표시 여부, default=true
    * @return 없음
    * @see #ComPriOpenWaitCallFunc
    */    
    function ComPriPopUpOpenWait(flag, bOpenLayer) {
//        ComPriOpenWait2 (flag, bOpenLayer);
//        if (!flag) document.body.scroll = "no";
    }    
    
    /**
     * 대기상태 여부와 대기이미지표시여부를 설정 변경한다. <br>
     * 특정 스크립트가 호출되는 동안 키보드나 마우스를 대기상태로 만들고자 할때 flag인자를 true로 설정하고, 이때 대기이미지까지 표시하고자 한다면 bOpenLayer인자를 true로 설정하여 이 함수를 호출한다. <br>
     * 특정 스크립트가 완료되어 키보드나 마우스를 원래상태로 하고, 대기이미지도 숨기고자 한다면 flag 인자를 false로 설정하여 이 함수를 호추한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    ComPriOpenWait(true);          // doActionIBSheet함수가 완료될때 까지 대기상태 유지
     *    doActionIBSheet(sheetObject,formObject,COMMAND01)
     *    ComPriOpenWait(false);
     * </pre>
     * @param {bool}   flag         필수,키보드나 마우스를 대기상태(true)/일반상태(false)
     * @param {bool}   bOpenLayer   선택,대기이미지(Waiting) 표시 여부, default=true
     * @return 없음
     * @see #ComPriOpenWaitCallFunc
     */
    function ComPriOpenWait2 (flag, bOpenLayer) {
        try {
            if(flag == isOpenWaitWindow ) return;// 이미 Wait화면이 오픈된 경우나 Wait화면이 Close된 상태에서 다시 close할때 return한다.
            if (waitPriDoc.getElementById(WAIT_PRI_DIV_NAME)==null && !flag) return;
            if (waitPriDoc.getElementById(WAIT_PRI_DIV_NAME)==null && flag) initPriWaitFrame();

            isOpenWaitWindow = flag;
            try {
                var childWaitDoc = waitPriDoc.getElementById("main").contentWindow.document;
            } catch(err) {
                var childWaitDoc = waitPriDoc;
            }

            var divobj  = waitPriDoc.getElementById(WAIT_PRI_DIV_NAME);
            var waitImg = waitPriDoc.getElementById(WAIT_PRI_FRAME_NAME);

            if (flag) {
            	
                 ComPriComboObjsEnable(false,childWaitDoc);
                //위치를 살짝 바꾸는것은 그래야 나중에 div태그가 잘 보이기 때문임
                //divobj.style.left = 0;
                //divobj.style.top = 0;

                //인자를 설정하지 않은 경우 default=true로 설정하기 위함
                if (bOpenLayer==undefined || bOpenLayer==null) bOpenLayer = true;
                if (bOpenLayer) {
                	
                    var leftPos=(divobj.clientWidth-waitPriW)/2 + waitPriDoc.body.scrollLeft ;       if(leftPos<0)   leftPos=0;
                    var topPos =(divobj.clientHeight-waitPriH)/2 + waitPriDoc.body.scrollTop  ;      if(topPos<0)    topPos=0;

                    waitImg.style.left = leftPos;
                    waitImg.style.top  = topPos;
                    //ComDebug("wait div=" + divobj.clientWidth +"," +divobj.clientHeight);
                    //ComDebug("waitDoc div=" + waitDoc.body.clientWidth +"," +waitDoc.body.clientHeight);

                    //waitImg.style.visibility="visible";
                    waitImg.style.display="inline";
                } else {
                    //waitImg.style.visibility="hidden";
                    waitImg.style.display="none";
                }

                /*
                ComDebug("wait div top scrollTop=" + waitPriDoc.body.scrollTop);
                ComDebug("wait div top clientTop=" + waitPriDoc.body.clientTop);
                ComDebug("wait div top offsetTop=" + waitPriDoc.body.offsetTop);
                */

                //스크롤바를 없애는것은 대기이미지가 그려지지 않은 영역으로 움직이지 않도록 하기 위함
                //waitPriDoc.body.scroll = "no";

                //위치를 바뀌주고, visible후 focus를 설정해주어야 대기이미지가 잘 보임
                divobj.style.left = waitPriDoc.body.scrollLeft;
                divobj.style.top =  waitPriDoc.body.scrollTop+1;

                divobj.style.visibility="visible";
                divobj.focus();
                waitImg.style.visibility="visible";
                waitImg.focus();
                window.defaultStatus="Processing......";
                window.status="Processing......";
                top.window.document.body.style.cursor="wait";
                window.document.body.style.cursor="wait";
                try {window.event.cancelBubble=true;} catch(ex) {}
            } else {
                top.window.document.body.style.cursor="default";
                window.document.body.style.cursor="default";
                window.defaultStatus="";
                window.status="";

                divobj.style.visibility="hidden";
                divobj.style.left = 0;
                divobj.style.top = 0;

                waitImg.style.visibility="hidden";
                waitImg.style.left = 0;
                waitImg.style.top = 0;

                //waitPriDoc.body.scroll = "yes";
                ComPriComboObjsEnable(true,childWaitDoc);
            }
        } catch (err) { ComFuncErrMsg(err.message); }
    }

 
    //IBCombo의 상태정보 저장
    var ORI_IBCOMBO_STATUS = new Array();
    //IBSheet의 상태정보 저장
    var ORI_IBSHEET_STATUS = new Array();
    //IBTab의 상태정보 저장
    var ORI_IBTAB_STATUS = new Array();
    var idx_combo=0;
    var idx_ibtab=0;
    var idx_ibsheet=0;

    /**
     * UI에 있는 ActiveX(IBMultiCombo, IBTab, IBSheet)를 Enable 또는 Disable 한다.
     * 이 때 Object들을 참조 하기 위한 class_id 상수값은 CoObject.js의 값을 참조한다.
     * 또한 해당 UI에 iframe이 포함 돼 있을경우 iframe안의 ActiveX Object들까지 모두 Enable 또는 Disable 한다.
     *
     * <br><b>Example :</b>
     * <pre>
     *    ComPriComboObjsEnable(true,childWaitDoc);
     * </pre>
     * @param {bool}   flag         필수,Object들의 상태를 Enable(true)/Disable(flase)로 바꾼다.
     * @param {object}   childWaitDoc   필수,ActiveX Object들을 포함하는 document object
     * @param {int}     depth   선택, recursive function 이기 때문에 현재의 depth
     * @return 없음
     */
    function ComPriComboObjsEnable (flag,childWaitDoc,depth) {
        var formObj = childWaitDoc.form;
        if (formObj == undefined) return;
        if (depth == undefined) depth = 0;

        if (depth == 0) {
            idx_combo=0;
            idx_ibtab=0;
            idx_ibsheet=0;
        }
        len = formObj.elements.length;

        if (flag == false) {
            for (i = 0 ; i < len ; i++) {
                if (formObj.elements[i].classid!=undefined) {
                    switch (formObj.elements[i].classid) {
                        case CLSID_IBMCOMBO: // IBMultiCombo 경우
                            ORI_IBCOMBO_STATUS[idx_combo++] = formObj.elements[i].Enable ;
                            formObj.elements[i].Enable = false;
                            break;
                        case CLSID_IBTAB : //IBTab
                            ORI_IBTAB_STATUS[idx_ibtab++] = formObj.elements[i].Enable ;
                            formObj.elements[i].Enable = false;
                            break;
                        case CLSID_IBSHEET : //IBSheet
                            ORI_IBSHEET_STATUS[idx_ibsheet++] = formObj.elements[i].Enable ;
                            formObj.elements[i].Enable = false;
                            break;
                    }
                }
            }
        } else {
            for (i = 0; i < len; i++) {
                if (formObj.elements[i].classid!=undefined) {
                    switch (formObj.elements[i].classid) {
                        case CLSID_IBMCOMBO: // IBMultiCombo 경우
                            formObj.elements[i].Enable = ORI_IBCOMBO_STATUS[idx_combo++];
                            break;
                        case CLSID_IBTAB : //IBTab
                            formObj.elements[i].Enable = ORI_IBTAB_STATUS[idx_ibtab++];
                            break;
                        case CLSID_IBSHEET : //IBSheet
                            formObj.elements[i].Enable =  ORI_IBSHEET_STATUS[idx_ibsheet++]  ;
                            break;
                    }
                }
            }
        }
        // iframe 안의 object에 대한 내용을 Enable
        var iframeObj = childWaitDoc.getElementsByTagName("iframe");
        if (iframeObj.length != undefined) {
            var ifrmLen = iframeObj.length;
            for (var idxFrame = 0 ; idxFrame < ifrmLen ; idxFrame++) {
                ComPriComboObjsEnable(flag,iframeObj[idxFrame].contentWindow.document ,depth+1) ;
            }
        }
    }

    /**
     * 첫번째 인자로 받은 특정 javascript Function을 호출하고, 그 함수가 실행되는 동안 대기이미지(Waiting)를 표시한다. <br>
     * 그 함수의 실행이 끝나면 대기이미지(Waiting)가 사라지고, 키보드나 마우스의 대기상태도 원래상태로 복원된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    ComPriOpenWaitCallFunc("setBkgCargo"); //setBkgCargo() 함수가 호출시작하면 대기상태로 되고, 실행완료되면 원래상태로 복원된다.
     *
     *    //아래의 3줄의 코드는 위의 1줄 코드와 동일하다.
     *    ComOpenWait(true);
     *    setBkgCargo();
     *    ComOpenWait(false);
     * </pre>
     * @param {string} sFunc        필수,호출할 Function 문장 전체
     * @param {bool}   bOpenLayer   선택,대기이미지(Waiting) 표시 여부, default=false
     * @return 없음
     * @see #ComPriOpenWait
     */
    function ComPriOpenWaitCallFunc(sFunc, bOpenLayer) {
        try {
            ComPriOpenWait(true, bOpenLayer);
            setTimeout(sFunc+"();ComPriOpenWait(false);", 100)
            /*
            if(ComFuncCheck(sFunc)) {
                ComFunc();
                ComOpenWait(false);
            } else {
                ComShowMessage("[ComOpenWaitCallFunc]" +sFunc + "함수는 정의되어 있지 않습니다.");
            }
            */
        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /**
     * 대기이미지를 처리하기 위한 대기Frame을 document 안에 생성 처리한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    initPriWaitFrame();
     * </pre>
     * @return 없음
     * @see #ComPriOpenWait
     */
    function initPriWaitFrame() {
        try {

            if (document.readyState!="complete") return;
            document.onreadystatechange = null;

            if (waitPriDoc != null && waitPriDoc.getElementById(WAIT_PRI_DIV_NAME)!=null) return;
            //대기 이미지를 위한 DIV 만들기
            var _divWait=waitPriDoc.createElement("<div id='"+WAIT_PRI_DIV_NAME+"' style='filter:alpha(opacity=20);background-color:gray;position:absolute; cursor:wait; left:0px; top:0px; width:100%; height:99.9%; z-index:100; visibility:hidden;'/>");
            waitPriDoc.body.insertBefore(_divWait);

            //DIV안에 iFrame 만들기(대기이미지가 select or object태그 아래로 숨겨지지 않도록 하기 위함)
            var _frameWait = waitPriDoc.createElement("<IFRAME id='"+WAIT_PRI_FRAME_NAME+"' src='"+waitPriImage +"' frameborder=0 marginHeight=0 marginWidth=0 width="+waitPriW+" height="+waitPriH+" style='position:absolute;visibility:hidden;z-index:999' />");
            //iframe div로 부터 분리.
            waitPriDoc.body.insertBefore(_frameWait);

        } catch(err) { ComFuncErrMsg(err.message); }
    }

    /*****************************************************************
     *
     *                Wait End
     *
     ******************************************************************/
     
     
     /**
      * 개발자 컴퓨터에서 개발중인지 서버에서 동작중인지 판단 할수 있도록 <BR>
      * localhost 여부를 return해 준다.
      * 
      * <br><b>Example :</b>
      * <pre>
      *   
      * </pre>
      * @return boolean, true : localhost, false : 그외
      * @author 송민석
      *   
      */
     function ComPriIsLocalhost() {
     	if(location.hostname == "localhost" 
    		|| location.hostname == "127.0.0.1" 
    		|| location.hostname == "mssongpc.com"
    		|| location.hostname == "sspark-pc"){
    		return true ;
    	}    	
     	return false;
     }
     
     
     /**
     * GEM OPEN시 버튼의 기능을 막아야 할경우 해당 버튼을 비활성화 하고 <BR>
     * 이름을 바꿔 쓸모없게 만든다.
     * 
     * <br><b>Example :</b>
     * <pre>
     *   
     * </pre>
     * @param {string} name : button의 이름
     * @author 송민석
     *   
     */
    function ComPriMakeButtonUseless(name) {
    	// 변경대상인지 알 수 없어서 두 경우 모두 작업 수행하도록 수정.
 		if( location.hostname == "gem.hanjin.com" || location.hostname == "gem.smlines.com"){
	       	var tds = document.getElementsByTagName("td");  
	      	for(var i = 0; i < tds.length; i++) {
	      	    var td=tds[i];
	       	    if (td.className.length > 0 && td.name == name ){
	     	    	if(td.className.indexOf('_1') == -1)
	     	    		td.className += "_1";
	   	    		td.name="useless_"+name;
	   	    		break;
	     	    }
	      	}
		}
    }
    
    
     
    /**
     * 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param {string} popProgId  : 팝업할 화면 id </br>
     * @param {string} callProgId : 호출하는 부모 화면 id </br>
     * @param {string} popParams  : 파라미터
     * @param {string} callEtc    : 기타
     * @return 없음
     * @author 김대호
     * @version 2010.01.29
     */
    function comCallPop(popProgId, callProgId, popParams, callEtc) {

        var isMenuWin = true;
        var winNm = "popWin" + popProgId + "_" + callProgId;

        /***** 메뉴포함 POP - Start *****/
        var pgmNo = popProgId;
        var pgmUrl = "/hanjin/" + popProgId + ".do";
        var parentPgmNo = pgmNo.substring(0, 8) + 'M001';   
        var src = "&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo;   
        var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
        /****** 메뉴포함 POP - Edn ********************************************************/

        /***** 일반 POP - Start *****/
        /* ComOpenWindowCenter(sUrl, sWinName, iWidth, iHeight, bModal, sScroll); */
        var popWidth  = 1024;
        var popHeight = 700;
        var isModal   = false;
        var popScroll = "no";
        /***** 일반 POP - End *****/

        switch(popProgId) {

            case "ESM_PRI_0003": break; // 0060, 0062
            case "ESM_PRI_0057": break; // 0062
            case "ESM_PRI_0061":        // 0062
                isMenuWin = false; popWidth = 1024; popHeight = 750; isModal = true;
                break;
            case "ESM_PRI_0111":        // 0108_01, 0108_02
            case "ESM_PRI_2211":        // 2219_01, 2219_02
                isMenuWin = false; popWidth = 900; popHeight = 520; 	        
                break;
            case "ESM_PRI_2003": break; // 2042, 2043
            case "ESM_PRI_2041": break; // 2043

        }

        if(isMenuWin){
            var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src + "&" + popParams, winNm, sFeatures);
        }else{
            ComOpenWindowCenter(pgmUrl + "?" + popParams, winNm, popWidth, popHeight, isModal, popScroll);	        
        }

    }     
      
    /**
     * Gem 서버에서 동작중인지 판단 할수 있도록 <BR>
     * Gem 서버 여부를 return해 준다.
     * 
     * <br><b>Example :</b>
     * <pre>
     *   
     * </pre>
     * @return boolean, true : Gem 서버, false : 그외
     * @author 공백진
     *   
     */
    function ComPriIsGem() {
    	// 변경대상인지 알 수 없어서 두 경우 모두 작업 수행하도록 수정.
        if(location.hostname == "gem.hanjin.com" || location.hostname == "gem.smlines.com"){
            return true ;
        }    	
        return false;
    }      

	/**
     * RFA,PROPOSAL No가 Login Office가 BA조직일때 BA 조직에서 Proposed한 것이 Check하는 로직 <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkRfaNobyBaOfc(sheetObj,Pricing No,Login office Code,RFA인지 Proposal 인지 구분자)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {string} 검사하고자 하는 No(RFA No or Proposal No
     * @param (string) Login Office
     * @param (string) No의 구분 'R' : RFA No, 'P' : Proposal No
     * @param (string) Login RHQ Ofc Cd
     * @return (String) 'Y' :BA것 맞음.No 유효함,'X' : No 유효함, BA것 아님. 'N' : No가 유효하지 않음.
     * @author 이석준
     * @version 2011.11.29
     */
	function checkRfaNobyBaOfc(sheetObj,formObj, rfaNo,logInOfcCd,rfaNoInd,logInRhqOfcCd) {		
		if (logInOfcCd.substr(3,2) !='BA') return 'Y' //BA가 아니면 그냥 Return
		if (logInRhqOfcCd != 'HAMRU') return 'Y' // HAMRU 산하의 BA Office 제한 로직을 걸어야 함.
		
		//etc1 : 	RfaNo
		 var sParam = "f_cmd="+SEARCH21+"&etc1="+rfaNo+"&etc2="+logInOfcCd+"&etc3="+rfaNoInd;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do",sParam);
			var chkRtn = ComGetEtcData(sXml,"baInd");
			
			if (chkRtn =='X'){ //RFA No 유효,BA것 아님
				ComShowCodeMessage('PRI07001');
			}
			return chkRtn;
		} 
		
	/**
	 * System의 오늘 날짜 조회
	 */
	function searchSystemToDate(sheetObj) {
		var sParam = "f_cmd=" + SEARCH30;
		var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
		return ComGetEtcData(sXml, "SYS_TODATE");
	}
	
	/**
	 * 외부 콤보박스의 리스트 가져오기
	 **/
	function getPriIbComboList( combo , code , text , option) {
		var cdList = code;
		var NmList = text;

		var cdArray = new Array();
		var nmArray = new Array();

		cdArray = cdList.split("|");
		nmArray = NmList.split("|");

		combo.RemoveAll();

		for(var i=0; i<cdArray.length; i++)
		{
			combo.InsertItem(i, nmArray[i]+'|'+cdArray[i],  cdArray[i]);
		}
		if (option == 'ALL') {
			combo.InsertItem(0, '' ,  '');
		}
	}

	 /**
	 * 멀티콤보 클릭 이벤트  <br>
	 * <b>Example :</b>
	 *
	 * @param comboObj	멀티콤보 오브젝트
	 * @param index		멀티콤보 index
	 */
	 function PriAllChkMultiCombo(comboObj,index) {
		//All 인 경우
	    if(index == 0) {
	    	//checked
	    	if(comboObj.CheckIndex(index)) {
	    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
	    			comboObj.checkIndex(i) = true;
	    		}

	    	} else {
	    		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
	    			comboObj.checkIndex(i) = false;
	    		}
	    	}
		//All 이 아닌 경우
	    } else {
	    	var checkCnt = 0;
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				if(comboObj.checkIndex(i)) {
					checkCnt++;
				}
			}
			if(checkCnt == comboObj.GetCount() - 1) {
				comboObj.checkIndex(0) = true;
			}else{
				comboObj.checkIndex(0) = false;
			}
	    }
	 }
	 
	 
 
	 function PriCheckMonthBetween(fromDt,toDt,month){
	     
	     var v = ComGetDateAdd(fromDt, "M" , month,"")	 ;
	     // alert("V="+v);
	     var v2 = ComGetDaysBetween(toDt, v);
	     //alert("V2="+v2);
	     return v2;
	 }
	