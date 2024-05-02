﻿﻿﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoBkg.js
*@FileTitle  : BKG common javascript
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
==========================================================*/
	if(msgs == undefined){
		msgs = new Array();
	}
  msgs['BKG00002']="You have no authority to update {?msg1}."
  msgs['BKG00003']="This booking is already BDRed."
  msgs['BKG00004']="This booking is BDRed If you want to modify booking data, use booking correction window"
  msgs['BKG00005']="This booking has been already canceled, You can not update booking data"
  msgs['BKG00006']="POR is not available"
  msgs['BKG00007']="VVD is not available!"
  msgs['BKG00008']="Shipper customer code is not available"
  msgs['BKG00009']="CNEE customer code is not available"
  msgs['BKG00010']="Commodity code is not available"
  msgs['BKG00011']="REP. Commodify code is not available."
  msgs['BKG00012']="Please search data first."
  msgs['BKG00013']="Q'ty must be larger than 0."
  msgs['BKG00014']="weight is not available"
  msgs['BKG00015']="The weight unit is not available"
  msgs['BKG00016']="You must input either S/C No or RFA No or TAA No."
  msgs['BKG00017']="Sailing due date must be inputted."
  msgs['BKG00019']="Origin Sales Office Code is not available"
  msgs['BKG00020']="For Egypt import cargoes, only F/O term is allowed. DEL term to be changed to F/O automatically."
  msgs['BKG00021']="Please, select & save specific commodity code."
  msgs['BKG00022']="Trunk VVD is  {?msg1}. In your manual route, can not find trunk VVD."
  msgs['BKG00023']="Select Notify ERROR!"
  msgs['BKG00024']="Select Dest AR Office ERROR!"
  msgs['BKG00025']="In your BKG OFC, BKG POL is invalid"
  msgs['BKG00034']="Duplicate Bkg No[{?msg1}]! Please try again."
  msgs['BKG00035']="Trunk VVD Changed.\nPlease check the on-board date"
  msgs['BKG00036']="DEL is changed.\nPlease make it sure whether collect office is correct or not"
  msgs['BKG00037']="MT PICK UP CY code is not available"
  msgs['BKG00038']="CNTR TP/SZ '{?msg1}' is duplicated"
  msgs['BKG00042']="OCP code is not available"
  msgs['BKG00043']="Location field is mandatory, if you want to input STOP OFF CGO Information."
  msgs['BKG00044']="{?msg1} code is not available"
  msgs['BKG00046']="Unable to save due to invalid Contract No"
  msgs['BKG00047']="Unable to save due to invalid Auth No"
  msgs['BKG00048']="Booking Number({?msg1} -> {?msg2}) is changed, You can not save this booking data"
  msgs['BKG00049']="Manual Booking Number is not available, X can not be 'year'"
  msgs['BKG00050']="Manual Booking Number Seq. is not available"
  msgs['BKG00051']="VVD({?msg1}) is not available."
  msgs['BKG00052']="Pre VVD amount is beyond limit."
  msgs['BKG00053']="POL and POD are the same. Check booking route again."
  msgs['BKG00054']="There is no Reefer Cntr Type/Size!"
  msgs['BKG00055']="This customer is blacklisted customer. Pls contact Sales Office for BKG allowance"
  msgs['BKG00056']="POL code is not available B/L number & Booking number are not created"
  msgs['BKG00057']="already sent to bank. Cannot change prior to cancel"
  msgs['BKG00058']="BKG VVD is not available. Trunk VVD({?msg1}) not exists"
  msgs['BKG00059']="Please check your POD location"
  msgs['BKG00061']="The location code({?msg1}) is not registered in DB(location)"
  msgs['BKG00062']="The container type size code({?msg1}) is not available"
  msgs['BKG00063']="BKG No split is invalid"
  msgs['BKG00064']="Reserved BKG No. for GT Nexus"
  msgs['BKG00065']="POL {?msg1} is invalid."
  msgs['BKG00066']="DEL({?msg1}) is not valid. Check location code again."
  msgs['BKG00067']="POD({?msg1}) is not valid. Check location code again."
  msgs['BKG00068']="[{?msg1}] is not available."
  msgs['BKG00069']="E/Q CTL OFC({?msg1}) is not registered in DB(office)"
  msgs['BKG00071']="This VVD({?msg1}) was already Released (BDR)"
  msgs['BKG00072']="This VVD({?msg1}) was not Released (BDR)\nIn correction mode, You have to use Released VVD"
  msgs['BKG00073']="Cargo type can not be updated.\nIf this process needed, create the new booking number"
  msgs['BKG00074']="This booking No({?msg1})'s agent code({?msg2}) is not registered in DB({?msg3})"
  msgs['BKG00075']="Invalid RTN CY code"
  msgs['BKG00076']="Customer Code {?msg1}is not available."
  msgs['BKG00077']="Unable to create a fwdr bkg due to IC customer type of customer[{?msg1}]"
  msgs['BKG00078']="POL({?msg1})/POD({?msg2}) is not calling port of vessel({?msg3})"
  msgs['BKG00079']="The ETD of VVD({?msg1}) is earlier than the ETB of VVD({?msg2})"
  msgs['BKG00080']="Can't update SCAC as Null When H/BL Exists!"
  msgs['BKG00081']="Unable to SAVE due to P.O No missing (or improper PO NO length).\n Please check PO NO again"
  msgs['BKG00082']="Update Error For S/C or Auth data ,if you want to modify data, use booking charge window"
  msgs['BKG00083']="Data saved after booking closing time"
  msgs['BKG00084']="Booking No is created after booking closing time"
  msgs['BKG00085']="Cargo type * commodity is unmatched.\nPlease check again"
  msgs['BKG00086']="Cargeo type * Container type size is unmatched.\nPlease check again"
  msgs['BKG00087']="This booking has been already downloaded for AMS/ACI filing.\nPlease inform related offices of modified booking data."
  msgs['BKG00088']="TRO Screen was updated as unconfirmed.\nPlease check it!"
  msgs['BKG00090']="Can’t copy Cancel booking."
  msgs['BKG00091']="Can't copy BDRed Booking."
  msgs['BKG00092']="You can not search Empty Reposition BKG Data"
  msgs['BKG00093']="Can't split Cancel Booking."
  msgs['BKG00094']="S/O already issued. Please cancel S/O first."
  msgs['BKG00095']="No data found."
  msgs['BKG00096']="Unable to save due to wrong code."
  msgs['BKG00097']="P/MIB number doesn't start with V17."
  msgs['BKG00098']="Failed to send Fax or e-mail."
  msgs['BKG00099']="Failed to transmit EDI"
  msgs['BKG00100']="Vesel SKD is not available."
  msgs['BKG00101']="EDI was transmitted successfully."
  msgs['BKG00102']="Data was saved successfully."
  msgs['BKG00103']="Please Input (VVD and POR) or (VVD and POD) !!!"
  msgs['BKG00104']="Mandatory item is missing. Please enter ({?msg1})"
  msgs['BKG00105']="Invalid code"
  msgs['BKG00106']="Unable to [EDI Transmit] Without NCM Code, Please input [B/L No : {?msg1}] NCM Code!"
  msgs['BKG00107']="Data exceeded maximum length ({?msg1})."
  msgs['BKG00108']="Please enter Year ccorrectly.\nFormat : YYYY"
  msgs['BKG00109']="As there is no result searched, it's impossible to  download in the [EXCEL] format."
  msgs['BKG00110']="Failed to ( {?msg1} ). Please try again"
  msgs['BKG00111']="Please, input VVD or Duration of Panama ETA!"
  msgs['BKG00112']="select(vvd list) error"
  msgs['BKG00113']="Not allowed to insert CNTR(s) into Canceled BKG({?msg1},{?msg2})."
  msgs['BKG00114']="Not allowed to insert CNTR(s) into BKG({?msg1},{?msg2}) with different TVVD({?msg3}), POL({?msg4}), POD({?msg5}), CGOTP({?msg6})."
  msgs['BKG00115']="Please, input VVD!"
  msgs['BKG00116']="Please, input Visit Number!"
  msgs['BKG00117']="Please, input Movement Sequence!"
  msgs['BKG00118']="Please, input ACP Custoemr Code!"
  msgs['BKG00119']="Please, input Origin Route!"
  msgs['BKG00120']="Please, input Dest Route!"
  msgs['BKG00121']="VVD[{?msg1}] INFO is saved successfully!"
  msgs['BKG00122']="CAD is transmitted successfully!"
  msgs['BKG00123']="Failed to select PAPAC calling sequence by VVD({?msg1})"
  msgs['BKG00124']="Failed to select General Cargo Info by VVD({?msg1})"
  msgs['BKG00125']="Failed to select CAD - Empty Cargo Info by VVD({?msg1})"
  msgs['BKG00126']="Failed to select CAD - Hazardous Info by VVD({?msg1})"
  msgs['BKG00128']="Failed to select Major Cargo Type({?msg1})"
  msgs['BKG00129']="Failed to make CAD - General Cargo Info by VVD({?msg1})"
  msgs['BKG00130']="Failed to make CAD - Empty Cargo Info by VVD({?msg1})"
  msgs['BKG00131']="Failed to make CAD - Hazardous Cargo Info by VVD({?msg1})"
  msgs['BKG00132']="Failed to make CAD - message header"
  msgs['BKG00133']="Failed to make CAD - Basic Infromation by VVD({?msg1})"
  msgs['BKG00134']="All cargo(General, Empty, Hazardous) information has not been generated. At least, one of them is needed for generating CAD."
  msgs['BKG00135']="send_msgs[via_MQ() Failed."
  msgs['BKG00136']="Booking Creation1 Main Window POL Input"
  msgs['BKG00137']="POL is not available"
  msgs['BKG00138']="Location Code Not Calling Port"
  msgs['BKG00140']="This Lane[{?msg1}] does not exist!"
  msgs['BKG00141']="POL,POD Equal!"
  msgs['BKG00143']="1/2/3/4 POD is not calling port!"
  msgs['BKG00144']="{?msg1} VVD does not exist!"
  msgs['BKG00145']="Please! Check your VVD."
  msgs['BKG00146']="POL or POD on Route Detail is different from BKG main."
  msgs['BKG00148']="You should inform to S/O issue staff,\nbecause S/O issue staff can't load S/O candidate."
  msgs['BKG00149']="Please select B/L."
  msgs['BKG00150']="You can't update it after BDR."
  msgs['BKG00151']="Please select reason of Roll Over."
  msgs['BKG00152']="VVD was not changed"
  msgs['BKG00153']="Please save change of VVD first"
  msgs['BKG00154']="You can't select multiple BKGs."
  msgs['BKG00155']="Document is not selected."
  msgs['BKG00156']="Invalid duration"
  msgs['BKG00157']="Shipper country codes are different !"
  msgs['BKG00158']="POR codes are different !"
  msgs['BKG00159']="DEL codes are different !"
  msgs['BKG00160']="Booking offices are different !"
  msgs['BKG00161']="Please Enter the Data..\nTrunk VVD"
  msgs['BKG00162']="Please Enter the Data..\nRegistry Number"
  msgs['BKG00163']="VVD is NOT Registered"
  msgs['BKG00164']="POL is NOT Registered"
  msgs['BKG00165']="POD is NOT Registered"
  msgs['BKG00166']="Data Saved Successfully!!"
  msgs['BKG00167']="Data Save Action Failed!!"
  msgs['BKG00168']="Data was changed. Do you want to close the window without saving it?"
  msgs['BKG00169']="No CNTR Number, No Confirm!"
  msgs['BKG00170']="D/O was not Assign yet !!"
  msgs['BKG00171']="Special Column Matching Completed, Deletion of Special Cargo info For CNTR ({?msg1}) is required!"
  msgs['BKG00172']="meaning HJCU {?msg1} ?"
  msgs['BKG00173']="failed to find CNTR( {?msg1} )"
  msgs['BKG00174']="CNTR measure exceeds 999.999!"
  msgs['BKG00175']="BKG CNTR Confirm Checked!"
  msgs['BKG00176']="Delivery due date should be later than loading date."
  msgs['BKG00177']="C/M data exists. Do you want to continue?"
  msgs['BKG00178']="Data modifed, save modifed data first!"
  msgs['BKG00179']="[BKG Q'TY] and [CNTR Q'TY] are unmatched. Please check again."
  msgs['BKG00180']="Matahing Image Storage(Container No) required"
  msgs['BKG00181']="Are you sure of releasing CNTR confirm?"
  msgs['BKG00182']="Container Can't be released in BKG. CORRECTION Mode!!!"
  msgs['BKG00183']="BKG No.[{?msg1}] is invalid."
  msgs['BKG00184']="Do you want to update each total quantities of BKG with those of C/M?"
  msgs['BKG00185']="Do you want to update Country Package & Weight according to C/M?"
  msgs['BKG00186']="Please, Input Customer's Country Code!"
  msgs['BKG00187']="Invalid Forward customer code!"
  msgs['BKG00188']="Please select Container first."
  msgs['BKG00189']="This will append the description to the end of \"DESCRIPITON OF GOODS\" in B/L.\nIf needed, SEQ of \"Marks & Description\" would be increased.\nAre you sure to proceed?"
  msgs['BKG00190']="Description successfully copied!"
  msgs['BKG00191']="You need to specify which unit contains special cargo.\n Please, select & save container number at special container screen(DG, RF, AK, BB)"
  msgs['BKG00192']="CNTR({?msg1}) was aleady reserved by BKG({?msg2}).\r\nCheck partial indicator if you want to use it!"
  msgs['BKG00193']="Please search Customer Information Template first.."
  msgs['BKG00194']="Invalid State, Country code (Shipper) - Pls check again({?msg1}-{?msg2})"
  msgs['BKG00195']="Invalid State, Country code (Consignee) - Pls check again({?msg1}-{?msg2})"
  msgs['BKG00196']="Invalid State, Country code (Notify) - Pls check again({?msg1}-{?msg2})"
  msgs['BKG00197']="Are you sure to replace charge remarks ?"
  msgs['BKG00198']="You can not insert both Manual input and Exemption. Please check data!!"
  msgs['BKG00199']="Discrepancy Info, \nThere is one more discrepancy of quantity B/W BKG and E/L.\nDo you want to save anyway?\n[BKG]\nPackage: {?msg1}  \nWeight : {?msg2} \n[E/L]\nPackage: {?msg3} \nWeight : {?msg4}"
  msgs['BKG00200']="System-generated CHK DIGIT({?msg1}) is different from Input CHK DIGIT({?msg2})!"
  msgs['BKG00201']="Insert Error"
  msgs['BKG00202']="Update Error"
  msgs['BKG00203']="VVD & POD are mandatory items."
  msgs['BKG00204']="Data Transmitted successfully!"
  msgs['BKG00205']="Data Transmitted Un-successfully!"
  msgs['BKG00206']="Port Registration No. is mandatory item !!"
  msgs['BKG00207']="Last Call Port is mandatory item. Please insert location code."
  msgs['BKG00208']="Plz, Check VVD or POD"
  msgs['BKG00209']="Please Input POL."
  msgs['BKG00210']="Please Input POD."
  msgs['BKG00211']="Please Check Message Function!!"
  msgs['BKG00212']="Please Check Manifest or Port Authority!!"
  msgs['BKG00213']="Missing VVD or POL."
  msgs['BKG00214']="POL or POD Code must be inputted !!"
  msgs['BKG00215']="VVD Select Error"
  msgs['BKG00216']="Data Searched Successfully !"
  msgs['BKG00217']="Do you want to transmit MFT file to The HKG Customs ?"
  msgs['BKG00218']="Data Transmitted Successfully!"
  msgs['BKG00219']="Send Log VVD Insert error"
  msgs['BKG00220']="Make FlatFile Failed!!"
  msgs['BKG00221']="As there is no result searched."
  msgs['BKG00223']="Please Enter the Data. (VVD, Duration, POD)"
  msgs['BKG00224']="Do you want to make preparation as MI file?"
  msgs['BKG00225']="Please do Evalucation first."
  msgs['BKG00227']="Please, input VVD!"
  msgs['BKG00228']="Hub city is not available."
  msgs['BKG00229']="Missing Last USA"
  msgs['BKG00230']="Missing P/MIB Type"
  msgs['BKG00231']="Please Input POL or POD."
  msgs['BKG00232']="Unknown system error took place while processing data. Please try later. If the same error continues, please contact system help desk."
  msgs['BKG00233']="Nothing changed"
  msgs['BKG00234']="ATTN! \nPlease fill out City Name for Canada Customs Manifest."
  msgs['BKG00235']="ATTN! \nPlease fill out State Code for Canada Customs Manifest."
  msgs['BKG00236']="ATTN! \nPlease fill out Country Code for Canada Customs Manifest."
  msgs['BKG00237']="Please assign Manifest File No. first before adding C/M"
  msgs['BKG00238']="Master B/L No must exist to assign AMS Ref No"
  msgs['BKG00239']="Select Container First!"
  msgs['BKG00240']="Do you want to assign Manifest File No.?"
  msgs['BKG00241']="B/L No. is Invalid."
  msgs['BKG00242']="Failed to transmit to the fax server. Contact the server admin"
  msgs['BKG00243']="Failed to transmit to the email server. Contact the server admin"
  msgs['BKG00244']="Has been failed to search data."
  msgs['BKG00245']="E-mail is invalid {?msg1}. Please check it again."
  msgs['BKG00246']="Fax No. is invalid {?msg1}. Please check it again."
  msgs['BKG00247']="This is Empty-repo Booking!"
  msgs['BKG00248']="Voy. File No is mandatory item."
  msgs['BKG00249']="No Selected Row"
  msgs['BKG00250']="This is Only Japan port Edit"
  msgs['BKG00251']="VVD is mandatory item."
  msgs['BKG00252']="POD is mandatory item."
  msgs['BKG00253']="In correction mode, you can not create new booking"
  msgs['BKG00254']="Data Changed. Do you want to save it ?"
  msgs['BKG00255']="Booking Number is not available."
  msgs['BKG00256']="This booking contains Precuation Cargo.\nTo avoid fire accident, container(s) will be loaded on deck or under deck away from boiler."
  msgs['BKG00257']="=Export license number=\n<Compostion of E/L number>\n(1)Code of CUSTOMS(3digits)\n(2)Code of DEPARTMENT(2digits) \n(3)Year(2digits) \n(4)Sequence number(7digits)\n(5)Check_digit(1digit:assigned by user or SYSTEM) \n(Ex) 010-21-96-0000001-6"
  msgs['BKG00258']="Total hanger volume is larger than BKG Q’TY"
  msgs['BKG00259']="Split suffix cannot be used for manual booking number."
  msgs['BKG00260']="Data NOT Changed"
  msgs['BKG00261']="Customs Data Created. \nIt fails to download {?msg1} B/Ls. \nPlease check out the mandatory item(s) again";
  msgs['BKG00262']="VVD or POD is mandatory item."
  msgs['BKG00263']="VVD={?msg1}, POD={?msg2}\nDo you want to trans to SEA-NACCS as MFR file?"
  msgs['BKG00264']="MFR Sent"
  msgs['BKG00265']="Nothing to Send"
  msgs['BKG00266']="B/L NO is mandatory item."
  msgs['BKG00267']="In your BKG OFC, BKG POL is invalid"
  msgs['BKG00268']="There is no valid zone code in {?msg1}"
  msgs['BKG00269']="There is no valid container yard in {?msg1}"
  msgs['BKG00270']="In case of tackle or free in term, POR and POL must be the same"
  msgs['BKG00271']="In case of tackle or free out term, POD and DEL must be the same."
  msgs['BKG00272']="There is no valid marine or barge terminal code in {?msg1}."
  msgs['BKG00273']="BKG or B/L No is invalid"
  msgs['BKG00274']="This booking cargo will be considered as Precaution Cargo and loaded on desk or under deck away from boiler space in order to escape any potential dangerous against fire accident."
  msgs['BKG00275']="You just changed the type/size/quantity of containers that your manifested rates are based on.\nPlease, go to Freight and Charge screen to avoid misrating. Are you going to open the Freight and Charge screen?"
  msgs['BKG00276']="Cargo type * commodity is unmatched Please check again"
  msgs['BKG00277']="Cargeo type * Container type size is unmatched Please check again"
  msgs['BKG00278']="TRO Screen was updated as unconfirmed.\nPlease check it"
  msgs['BKG00279']="The Date code of booking number is not available"
  msgs['BKG00280']="Duplicate Bkg No! Please try again."
  msgs['BKG00281']="Unable to save due to invalid S/C No.!"
  msgs['BKG00282']="Unable to save due to invalid RFA No.!"
  msgs['BKG00283']="Please select proper US customs Filer!"
  msgs['BKG00284']="Please select proper Canada Filer!"
  msgs['BKG00285']="Please select a Canada Filer as '3' !"
  msgs['BKG00286']="ATTN:Do not forget to make NVO H/BL Record."
  msgs['BKG00287']="This is HCDG cargo required for strict security procedure for inland haulage in EU.\nPlease don't accept Carrier's haulage Booking and Induce CY port term.\nDo you want to continue"
  msgs['BKG00288']="POL is not available"
  msgs['BKG00289']="POD is not available"
  msgs['BKG00290']="DEL is not available"
  msgs['BKG00291']="Consignee country code is not available"
  msgs['BKG00292']="Forwarder country code is not available"
  msgs['BKG00293']="Forwarder customer code is not available"
  msgs['BKG00294']="POL is not available"
  msgs['BKG00295']="POD is not available"
  msgs['BKG00296']="DEL is not available"
  msgs['BKG00297']="Container type/size is not available"
  msgs['BKG00298']="You can select Mixed term when CNTR Q'ty is two or more."
  msgs['BKG00299']="S.Rep code is not available !"
  msgs['BKG00300']="Shipper country code is not available"
  msgs['BKG00301']="When S/C specifies US inland transportation mode as 'All motor'\n1) Click on T/S Route in booking main screen.\n2) Select 'All motor' in drop-off button of Mode next to DEL"
  msgs['BKG00302']="Your RCV / DEL term may not be chosen unless RHQ exceptionally allows.\nAs per marketing decision, carriage from CY(or Door/Carrier's haulage) to CFS is prohibited except for below accounts.\nExceptions : BASF, Fair Trade, Thyssen Krupp, SUZUKI MOTOR CORPOR"
  msgs['BKG00303']="Receiving/Delivery term of reefer cargo should be noted on B/L as CY/CY.\nIf not, it is requested to consult with Controlling Regional Head Quarter before booking."
  msgs['BKG00304']="1. Booking staff is requested to book A4 containers mainly for Oversize cargos, but he/she may get an written approval from local logistic manager when A4 containers should be substituted for normal flat rack container due to the lack of flat rack cont"
  msgs['BKG00305']="The commodity you booked for is precaution cargo which needs to load on deck in usual.\nIf you have any special request for stowage, then, insert it into STOW"
  msgs['BKG00306']="Please, select and save Y2 next to your POD, PHMNL, only if your shipper requests north harbor of PHMNL for port of discharge,and have the RFA or S/C rate."
  msgs['BKG00307']="Please, select & save specific commodity code."
  msgs['BKG00308']="Wrong AMS filer type was chosen.NVOCC S/C is only applicable to filer 01 or 02. Cargo Owner S/C is only applicable to filer 03."
  msgs['BKG00309']="P/C was not executed successfully after change of route."
  msgs['BKG00310']="Cargo type can not be updated. If this process needed, create the new booking number"
  msgs['BKG00311']="Update Error For S/C or Auth data ,if you want to modify data, use booking charge window"
  msgs['BKG00312']="The booking for {?msg1} is closed. Will you proceed?"
  msgs['BKG00313']="New Booking({?msg1}) is created."
  msgs['BKG00314']="Data saved after booking closing time. Please send e-mail to related party."
  msgs['BKG00315']="Data saved"
  msgs['BKG00316']="Special cargo approval is under process. You cannot change booking status."
  msgs['BKG00317']="Booking status cannot be changed after VL status."
  msgs['BKG00318']="Other user hold this booking. You cannot change booking status."
  msgs['BKG00319']="Data exceeded field length. ({?msg1})"
  msgs['BKG00320']="Please, Input to Frist VVD"
  msgs['BKG00321']="Please, Input to POL"
  msgs['BKG00322']="Total : $S  Completed"
  msgs['BKG00323']="Please check Select box of the target BKG No"
  msgs['BKG00324']="S/C No should be 8 digit."
  msgs['BKG00325']="RFA No should be 11 digit."
  msgs['BKG00326']="Temperature will not be copied. Please set temperature in the reefer application screen!"
  msgs['BKG00327']="No of Bkg_no <= 30"
  msgs['BKG00328']="Not allowed to update after O/BL release."
  msgs['BKG00329']="Unable to update due to office validation rule.\nIt should be Sales or BKG or  B/L Issue OFC."
  msgs['BKG00330']="Invalid Lane Code"
  msgs['BKG00331']="Invalid Bound"
  msgs['BKG00332']="Invalid POL"
  msgs['BKG00333']="Nothing To Select"
  msgs['BKG00334']="Please enter {?msg1} code"
  msgs['BKG00335']="This Booking No. Can Be Changed In Correction Mode."
  msgs['BKG00336']="EQ Office Code is not available"
  msgs['BKG00337']="S.Rep code or contact person is not selected."
  msgs['BKG00338']="You can’t copy data to C/M as Booking Rep. commodity is FAK(00) or Mixed Cargo(99)"
  msgs['BKG00340']="Customer code is invalid."
  msgs['BKG00341']="Please enter duration."
  msgs['BKG00342']="Unable to search ! Pls reduce duration within max. 7 days"
  msgs['BKG00343']="Data Already Existed Are you Sure to Replace it?"
  msgs['BKG00344']="Zip Code is mandatory for US/CA Location."
  msgs['BKG00345']="Same as … ‘ is not allowed."
  msgs['BKG00346']="Please fill out City Name, State, Country Code for Customs Manifest"
  msgs['BKG00347']="‘ORDER’ word is detected while B/L Type(S-Straight) in consingee.\nWould you change here to ‘O’ ?"
  msgs['BKG00348']="Cannot Find ‘ORDER’ while B/L Type(O-Order) in Consignee.\nWould you change directly to ‘S’ ?"
  msgs['BKG00349']="This booking has been already ‘CDRed’ for AMS/ACI."
  msgs['BKG00350']="Do you want to save your change(s)?"
  msgs['BKG00351']="Please Enter the Data [Shipper Name]"
  msgs['BKG00352']="Please Enter the Data [Shipper Address]"
  msgs['BKG00353']="unable to save due to deleted customer code({?msg1},{?msg2})"
  msgs['BKG00354']="customer({?msg1}, {?msg2}) code is a No Use code Please check again"
  msgs['BKG00355']="Invalid state,country code- Pls check again({?msg1}-{?msg2})"
  msgs['BKG00356']="Not found(Customer Code({?msg1},{?msg2}) In CUSTOMER ENTITY"
  msgs['BKG00357']="Not same shipper code or e-mail."
  msgs['BKG00358']="Please select data to save."
  msgs['BKG00359']="Do you want to combine the selected booking data ? Other booking no will be cancelled"
  msgs['BKG00360']="Please, go to TRO/O screen of each splitted booking to insert TRO information."
  msgs['BKG00361']="Do you want to print out Draft B/L ?"
  msgs['BKG00362']="You can't select multiple data."
  msgs['BKG00363']="Do you want to send email Draft B/L ?"
  msgs['BKG00364']="Do you want to send fax Draft B/L ?"
  msgs['BKG00365']="Fax No is either missing or not number!"
  msgs['BKG00366']="E-mail Address is missing or not correct format"
  msgs['BKG00367']="Please input VVD, B/L Issue Date or B/L No."
  msgs['BKG00368']="Data transmitted successfully."
  msgs['BKG00369']="VVD input max 50!"
  msgs['BKG00370']="File size can't not exceeds 5MB."
  msgs['BKG00371']="Do you want to delete the selected file?"
  msgs['BKG00372']="B/L Type is invalid(not ‘B’)"
  msgs['BKG00373']="O/BL not released"
  msgs['BKG00374']="B/L Type is invalid (not 'S: Straight')"
  msgs['BKG00375']="You can't input the date prior to today."
  msgs['BKG00376']="Number of surrendered B/L is not same as number of issued B/L"
  msgs['BKG00377']="Please check the input data. (YYYYMMDD)"
  msgs['BKG00378']="Please Input POL or POD!!!"
  msgs['BKG00379']="Container No. is not available."
  msgs['BKG00380']="VVD No Data!,Data InPut"
  msgs['BKG00381']="Incorrect Data Length"
  msgs['BKG00382']="This O/BL Surrender Infomation is created in [{?msg1}]. So, can not modify this information in your office  [{?msg2}]."
  msgs['BKG00383']="You can't change status."
  msgs['BKG00384']="Already canceled. ({?msg1}, {?msg2})"
  msgs['BKG00385']="Date should be between ETA-3 and ETD+3."
  msgs['BKG00386']="Data changed. Do you want to save?"
  msgs['BKG00387']="Mandatory conditions are missing. Please enter POD+ETA or POD+VVD."
  msgs['BKG00388']="Data is invalid. ({?msg1} )"
  msgs['BKG00389']="No data to dowload as Excel"
  msgs['BKG00390']="Do you want to generate CRN ?"
  msgs['BKG00391']="Failed to save data."
  msgs['BKG00392']="Failed to create CRN."
  msgs['BKG00393']="Do you want to delete the selected B/L?"
  msgs['BKG00394']="Nothing to print."
  msgs['BKG00395']="Data was not searched."
  msgs['BKG00396']="Nothing to transmit."
  msgs['BKG00397']="Error B/L(s) are included. Do you still want to transmit?"
  msgs['BKG00398']="Issue Date can't be eariler than On-Board Date."
  msgs['BKG00399']="Booking No not Exist"
  msgs['BKG00400']="B/L No not Exist"
  msgs['BKG00401']="Vessel Code is missing !"
  msgs['BKG00402']="THERE IS NO BKG CNTR NO IN BKG/DOC"
  msgs['BKG00403']="CNTR COUNT DIFFERENCE BETWEEN THE AMS CNTR AND BKG CNTR !"
  msgs['BKG00404']="{?msg1} is mandatory. Please enter {?msg2}."
  msgs['BKG00405']="Please select data to download."
  msgs['BKG00406']="Please input VVD + POL(POD), M. B/L No., or BKG No."
  msgs['BKG00407']="Please input Customer Name."
  msgs['BKG00408']="Please input Customer Code or Name."
  msgs['BKG00409']="Do you want to copy of the Name & Address ?"
  msgs['BKG00410']="Do you want to copy the B/L data ?"
  msgs['BKG00411']="Input 'Copy To' booking number"
  msgs['BKG00412']="Click item that you want to copy first"
  msgs['BKG00413']="quantity is missing"
  msgs['BKG00414']="door arrival date is missing"
  msgs['BKG00415']="actual shipper name is missing"
  msgs['BKG00416']="location code, zone code is missing"
  msgs['BKG00417']="Zip Code is mandatory in US location"
  msgs['BKG00418']="There is difference is Shipper Code between source Booking Number [{?msg1}] and Target  Booking Number [{?msg2}]"
  msgs['BKG00419']="Data Searched Successfully !"
  msgs['BKG00420']="TRO Qty is cannot bigger than BKG Qty"
  msgs['BKG00421']="Invalid From  ~ To Date"
  msgs['BKG00422']="Input VSL Lane or VVD."
  msgs['BKG00423']="Input Year Month or Week."
  msgs['BKG00424']="Please Input Port"
  msgs['BKG00425']="Please Input B/L No or BKG No"
  msgs['BKG00426']="Booking No is not available"
  msgs['BKG00427']="Booking No Split is no available"
  msgs['BKG00428']="TRO copy is not available for booking having TRO data"
  msgs['BKG00429']="Booking for (%VVD) has been closed. Inform related party of this change."
  msgs['BKG00430']="Are you sure to replace remarks?"
  msgs['BKG00431']="Do you want to print out Surrender Notice with the authorized signature?"
  msgs['BKG00432']="Route was changed. Please save first."
  msgs['BKG00433']="This booking already canceled"
  msgs['BKG00434']="D/O already issued"
  msgs['BKG00435']="The office({?msg1})'s country code({?msg2}) must be different from DEL's country code({?msg3})"
  msgs['BKG00436']="The date must be later than B/L issue date({?msg1})"
  msgs['BKG00437']="No of O/BL({?msg1}) must be equivalent to B/L issue No({?msg2})"
  msgs['BKG00438']="Same as Consignee is not allowed. B/L Type is O(Order)."
  msgs['BKG00439']="B/L Number is changed ({?msg1}->{?msg2}) You can not save this booking data"
  msgs['BKG00440']="Data exceeded maximum length ({?msg1})."
  msgs['BKG00441']="invalid location or Zone code"
  msgs['BKG00442']="Please check data."
  msgs['BKG00443']="Container No. is invalid."
  msgs['BKG00444']="Same as POL country"
  msgs['BKG00445']="Please input {?msg1}."
  msgs['BKG00446']="Container No. is invalid."
  msgs['BKG00447']="Do you want to transmit EDI?"
  msgs['BKG00448']="Please Click the Search button before putting the data in the text fields"
  msgs['BKG00449']="Container ({?msg1}) is not Attached to this booking!"
  msgs['BKG00450']="Faile to search data."
  msgs['BKG00451']="S/O was already created with other booking for this partial container"
  msgs['BKG00452']="Will you start BKG correction?"
  msgs['BKG00453']="S/O is not created for this partial container yet"
  msgs['BKG00454']="Number of collected B(s)/L is not same as number of issued B(s)/L"
  msgs['BKG00455']="It was already confirmed by Company Transportation."
  msgs['BKG00456']="DMF File Already transmitted."
  msgs['BKG00457']="O.B/L surrendered. If you want to continue cancel surrender first."
  msgs['BKG00458']="invalid customer code"
  msgs['BKG00459']="This B/L={?msg1}(bl_no) before MFR sending or Already DOR transmitted."
  msgs['BKG00460']="Duplication occurred.({?msg1})"
  msgs['BKG00461']="Location code is missing"
  msgs['BKG00462']="Data exceeded maximum duration. ({?msg1})"
  msgs['BKG00463']="BKG no does not exist for retrieval."
  msgs['BKG00464']="Country code is invalid ({?msg1},{?msg2})"
  msgs['BKG00465']="Country code exceeds field length."
  msgs['BKG00466']="Please input B/L Issue Information"
  msgs['BKG00467']="On board Date is not same as actual  vessel schedule (ETA/ETD). Do you want to continue?"
  msgs['BKG00468']="Cargo Receiving Date is not same as actual container gate-in (OC) date. Do you want to continue?"
  msgs['BKG00469']="B/L type is not “S (Straight)"
  msgs['BKG00470']="Not Ready to Release O.B/L!. Please Check B/L Issue Status (Date, Office), BKG No"
  msgs['BKG00471']="It was already deleted"
  msgs['BKG00472']="It is in pending"
  msgs['BKG00473']="It was already rejected"
  msgs['BKG00474']="Sea Waybill Issued. You can't update data."
  msgs['BKG00476']="Issue Date should be later than On-Board Date."
  msgs['BKG00477']="Already Active status"
  msgs['BKG00478']="B/L was not issued."
  msgs['BKG00479']="Please Input Data of VVD and Location!!!"
  msgs['BKG00480']="Issue Not Allowed"
  msgs['BKG00481']="O.B/L Release Not Allowed"
  msgs['BKG00482']="SWB Release Not Allowed"
  msgs['BKG00483']="Internet Auth Not Allowed"
  msgs['BKG00484']="O.B/L Surrender Not Allowed"
  msgs['BKG00485']="Do you want to transmit AI?"
  msgs['BKG00486']="Cancel Release Not Allowed"
  msgs['BKG00487']="Cancel Auth Not Allowed"
  msgs['BKG00488']="Duplication occurred.({?msg1})"
  msgs['BKG00489']="Can not Print !. Please clarify VVD and POL"
  msgs['BKG00490']="BKG Q'ty is smaller than AK Q'ty."
  msgs['BKG00491']="Gross weight should not be smaller than net weight."
  msgs['BKG00492']="MSN Type is Not Validation"
  msgs['BKG00493']="Booking Q'ty is not matched with Vol Detail"
  msgs['BKG00494']="Void space cannot be 0 with over height."
  msgs['BKG00495']="No Data Found for Printing"
  msgs['BKG00496']="FAX was sent successfully."
  msgs['BKG00497']="E-mail was sent successfully."
  msgs['BKG00498']="Do you want to save {?msg1}?"
  msgs['BKG00499']="Period are mandatory items."
  msgs['BKG00500']="Data change is not permitted under 'Pending' Status."
  msgs['BKG00501']="Data isn't changed"
  msgs['BKG00502']="No data in BKG Q'ty.\nPlease go back to booking main,\nopen \"Vol Detail\",  click \"OK\" and then save booking."
  msgs['BKG00503']="NULL_DATA,Container type/size"
  msgs['BKG00504']="NULL_DATA,Package Quantity"
  msgs['BKG00505']="NULL_DATA,Package code"
  msgs['BKG00506']="NULL_DATA,Gross Weight"
  msgs['BKG00507']="NULL_DATA,Gross Weight Type"
  msgs['BKG00508']="NULL_DATA,Net Weight"
  msgs['BKG00509']="NULL_DATA,Net Weight Type"
  msgs['BKG00510']="Please input Customs Description"
  msgs['BKG00511']="NULL_DATA,Total Over Length / Over Width"
  msgs['BKG00512']="Row Invalid Doc User ID Code"
  msgs['BKG00513']="Row  Invalid Doc User Group Code"
  msgs['BKG00514']="Row  Invalid Doc User Group Position Code"
  msgs['BKG00515']="Please rectify Post Status : E Or F"
  msgs['BKG00516']="Please rectify Post Status : E"
  msgs['BKG00517']="Please rectify Post Status."
  msgs['BKG00518']="Please rectify additional O/H after post extension."
  msgs['BKG00519']="Please check whether post locking pin engaged or not."
  msgs['BKG00520']="Please check Height & extra O/H considering Post status. Do you want to save?"
  msgs['BKG00521']="Do you want to Request ?"
  msgs['BKG00522']="Booking Number [{?msg1}] Already Requested.\nWould You Request Again ?"
  msgs['BKG00523']="Your Booking Number [{?msg1}] is Already Authorized.\nWould You Request Again ?"
  msgs['BKG00524']="Cargo Data does not exist"
  msgs['BKG00525']="This booking number already requested or pending status!! First! Click [REQ. Cancel] button"
  msgs['BKG00526']="This booking is EMPTY REPO BOOKING!This booking is EMPTY REPO BOOKING!! You can't search detail data!!"
  msgs['BKG00527']="Not Found Commodity Description"
  msgs['BKG00528']="Missing Date…"
  msgs['BKG00529']="Please Check DG Container Serial Number !! Unmatch DG-CNTR S/N. \n Please Input Correct DG-CNTR S/N !!"
  msgs['BKG00530']="Package Type is not available."
  msgs['BKG00531']="Unable to Request after BDR time."
  msgs['BKG00532']="This sequence will be requested again before save due to mandatory item change. Will you proceed?"
  msgs['BKG00533']="There is no selected booking."
  msgs['BKG00534']="Select the Doc.Type."
  msgs['BKG00535']="Are you sure to delete?"
  msgs['BKG00536']="BKG Q'ty may not exceeds Special Q'ty."
  msgs['BKG00537']="Length of CRN No is INCORRECT!"
  msgs['BKG00538']="Length of VVD No is INCORRECT!"
  msgs['BKG00539']="’OR’ cannot be used in Proper Shipping Name."
  msgs['BKG00540']="Mandatory field is missing. Flash point is Mandatory for Class 3 {?msg1} Please put it in."
  msgs['BKG00541']="Flashpoint is expected to be in the range of 23`C (include 23`C) to 60`C(include 60`C) for packing group 3. {?msg1}"
  msgs['BKG00542']="Flashpoint is expected to be below 23`C for packing group 1 or 2. {?msg1}"
  msgs['BKG00543']="This UN No. is not allowed to be carried in limited quantity. {?msg1}"
  msgs['BKG00544']="This UN No. is not permitted as Excepted Quantity. {?msg1}"
  msgs['BKG00545']="Mandatory field is missing. Please enter ({?msg1})."
  msgs['BKG00546']="Please select row to delete."
  msgs['BKG00547']="VVD already exist"
  msgs['BKG00548']="Freight Status I/F from ERP system isn't clear [N].\nPlease check the outstanding amounts and/or Credits by contacting A/R staffs.\n\nIf System error or cash/check payments causes the discrepancy.\nYou can release containers on condition that you input texts in [Remark for Release] field and save."
  msgs['BKG00549']="Input VVD!!!"
  msgs['BKG00550']="Input DEM FREE!!!"
  msgs['BKG00551']="Input NL TEXT!!!"
  msgs['BKG00552']="Please, input only number in Flash Point."
  msgs['BKG00553']="Please Input POL or POD"
  msgs['BKG00554']="Mandatory field is missing. Please enter ({?msg1})."
  msgs['BKG00555']="Data exceeds maximum duration ({?msg1})."
  msgs['BKG00556']="The Flash Point of CLASS 3.1 has to be lower then -18"
  msgs['BKG00557']="The Flash Point of CLASS 3.2 has to be between -18 ~ 23"
  msgs['BKG00558']="The Flash Point of CLASS 3.3 has to be Higher then 23"
  msgs['BKG00559']="IMO Class -> 1 ; Please input the detail for IMDG class 1 of seq {?msg1}"
  msgs['BKG00560']="IMO Class -> 7 ; Please input the detail for IMDG class 7 of seq {?msg1}"
  msgs['BKG00561']="Special Cargo Qty by Type Size is not matching with Container Qty."
  msgs['BKG00562']="Booking({?msg1}) is being corrected now by {?msg2} at {?msg3} from {?msg4}!"
  msgs['BKG00563']="This is HCDG cargo required for strict security procedure for inland haulage in EU.\nPlease don't accept Carrier's haulage Booking and Induce CY port term.\nDo you want to continue?"
  msgs['BKG00564']="Input ETA or VVD or VCR"
  msgs['BKG00565']="Please Input VVD or CNTR No!"
  msgs['BKG00566']="Please Check Data of VVD Length"
  msgs['BKG00567']="Please Select a Row"
  msgs['BKG00568']="Please POL Select a Row"
  msgs['BKG00569']="CRN Number is not created"
  msgs['BKG00570']="Container Type/Size is unmatched!\nWould you replace it ?"
  msgs['BKG00571']="Please clear error data and try again."
  msgs['BKG00572']="It is already canceled"
  msgs['BKG00573']="Do you want to Create it?"
  msgs['BKG00574']="B/L Created Successfully"
  msgs['BKG00575']="Do you want to Cancel it?"
  msgs['BKG00576']="No Data Found for Printing"
  msgs['BKG00577']="Fax No is not available."
  msgs['BKG00578']="Please input cargo sequence."
  msgs['BKG00579']="Please fill out mandatory item for sequence {?msg1}"
  msgs['BKG00580']="Please input emergency contact point. {?msg1}"
  msgs['BKG00581']="Please input PKG Q'ty / type. {?msg1}"
  msgs['BKG00582']="Please input outer package type code. {?msg1}"
  msgs['BKG00583']="Please input Max Inner Package Quantity{?msg1}"
  msgs['BKG00584']="Please input Max Inner Package Type Code{?msg1}"
  msgs['BKG00585']="Please input gross weight. {?msg1}"
  msgs['BKG00586']="Please input net weight. {?msg1}"
  msgs['BKG00587']="Please input cargo status. {?msg1}"
  msgs['BKG00588']="Enter -PACKING GROUP- Data !!!"
  msgs['BKG00589']="Please input limited Q'ty"
  msgs['BKG00590']="Canceled Successfully"
  msgs['BKG00591']="Please Input Option - [CRN and VVD]"
  msgs['BKG00592']="Are you sure you want to delete it?"
  msgs['BKG00593']="Data Deleted Successfully"
  msgs['BKG00594']="Warnning !!!, UNNO [{?msg1}] is prohibited by Company Gudeline."
  msgs['BKG00595']="[Inner Package Code 1st] is NOT valid!!"
  msgs['BKG00596']="[Inner Package Code 2st] is NOT valid!!"
  msgs['BKG00597']="[Outer Package Code 1st] is NOT valid!!"
  msgs['BKG00598']="[Outer Package Code 2st] is NOT valid!!"
  msgs['BKG00599']="For the purpose of documentation and package marking,\nthe Proper Shipping Name shall be supplementatione with the\ntechnical name as per Special Provision 274 of Chapter of IMDG code.\n You should input 'HAZ Conttents' before 'save'/'request' for your DG cargo!!!"
  msgs['BKG00600']="FLASH POINT IS MISSING! PLS DECLARE F/POINT."
  msgs['BKG00601']="If IMO Class or Sub Risk Label[SRL] is not '3', Flash point cannot be inputted."
  msgs['BKG00602']="Classisfication as LTD QTY is not allowed for {?msg1} Unno."
  msgs['BKG00603']="Input VVD & POD !"
  msgs['BKG00604']="Input Issue OFC !"
  msgs['BKG00605']="The period cannot exceed 30 days."
  msgs['BKG00606']="Please select data to print."
  msgs['BKG00607']="Please Input Option - [CRN]"
  msgs['BKG00608']="Please, Check CRN No !"
  msgs['BKG00609']="Please, Check BL No !"
  msgs['BKG00610']="invalid D/O No!"
  msgs['BKG00611']="Temperature is missing"
  msgs['BKG00612']="Nature is missing"
  msgs['BKG00613']="Do you want to request cancel this sequence[{?msg1}] ?"
  msgs['BKG00614']="Do you want confirm it?"
  msgs['BKG00615']="Your temperature setting( {?msg1} C / {?msg2} F) is not suitable for the Chilled Cargo.  Please check the temperature of seq {?msg3}"
  msgs['BKG00616']="Your temperature setting( {?msg1} C / {?msg2} F) is not suitable for the Frozen Cargo.  Please check the temperature of seq {?msg3}"
  msgs['BKG00617']="Your temperature setting( {?msg1} C / {?msg2} F) is not suitable for the Fresh Cargo.  Please check the temperature of seq {?msg3}"
  msgs['BKG00618']="Would you really want to confirm?"
  msgs['BKG00619']="FAK(00) is not allowed for Reefer. Please specify commodity code."
  msgs['BKG00620']="This B/L not Confirm"
  msgs['BKG00621']="This B/L is not Original"
  msgs['BKG00622']="This B/L is not Replace"
  msgs['BKG00623']="This B/L is not Cancel"
  msgs['BKG00624']="Please select row first."
  msgs['BKG00625']="Mandatory Data Input Error !!"
  msgs['BKG00626']="Mandatory field is missing. Please enter {?msg1}."
  msgs['BKG00627']="Search Failed : {?msg1}"
  msgs['BKG00628']="Save Failed : {?msg1}"
  msgs['BKG00629']="Transmit Failed : {?msg1}"
  msgs['BKG00630']="Switch B/L is not applicable into this Screen. Please move to [B/L Issue] Screen then use [O/BL Surrender] button.\nIf the said B/L is 'to order', cut C/A to straight B/L first and use [O/BL Surrender] or turn it to 'Seaway Bill"
  msgs['BKG00631']="Not Ready to Redempt OB/L! PLZ Check Issue B/L Status(Office).!"
  msgs['BKG00632']="Not Ready to Redempt OB/L! PLZ Check Issue B/L Status(Date).!"
  msgs['BKG00633']="Not Ready to Redempt OB/L! B/L Office was not assigned.!"
  msgs['BKG00634']="Not Ready to Redempt OB/L! PLZ Check Issue B/L Status."
  msgs['BKG00635']="OB/L was not redempted. Pls withdraw OB/L(Office).!"
  msgs['BKG00636']="OB/L was not redempted. Pls withdraw OB/L(Date).!"
  msgs['BKG00637']="OB/L was not redempted. Pls withdraw OB/L(No).!"
  msgs['BKG00638']="OB/L was not redempted. Pls withdraw OB/L(Other Office).!"
  msgs['BKG00639']="OB/L was not redempted. Pls withdraw OB/L(Other Date).!"
  msgs['BKG00640']="OB/L was not redempted. Pls withdraw OB/L(Other Type).!"
  msgs['BKG00641']="Please input either OB/L or Other Doc!"
  msgs['BKG00642']="Sum of QTY({?msg1}) exceeded total."
  msgs['BKG00643']="Sum of estimated weight exceeded total."
  msgs['BKG00644']="Sum of package quantity exceeded total."
  msgs['BKG00645']="Sum of measure exceeded total."
  msgs['BKG00646']="Booking is already splitted."
  msgs['BKG00647']="PLS, input count of BKG as a result of split"
  msgs['BKG00648']="PLS, count of BKG as a result of split is invalid"
  msgs['BKG00649']="B/L was Held"
  msgs['BKG00650']="Warning(Prepaid Not Received)! \n Do you want to Assign D/O no."
  msgs['BKG00651']="{?msg1} is invalid."
  msgs['BKG00652']="B/L No's prefix is invalid"
  msgs['BKG00653']="D/O Assign is Successfully!!"
  msgs['BKG00654']="VVD input max 50"
  msgs['BKG00655']="Do You must insert Port"
  msgs['BKG00656']="The B/L Is Less than Container Load"
  msgs['BKG00657']="No matched code"
  msgs['BKG00658']="Please, run P/C next to BKG No {?msg1}"
  msgs['BKG00659']="CNTR {?msg1} is not assigned to any BKG."
  msgs['BKG00660']="You put cargo on Carrier hold successfully"
  msgs['BKG00661']="You removed carrier hold successfully"
  msgs['BKG00662']="Sum of splitted BKG's QTY({?msg1}) is different from Original QTY({?msg2})."
  msgs['BKG00663']="Sum of splitted BKG's Est.Weight is diffSum of splitted BKG's Est.Weight is different from Original Est. Weight."
  msgs['BKG00664']="Sum of splitted BKG's PKG is different from Original PKG QTY."
  msgs['BKG00665']="Sum of splitted BKG's MEA is different from Original MEA QTY."
  msgs['BKG00666']="In memo B/L case, you should check Advance or Shortship mark at one more splitted bookings!"
  msgs['BKG00667']="All of B/L has not been received yet for LCL"
  msgs['BKG00668']="Please input Hold Remark"
  msgs['BKG00669']="D/O Release is Successfully!!"
  msgs['BKG00670']="Are you sure to Cancel?"
  msgs['BKG00671']="Are you sure to Hold?"
  msgs['BKG00672']="Are you sure to Assign?"
  msgs['BKG00673']="Are you sure to Release?"
  msgs['BKG00674']="Cancel is Successfully!!"
  msgs['BKG00675']="This BL's DELIVERY is {?msg1}! Would You Want to Send?"
  msgs['BKG00676']="Please Select a Message Code"
  msgs['BKG00677']="AK Q’ty should not be larger than BKG Q’ty!"
  msgs['BKG00678']="Q’ty of container list and {?msg1} Q’ty is not the same. Will you proceed?"
  msgs['BKG00679']="{?msg1} Q’ty is smaller than updated containers. Adjust {?msg2} Q’ty or container list first before save!"
  msgs['BKG00680']="Hour ranges 01 to 24"
  msgs['BKG00681']="Minute ranges 01 to 60"
  msgs['BKG00682']="BB Q’ty should not be bigger than BKG Q’ty"
  msgs['BKG00683']="BB Q’ty is smaller than updated containers. Adjust BB Q’ty or container list first before save!"
  msgs['BKG00684']="Plz, Check V.V.D !!"
  msgs['BKG00685']="Plz, Check POD !!"
  msgs['BKG00686']="Plz, Check B/L No"
  msgs['BKG00687']="DG Q’ty should not be larger than BKG Q’ty!"
  msgs['BKG00688']="Plz, Check BND"
  msgs['BKG00689']="Plz, Check MRN NBR"
  msgs['BKG00690']="Unable to [EDI Transmit] Without NCM Code, Please input [B/L No : {?msg1}] NCM Code!, B/L No"
  msgs['BKG00691']="Contact person is mandatory item. {?msg1}]"
  msgs['BKG00692']="S/T Cancel is Successfully!!"
  msgs['BKG00693']="EDI Send is Successfully!!"
  msgs['BKG00694']="D/G request is not permitted to EBX and SNA lane."
  msgs['BKG00695']="DG Q’ty is smaller than updated containers. Adjust DG Q’ty or container list first before save!"
  msgs['BKG00696']="Q’ty of container list and DG Q’ty is not the same. Will you proceed?"
  msgs['BKG00697']="RF Q’ty should not be larger than BKG Q’ty!"
  msgs['BKG00698']="RF Q’ty is smaller than updated containers. Adjust RF Q’ty or container list first before save!"
  msgs['BKG00699']="Q’ty of container list and RF Q’ty is not the same. Will you proceed?"
  msgs['BKG00700']="Container No's prefix is invalid"
  msgs['BKG00701']="Mandatory field is missing. Please enter ({?msg1})."
  msgs['BKG00702']="Mandatory field is missing. Please enter Duration."
  msgs['BKG00703']="Mandatory field is missing. Please enter Correction No."
  msgs['BKG00704']="Mandatory field is missing. Please enter Relay Port and Duration."
  msgs['BKG00705']="Please select Next VVD."
  msgs['BKG00706']="Confirm Failed : {?msg1}"
  msgs['BKG00707']="Interface Failed : {?msg1}"
  msgs['BKG00708']="One of Both, VVD or Send Date, is Mandatory!"
  msgs['BKG00709']="Length of B/L Number should be over 12!"
  msgs['BKG00710']="Length of VVD is INCORRECT!"
  msgs['BKG00711']="Length of POL is INCORRECT!"
  msgs['BKG00712']="Length of POD is INCORRECT!"
  msgs['BKG00713']="Length of Office should be over 5!"
  msgs['BKG00714']="Please Check Date"
  msgs['BKG00715']="Mandatory field is missing. Please enter ({?msg1})."
  msgs['BKG00716']="D/O Assign&Issue is Successfully!!"
  msgs['BKG00717']="Mandatory field is missing. Please enter ({?msg1})."
  msgs['BKG00718']="Collect Term is not allowed to Reefer cargo. Do you still want to continue?"
  msgs['BKG00719']="Check route SKD : \"VVD({?msg1}) -> PORT({?msg2}) -> VVD({?msg3})\" can not be established."
  msgs['BKG00720']="VVD({?msg1}) is not calling from ({?msg2}) to ({?msg3})."
  msgs['BKG00721']="The bookings of different route cannot be selected."
  msgs['BKG00722']="Are You Sure To Transmit With DO ID [{?msg1}]?"
  msgs['BKG00723']="Are You Sure To DOR CANCEL With DO ID [{?msg1}]?"
  msgs['BKG00724']="Unable DOR Cancel!"
  msgs['BKG00725']="This D/O has not been SENT!!!"
  msgs['BKG00726']="Technical name(HAZ. Contents) should be inputted for this UN No."
  msgs['BKG00727']="UN No. OOOO is OOO(Carrier Code)’s restricted cargo. Load can be rejected by vessel operator"
  msgs['BKG00728']="MFR Not yet !"
  msgs['BKG00729']="DOR DATA Successfully Saved!"
  msgs['BKG00730']="DOR Transmit Successfully!"
  msgs['BKG00731']="The bookings of different next port cannot be selected."
  msgs['BKG00732']="POL should not be \"US\"."
  msgs['BKG00733']="You can't select multiple rows."
  msgs['BKG00734']="Do you want to send Fax Empty Container Release Order ?"
  msgs['BKG00735']="Do you want to send Email Empty Container Release Order ?"
  msgs['BKG00736']="B/L Sequence Update was Failed!"
  msgs['BKG00737']="Nothing Changed!!!"
  msgs['BKG00738']="please Input Date or VVD or Booking NO."
  msgs['BKG00739']="please Input BKG OFC or EQ CTL OFC or POR or POL or P/U CY or FULL RTN CY."
  msgs['BKG00740']="Re-handling port is not available."
  msgs['BKG00741']="Approval RSO is not available."
  msgs['BKG00742']="COD reason is not available."
  msgs['BKG00743']="There is no updated data to save."
  msgs['BKG00744']="Can not caclulation Re-handling Charge."
  msgs['BKG00745']="Multi-POD or Multi-Arrival Vessel!"
  msgs['BKG00746']="You can't update/delete data. COD Status is R (Request)."
  msgs['BKG00747']="You can't cancel COD."
  msgs['BKG00748']="You can't confirm COD."
  msgs['BKG00749']="You can't request COD."
  msgs['BKG00750']="Already requested COD"
  msgs['BKG00751']="You can't delete COD."
  msgs['BKG00752']="Do you want to update CNTR quantities?"
  msgs['BKG00753']="Mandatory field is missing. Please enter container no."
  msgs['BKG00754']="Mandatory field is missing. Please enter VVD."
  msgs['BKG00755']="Mandatory field is missing. Please enter ETB duration."
  msgs['BKG00756']="{?msg1} exceeds maximum duration {?msg2}."
  msgs['BKG00757']="Mandatory field is missing. Please enter Relay Port."
  msgs['BKG00758']="Mandatory field is missing. Please enter ETD or Duration."
  msgs['BKG00759']="It's not downloaded yet. Please do download first!"
  msgs['BKG00760']="It's only possible to tranmit cacellation request once inital transmission has performed."
  msgs['BKG00761']="Technical name(HAZ. Contents) should be inputted for this UN No."
  msgs['BKG00762']="[{?msg1}(Carrier's code)] shall refrain from Cargo with UN No. {?msg2}. The vessel might reject to load the cargo."
  msgs['BKG00763']="Need Terminal VSL Code!"
  msgs['BKG00764']="{?msg1} is duplicated."
  msgs['BKG00765']="Please input weight."
  msgs['BKG00766']="Please input weight unit."
  msgs['BKG00767']="{?msg1} is missing."
  msgs['BKG00768']="User ID is missing !"
  msgs['BKG00769']="VVD is missed"
  msgs['BKG00770']="Port is missed"
  msgs['BKG00771']="Plz, Input POL or POD !"
  msgs['BKG00772']="Plz, Input V.V.D !"
  msgs['BKG00773']="Plz, Choose Port !"
  msgs['BKG00774']="Already Transmitted !\nDo you want to Re-Transmit ?"
  msgs['BKG00775']="You Must Check CNTR"
  msgs['BKG00776']="Data was transmitted successfully."
  msgs['BKG00777']="D/O is already assigned."
  msgs['BKG00778']="D/O is already released. if you want to release once again, please press the [Cancel] button first"
  msgs['BKG00779']="Previous Transaction is not completed yet. Please try again after a while."
  msgs['BKG00780']="T.VVD length should be ({?msg1})."
  msgs['BKG00781']="Agent Code is invalid."
  msgs['BKG00782']="{?msg1} exceeds maximum duration {?msg2}."
  msgs['BKG00783']="Mandatory field is missing. Please enter BKG Period+Code Input OFC."
  msgs['BKG00784']="Mandatory field is missing. Please enter POD ETA or VVD + POD or B/L No."
  msgs['BKG00785']="{?msg1} exceeds maximum duration {?msg2}."
  msgs['BKG00786']="Mandatory field is missing. Please enter B/L No or Container No or BKG No."
  msgs['BKG00787']="Do you want to update Container Package & Weight according to C/M?"
  msgs['BKG00788']="Please enter NCM code"
  msgs['BKG00789']="Please, check the AMS REF No({?msg2}) in the NVOCC H/B Information Screen."
  msgs['BKG00790']="This HT({?msg2}) is not registered in Harmonized Tariff Code Table."
  msgs['BKG00791']="Unable to SAVE due to HTS Code missing or improper length!"
  msgs['BKG00792']="Please InPut VVD and POD"
  msgs['BKG00793']="{?msg1} exceeds maximum duration {?msg2}."
  msgs['BKG00794']="Mandatory field is missing. Please enter Release Office."
  msgs['BKG00795']="Data was changed. Do you want to close the window without save ?"
  msgs['BKG00796']="CRN ({?msg1}) of VVD ({?msg2}) is not avaiable : Vessel Operator=[{?msg3}]"
  msgs['BKG00797']="Nothing has been changed after data is searched"
  msgs['BKG00798']="Mandatory field is missing. Please enter BKG Data or VVD."
  msgs['BKG00799']="PURCHASE ORDER NUMBER is not available."
  msgs['BKG00800']="Not Found Data!"
  msgs['BKG00801']="Mandatory field is missing. Please enter {?msg1} or VVD+POL."
  msgs['BKG00802']="Please Select a Terminal"
  msgs['BKG00803']="A/Customer Not Found"
  msgs['BKG00804']="Mandatory field is missing. Please enter Shipper's Name or Consignee's Name."
  msgs['BKG00805']="Not OPUS’s vessel. You can’t automatically create CRN."
  msgs['BKG00806']="Office code does not exist."
  msgs['BKG00807']="E-mail address is not same. You can't send by group."
  msgs['BKG00808']="Please, Input Yard Code!"
  msgs['BKG00809']="BKG No({?msg1}) is not available"
  msgs['BKG00810']="Do you want to interface PSA Booking ?"
  msgs['BKG00811']="Master B/L's POR({?msg1}) is not match for Covered B/L's ({?msg2})"
  msgs['BKG00812']="Master B/L's DEL({?msg1}) is not match for Covered B/L's ({?msg2})"
  msgs['BKG00813']="Master B/L's shipper({?msg1}) is not match for Covered B/L's ({?msg2})"
  msgs['BKG00814']="Master B/L's first VVD({?msg1}) is not match for Covered B/L's ({?msg2})"
  msgs['BKG00815']="Covered B/L No({?msg1}) Canceled"
  msgs['BKG00816']="Covered B/L No({?msg1}) Freight Code [OFT] exists"
  msgs['BKG00817']="Madatory retrieval condition(Latest Update Date) is missing."
  msgs['BKG00818']="From Date couldn't be greater than ToDate."
  msgs['BKG00819']="Mandatory field is missing. Please enter BKG Date."
  msgs['BKG00820']="Mandatory field is missing. Please enter BKG Office."
  msgs['BKG00821']="A2,F2     : Maximum is 7 container!\nA4,F4,F5 : Maximum is 4 container!"
  msgs['BKG00822']="Bundle should be same type/size of F2+A2 or F4+F5+A4 and select which container is on the bottom."
  msgs['BKG00823']="Mandatory field is missing. Please enter BKG Office or POL+POD."
  msgs['BKG00824']="Do you want to save?"
  msgs['BKG00825']="Do you want to take manual BDR for selected Bookings ?"
  msgs['BKG00826']="Do you want to take manual BDR for selected vessel ?"
  msgs['BKG00827']="Duplicate Doc ID,Grop! Please try again."
  msgs['BKG00828']="Duplicate Pod Cd! Please try again."
  msgs['BKG00829']="Please Input VVD or POL !"
  msgs['BKG00830']="The Control Office code({?msg1})  is not registered"
  msgs['BKG00831']="The Customer code({?msg1},{?msg2}) is not registered"
  msgs['BKG00832']="The Vendor code({?msg1},{?msg2})  is not registered"
  msgs['BKG00833']="VVD is not available"
  msgs['BKG00834']="POD is not available"
  msgs['BKG00835']="BKG No is not available"
  msgs['BKG00836']="S.Date is not available"
  msgs['BKG00837']="Please, Select the row"
  msgs['BKG00838']="Booking Split !"
  msgs['BKG00839']="Split BKG + VL option is not allowed. Please select VD option or input non split BKG No."
  msgs['BKG00840']="The import status has been saved. You cannot delete vessel information"
  msgs['BKG00841']="INVALID VESSEL PORT SCHEDULE"
  msgs['BKG00842']="Input Opus Port!!"
  msgs['BKG00843']="Saved successfully!   Current movement status will not be changed.    Please adjust movement status."
  msgs['BKG00844']="There is unsaved data remaining which will be disappreared if you leave the current tab. Will you save it?"
  msgs['BKG00845']="Please input VVD or Register Date."
  msgs['BKG00846']="The period cannot exceed 30 days."
  msgs['BKG00847']="Please put one item of four, T.VVD, Resigster Date, Booking No, B/L No."
  msgs['BKG00849']="The total volume exceed booking total. Will you proceed?"
  msgs['BKG00850']="The total volume exceed weight total. Will you proceed?"
  msgs['BKG00851']="The total volume exceed booking total. Will you proceed?"
  msgs['BKG00852']="The total {?msg1} exceed(s) booking total. Will you proceed?"
  msgs['BKG00853']="M term exists in R/D term. Select correct R/D term before confirmation!"
  msgs['BKG00854']="Volume per each TP/SZ is different from booking creation screen’s volume!"
  msgs['BKG00855']="R/D term is different from booking R/D term!"
  msgs['BKG00856']="Please input Trans Mode"
  msgs['BKG00857']="Please input email"
  msgs['BKG00858']="Please input load Ref"
  msgs['BKG00859']="Please input Contact Name"
  msgs['BKG00860']="Please input Telephone number"
  msgs['BKG00861']="M term is not acceptable as R/D term. Please select adequate per each container"
  msgs['BKG00862']="R/D term is different from booking R/D term!"
  msgs['BKG00863']="CNTR NO {?msg1} can't be processed due to Partial indicator. Please go to Master BKG NO {?msg2} to proceed TRO/"
  msgs['BKG00864']="All Container Released"
  msgs['BKG00865']="All Container Confirmed"
  msgs['BKG00866']="POD of preceding VVD and POL of the next connected VVD should be the same"
  msgs['BKG00867']="ETD should be later than ETA of the preceding VVD"
  msgs['BKG00868']="Please input Port Code"
  msgs['BKG00869']="Please input ETB"
  msgs['BKG00870']="Invalid from date"
  msgs['BKG00871']="Invalid to date"
  msgs['BKG00872']="Please check the date range"
  msgs['BKG00873']="Please check the date range!. Maximum date range is 40 days"
  msgs['BKG00874']="Export can not be chosen with the others."
  msgs['BKG00875']="Login office should be same with booking office."
  msgs['BKG00876']="Please input VVD and POD"
  msgs['BKG00877']="Remark is mandatory item."
  msgs['BKG00878']="Amend Customer Master Data Details"
  msgs['BKG00879']="This booking already canceled or Advanced"
  msgs['BKG00880']="Mandatory retrieval condition is missing (Handling Office)"
  msgs['BKG00881']="Please Enter a Min 5/Max 6-digit code in the Handling Office field"
  msgs['BKG00882']="Please search data first."
  msgs['BKG00883']="Please Check The Currency Code of Charge In CAF"
  msgs['BKG00884']="Booking number split is not available"
  msgs['BKG00885']="BL number is not available"
  msgs['BKG00886']="Mandatory Download Condition(s) is(are) missing : {?msg1}"
  msgs['BKG00887']="Mandatory field is missing. Please enter {?msg1}."
  msgs['BKG00888']="Mandatory Input item(s) is(are) missing: {?msg1}"
  msgs['BKG00889']="No data found."
  msgs['BKG00890']="You cannot save any charge for the Memo B/L. Please, go to original master booking for rating. Do you still want to save?"
  msgs['BKG00891']="This({?msg1}) is invalid contract no. Please check it again"
  msgs['BKG00892']="Bill type is not available"
  msgs['BKG00893']="PPD office code is not available"
  msgs['BKG00894']="PPD Payer code is not available"
  msgs['BKG00895']="CCT office code is not available"
  msgs['BKG00896']="CCT Payer code is not available"
  msgs['BKG00897']="Carge code is not available"
  msgs['BKG00898']="Currency code is not available"
  msgs['BKG00899']="Rate is not available"
  msgs['BKG00900']="Rated As is not available"
  msgs['BKG00901']="Per type is not available"
  msgs['BKG00902']="Amount is not available"
  msgs['BKG00903']="N/I/E indicator is not available"
  msgs['BKG00904']="Pay indicator is not available"
  msgs['BKG00905']="Office is not available."
  msgs['BKG00906']="Third Payer code is not available"
  msgs['BKG00907']="Cargo class is not available"
  msgs['BKG00908']="RCV Term is not available"
  msgs['BKG00909']="DEL Term is not available"
  msgs['BKG00910']="IMO class is not available"
  msgs['BKG00911']="Auto/Manual indicator is not available"
  msgs['BKG00912']="Third office must be different from PPD office or CCT office."
  msgs['BKG00913']="OFT(or ASC) Currency must be 'USD' or 'AUD' or 'EUR' or 'JPY' or 'GBP' or 'DEM'"
  msgs['BKG00914']="OFT(or ASC) Currency must be equivalent"
  msgs['BKG00915']="B/L No.is not available."
  msgs['BKG00916']="You indicates to include charge but System can not find available 'OFT(or ASC)' to include charge"
  msgs['BKG00917']="Data not modified, No need to save"
  msgs['BKG00918']="\"BEF\", \"DEM\", \"ESP\", \"FIM\", \"FRF\", \"IEP\", \"ITL\", \"NLG\", \"PTE\" Currency code must be \"EUR\""
  msgs['BKG00919']="When S/C specifies US inland transportation mode as 'All motor' 1) Click on T/S Route in booking main screen 2) Select 'All motor' in drop-off button of Mode next to DEL"
  msgs['BKG00920']="Please enter a valid date format: DDMonYY (ex:01Jan09)"
  msgs['BKG00921']="Please enter a valid date format: YYYYMMDD"
  msgs['BKG00922']="Please, input Office Code!"
  msgs['BKG00923']="Unable to Rating!. Pls input Applicable date."
  msgs['BKG00924']="Unable to SAVE due to P.O No missing (or improper PO NO length)(%d).\n Please check PO NO again."
  msgs['BKG00925']="PPD Office code({?msg1}) is not registered in DB(office)"
  msgs['BKG00926']="Customer code({?msg1}%06d) is not registered in DB(customer)"
  msgs['BKG00927']="Customer code is No Use code. Please check again({?msg1}%ld)."
  msgs['BKG00928']="CCT Office code({?msg1}) is not registered in DB(office-ofc_cd)"
  msgs['BKG00929']="CCT Customer code({?msg1}%06d) is not registered in DB(customer)"
  msgs['BKG00930']="CCT Customer code is No Use code. Please check again({?msg1}%ld)."
  msgs['BKG00931']="THIRD's office code must be different from PPD's and CCT's office code"
  msgs['BKG00932']="THIRD's office code must be different from PPD's and CCT's office code"
  msgs['BKG00933']="Head Office ({?msg1}) can not be a collection office"
  msgs['BKG00934']="Are you sure to merge  {?msg1} charge ?"
  msgs['BKG00935']="Currency code is different"
  msgs['BKG00936']="Payer is different"
  msgs['BKG00937']="Only 'Normal' charge can be merged"
  msgs['BKG00938']="No need to merge"
  msgs['BKG00939']="Please Choose Service Scope Code first in case of IMU Lane"
  msgs['BKG00940']="S/C No is incorrect or is not in S/C DB. Do you want to proceed manually?"
  msgs['BKG00941']="Are you sure to make rating data automatically with ( AutoRating ) ?"
  msgs['BKG00942']="S/C No({?msg1}) is not available.\nPlease, check Route, R/D Term, CRD date & etc.\nDo you want to search for tariff surcharges?"
  msgs['BKG00943']="Do you want to rate automatically through RFA?"
  msgs['BKG00944']="VVD is not Activated"
  msgs['BKG00945']="POD is not calling port of vessel({?msg1})"
  msgs['BKG00946']="Check your BOOKING NO.!! This is not an EMPTY REPO BKG NO!!!"
  msgs['BKG00947']="Please reduce container list under 800boxes to avoid system error."
  msgs['BKG00948']="This Container No.({?msg1}) is Shipper CNTR!"
  msgs['BKG00949']="This container({?msg1}) has already been assigned to ({?msg2})!,  Check your container number!!"
  msgs['BKG00950']="This container({?msg1})'s server id({?msg2}) id is NOT valid. Check your container number!!"
  msgs['BKG00951']="Container[{?msg1}] movement status code[{?msg2}] is not valid"
  msgs['BKG00952']="his Container({?msg1}) is inactive container. Check your conainer number!!"
  msgs['BKG00953']="Please check up the Current Movement Status![{?msg1}]"
  msgs['BKG00954']="This Container[{?msg1}] is NOT vaild !!\n This Container is NOT attached to master booking"
  msgs['BKG00955']="Container[{?msg1}] already assigned Another booking split[{?msg2}][{?msg2}]!!"
  msgs['BKG00956']="Container[{?msg1}]already assigned THIS booking[{?msg2}][{?msg3}]!!"
  msgs['BKG00957']="This Container[{?msg1}]'s status is {?msg2}. \n You can assign CNTR olny VL status"
  msgs['BKG00958']="Please select container for rider"
  msgs['BKG00959']="Already MI Sent!"
  msgs['BKG00960']="Discrepancy of FILER between Master and House B/L"
  msgs['BKG00961']="Please Enter the Data. {?msg1}"
  msgs['BKG00962']="Do you want to save the modified information?"
  msgs['BKG00963']="If POL is in CN, save will be blocked if IMO Class is 5.1 or 5.2."
  msgs['BKG00964']="Total void space of each sequence and AK Q’ty is different."
  msgs['BKG00965']="Container No. [{?msg1}] is duplicated. Check container number."
  msgs['BKG00966']="{?msg1} also exists in other BKG {?msg2}. Please check container number again."
  msgs['BKG00967']="Container data is different from EQ detail data. Please adjust container or EQ detail data."
  msgs['BKG00968']="special Q’ty and assigned CNTR Q’ty in special cargo application is different."
  msgs['BKG00969']="Service scope is duplicated. Please select adequate service scope before rating."
  msgs['BKG00970']="[{?msg1}] is not registered code. Please  check the charge code again."
  msgs['BKG00971']="WHF exemption reason exists. WHF will not be inputted with exemption reason."
  msgs['BKG00972']="GST cannot be changed manually."
  msgs['BKG00973']="CCT term for RF cargo is prohibited in principle. Will you change payment term ?"
  msgs['BKG00974']="Mandatory Trasmit Condition is(are) missing: {?msg1}"
  msgs['BKG00975']="Data Transmitting -> OK Processed!!"
  msgs['BKG00976']="You can’t transmit A6. Please check ACI Vessel Information [{?msg1}]"
  msgs['BKG00977']="Vessel Certificate has been already expired. [{?msg1}]. Please check ACI Vessel Information."
  msgs['BKG00978']="Booking Select Error !!"
  msgs['BKG00979']="Please input ETD"
  msgs['BKG00980']="Plz, Check Date"
  msgs['BKG00981']="Plz, Check Date : The term can't be more than 7 days"
  msgs['BKG00982']="Plz, Check VVD/POL/POD"
  msgs['BKG00983']="Plz, Check MRN"
  msgs['BKG00984']="Plz, Check Key Data"
  msgs['BKG00986']="Data was changed. Do you want to save it ?"
  msgs['BKG00988']="[{?msg1}] was searched successfully."
  msgs['BKG00989']="There is no updated data to save."
  msgs['BKG00990']="Do you want to save [{?msg1}]?"
  msgs['BKG00992']="Please input [{?msg1}]."
  msgs['BKG00993']="[{?msg1}] is not available."
  msgs['BKG00994']="Can not be changed Once Container Confirmed."
  msgs['BKG00995']="Length of Visit No should be 6 !"
  msgs['BKG00996']="Please try again after select By BKG"
  msgs['BKG00997']="POL nodes are different !"
  msgs['BKG00998']="VVD codes are different !"
  msgs['BKG00999']="This is under MT Movement.\n You can split REPO BKG under VL movement. \n This Container No.({?msg1})"
  msgs['BKG01000']="You can't split this BKG No({?msg1}) in this screen because it was created in EQR System(e-OPUS).\n Please split this BKG No in e-OPUS."
  msgs['BKG01001']="Please select one actual customer only"
  msgs['BKG01002']="Please select one B/L No"
  msgs['BKG01003']="Dummy B/L No for USA exceed the maximum(9999)"
  msgs['BKG01004']="Lane cannot be searched by trunk VVD. Check trunk VVD again."
  msgs['BKG01005']="Expiry date of S/C(RFA) is earlier than ETD of 1st VVD. Please prolong the contract or input another S/C(RFA) No."
  msgs['BKG01006']="Please input House B/L information"
  msgs['BKG01007']="EQ Sub volume should not be larger than total volume"
  msgs['BKG01008']="SOC Q'ty should not be larger than total Q'ty"
  msgs['BKG01009']="Cut Off Time can be inputted after booking creation."
  msgs['BKG01010']="Reference No. can be inputted after booking creation."
  msgs['BKG01011']="Roll Over Information can be inputted after booking creation."
  msgs['BKG01012']="Shipper or forwarder code should be inputted."
  msgs['BKG01013']="Only void space exists. Input actual container TP/SZ."
  msgs['BKG01014']="L.OFC is not available. Select correct one in the Customer Inquiry screen."
  msgs['BKG01015']="Reefer container exists. Select RF or RD indicator."
  msgs['BKG01016']="Fifth VVD cannot be added."
  msgs['BKG01017']="Double input of the VVD XXXXXXXXX. Check the VVD again."
  msgs['BKG01018']="Search Failed: {?msg1}"
  msgs['BKG01019']="Mandatory Item(s) for \"Save\" is(are) missing: {?msg1}"
  msgs['BKG01020']="Delete Failed : {?msg1}"
  msgs['BKG01021']="Download Failed : {?msg1}"
  msgs['BKG01022']="Only one person per B/S part or ‘All’ part alone can be selected."
  msgs['BKG01023']="Do you want to transmit [{?msg1}] to [{?msg2}]?"
  msgs['BKG01024']="Create booking quantity, first!"
  msgs['BKG01025']="Please input Pre VVD."
  msgs['BKG01026']="This booking is not BDRed."
  msgs['BKG01027']="CRN ({?msg1}) of VVD ({?msg2}) is not allowed : Duplicate CRN ({?msg3})"
  msgs['BKG01028']="There is no container no!"
  msgs['BKG01029']="Please select one actual customer only"
  msgs['BKG01030']="Please Input POD or Customs."
  msgs['BKG01031']="Already Transmitted Case. \n\nYou must re-search the detail data \nBy double click the row that has the blank-sent-time data."
  msgs['BKG01032']="Full Cargo B/L(s) are not included. \n\nFor Transmit, Cargo Type Condition must be 'Full' or 'All'."
  msgs['BKG01033']="Error B/L(s) are included. Do you still want to transmit?"
  msgs['BKG01034']="You must input Service Scope Code"
  msgs['BKG01035']="Special cargo application has been rejected. Please check the application."
  msgs['BKG01036']="Please define method of Parent Window {?msg1} "
  msgs['BKG01037']="Next VVD should be later than preceding VVD."
  msgs['BKG01038']="POD of preceding VVD and POL of the next connected VVD should be the same."
  msgs['BKG01039']="Unable To Send ..."
  msgs['BKG01040']="D/O is not released. Do you want to continue ?"
  msgs['BKG01041']="Invalid Node Code({?msg1})"
  msgs['BKG01042']="NULL_DATA - Description for CUSTOMS"
  msgs['BKG01043']="PKG(or MEA or WGT) QTY of CNTR({?msg1}) is different from its sum of C/M PKG QTY! \nDo you want to save your change anyway?"
  msgs['BKG01044']="Do you want to save your change anyway?"
  msgs['BKG01045']="HS or?HTS code is a mandatory?for MYPKG T/S?cargo. Please enter proper?code(s) in HS or HTS?field"
  msgs['BKG01046']="Please double click the row to open Customer Information Template."
  msgs['BKG01047']="The Location code is invalid. MSN Discharge Location is not available."
  msgs['BKG01048']="assign Container first."
  msgs['BKG01049']="Booking({?msg1}) Not Found!"
  msgs['BKG01050']="Please check the entered data [{?msg1} code]"
  msgs['BKG01051']="There is no trans data"
  msgs['BKG01052']="Vessel Info. Data Not Found"
  msgs['BKG01053']="Please update vessel schedule first before you send MI & AI."
  msgs['BKG01054']="MI File Already transmitted.\nDo you want to transmit MI again?"
  msgs['BKG01055']="You must transmit MI file first."
  msgs['BKG01056']="Location AMS code Data Not Found."
  msgs['BKG01057']="Only maximum 2 input is possible."
  msgs['BKG01058']="D/O is invalid.[{?msg1}]"
  msgs['BKG01059']="Vessel Name not found"
  msgs['BKG01060']="Vessel SKD Code not found"
  msgs['BKG01061']="B/L count select error"
  msgs['BKG01062']="MI SENT DATE SELECT Error."
  msgs['BKG01063']="Do you want to transmit this Departure data?"
  msgs['BKG01064']="Do you want to transmit this Arrival data?"
  msgs['BKG01065']="Success to Download\n\nDownload path:"
  msgs['BKG01066']="There is no data for OFM Generation."
  msgs['BKG01067']="Only Canada Or USA Office is applicable"
  msgs['BKG01068']="Missing P/MIB Type"
  msgs['BKG01069']="Do you want to send Email Full Container Release Order ?"
  msgs['BKG01070']="Do you want to send Edi Full Container Release Order ?"
  msgs['BKG01071']="Since D/O has not released yet. Gate-out of Cargo can not be approved."
  msgs['BKG01072']="Retrieval Condition has been changed.\nRetrieval Condition can not be changed."
  msgs['BKG01073']="Please Excel Load first!"
  msgs['BKG01074']="D/O number ({?msg1}1) is invalid."
  msgs['BKG01075']="An error occured during Customer Code Validatation."
  msgs['BKG01076']="Madatory Retrieval Condition is missing. Office Code is Mandatory Conditiotn"
  msgs['BKG01077']="Customer code({?msg1}) is not registered."
  msgs['BKG01078']="The yard Code({?msg1}) is invalid!!!"
  msgs['BKG01079']="Please do {?msg1} first"
  msgs['BKG01080']="Maximum 1 Month Available."
  msgs['BKG01081']="Do you want to send email ?"
  msgs['BKG01082']="Do you want to send fax ?"
  msgs['BKG01083']="Duplicated Email exists."
  msgs['BKG01084']="Duplicated Fax No exists."
  msgs['BKG01087']="Do you want to download selected B/L?"
  msgs['BKG01088']="DownLoad successfully"
  msgs['BKG01089']="DownLoad Fail"
  msgs['BKG01090']="Please inpout {?msg1} or {?msg2}"
  msgs['BKG01091']="Both of POL and POD is Brazil"
  msgs['BKG01092']="There is no data to download."
  msgs['BKG01093']="Please select row first."
  msgs['BKG01094']="You selected already downloaded B/L. Do you want to continue?"
  msgs['BKG01095']="There is no data I/F is \"Y\""
  msgs['BKG01096']="There is no data to transmit."
  msgs['BKG01097']="Please check Select box of the target B/L No"
  msgs['BKG01099']="Data is under editing. You can’t transmit[B/L No :  {?msg1} ]"
  msgs['BKG01100']="Missing [{?msg1}].  You can’t transmit[B/L No :  {?msg2} ]"
  msgs['BKG01101']="{?msg1} is mandatory item."
  msgs['BKG01102']="Mandatory field is missing. seq {?msg1} [{?msg2}"
  msgs['BKG01103']="Data exceeded field length (6 or 8). seq {?msg1} [{?msg2}]"
  msgs['BKG01104']="Please input starting Line No."
  msgs['BKG01105']="Please select row first."
  msgs['BKG01106']="There is no data to assign"
  msgs['BKG01107']="Office Code is invalid."
  msgs['BKG01108']="P/MIB will be canceled and P/MIB No. will be deleted. Do you want to continue?"
  msgs['BKG01110']="P/MIB No. already exist"
  msgs['BKG01111']="Only In-Bond B/L can be assigned"
  msgs['BKG01112']="Aleady Deleted!"
  msgs['BKG01113']="This B/L No has been downloaded to another VVD. Plz delete it first"
  msgs['BKG01114']="Already Transmitted 1[{?msg1}]"
  msgs['BKG01115']="Failed to get SUB_NO"
  msgs['BKG01116']="Already Transmitted 2[{?msg1}]"
  msgs['BKG01117']="This B/L No [{?msg1}] has been downloaded to another VVD [{?msg2}]. Plz delete it first."
  msgs['BKG01118']="Already MRN Exist"
  msgs['BKG01119']="MRN No exist for this vessel"
  msgs['BKG01120']="Invalid Vessel Port Schedule"
  msgs['BKG01121']="INVALID Container No [{?msg1}]!"
  msgs['BKG01122']="Please register the VVD[{?msg1}] to PSA VVD Table!"
  msgs['BKG01123']="Total Package QTY does not match ![{?msg1}]"
  msgs['BKG01124']="Total Weight does not match ![{?msg1}]"
  msgs['BKG01167'] = "B/L was confirmed by shipper.  Do you want to reflect it on 'B/L Issue' tab. ?"
  msgs['BKG01175'] = "PPD Data is not Ready. Do you want to continue?"
  msgs['BKG01176']="There is a discrepancy between {?msg1} Cargo Application Split and  Container Split. [ {?msg2} ]"
  msgs['BKG01177']="Please input proper number into Flash Point. {?msg1}"
  msgs['BKG01178']="(Flash Point) Number of decimal places is {?msg1}. {?msg2}"
  msgs['BKG01179']="Only TS or TT can be inputted when TYPE is T/S.\n(TT : use same yard when T/S\n TS : use different yard when T/S)"
  msgs['BKG01180']="Mandatory items are not inputted.\n(Container No., TP, VVD)"
  msgs['BKG01181']="TS column should be inputted such as TS or TT when TYPE is T/S!"
  msgs['BKG01182']="R/D column is not invalid. Please input proper value."
  msgs['BKG01183']="TP of [{?msg1}] is invalid.\nLength should be 2."
  msgs['BKG01184']="VVD of [{?msg1}] is invalid.\nPlease input proper value."
  msgs['BKG01185']="POL of [{?msg1}] is invalid.\nPlease input proper value."
  msgs['BKG01186']="It is not available to input CNTR measure more than 34,999.999\nwhen Measure type is CBF!"
  msgs['BKG01187']="It is not available to input CNTR measure more than 999,999\nwhen Measure type is CBM!"
  msgs['BKG01188']="Do you want to delete all saved data?"
  msgs['BKG01189']="B/L Type is different from B/L Type of Doc Req.\nWould you like to continue this?"
  msgs['BKG01190']="The number of lines exceeds 3!\nPlease input less than three lines before save."
  msgs['BKG01191']="POL({?msg1}) is not calling port of vessel({?msg2})."
  msgs['BKG01192']="POD({?msg1}) is not calling port of vessel({?msg2})."
  msgs['BKG01193']="Please confirm this route by [Route Edit]. VVD({?msg1}) calls {?msg2} more than one time."
  msgs['BKG01194']="TRO Qty is bigger than BKG Qty. Please reduce TRO Qty of the following container. \nType/Size : {?msg1}"
  msgs['BKG01196']="You can delete only duplicated container."
  msgs['BKG01197']="Container NO ( {?msg1} ) Appointment is duplicated. Check Container number. "

  msgs['BKG02001']="Sum of EQ SUB Volumn, SoC Volume should not be larger then total Qty."
  msgs['BKG02002']="EQ sub TP/SZ error. EQ sub TP/SZ should be different from original one."
  msgs['BKG02003']="Not inputted TP/SZ in booking creation screen."
  msgs['BKG02004']="This code({?msg1}) is not used anymore. Please select another one."
  msgs['BKG02005']="Total volume should be smaller than booking volume."
  msgs['BKG02006']="{?msg1} - You can't input data more than limited rows. {?msg2}"
  msgs['BKG02007']="Hanger volume is different from 'Hanger Installation Order.\nPlease change hanger volume."
  msgs['BKG02008']="EQ sub vol. per {?msg1} is different form booking.\nPlease check EQ sub volume again."
  msgs['BKG02009']="You can't copy BKG of other BKG office"
  msgs['BKG02010']="BKG EQ substtitution quantity must be larger than 0."
  msgs['BKG02011']="You should confirm prior COD sequence first."
  msgs['BKG02012']="Trunk VVD can not be changed."
  msgs['BKG02013']="Please input only one VVD"
  msgs['BKG02014']="POR Nodes are different."
  msgs['BKG02015']="DEL Nodes are different."
  msgs['BKG02016']="ETB Duration must less then 10 days."
  msgs['BKG02017']="The country code of POR or POL should be the same. Please check POR or POL code again."
  msgs['BKG02018']="Booking Data does not exist. Do you have data copied?"
  msgs['BKG02019']="Original B/L has already bean released"
  msgs['BKG02020']="COD is not allowed for BB, AK cargo {?msg1}"
  msgs['BKG02021']="Receiving Term is not D !"
  msgs['BKG02022']="TP/SZ is full over !"
  msgs['BKG02024']="Container({?msg1}) is not located on this location."
  msgs['BKG02025']="This container({?msg1}) is immediate exit status. If you want to proceed, please contact HQ."
  msgs['BKG02026']="Saved successfully!\nCurrent movement status will not be changed.\nPlease adjust movement status."
  msgs['BKG02028']="Door Location Mismatched!";
  msgs['BKG02029']="Manfiested Rate is available for Door term only"
  msgs['BKG02036']="Bottom indicator should be one in a bundle."
  msgs['BKG02037']="Will you upload all items including TRO/O, Reefer, Danger and Akward?\nIf not, All Items but TRO/O, Reefer, Danger and Akward will be updated."
  msgs['BKG02038']="BKGs({?msg1}) are already BDRed.\nAre you sure?"
  msgs['BKG02039']="{?msg1} is off-line.  Please take a necessary action for manual approval process."
  msgs['BKG02040']="{?msg1}({?msg2}) not departured yet. Please take a necessary action for manual approval process."
  msgs['BKG02041']="{?msg1}({?msg2}) already arrived. Please take a necessary action for manual approval process."
  msgs['BKG02042']="Please request first before approval."
  msgs['BKG02043']="Requested successfully."
  msgs['BKG02044']="Brokoer codes are different.\nYou cannot combine bookings."
  msgs['BKG02045']="{?msg1}({?msg2}) already departured. Please check the new route."
  msgs['BKG02046']="P/C operated successfully."
  msgs['BKG02047']="It will be uploaded through Auto C/A Mode, since it's been BDRed."
  msgs['BKG02048']="Please check 'Special Cargo' indicator and save booking to open 'Special Cargo Application' menu."
  msgs['BKG02049']="Already Confirmed."
  msgs['BKG02050']="Please delete dummy S/C or RFA No or TAA No. first before you save."
  msgs['BKG02051']="For Commodity to Nigeria, Pls check. \n'Nigeria Import Prohibition List'\nhttp://www.customs.gov.ng/ProhibitionList/import.php\nOpen(confirm), Close(cancel)"
  msgs['BKG02052']="Please check 'Vol. Detail' and click 'OK' after split.\n 'Vol. Detail' is not split automatically and YOU MUST DO IT AFTER SPLIT FOR FURTHER WORK."
  msgs['BKG02053']="now loading {?msg2} tab. Please wait."
  msgs['BKG02054']="Container exists. Will you proceed?"
  msgs['BKG02055']="Please cancel B/L issue/release first!"
  msgs['BKG02056']="This booking is rejected by Sales Department. For detailed information, please contact {?msg1}"
  msgs['BKG02057']="TRO is already confirmed. Please cancel TRO first before change BKG QTY."
  msgs['BKG02058']="B/L is already issued. To update S/I information, you should cancel B/L issue first."
  msgs['BKG02059']="Container\"{?msg1}\" is newly added from e-Service. But after container confirmation, new container won't be added through e-Booking & S/I. Please delete it or cancel \"Container Confirmation\" in CNTR tab to upload it."
  msgs['BKG02060']="Saving booking no is available for SEANACC only."
  msgs['BKG02061']="Only XXXXX is available."
  msgs['BKG02062']="In case POD is US west coast or canada port, 'Trans Mode' won't be selected by booking staff."
  msgs['BKG02063']="[{?msg1}] For cargo to European nations, either EORI # \n or detail address(City, Country, Street, Zip code) is mandatory. Please input."
  msgs['BKG02064']="Booking won't be confirmed when special cargo approval is under process.\nFor CCA feeder service which doesn’t require special cargo approval via online,\nplease click “Compulsory Firm” button to confirm booking."
  msgs['BKG02065']="This B/L is already rated, please check it in charge.";
  msgs['BKG02066']="In case all reefer containers are assigned as R/D (Reefer Dry), please do not check on \"Reefer\" indicator.";
  msgs['BKG02068']="{?msg1} request is not processed yet. In case of S/I via Japan SEANACCS, you should upload e-SI in sequence."
  msgs['BKG02069']="Final CBF was already processed, will you proceed?"
  msgs['BKG02070']="Customer's Name({?msg1}) you input is registered on Sanctioned Customer List. Will you contact Sales, Customer, destination office and others before proceeding?"
  msgs['BKG02087']="\"Issue Place\” in Doc requirement allows up to 100 characters in length."
  msgs['BKG02089']="Input vent setting - If close, 0 % or 0 CMH."
  msgs['BKG02108'] = "Please click the Check Box which you want to transmit";
  msgs['BKG02109'] = "Please click the Check Box which you want to save";
  msgs['BKG02110'] = "Data is already existing. Please close and re-open this pop-up screen.";
  msgs['BKG02111'] = "Please input VVD or Period.";
  msgs['BKG02113'] = "Please input VVD or POL or Period or User ID.";
  msgs['BKG02115'] = "Please input Voyage number.";
  msgs['BKG02119'] = "The row ({?msg1}th) is a deleted schedule.";
  msgs['BKG02120'] = "It is possible to cancel D/O which is already released. Please check released one.";
  msgs['BKG02121'] = "Not same CNEE/NTFY code or e-mail.";
  msgs['BKG02122'] = "UN No sequence is not existed. Please check your UN No."
  msgs['BKG02123'] = "What you selected is issued successfully."
  msgs['BKG02124'] = "The booking [{?msg1}] already issued.\nWill be excluded from this work.";
  msgs['BKG02125'] = "CFR Items are available only for POL or POD in US.";

  msgs['BKG03009']="{?msg1} Q'ty is different form booking.\nPlease check {?msg2} Q'ty again."
  msgs['BKG03023']="TP/SZ [{?msg1}] is not in booking creation. Please check it again."
  msgs['BKG03035']="Please input {?msg1}."
  msgs['BKG03037']="Do you want to delete ? Then, please click \"Save\" button."
  msgs['BKG03049']="{?msg1} exceeds maximum duration {?msg2}."
  msgs['BKG03050']="{?msg1} is mandatory. Please enter {?msg2}."
  msgs['BKG03051']="{?msg1} is mandatory. Please enter {?msg2}."
  msgs['BKG03052']="Evaluation First"
  msgs['BKG03053']="Searching option was changed. Please search first."
  msgs['BKG03054']="There is no data to delete."
  msgs['BKG03055']="There is no data."
  msgs['BKG03056']="{?msg1} is duplicated."
  msgs['BKG03061']="{?msg1} is not available."
  msgs['BKG03064']="{?msg1} is duplicated."
  msgs['BKG03065']="{?msg1} is not available."
  msgs['BKG03157']="Shipper code are different !"
  msgs['BKG03158']="POR or DEL nodes are different !"
  msgs['BKG03159']="POD nodes are different !"
  msgs['BKG03833']="{?msg1} is duplicated."
  msgs['BKG03931']="CCT's office code({?msg1}) must be different from PPD's office code({?msg2})"
  msgs['BKG04001']="Failed to upload. Excel format is invalid."
  msgs['BKG04002']="Bookings with different VVD can not be chosen toghter."
  msgs['BKG04003']="You did not evaluate the Customer Code of some B/Ls, Please move to Code Validate screen and evaluate  those B/Ls first"
  msgs['BKG04004']="Booking in waiting status"
  msgs['BKG04005']="You should upload the file without any amendment to the B/L Detail [Seq] [B/L No.] [Container No.] [Name]"
  msgs['BKG04006']="The Fax, E-Mail is invalid"
  msgs['BKG04007']="Please Mouse-Click One B/L No in the list"
  msgs['BKG04008']="The Data you input were already existed. Please check it again"
  msgs['BKG04009']="[{?msg1}] shouldn't be earlier than ETA POD"
  msgs['BKG04010']="No data found to Delete!"
  msgs['BKG04011']="Delete Action Failed!!"
  msgs['BKG04012']="{?msg1} exceeded field length ({?msg2})"
  msgs['BKG04013']="The Return YD Code({?msg1}1) is invalid!!!"
  msgs['BKG04014']="Either VVD or POD is mandatory item."
  msgs['BKG04015']="The yard is not available for EDI !"
  msgs['BKG04016']="There is no data in Text Fields of Office [{?msg1}], please put Text in the fields"
  msgs['BKG04017']="You should put More than 2 Characters in Customer Name field in order to search data"
  msgs['BKG04018']="Data exists. Do you want to overwrite?"
  msgs['BKG04019']="Please Select One Row in the list"
  msgs['BKG04020']="Parsing e-mail Report failed. Unknown Rail Company or Service Provider has been given: [{?msg1}]"
  msgs['BKG04021']="EDI Transmit is only available to B/Ls with POD USA. The B/L [{?msg1}] is POD [{?msg2}] So, It is not applicable."
  msgs['BKG06000']="VVD, POD, EDA on MI or ETA is missing"
  msgs['BKG06001']="[{?msg1}][{?msg2}] can not pass following condition: \ni. Current U.S. Server Date < EDA on MI - 5 Days, vvd, pod"
  msgs['BKG06002']="[{?msg1}][{?msg2}] can not pass following condition: \nii. Current U.S. Server Date < New ETA (on OPUS Vessel Schedule) - 5 Days, vvd, pod"
  msgs['BKG06003']="VVD And POL or POD code is mandatory Item."
  msgs['BKG06004']="Please, Input Search Condition!"
  msgs['BKG06005']="No data found to Delete Row!"
  msgs['BKG06006']="Original Manifest should be filed 24HR prior to loading."
  msgs['BKG06007']="VSL has sailed out. Contact POD for correction."
  msgs['BKG06008']="Manifest should be transmitted before VSL Arrival."
  msgs['BKG06009']="Do want to delete selected ?"
  msgs['BKG06010']="Delete Completed."
  msgs['BKG06011']="Please Input Option - [VVD or POL or OFFICE or User ID]"
  msgs['BKG06012']="[{?msg1}] is invalid."
  msgs['BKG06013']="?[{?msg1}] is invalid.(cntr_no.value)"
  msgs['BKG06014']="Failed to save data. ({?msg1})"
  msgs['BKG06015']="The PRV Port is invaild"
  msgs['BKG06016']="There is no data for Down Excel."
  msgs['BKG06017']="Unable to save due to improper Hold code. You should input Hold code in case of Release code type."
  msgs['BKG06018']="Not available duplicated code."
  msgs['BKG06019']="Not available due to not registered Hold code."
  msgs['BKG06020']="Please deselect row(s) and then Save."
  msgs['BKG06021']="Type : {?msg1} only available"
  msgs['BKG06022']="Data was saved successfully."
  msgs['BKG06023']="Interface has been successfully completed."
  msgs['BKG06024']="Original MSG should be filed First. - [{?msg1}]"
  msgs['BKG06025']="Original MFT already transmitted. Select other MSG Type. - [{?msg1}]"
  msgs['BKG06026']="Check POD length !"
  msgs['BKG06027']="Check DEL length !"
  msgs['BKG06028']="POD & DEL are Duplicated ! [Seq. : {?msg1}]"
  msgs['BKG06029']="Sequence No.[{?msg1}] Duplication occurred. Do you want to save it anyway?"
  msgs['BKG06030']="You can’t update the data. Not Create Office [{?msg1}]."
  msgs['BKG06031']="Invalid commodity code"
  msgs['BKG06032']="bkg_cstms_chn_de_mod DELETE Error - {?msg1}"
  msgs['BKG06033']="bkg_cstms_chn_de_mod INSERT Error - {?msg1}"
  msgs['BKG06034']="Already History Searched!"
  msgs['BKG06035']="Please search data first."
  msgs['BKG06036']="Invalid POD. China port only."
  msgs['BKG06037']="License No, Customer Code or Customer Name are mandatory items.\nPlease enter one in the three item kinds."
  msgs['BKG06038']="License No({?msg1}) is Duplicated !"
  msgs['BKG06039']="Customer Code({?msg1}) is Duplicated !"
  msgs['BKG06040']="Customs Office at POD or Customs Office at DEL is missing. [FF fields: CC_CUSTOFCO:, CC_CUSTOFCD:] [{?msg1}][{?msg2}][{?msg3}]"
  msgs['BKG06041']="Original MSG should be filed First. - [{?msg1}]"
  msgs['BKG06042']="Original MFT already transmitted. Select other MSG Type. - [{?msg1}]"
  msgs['BKG06043']="You must cancel CUSCAR first"
  msgs['BKG06044']="You can not send update MSG without change !"
  msgs['BKG06045']="Please input Harmonized Tariff Code or Description"
  msgs['BKG06046']="Customer Code. is duplicated. Check customer code."
  msgs['BKG06047']="Even though it is indicated that mutiple customer exists in the list, Total count of distinct Business Registration number is 1\n, Or Vise versa"
  msgs['BKG06048']="Please choose send mode for Dec EDI"
  msgs['BKG06049']="Are you sure to send Dec EDI?"
  msgs['BKG06050']="Please check Bound, which must be either \"OO\" or \"II\" for DEC I/F."
  msgs['BKG06051']="It is not avaiable notice number."
  msgs['BKG06052']="It is not avaiable notice date."
  msgs['BKG06053']="It is not avaiable person in charge."
  msgs['BKG06054']="Please check Notice Amount, which is Zero."
  msgs['BKG06055']="Please check Notice Amount. Difference between Total Amount and Notice Amount is bigger than 50."
  msgs['BKG06056']="Please check Truncated Amount, which is bigger than 50."
  msgs['BKG06057']="Please check Notice Amount. Remainder (modulus) of Notice Amount by 10 is bigger than Zero."
  msgs['BKG06058']="Are you sure to trigger Dec I/F?"
  msgs['BKG06059']="You selected more than one B/L. Please mouse-click one B/L and press [B/L View] button once again"
  msgs['BKG06060']="Invalid NCM Code({?msg1})"
  msgs['BKG06061']="Customer code already exist."
  msgs['BKG06062']="Download has been finished successfully"
  msgs['BKG06063']="Already Interfaced VVD: [{?msg1}] [{?msg2}] [{?msg3}]"
  msgs['BKG06064']="Please input Customer Code, POD, DEL or Create Office."
  msgs['BKG06065']="Please check {?msg1} length!"
  msgs['BKG06066']="In case of Office \"ANRBS\", You have to put \"BEANR\" into either POL or POD column to search."
  msgs['BKG06067']="There is data discrepancy between Cargo classification for whf[{?msg1}] and whf declaration[{?msg2}]. Please, reconcile this screen with Cargo classification for whf and make a correction"
  msgs['BKG06068']="Dec No exists [{?msg1}]"
  msgs['BKG06069']="New Dec No already exists [{?msg1}]"
  msgs['BKG06070']="EDI has been transmitted successfully."
  msgs['BKG06071']="Data has been saved successfully."
  msgs['BKG06072']="You can't Transmit Arrival. (Type=63)"
  msgs['BKG06073']="Arrival Date is missing."
  msgs['BKG06074']="Arrival already transmitted."
  msgs['BKG06075']="Arrival Date changed. Please \"Save\" before transmitting."
  msgs['BKG06076']="You can't Transmit Export. (Type=61)"
  msgs['BKG06077']="Export already transmitted."
  msgs['BKG06078']="Export Date is missing."
  msgs['BKG06079']="Export Date changed. Please \"Save\" before transmitting."
  msgs['BKG06080']="Please input Arrival Date."
  msgs['BKG06081']="Please Input Row Number."
  msgs['BKG06082']="Send E-mail/Fax Successfully!"
  msgs['BKG06083']="Vessel A6A not transmitted yet. You can’t transmit this B/L in advance."
  msgs['BKG06084']="RECEIVER ID is a mandatory items."
  msgs['BKG06086']="Search Failed"
  msgs['BKG06087']="Save Failed"
  msgs['BKG06088']="Transmit Failed"
  msgs['BKG06089']="Can't tranmit in case of local b/l."
  msgs['BKG06090']="Unable to download due to missing CCN [Vessel CRN] Pls contact PIC of CCN maintenance."
  msgs['BKG06091'] = "please check a mandatory item. One of Acknowledge Date,BL No,Container No should be input.";
  msgs['BKG06096']="Unable to send cancel message without original sent message."
  msgs['BKG06097']="B/L No.[{?msg1}] is already Canceled."
  msgs['BKG06098']="There are some changed items, so you can transmit after save."
  msgs['BKG06100'] = "You can open DG Inquiry only after pressing [Save] button";
  msgs['BKG06102']="It is saved by [{?msg1}] level. Do you preceed it?"
  msgs['BKG06103']="Korea Wharfage Declaration No. already exists."
  msgs['BKG06106']="The Vessel doesn't call at BEANR, Please check Vessel schedule once again."
  msgs['BKG06107']="None of B/L Data is found with the SSR: [{?msg1}]"
  msgs['BKG06108']="The Vessel is calling at BEANR but none of B/L is for BEANR."
  msgs['BKG06109']="Some B/Ls are unsatisfied with BDR."
  msgs['BKG06110']="Please be aware that EDI Cancel is made based on First Msg Snd No.\nPlease check out click-boxes. Do you want to continue ?"
  msgs['BKG06111']="Please be noted that Re-Transmit is based on \"msg_send_no.\" of Original Transmit.\n" + "The B/Ls you selected will be transmitted with \"Update\" and B/Ls you didn\'t select will be transmitted with \"delete\".\n" + "Please re-check \"click box\" and \"msg_send_no\" then step further"
  msgs['BKG06112']="Different {?msg1} exsits for the same container [{?msg2}]"
  msgs['BKG06113']="[{?msg1}] or [{?msg2}] is mandatory condition."
  msgs['BKG06114']="B/L does not exist to declare! please check it!"
  msgs['BKG06115']="This {?msg1} has t/s information, please input vvd & port(pol or pod)."
  msgs['BKG06116']="부산 입항 {?msg1}일째(ETA DATE: {?msg2}) 화물입니다. 추후, Empty B/L Type을 정정할 수 있도록 선박 입항 후, 25~29일에 전송/신고하여 주시기 바랍니다."
  msgs['BKG06117']="Attention: this VVD contains SPECIAL DG (ZTG/AMN/SPR)"
  msgs['BKG06118']="Condition was changed!\n(BEFORE:{?msg1}) -> (AFTER:{?msg2})"
  msgs['BKG06120']="Please check total amount for WHF (Declare Amount + the Difference)"
  msgs['BKG06121']="The declare amount is larger than the total amount."
  msgs['BKG06122']="Please check last number. It shoud be \"Zero\""
  msgs['BKG06123']="CNTR QTY should be same with booking qty"
  msgs['BKG06124']="Please input data in one row for same TP/SZ and P/UP CY"
  msgs['BKG06125']="PSA BKG EDI fail to be sent automatically due to non-registration VVD. Please register VVD in PSA Vessel registration and send EDI manually."
  msgs['BKG06126']="Booking No is deleted. Booking No is mandatory item to save or copy data."
  msgs['BKG06127']="There are B/L without issue date ({?msg1}). Are you sure to download B/Ls with issue date only?"
  msgs['BKG06128']="There are B/L without issue date ({?msg1}). Please input B/L Issue date before downloading and EDI transmission"
  msgs['BKG06129']="Sum of Marks and Description cannot exceed 4000 characters. \n\nPlease check it again."

  msgs['BKG06133'] = "{?msg1} is empty.";
  msgs['BKG06134'] = "Duplicated value exists.";
  msgs['BKG06135'] = "Length of Prev.DocNo must be greater than 11 digit.";
  msgs['BKG06136'] = "Length of Prev.DocNo must be  23 digit.";
  msgs['BKG06137'] = "Prev. Doc No is {?msg1}. {?msg2} please!";
  msgs['BKG06138'] = "VVD POL is not matching. Please check EU POL again.";
  msgs['BKG06139'] = "Please download B/L data for the 1st POFE first, before the 2nd POFE.";
  msgs['BKG06140'] = "The VVD has TWO POFE, please send ENS for each POFE.";
  msgs['BKG06141'] = "Selection for Dwell Reason SVC Type is mandatory.";
  msgs['BKG06142'] = "The same CRN is already exisiting for a different VVD (?msg1). Please check again.";
  msgs['BKG06143'] = "The port is not available. Please check if EDI set-up is required.";
  msgs['BKG06144'] = "[{?msg1}] ENS was already transmitted and the Ack message is not received yet. Please wait more. Duplicate ENS is not allowed for NL customs.";
  msgs['BKG06145'] = "There is no CNTR No. in BKG No. please check it again.";
  msgs['BKG06146'] = "Please check less than 40 B/L.";
  msgs['BKG06147'] = "BKGs via FIKTK are selected. {?msg1} \nDo not miss to send ENS to second POFE 'FIKTK'.";
  msgs['BKG06148'] = "Yard Code is mandatory {?msg1}";
  msgs['BKG06149'] = "The inputted VVD is not calling {?msg1}. Please check it";
  msgs['BKG06150'] = "The weight unit should be {?msg1}.";
  msgs['BKG06151'] = "Not possible to send ENS, ENS ETA is already passed.";
  msgs['BKG06152'] = "Each Package of C/M cannot be exceed over 99,999";
  msgs['BKG06153'] = "Are you sure to change ENS ETA? If yes, previous ENS ETA data will be revised.";
  msgs['BKG06154'] = "Are you sure to delete All MRN? If yes, previous all MRN will be deleted.";
  msgs['BKG06155'] = "Mandatory Condition is missing. [ {?msg1} ]"
  msgs['BKG06156'] = "Transmit is unnecessary because there is no SAS111."
  msgs['BKG06157'] = "T/S VVD can't be transmit."
  msgs['BKG06158'] = "You can't transmit the Break Bulk B/L [ {?msg1} ]."
  msgs['BKG06159'] = "Export date should not be earlier than arrival date."
  msgs['BKG06160'] = "{?msg1} should not be later than \ncurrent time in EST"

  msgs['BKG06200'] = "Do you want to {?msg1} transmit ?"

  msgs['BKG08003']="Booking Data was Issued!!!"
  msgs['BKG08004']="Package Qty > 0"
  msgs['BKG08005']="Plase adjust sum of Partial Containers as One, Container No.(s) {msgs1}"
  msgs['BKG08006']="You can't select the data [{?msg1}]."
  msgs['BKG08007']="Do you want to copy of the {?msg1} ?"
  msgs['BKG08008']="Original Vol & Partial Vol. is not the same. Adjust Partial Vol.!"
  msgs['BKG08009']="The total of adjusted volume should be 1. Adjust volume again."
  msgs['BKG08010']="Customer Grid INfo. has been added. WIll you proceed after saving it?"
  msgs['BKG08011']="Please, input Warehouse Abbr. Code"
  msgs['BKG08012']="The container of ({?msg1}) will be deleted. Will you proceed?"
  msgs['BKG08013']="Container volume should be between 0 and 1.(0 < Vol ≤ 1)"
  msgs['BKG08014']="Container R/D term is updated to AK term. Please check AK term again."
  msgs['BKG08015']="Not  Complete"
  msgs['BKG08016']="The Page number you input exists on the add list. \nCheck the number and try again"
  msgs['BKG08017']="BKG No. not exists"
  msgs['BKG08018']="Not all S/R Transferred to DC"
  msgs['BKG08019']="Please Check BKG No."
  msgs['BKG08020']="Invalid data (NULL)"
  msgs['BKG08021']="MatchingComplete Success"
  msgs['BKG08022']="You Must Input page(s)"
  msgs['BKG08023']="TP/SZ{?msg1} is not in booking creation. Please check it again."
  msgs['BKG08024']="Corner post status is changed. Please check if it is adequate."
  msgs['BKG08025']="Please select post lock pin status."
  msgs['BKG08026']="Please fill out the total dimension."
  msgs['BKG08027']="Input TP/SZ!"
  msgs['BKG08028']="Please Input Add"
  msgs['BKG08029']="Please Input Period"
  msgs['BKG08030']="Please Input Template Name"
  msgs['BKG08031']="C/A Issue Office is 5 Digits"
  msgs['BKG08032']="Filer type is not [1]."
  msgs['BKG08033']="BKG Freight and sum of dirstributed Freight per Container is not matching."
  msgs['BKG08034']="Over length' exists. Please contact awkward cargo approval staff and make sure if this shipment is acceptable."
  msgs['BKG08035']="Select Pending or Return to Return Queue!!"
  msgs['BKG08036']="Target Booking [{?msg1}] is under CA."
  msgs['BKG08037']="SR already transferred to Doc Center"
  msgs['BKG08038']="Processing by {?msg1}"
  msgs['BKG08039']="Marine pollutant flag is 'Y' for UN No.[{?msg1}]. Changing marine pollutant flag is not permitted."
  msgs['BKG08040']="Please select only one row."
  msgs['BKG08041']="Not Allowed to delete Container({?msg1}) w/out \"VL\" status withdrawl!"
  msgs['BKG08042']="Not Allowed to insert Container({?msg1}) Which was aleady Reserved By Booking({?msg2}) with Different Cargo Type({?msg3})!"
  msgs['BKG08043']="Not Allowed to insert Container({?msg1}) Which was aleady Reserved By Booking({?msg2}) with Different T.VVD({?msg3})"
  msgs['BKG08044']="Not Allowed to insert Container({?msg1}) Which was aleady Reserved By Booking({?msg2}) with Different T.VVD({?msg3}) and Cargo Type({?msg4})!"
  msgs['BKG08045']="Not Allowed to insert Container({?msg1}, {?msg2}) Which was aleady Reserved By Booking({?msg3}) on Other Server!({?msg4})"
  msgs['BKG08046']="Not Allowed to insert Container({?msg1}) Which was aleady Reserved By Booking({?msg2}) on Other Server({?msg3})!"
  msgs['BKG08047']="Container({?msg1}) was damaged!, it can't be used now!"
  msgs['BKG08048']="Container({?msg1}) was deleted, it can't be used any more!"
  msgs['BKG08049']="Container({?msg1}) will be refurbished, it can't be used now!"
  msgs['BKG08050']="Container({?msg1}) will be disposed, it can't be used now!"
  msgs['BKG08051']="Container({?msg1}) will be imediately returned, it can't be used now!"
  msgs['BKG08052']="Container({?msg1}) is inactive, it can't be used now!"
  msgs['BKG08053']="Container({?msg1}) is currently under \"VL\", it can't be deleted now without WITHDRAWAL of \"VL\"!"
  msgs['BKG08054']="POR, DEL and first VVD should be the same. Please check B/L number again."
  msgs['BKG08055']="({?msg1}) is not registered code.Please check the charge code again."
  msgs['BKG08056']="{?msg1} does not have payment term. Please input payment term."
  msgs['BKG08057']="Prepaid is recommanded to RF cargo. Please check if payment term change for this rate is adequate."
  msgs['BKG08058']="[{?msg1}] is cancelled booking. Please check B/L number again"
  msgs['BKG08059']="Failed to add new Nortch China Booking Number[{?msg1}] to List [{?msg2}]"
  msgs['BKG08060']="Master B/L No. can't be used for covered B/L No. Please check B/L No. again."
  msgs['BKG08061']="Master B/L No does not exist"
  msgs['BKG08062']="[{?msg1}] does not exist. Please check B/L No. again."
  msgs['BKG08063']="Plase input \"{?msg1}\" to create Chinese Manual Booking Number!"
  msgs['BKG08064']="Office[{?msg1}] doesn't have [{?msg2}] as chinese agent."
  msgs['BKG08065']="Fail to assign Manifest File No."
  msgs['BKG08066']="B/L is not Ready"
  msgs['BKG08067']="PPD and CCT offices are mandatory items"
  msgs['BKG08068']="Number of collected B(s)/L is not same as number of issued B(s)/L"
  msgs['BKG08069']="Data saved successfully!"
  msgs['BKG08070']="Please input  Total No. of PKG/CNTR in Word"
  msgs['BKG08071']="The detail Q'ty between BKG & CNTR is different. \nPlease go back to booking main,\nopen \"Vol Detail\",  click \"OK\" and then save booking."
  msgs['BKG08072']="B/L Issue information is not ready"
  msgs['BKG08073']="Not allowed to issue for advanced/waiting/cancelled booking"
  msgs['BKG08074']="Data was changed. Please issue C/A first if data should be changed before request."
  msgs['BKG08075']="After BDR, special application request is available only for Post VVD\nPlease check VVD if you proceed with the request for approval."
  msgs['BKG08076']="Please confirm C/A first!"
  msgs['BKG08077']="M&D data is not Ready"
  msgs['BKG08078']="Rate Data is not Ready"
  msgs['BKG08079']="PPD Data is not Ready"
  msgs['BKG08080']="Issue Data is not Ready"
  msgs['BKG08081']="Released Data is not Ready"
  msgs['BKG08082']="B/L Type Data NOT 'B'"
  msgs['BKG08083']="Surrender Data is not Ready"
  msgs['BKG08084']="B/L Data is not Ready {?msg1}"
  msgs['BKG08085']="BB Q'ty is full. Please increase BB Q'ty first to add more containers."
  msgs['BKG08086']="Please input Application Date"
  msgs['BKG08087']="Would you like to send Draft B/L by Fax or by E-mail?"
  msgs['BKG08088']="B/L Release has been already done!"
  msgs['BKG08089']="This is Waybill"
  msgs['BKG08090']="This B/L is not issued yet. For original B/L print, please issue first"
  msgs['BKG08091']="This Original B/L was already printed. For reprint, please cancel issue & release first"
  msgs['BKG08092']="This is not Waybill"
  msgs['BKG08093']="This option is available Break Bulk cargo only"
  msgs['BKG08094']="Do you want to initialize?"
  msgs['BKG08095']="BKG No successfully checked!"
  msgs['BKG08096']="You Must Input S/R NO"
  msgs['BKG08097']="Did you finish all of booking matching? \n\nIf you click 'Yes', which means you completed this job and changing 'Transfer Status' from 'Processing' to 'Transfered'.\n\nAlso Clicking 'Yes' is same as clicking 'Matching Complete' button above. Question!, YesNo!"
  msgs['BKG08098']="This Original B/L was already released. For reprint, please cancel issue & release first"
  msgs['BKG08099']="Customer [{?msg1}] is Black Listed Customer. Please check possiblity with Sales Office before B/L Release"
  msgs['BKG08100']="Do you want to trans to Customs"
  msgs['BKG08102']="Requested successfully."
  msgs['BKG08103']="Request canceled."
  msgs['BKG08104']="The customer codes are unmatched btwn BKG and RFA. please check it again."
  msgs['BKG08105']="The customer codes are unmatched btwn BKG and SC.\n Do you still want to proceed autorating ?"
  msgs['BKG08107']="All sequences have been canceled. You cannot request approval."
  msgs['BKG08108']="There is no ocean freight available in autorating. Do you want to searh for tariff autorating ?"
  msgs['BKG08109']="Please check No. of B/L"
  msgs['BKG08110']="Are you sure to authorize the printing of Internet O.B/L?"
  msgs['BKG08111']="Do you want to send E-mail?"
  msgs['BKG08112']="The EQ OFC {?msg1} is already setup with Handling OFC {?msg2} You can't one EQ OFC should get one handling office!"
  msgs['BKG08113']="Please Check  Page No!"
  msgs['BKG08114']="Please delete dummy S/C or RFA No. first before you save"
  msgs['BKG08115']="Amend Reson Item!"
  msgs['BKG08116']="B/L data (Customer, M&D, C/M) is not available."
  msgs['BKG08117']="Charge data is not available."
  msgs['BKG08118']="An unknown error has occurred while tranfering data at BKG System. (BDR LOG)"
  msgs['BKG08119']="Failed to delete. Already transferred to DC."
  msgs['BKG08121']="Please update a specific contract number first before you run autorating."
  msgs['BKG08123']="The customer codes are unmatched btwn BKG and TAA. please check it again."
  msgs['BKG08124']="You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time"
  msgs['BKG08125']="Please input B/L Mater No."
  msgs['BKG08126']="Please input Container Type/Size in 'TS' field. It is mandatory item."
  msgs['BKG08127']="Attached File is deleted due to storage server capacity"
  msgs['BKG08128']="Do you want to save changed information in 'Hide' column?"
  msgs['BKG08129']="Partial Total({?msg1}) should be range from 0 to 1 (o < Partial Total=< 1). Please change [Vol] value for each booking."
  msgs['BKG08130']="Please add container first before adding C/M"
  msgs['BKG08131']="The payment term of OFT is recommended to be 'Prepaid'"
  msgs['BKG08132']="The payment term of personal effects is recommended to be 'Prepaid'"
  msgs['BKG08133']="The payment term of GOH is recommended to be 'Prepaid'"
  msgs['BKG08134']="No charge to merge"
  msgs['BKG08135']="CAF is duplicated"
  msgs['BKG08136']="Service Scope does not exist. Please click 'Save' in the BKG Creation to assign service scope."
  msgs['BKG08137']="On board Date is not same as cargo receiving date. Do you want to continue?"
  msgs['BKG08138']="User office does not correspond with surrender creation office."
  msgs['BKG08140']="CNTR TY/SZ is different from BKG volume. Do you go ahead?"
  msgs['BKG08141']="Duplicate Control Office,Agent,Customer Code! Please try again."
  msgs['BKG08142']="There is no Charge code($s) in master table. please check it again."
  msgs['BKG08143']="There is no Currency code($s) in master table. please check it again."
  msgs['BKG08144']="There is no Rating Unit code($s) in master table. please check it again."
  msgs['BKG08145']="B/L Data is not completed. Please check M&D, Charge, Customer, Container"
  msgs['BKG08146']="Unable to save due to invalid TAA No.!"
  msgs['BKG08147']="Conversion update has not been completed yet. Please check result of autorating before saving."
  msgs['BKG08148']="There is no contract. please input contract no first."
  msgs['BKG08149']="Please input contract number."
  msgs['BKG08150']="Please delete dummy No. first before you save"
  msgs['BKG08151']="S/O already created"
  msgs['BKG08152']="Rates cannot be saved with dummy contract number."
  msgs['BKG08153']="Special cargo approval request will not be sent because VVD {?msg1} is not target lane!"
  msgs['BKG08154']="The trans mode of [{?msg1}] is not registered to IRG of Product Catalogue. Please change trans mode of booking or register transmode to IRG."
  msgs['BKG08155']="The trans mode of $s is not registered to IRG of Product Catalogue. Please change trans mode of booking or register transmode to IRG."
  msgs['BKG08156']="Autorating is not available in case of BKG created in OPUS Please rate it manually."
  msgs['BKG08157']="Cancel Master B/L No. in covered B/L first."
  msgs['BKG08169']="Confirm is available up to 3 TROs at the same time due to system performance!!"
  msgs['BKG08170']="Please input master/covered B/L number in master/covered B/L again after C/A confirmation."
  msgs['BKG08171']="Duplicated container no!! Please check container no again"
  msgs['BKG08172']="Please cancel B/L issue first."
  msgs['BKG08173']="Please cancel B/L issue to change type."
  msgs['BKG08174']="Only 'Hide' can be changed after BDR. Please issue C/A."
  msgs['BKG08175']="Please check main EDI data"
  msgs['BKG08177']="Temperature conversion is not correct between C & F. Please check temperature setting again.";
  msgs['BKG08178']="The application date does not exist. Please input application date!!";
  msgs['BKG08179']="[{?msg1}] is not available. \nSave data in the Container screen.";
  msgs['BKG08181']="There is partial shipment in this booking, please check WSC again.";
  msgs['BKG08185']="Do you continue to self-audit?";
  msgs['BKG08186']="CRD is not fixed because OC for CNTR [{?msg1}] has not been occurred";
  msgs['BKG08192'] = "Seal Information is mandatory. \nPlease insert seal number / kind / code."
  msgs['BKG08193']="Container Data is not Ready"
  msgs['BKG08194'] = "Customs Data Created."

  msgs['BKG08238'] = "ATTN! \nPlease fill out Zip Code for Canada Customs Manifest.";
  msgs['BKG08247'] = "Do you want to overwrite all items including already\nexisting B/L data which was downloaded before?";

  msgs['BKG08248'] = "Reactivated successfully";
  msgs['BKG08249'] = "Fail to reactivate BKG";
  msgs['BKG08250'] = "This Documentation Cut-off Time \n[{?msg1}] is already existed. \nYou should update the row directly. \n(If there is DELT of this row as 'Y', please modify this existed one. \nYou can see all of rows including deleted rows \nby clicking checkbox 'Including Deleted Code'.)";
  msgs['BKG08251'] = "You should check one of ETA, ETB, ETD, DAY necessarily";
  msgs['BKG08252'] = "There is no Recipient in this Line and Approval RSO! \nManual Mail popup will be opened";
  msgs['BKG08253'] = "The Total of Orginal B/L and N/N Copy cannot exceed 5 digits";
  msgs['BKG08254'] = "You cannot use manual email if there is no status of COD \nPlease use after making COD status.";

  msgs['BKG10001']="SAME, ‘CONSIGNEE, ‘AS ABOVE’ was detected in Notify Name while B/L Type is ‘O-Order’. Do you want to change the B/L Type to ‘S-Straight’ ?]"
  msgs['BKG02093'] = "UNNO Sequence number is Mandatory";
  msgs['BKG40001']="Invalid Business Registration Number"
  msgs['BKG40002']="Effective data is greater than Expire Date."
  msgs['BKG40003']="Gap Between Effective Date and Expire Date should be less than 5 years"
  msgs['BKG40004']="Released B/L Quantity can not exceed Received B/L Quantity."
  msgs['BKG40005']="Mandatory Retrieval Condition is missing. Business Registration Number is Mandatory Retrieval Conidtion."
  msgs['BKG40006']="Inputted Business Name exceeded 100 bytes. Korean Character 3 Bytes" // 입력한 사업자명의 길이가 100Byte를 초과하였습니다. 한글3Byte"
  msgs['BKG40007']="ERP Interface doesn't work properly. Please try again later."
  msgs['BKG40008']="only less than {?msg1}-day periods allowed"
  msgs['BKG40009']="You should only put either 2 characters or 5 characters in DEL field"
  msgs['BKG40010']="Please put either 5-characters in POD or 2 or 5-characters in DEL field in order to search data."
  msgs['BKG40011']="You can't select \"Okay\" evaluation type because none of consignee or notify code is in booking customer column."
  msgs['BKG40012']="A content of Mandatory Fields is missing, please fill in with either Customer Code or Customer Name in order to search data."
  msgs['BKG40013']="only less than {?msg1} -month periods allowed"
  msgs['BKG40014']="only less than {?msg1} -week periods allowed"
  msgs['BKG40015']="A content of Mandatory Fields is missing, please fill in with {?msg1} in order to search data."
  msgs['BKG40016']="Please input notification date or later"
  msgs['BKG40017']="Please select at least one row by mouse click in order to Fax or E-mail"
  msgs['BKG40018']="Please select at least one row by mouse click in order to Fax"
  msgs['BKG40019']="Please select at least one row by mouse click in order to E-mail"
  msgs['BKG40020']="Fax No {?msg1} is invalid."
  msgs['BKG40021']="E-mail Address {?msg1} is invalid."
  msgs['BKG40022']="You can't amend the contents [B/L No][Customer Name]"
  msgs['BKG40023']="D/O ID. is Invalid!"
  msgs['BKG40024']="DOR DATA Successfully Fail!"
  msgs['BKG40025']="DOR Transmit Fail!"
  msgs['BKG40026']="Invalid P/Up DT"
  msgs['BKG40027']="You didn't make any changes"
  msgs['BKG40028']="There is no data in Text Field of Office {?msg1}, please put Text in the fields"
  msgs['BKG40029']="You can't copy text contents with Save button. Please press Copy button and input POD or/and Handling Office"
  msgs['BKG40030']="The input No is Empty B/L(BKG). Please input Full B/L (BKG) No then search data"
  msgs['BKG40031']="B/L No.[{?msg1}] doesn't exist"
  msgs['BKG40032']="Max duration is 7. please change date condition."
  msgs['BKG40033']="Booking No.[{?msg1}] doesn't exist"
  msgs['BKG40034']="Mandatory field is missing. Please enter VVD+POD or Sant Date+POD."
  msgs['BKG40035']="Failed to transmit to the Fax [{?msg1}]. Contact the server admin"
  msgs['BKG40036']="Failed to transmit to the email [{?msg1}]. Contact the server admin"
  msgs['BKG40037']="Do you want to send fax {?msg1}"
  msgs['BKG40038']="Do you want to send email {?msg1}"
  msgs['BKG40039']="Mandatroy Retrieval Condition is missing: Either VVD, POD ETA or B/L No is a mandatory item"
  msgs['BKG40040']="Please select target."
  msgs['BKG40041']="B/L No.[{?msg1}] doesn't exist"
  msgs['BKG40042']="Please be aware that None of Data was changed, Close"
  msgs['BKG40043']="You didn't input any [B/L No.] or [Container No.]. Please fill it in in order to use Filter function"
  msgs['BKG40044']="You can't transmit the data because Mandatory items are blank or invalid, Please check it and press \"EDI Transmit\" button once again"
  msgs['BKG40045']="You can't handle this B/L Because the Port of Discharging is [{?msg1}]"
  msgs['BKG40046']="VVD & POL/POD are mandatory items.please input !"
  msgs['BKG40047']="VVD & POL or POD is mandatory items.please input !"
  msgs['BKG40048']="Please, Check Hold"
  msgs['BKG40049']="Please input hold reason"
  msgs['BKG40050']="You did not insert any Text Information such as Address, important Information into Arrival Notice Template -Office Default."
  msgs['BKG40051']="VVD ({?msg1}) is not available"
  msgs['BKG40052']="POD ({?msg1}) is not available"
  msgs['BKG40053']="Fax Successfully!"
  msgs['BKG40054']="E-Mail Successfully!"
  msgs['BKG40055']="Please check the row!"
  msgs['BKG40056']="VVD=[{?msg1}], POL=[{?msg2}] , POD=[{?msg3}] Do you want to transmit Manifest to The Mexico Customs ?"
  msgs['BKG40057']="You mouse-clicked the B/L No. which hasn't got Customer Code \nPlease mouse-click B/L No. which get Customer Code then press [Grouping by code] button once again"
  msgs['BKG40058']="You mouse-clicked the B/L which hasn't got S/C No.\nPlease mouse-click the B/L which get S/C No. then press [Grouping by S/C] button once again"
  msgs['BKG40059']="If you want to go one step further, the B/L [{?msg1}] should be on Release Status. \nPlease press Release button then try it again"
  msgs['BKG40060']="There is no data to retireve,"
  msgs['BKG40061']="The B/L [{?msg1}] you pressed 'Release' or 'Cancel' button has been placed on hold for some reason.\nPlease check the reason then press 'Hold Removal' button and process release or cancel once again"
  msgs['BKG40062']="Unable to Send without MRN, MSN No."
  msgs['BKG40063']="The B/L is Partial One"
  msgs['BKG40064']="Rlse Remark is madatory item to input."
  msgs['BKG40065']="The number of B/L Received you inputted is bigger than B/Ls released in B/L Issue Screen."
  msgs['BKG40066']="You can't release because B/L Status is N.\nB/L Status will turn Y only when one out of items 1) Seaway Bill, 2) O.B/L Surrenderred, 3) O. B/L received, 4) LG received with accepted is satified with. please check it."
  msgs['BKG40067']="Completed updating the data of VVD [{?msg1}]"
  msgs['BKG40068']="You changed some items of this screen. Do you want to close the screen without saving these items ?"
  msgs['BKG40069']="[{?msg1}] Button is available only when you select Containers by clicking a check box."
  msgs['BKG40070']="Container No. prefix is invalid"
  msgs['BKG40071']="If you want to go one step further, the CNTR. [{?msg1}] should be on Release Status. \nPlease press Release button then try it again"
  msgs['BKG40072']="You can't change the number of B/L Received \"{?msg1}\" by manually inputting"
  msgs['BKG40073']="You can't select the Containers which were assigned to different D/O No. \nPlease check the D/O No of the containers you clicked. \nThen, mouse-click the check box of containers with same D/O No and press {?msg1} Button once again."
  msgs['BKG40074']="The B/L is Partial One"
  msgs['BKG40075']="Please select at least one row by mouse click"
  msgs['BKG40076']="Please select one row"
  msgs['BKG40077']="You did not insert any Text Information such as Address, important Information into Hold Notice Template -Office Default. \nPlease move to Hold Notice Set-up and fill it in text field, then please repeat step"
  msgs['BKG40078']="You didn't put it in OFC or ID column. Please insert either OFC or ID to search data."
  msgs['BKG40079']="You can't handle this B/L Because the Port of Discharging"
  msgs['BKG40080']="You did not insert any Text Information such as Address, important Information into Cargo Release Order Template -Office Default. \nPlease move to Cargo Release Order Set-up and fill it in text field, then please repeat step"
  msgs['BKG40081']="Since D/O has not released yet. Gate-out of Cargo can not be approved." //"D/O 가 Release 안되었습니다. 반출 승인할 수없습니다."
  msgs['BKG40082']="please confirm whether you approve transmission or not" //"전송 승인 여부를 선택하여 주시기 바랍니다."
  msgs['BKG40083']="You didn't change any item. Nothing to be saved."
  msgs['BKG40084']="Do you really want to transmit Carriers' release to the Terminal? (Yes, No)"
  msgs['BKG40085']="The B/L you selected for Carriers' Release is not applicable to transmit."
  msgs['BKG40086']="The B/L you selected for Carriers' Release doesn't have sufficient data to transmit"
  msgs['BKG40087']="The B/L you selected for Carriers' Release failed to transmit"
  msgs['BKG40088']="You didn't put Incurred charges. Please input it before opening TPB pop-up Screen."
  msgs['BKG40089']="If you want to go one step further, the B/L [{?msg1}] should be on Assign&Issue Status. \nPlease press Assign&Issue button then try it again"
  msgs['BKG40090']="You didn't select one B/L by mouse-clicking on Check Box. \nPlease click on a Check Box of B/Ls, then press [{?msg1}] Button."
  msgs['BKG40091']="You can't handle this B/L Because the Port of Discharging is [{?msg1}]"
  msgs['BKG40092']="The B/L is Partial One."
  msgs['BKG40093']="Unable to Send without MRN, MSN No."
  msgs['BKG40094']="If you want to go one step further, the CNTR. [{?msg1}] should be on Release Status in EU Cargo Release Screen. \nPlease 1) Move to EU Cargo Release Screen, 2) Check O.B/L, FRT, DEM Status, 3) press Release button if 3 statu"
  msgs['BKG40095']="Since it is registered as the mandatory, it can not be deleted"
  msgs['BKG40096']="B/L No or Container No or BKG No is mandatory item."
  msgs['BKG40097']="B/L No or BKG No is mandatory item."
  msgs['BKG40098']="Do you want to E-mail this Cargo Release Order to the Receiver [{?msg1}]"
  msgs['BKG40099']="Do you want to fax this Cargo Release Order to the Receiver [{?msg1}]"
  msgs['BKG40100']="Please input {?msg1} for container[{?msg2}]"
  msgs['BKG40101']="Unexpected system error took place during data processing. Please try again later."
  msgs['BKG40102']="Invalid {?msg1}  for container[({?msg2})]"
  msgs['BKG40103']="The container is Empty without Full Booking No at present. Please input BKG No. or B/L No to search data"
  msgs['BKG40104']="The Fax No and/or E-mail Address you inputted is duplicated one. Please check it and Re-Save"
  msgs['BKG40105']="The [{?msg1}] length is invalid!!!"
  msgs['BKG40106']="The maximum length of [{?msg1}] is [{?msg2}] Digits."
  msgs['BKG40107']="The B/L [{?msg1}] you pressed [{?msg2}] button has been placed on hold for some reason. \nPlease check the reason then press 'Hold Removal' button and process release or cancel once again"
  msgs['BKG40108']="The Container you pressed [{?msg2}] button has been placed on hold for some reason. \nPlease check the reason then press 'CNTR Hold Removal' button and process release or cancel once again"
  msgs['BKG40111']="Any data for self-trans do not exist."
  msgs['BKG40112']="Any data for inbond_trans requests do not exist."
  msgs['BKG40113']="Any data for D/O issue requests do not exist."
  msgs['BKG40114']="Expect Delivery Date[{?msg1}] must be same or later than today"
  msgs['BKG40115']="VVD and POD is mandatory item"
  msgs['BKG40116']="POD ETA and POD is mandatory item."
  msgs['BKG40117']="You didn't request [{?msg1}] Code Creation through Mouse-clicking @.\nDo you want to save without requesting ?";
  msgs['BKG40118']="Please put a number into B/L Receive or choose L/G then press [Save] button.";
  msgs['BKG43028']="Office[{?msg1}] and POD [{?msg2}] haven't got any Text Contents in each field. Please fill it in and press Save button."
  msgs['BKG43034']="No downloaded {?msg1} data."
  msgs['BKG43035']="{?msg1} must not be over {?msg2} characters long.\nYou Input {?msg3} Characters."
  msgs['BKG43036']="위임장이 없습니다."
  msgs['BKG43037']="위임장 만료일이 지났습니다."
  msgs['BKG43039']="Container is not full!"
  msgs['BKG43040']="The B/L No doesn't have a VVD to call at Last POD!!  \nPlease mouse-click to the box of T/S option then press [Search] Button again."
  msgs['BKG43041']="Please do not add or delete any row in Excel file which you down-loaded from Opus.\nPlease Excel down again and input only MRN and RTN Yard columns in Excel and upload it again"
  msgs['BKG43042']="Please do not amend columns colored in Excel file which you down-loaded from Opus.\nPlease Excel down again and input only MRN, RTN Yard and Reference  columns in Excel and upload it again"
  msgs['BKG43043']="Auto Batch is running now. please press [Batch] button a few seconds later.";
  msgs['BKG43044']="잘못된 신청정보입니다.";
  msgs['BKG43045']="You cannot manage multiple BLs using this function";
  msgs['BKG43046']="Please select multiple row first.";
  msgs['BKG43047']="B/L on the grid and below form is not the same. Please double click the grid.";
  msgs['BKG43048']="B/L [{?msg1}] is 'Hold' status. (User made the BL Hold) Please un-check the B/L, and send.";
  msgs['BKG08176']="Only number is acceptable for ‘Transportation index’. In case of ‘N/A’, please input 0.";
  msgs['BKG50461']="Invalid RQST DATE"
  msgs['BKG50462']="Invalid RQST WEEK"
  msgs['BKG50463']="Invalid RQST Month"
  msgs['BKG50464']="Invalid Report Type"
  msgs['BKG50465']="Invalid DOC Type"
  msgs['BKG50466']="Invalid Server"
  msgs['BKG50467']="Please, Input to Booking Date"
  msgs['BKG50468']="Can't Input Date Over 15 days!"
  msgs['BKG50469']="Can't Input Date Over 31 days!"
  msgs['BKG50470']="Can't Input Date Over 5 weeks!"
  msgs['BKG50471']="Please check the date range!"
  msgs['BKG50472']="Please check the date range!. Maximum date range is 7 days"
  msgs['BKG50473']="Cancelled SR No"
  msgs['BKG50474']="Please, Check Period"
  msgs['BKG50475']="Are you sure to save?"
  msgs['BKG50476']="NOT Complete"
  msgs['BKG50477']="NOT Transfer to DC"
  msgs['BKG50478']="The Page number you input exists on the add list. Check the number and try again"
  msgs['BKG50479']="Do you transmit AI to USCS"
  msgs['BKG50480']="Are Your Sure Delete?"
  msgs['BKG50481']="You did not evaluate the Customer Code of the B/L No{?msg1}, Please move to Code Validate screen and evaluate it first"
  msgs['BKG50482']="Please check Gate-in/out wharf code"
  msgs['BKG50483']="No Data to EDI send"
  msgs['BKG80006']="You can't select the data [{?msg1}]."
  msgs['BKG80007']="Do you want to copy of the {?msg1} ?"
  msgs['BKG80841']="Are you sure to do BDR only selected BKGs?"
  msgs['BKG80842']="Are you sure to do BDR all BKGs of VVD?"
  msgs['BKG90771']="BKG : {?msg1} {?msg2}."
  msgs['BKG90772']="Booking office mismatching."
  msgs['BKG95001']="Please {?msg1} {?msg2}."
  msgs['BKG95002']="Data was changed. Do you want to save it?"
  msgs['BKG95003']="Do you want to {?msg1}?"
  msgs['BKG95004']="[{?msg1}] was searched successfully."
  msgs['BKG95005']="There is no updated data to save."
  msgs['BKG95006']="Do you want to save?"
  msgs['BKG95007']="[{?msg1}] is duplicated."
  msgs['BKG95008']="Please input [{?msg1}]."
  msgs['BKG95009']="{?msg1} is not available."
  msgs['BKG95010']="There is no data."
  msgs['BKG95011']="BL No {?msg1} 's length must be 12. Please check again."
  msgs['BKG95012']="RDN No {?msg1} 's length must be 9. Please check again."
  msgs['BKG95013']="CA No is not exist. Please check again."
  msgs['BKG95014']="CA No {?msg1} 's length must be 12. Please check again."
  msgs['BKG95015']="{?msg1} date should be earlier than {?msg2} date."
  msgs['BKG95016']="Please select target row."
  msgs['BKG95017']="There is no data to {?msg1}. Please check again."
  msgs['BKG95018']="{?msg1} length must be {?msg2}. Please check again"
  msgs['BKG95019']="Failed to download. Please try again."
  msgs['BKG95020']="Data was downloaded successfully."
  msgs['BKG95021'] = "{?msg1} Rows Imported."
  msgs['BKG95022']="[?msg1} is wrong Disch. CY"
  msgs['BKG95023']="Plz, fill in the blanks of Entry Type and Disch CY."
  msgs['BKG95024']="Already MSN Exist. Other MSN Input."
  msgs['BKG95025']="Please input {?msg1}."
  msgs['BKG95026']="'{?msg1}' must be earlier than '{?msg2}'."
  msgs['BKG95027']="The period of Date can't be over {?msg1}."
  msgs['BKG95028']="Please select the B/L that you want to audit again."
  msgs['BKG95029']="Do you want to execute Re-Audit?"
  msgs['BKG95030']="Re-Audited."
  msgs['BKG95031']="Please select {?msg1}."
  msgs['BKG95032']="Settled manually."
  msgs['BKG95033']="Saved."
  msgs['BKG95034']="Please add the row of {?msg1}."
  msgs['BKG95035']="Issued."
  msgs['BKG95036']="Revised."
  msgs['BKG95037']="Settled."
  msgs['BKG95038']="Copied."
  msgs['BKG95039']="Canceled."
  msgs['BKG95040']="Requested."
  msgs['BKG95041']="Accepted."
  msgs['BKG95042']="Please insert the Revenue C/A No. that you issued for correction of freight and charges of the B/L."
  msgs['BKG95043']="Upload Screen. Two is Maximum. \nPlease Close at least only Upload Screen. \nFor New Upload Screen."
  msgs['BKG95044']="Please input the reason of manual settlement into Remarks(Office) and save it."
  msgs['BKG95045']="You can settle Error B/L manually only for B/L in staus of BDR_No. Please see if you selected B/L in status of BDR_Yes."
  msgs['BKG95046']="The selected B/L is Door Term. Please revise R/D terms before you can issue Full Release for this B/L."
  msgs['COM12147']="Do you want to save {?msg1}?";                       //COM130101-> db메세지 코드와 상이함:()제거
  msgs['COM12193']="Please input {?msg1}.";                              //COM130201-> CoMessage.js의 메세지코드가 DB의 메세지 코드가와상이함
  msgs['COM12194']="Do you want to delete {?msg1}?";                     //COM12165 -> db메세지 코드와 상이함
  msgs['COM12200']="Mandatory field is missing. Please enter {?msg1}.";  //COM130403-> db메세지 코드와 상이함
  msgs['COM12242']="{?msg1} is not available.";                          //COM132202-> db메세지 코드와 상이함
  msgs['BKG43029']="선택된 대상을 정말 삭제하시겠습니까?"
  msgs['BKG43030']="Please choose transmit type."
  msgs['BKG43031']="Nothing to be sent as a original!"
  msgs['BKG43033']="DOOR 조건입니다. 그래도 승인하시겠습니까?"
  msgs['BKG04022']="There are different Act.Filing direction code.Do you want to update all b/l as {?msg1}?";
  msgs['BKG04023']="Correction inquiry of all the searched C/As will be printed. Will you proceed?";
  msgs['BKG04024']="Office already exist";
  msgs['BKG04025']="The row you select doesn't have any container. \nYou should select the row which has a container.";

  msgs['BKG01126']="Duplicated data existed. please check it again";
  msgs['BKG01127']="Invalid Stowage Code. Please check it again.";
  msgs['BKG01128']="No ENS data Found.";
  msgs['BKG01129']="Please Save First.";
  msgs['BKG01130']="{?msg1} B/L(s) were not downloaded. Please \"Download\" first, before \"transmit\". \nB/L #: {?msg2}.";
  msgs['BKG01131']="Customs office doen't exist. Please register.";
  msgs['BKG01132']="Original & New First Office should not be same.";
  msgs['BKG01133']="Error B/L ({?msg1}) is included. {?msg2}";
  msgs['BKG01134']="You should select one B/L";
  msgs['BKG01138']="Diversion Request for “{?msg1}” is already submitted. ENS won’t be submitted after Diversion Request";
  msgs['BKG01139']="POL is EU country.";
  msgs['BKG01140']="The vessel already arrived at POFE. ENS can not be manifested anymore.";
  msgs['BKG01141']="[{?msg1}] EDI is already transmitted and Ack Message is not received yet. Will you re-transmitted EDI?";
  msgs['BKG01142']="ENS Amendment to ES is not acceptable for a while.\nOnly original ENS is accepted by ES customs at this moment.";
  msgs['BKG01143']="An {?msg1}EORI number must start with two uppercase letters (the ISO code of the country that granted the number) followed by maximum 15 alphanumeric characters.";
  msgs['BKG01144'] = "No ENS data found. Please make sure this VVD is the correct one to proceed D/R. All ENS should be properly sent before D/R.";
  msgs['BKG01145'] = "ENS manifest for {?msg1} is not possible anymore.\nArrival Notification has been already sent by our inbound office to POFE.";
  msgs['BKG01146'] = "At least one(1) search element should be filled (eg. handling office).";

  msgs['BKG01135']="There are un-matched DG Seq with {?msg1}. For europe destined cargo, all D/G Seq should be matched in CM/ screen";
  msgs['BKG01136']="DG seq {?msg1} is matched with more than 2 C/M.  It should be matched one by one";
  msgs['BKG01151']="Country code of detail address is different from that of customer code. Do you continue to save data?";
  msgs['BKG01152']="An EORI number must start with two uppercase letters (the ISO code of the country that granted the number) followed by maximum 15 alphanumeric characters";
  msgs['BKG95051']="The Same ID is existed.";
  msgs['BKG95052']="Updated data exists, Please save it first.";
  msgs['BKG95053']="There is no data to Save. Please check again.";
  msgs['BKG95054']="There is modified data. Do you want to continue?";
  msgs['BKG95055']="You can\'t delete this data.\nHard Coding Contents table data should be deleted first.";
  msgs['BKG95056']="Data changed. Do you want to continue ?";
  msgs['BKG95057']="Can not copy the Row Data. These is exist only Header";

  msgs['BKG08320'] = "B/L Data Complete information is not ready";
  msgs['BKG43055'] = "Customer [{?msg1}] has a financial risk. Pls check with Accounting/Sales parts before D/O release.{?msg2}";	//2014-10-14 An Jin Eung Add


  msgs['BKG43060'] = "Please check Manual Booking Option of the Office.";	//2014-11-20 In Sun Jung Add
  msgs['BKG43061'] = "Port and Equalization Port are the same. Please check again";	//2014-12-23 In Sun Jung Add
  msgs['BKG43062'] = "There are Container No that have no data. Please check again."
  msgs['BKG43063']="Plase input \"{?msg1}\" to create Manual Booking Number!" //2015-01-06 In Sun Jung Add
  msgs['BKG43064']="\"{?msg1}\" is Required." //2015-01-20 In Sun Jung Add
  msgs['BKG43065']="\"{?msg1}\" already exists." //2015-01-28 In Sun Jung Add

  msgs['BKG43056']="{?msg1} exceeded field row ({?msg2})"

  msgs['BKG08321'] = "Unable to transmit due to missing of PSA Voyage No. Please set the PSA Voyage first";
  msgs['BKG08322'] = "Country SEQ and minimum 1 character of Name or Address is mandatory";

  msgs['BKG08323'] = "Ship Party-[{?msg1}] exceed  line(Name:2, Addr:3 line). When upload, overflowed data will be deleted. Please adjust data layout here or make sure to update it  later on. ";
  msgs['BKG08324'] = "There is no Container information. Please send me Cancel Copy Data of CM Tab";
  msgs['BKG08325'] = "Office code already associated with e-Signature";
  msgs['BKG08326'] = "O/BL receipt update, Complete IVC, Freight update are not allowed for {?msg1} destination cargo.\nplease use {?msg2} cargo release to update it. ({?msg3})";
  msgs['BKG08327'] = "If Booking is created or EDI ID is WEB, then it's impossible to Rereoute data.";
  msgs['BKG08328'] = "SI re-routing is not allowed";
  msgs['BKG08329'] = "Cannot re-route rejected or deleted booking.";
  msgs['BKG08330'] = "There is no corresponding data.\nYou have to add a new provision first at {?msg1}.";
  msgs['BKG08331'] = "Please input the Dangerous Cargo Application first.";
  msgs['BKG08332'] = "The B/L({?msg1}) does not have an ack message from customs. For Germany, you must wait for ack before retransmitting";
  msgs['BKG08333'] = "The B/L({?msg1}) does not have an ack message from customs, do you want to retransmit it?";
  msgs['BKG08334'] = "Error occured.({?msg1})";
  msgs['BKG08335'] = "You cannot select rate including mixed currencies because 'Break Down' is unticked. Please tick that check box.";
  msgs['BKG08336'] = "RFA only allows 'Break Down' status.";
  msgs['BKG08337'] = 'Container Vol. cannot exceed more then {?msg1} containers planned TO Japan({?msg2}). \nPlease check Total Vol of container. ';
  msgs['BKG08338'] = "Please click the Check Box.\n[either ' M&D ( Print ) ' or ' C/M ( Print ) ']";

  msgs['BKG08339'] = "BKG PTY customer code is not available"
  msgs['BKG08340'] = "TAA only allows 'Break Down' status.";

  msgs['BKG08341'] = "There is no VGM of BKG {?msg1}";
  msgs['BKG08342'] = "Cannot proceed with BKG {?msg1}.\nIt is not able to use EDI button after VGM Close.";
  msgs['BKG08343'] = "VGM CLOSE is successfully completed.\nCLL screen will be opened to send EDI.";
  msgs['BKG08344'] = "There is a container which doesn't have Seal# or Package.\n\n{?msg1}\n\nPlease untick these containers, if you would like to disregarding these containers.\nIf not, manifest will be submitted without seal # or Package information.";
  msgs['BKG08345'] = "To proceed with CLL, VGM should be declared.\n Would you like to declare VGM?";
  msgs['BKG08346'] = "Declared VGM cannot be updated when there is no Latest VGM";
  msgs['BKG08347'] = "Manual EDI is not able to use when there is no Declared VGM among containers of Booking you selected";
  msgs['BKG08348'] = "When the country of POL in search condition is 'KR', Local and T/S cannot be mixed\nPlease retrieve again with Local or T/S in L/T.";
  msgs['BKG08349'] = "($s) is not able to close VGM since there is a container which doesn't have 'Latest VGM'.";
  msgs['BKG08350'] = "Third PPD office must be different from Third CCT office.";
  msgs['BKG08351'] = "CLL is not able to use when search for multi BKG is used.";
  msgs['BKG08352'] = "When Marine Pollutant is 'Y', please enter Technical Name to save booking. {?msg1}";
  msgs['BKG08353'] = "To proceed with Manual EDI, VGM should be declared.\n Would you like to declare VGM?";
  msgs['BKG08354'] = "Are you sure to release damage container?";
  msgs['BKG08355'] = "ZIP code of [{?msg1}] should be 5-digit number when Location is US.";
  msgs['BKG08356'] = "Booking Number is changed. Please search first.";
  msgs['BKG08357'] = "The customer code {?msg1} is currently set to BL Group in eCommerce. \nBefore removing the customer code from BL Group in OPUS CNTR, the customer code should be excluded from BL Group in eCommerce first."
  msgs['BKG08358'] = "There is a percent base charge for Vietnam Tax as 3rd({?msg1}), please inform 3rd Payer Office to add in manually. \nDo you want to save your change(s)?";
  msgs['BKG08359'] = "There is a charge for Vietnam Tax, but payment office is not Vietnam. Please check prepaid office. \nPlease delete the {?msg1} Charge(s).";
  msgs['BKG08360'] = "There is a charge for Vietnam Tax, but payment office is not Vietnam. Please check collect office. \nPlease delete the {?msg1} Charge(s).";
  msgs['BKG08361'] = "There is a percent base charge for Vietnam Tax as 3rd({?msg1}), please inform 3rd Payer Office to add in manually. \nDo you want to save changed information in 'Hide' column?";
  msgs['BKG08362'] = "There is a charge for Vietnam Tax, but payment office is not Vietnam. Please check prepaid office. \nPlease delete the {?msg1} Charge(s).";
  msgs['BKG08363'] = "There is a charge for Vietnam Tax, but payment office is not Vietnam. Please check collect office. \nPlease delete the {?msg1} Charge(s).";
  msgs['BKG08364'] = "The Bay Plan of the Last Foregin POL you selected does not exist. Please contact the PIC of Bay Plan.";
  msgs['BKG08365'] = "Do you want to transmit FTP ?";
  msgs['BKG08366'] = "Please register the FTP to Controlling Party Setup!";
  msgs['BKG08367'] = "FTP was transmitted successfully.";
  msgs['BKG08368'] = "Total void space of {?msg1} and AK Q’ty is different. \nDo you want to update void space according to Over Dimension? ";
  msgs['BKG08369'] = "Reference number is invalid for the BL hence it is not FTP to customer, please check with the customer";
  msgs['BKG08370'] = "Invalid HS Code {?msg1} - Please check Effective Date.\nNevertheless, would you continue to proceed?"
	  
  /****************************************************************************************************************************************
    BOOKING INBOUND ERROR MESSABE END
****************************************************************************************************************************************/
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
   * @return 없음.
    * @author 박성수
    * @version 2009.04.22
   */
  function ComBkgXml2ComboItem(xmlStr, cmbObj, codeCol, textCol, bClear) {
      if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "")  return;
      if (codeCol == null || codeCol == "" || textCol == null || textCol == "")  return;

      try {
          cmbObj.RemoveAll();
          var xmlDoc = ComGetXmlDoc(xmlStr);
          if (xmlDoc == null) return;
          var xmlRoot = xmlDoc.documentElement;

          var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
          if (dataNode == null || dataNode.attributes.length < 3) {
              return;
          }
          var col=dataNode.getAttribute("COLORDER");
          var colArr=col.split("|");
          var sep=dataNode.getAttribute("COLSEPARATOR");
          var total=dataNode.getAttribute("TOTAL");
          var dataChildNodes=dataNode.childNodes;
          if (dataChildNodes == null)  return;

          var colListIdx=Array();
          for ( var i=0; i < colArr.length; i++) {
              if (colArr[i] == codeCol) {
                  colListIdx[0]=i;
              }
              if (colArr[i] == textCol) {
                  colListIdx[1]=i;
              }
          }
          for ( var i=0; i < dataChildNodes.length; i++) {
              if (dataChildNodes[i].nodeType != 1)  continue;

              var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
              var item=arrData[colListIdx[0]] + "|" + arrData[colListIdx[1]];
              cmbObj.InsertItem(i, item, arrData[colListIdx[0]]);

          }
      } catch (err) {
          ComFuncErrMsg(err.message);
      }
  }

  function ComBkgXml2ComboItem2(xmlStr, cmbObj, codeCol, textCol, bClear) {
      if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "")  return;
      if (codeCol == null || codeCol == "" || textCol == null || textCol == "")  return;

      try {
          cmbObj.RemoveAll();
          var xmlDoc = ComGetXmlDoc(xmlStr);
          if (xmlDoc == null) return;
          var xmlRoot = xmlDoc.documentElement;

          var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
          if (dataNode == null || dataNode.attributes.length < 3) {
              return;
          }
          var col=dataNode.getAttribute("COLORDER");
          var colArr=col.split("|");
          var sep=dataNode.getAttribute("COLSEPARATOR");
          var total=dataNode.getAttribute("TOTAL");
          var dataChildNodes=dataNode.childNodes;
          if (dataChildNodes == null)  return;

          var colListIdx=Array();
          for ( var i=0; i < colArr.length; i++) {
              if (colArr[i] == codeCol) {
                  colListIdx[0]=i;
              }
              if (colArr[i] == textCol) {
                  colListIdx[1]=i;
              }
          }
          for ( var i=0; i < dataChildNodes.length; i++) {
              if (dataChildNodes[i].nodeType != 1) {
                  continue;
              }
              var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
              cmbObj.InsertItem(i, arrData[colListIdx[1]], arrData[colListIdx[0]]);
          }
      } catch (err) {
          ComFuncErrMsg(err.message);
      }
  }
  /**
   *   jsp에서 페이지 최초 로딩시 아래와 같이 combo를 위한 값을 구성하고 script에서 multi combo에 값을 assign 하고자 할경우
   *   그 값을 파싱해 multi combo에 assign 해준다.
   *   JSP의 Value 예시)
   *    var appOfcCdComboText = "HAMUR  EUROPE REGIONAL HEADQUARTERS|NYCNA  AMERICA REGIONAL HEADQUARTERS|SAOBB San Paulo Branch Office|SELSKM  KEY ACCOUNT GROUP|SELSTA    Trans-pacific Trade Group|SELSTE    European Trade Group|SELSTI Intra-Asia Trade Group|SHAAS    ASIA REGIONAL HEADQUARTERS";
   *    var appOfcCdComboValue = "HAMUR|NYCNA|SAOBB|SELSKM|SELSTA|SELSTE|SELSTI|SHAAS";
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
   *                 <BR> 예) "HAMUR|NYCNA|SAOBB|SELSKM|SELSTA|SELSTE|SELSTI|SHAAS";
   * @param {string} textStr MultiCombo에 assign될 rowSeparator과 colSeparator로 구분된 Text String
   *                 <BR> combo를 다중컬럼으로 보여줄경우 colSeparator로 구분해서 값을 구성한다.
   *                 <BR> 예) 1. 하나의 컬럼일경우 textStr값
   *                            "Trade Profit|Office Profit";
   *                 <BR>     2. 다중컬럼으로 구성했을경우 textStr값
   *                 <BR>       이때의 rowSeparator는 '|'이되고 colSeparator는 '\t"가 된다.
   *                              "HAMUR    EUROPE REGIONAL HEADQUARTERS|NYCNA  AMERICA REGIONAL HEADQUARTERS|SAOBB San Paulo Branch Office|SELSKM  KEY ACCOUNT GROUP|SELSTA    Trans-pacific Trade Group|SELSTE    European Trade Group|SELSTI Intra-Asia Trade Group|SHAAS    ASIA REGIONAL HEADQUARTERS";
   *
   * @param {object} cmbObj 해당 ComboObject
   * @param (stirng) rowSeparator code,text에서 공통으로 쓰이는 구분자로 combo의 row를 구분하는 구분자 default : '|'
   * @param (stirng) colSeparator combo의 text에서만 사용하는 구분자로 다중컬럼을 보여줄때 각 컬럼의 값을 구분하는 구분자다 default : '\t'
   * @param (stirng) showCellIdx  textStr의 값은 colSeparator로 구분된 여러 값이 들어 있으나 다중컬럼으로 보여주지 않고
   *                 <BR>  showCellIdx번째 cell을 보여주고자 할때 사용한다., 0부터 시작,  default : 넘어온 textStr의 컬럼 갯수만큼 컬럼을 보여줌
   * @author 송민석
   * @version 2009.08.14
   */
function ComBkgTextCode2ComboItem(codeStr,textStr, cmbObj,rowSeparator,colSeparator,showCellIdx ){
        if( rowSeparator  == undefined ){
            rowSeparator="|"
        }
        if( colSeparator  == undefined ){
            colSeparator="\t"
        }
        var isSplit=true;
        var isShowSpclCol=false;
        var arrCode=codeStr.split(rowSeparator);
        var arrText=textStr.split(rowSeparator);
        if( colSeparator == "|"){
            isSplit=false;
        }
        if( showCellIdx != undefined && ( ComIsNumber(showCellIdx) ||  showCellIdx == "0")
                && showCellIdx < (arrText[0].split(colSeparator)).length ){
            isShowSpclCol=true;
        }
        for(var idx=0;idx < arrCode.length; idx++ ){
            var text=arrText[idx];
            //특정 Text값을 보여준다.
            if( isShowSpclCol ){
                text=text.split(colSeparator)[showCellIdx];
            }else if( isSplit ){
                text=text.replace(colSeparator,"|");
            }
            cmbObj.InsertItem(-1, text, arrCode[idx]);
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
        for (var i=0, n=comboObjs.length ; i < n ; i++) {
            if (comboObjs[i].options.id == objId) {
                return comboObjs[i];
            }
        }
    }
    return null;
}
 /**
  * Vessel code 및 SKD 조회 선택 팝업 호출. <br>
  * <br><b>Example :</b>
  * <pre>
  *     comBkgCallPop0019(callback_func, vvd);
  * </pre>
  * @param {string} 팝업 값 select시 호출되어져야 할 self func명</br>
  * @param {string} 입력 vvd
  * @param {string} 입력 pol_cd
  * @param {string} 입력 pod_cd
  * @return 없음
  * @author 김기종
  * @version 2009.05.06
  */
 function comBkgCallPop0019(callback_func,vvd,pol_cd,pod_cd , type){
	 if( type == undefined)  type = true;
   var param="?pgmNo=ESM_BKG_0019&vvd="+vvd+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd;
   ComOpenPopup("ESM_BKG_0019POP.do"+param, 900, 550, callback_func, "1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1", type);
 }
/**
 * Awkward 팝업 호출<br>
 * <br><b>Example :</b>
 * <pre>
 *     comBkgCallPop0055(bkgNo, caFlg);
 * </pre>
 * @param  bkgNo
 * @param  caFlg
 * @return 없음
 * @author 이남경
 * @version 2009.12.14
 */
function comBkgCallPop0055(bkgNo, caFlg){
    var param="?pgmNo=ESM_BKG_0055&bkg_no="+bkgNo + "&ca_flg="+caFlg;
    var sUrl="ESM_BKG_0055.do"+param;
    ComOpenWindowCenter(sUrl, "ESM_BKG_0055", 1020, 550, true);
}
 /**
  * Booking Creation화면 호출<br>
  * <br><b>Example :</b>
  * <pre>
  *     comBkgCall0079(bkgNo);
  * </pre>
  * @param  bkgNo
  * @return 없음
  * @author 류대영
  * @version 2010.03.17
  */
function ComBkgCall0079(bkgNo){
 	var sUrl="/opuscntr/ESM_BKG_0079.do";
 	sUrl += "?parentPgmNo=ESM_BKG_M001";
 	sUrl += "&pgmUrl=^opuscntr^ESM_BKG_0079.do";
 	sUrl += "&mainPage=true&pgmNo=ESM_BKG_0079"+bkgNo;
 	sUrl += "&bkg_no="+bkgNo
 	window.open(sUrl, "ESM_BKG_0079"+bkgNo);
 	//ComOpenWindowCenter(sUrl, "ESM_BKG_0079"+bkgNo, 1024, 730, true, 'yes');
}

/**
 *
 * @param bkgNo
 * @returns
 */
function ComBkgCall0079Q(bkgNo){
 	var sUrl="/opuscntr/ESM_BKG_0079_Q.do";
 	sUrl += "?parentPgmNo=ESM_BKG_M001";
 	sUrl += "&pgmUrl=^opuscntr^ESM_BKG_0079_Q.do";
 	sUrl += "&mainPage=true&pgmNo=ESM_BKG_0079_Q"+bkgNo;
 	sUrl += "&bkg_no="+bkgNo
 	window.open(sUrl, "ESM_BKG_0079_Q"+bkgNo);
}

    /**
     * Container Type/Size 선택 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0080(callback_func, cntr_tpsz_cd);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func</br>
     * @param  {string}입력 cntr_tpsz_cd
     * @return 없음
     * @author 김기종
     * @version 2009.05.06
     */
    function comBkgCallPop0080(callback_func,cntr_tpsz_cd){
      ComOpenPopup("ESM_BKG_0080.do?pgmNo=ESM_BKG_0080&searcheKeyOpener="+cntr_tpsz_cd , 400, 470, callback_func, "1,0,1,1,1", true);
    }
    /**
     * Booking Creation 1_MT P/UP CY inquiry 선택 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0082(callback_func, callSheetIdx,yd_cd);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func</br>
     * @param (string) ref sheet index</br>
     * @param {string} 입력 cntr_tpsz_cd
     * @return 없음
     * @author 김기종
     * @version 2009.05.06
     */
    function comBkgCallPop0082(callback_func,callSheetIdx,yd_cd){
      ComOpenPopup("ESM_BKG_0082.do?pgmNo=ESM_BKG_0082&searcheKeyOpener="+yd_cd+"&callSheetIdx="+callSheetIdx, 850, 550, callback_func, "none", true);
    }
     /**
      * Node Search 팝업 호출. <br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallPop0083('callBack0083','POR',porCd,porYdCd);
      * </pre>
      * @param {string} 팝업 값 select시 호출되어져야 할 self func
      * @param {string} locTp
      * @param {string} locCd
      * @param {string} ydCd
      * @param {string} rdTerm
      * @param {string}
      * @return 없음
      * @version 2009.08.06
      */
     function comBkgCallPop0083(callback_func, locTp, locCd, ydCd, rdTerm){
         ComOpenPopup("ESM_BKG_0083.do?pgmNo=ESM_BKG_0083&loc_tp="+locTp+"&loc_cd="+locCd+"&yd_cd="+ydCd+"&rd_term="+rdTerm, 1030, 450, callback_func,"1,0,1,1,1", true);
     }
    /**
     * Return CY Inquiry. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0082(callback_func, yd_cd);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func</br>
     * @param {string} 입력 yd_cd
     * @return 없음
     * @author 김기종
     * @version 2009.05.06
     */
    function comBkgCallPop0088(callback_func,yd_cd){
      ComOpenPopup("ESM_BKG_0088.do?pgmNo=ESM_BKG_0088&searcheKeyOpener="+yd_cd, 630, 400, callback_func, "1,0,1,1,1,1", true);
    }
     /**
      * Bulk 팝업 호출<br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallPop0106(bkgNo, caFlg);
      * </pre>
      * @param  bkgNo
      * @param  caFlg
      * @return 없음
      * @author 이남경
      * @version 2009.12.14
      */
     function comBkgCallPop0106(bkgNo, caFlg){
         var param="?pgmNo=ESM_BKG_0106&bkg_no="+bkgNo + "&ca_flg="+caFlg;
         var sUrl="ESM_BKG_0106.do"+param;
         ComOpenWindowCenter(sUrl, "ESM_BKG_0106", 1020, 605, true);
     }
     /**
      * Danger 팝업 호출<br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallPop0200(bkgNo, caFlg);
      * </pre>
      * @param  bkgNo
      * @param  caFlg
      * @return 없음
      * @author 이남경
      * @version 2009.12.14
      */
     function comBkgCallPop0200(bkgNo, caFlg){
         var param="?pgmNo=ESM_BKG_0200&bkg_no="+bkgNo + "&ca_flg="+caFlg;
         var sUrl="ESM_BKG_0200.do"+param;
         ComOpenWindowCenter(sUrl, "ESM_BKG_0200", 1020, 510, true);
     }
     /**
      * Booking TRO - T1 and Revenue Infomation <br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallPop0317(callback_func, bkg_no, t1_doc_flg, cstms_clr_no, all_in_rt_cd, curr_cd, trns_rev_amt, non_trns_rev_amt , add_rev_amt, add_rev_chg_cd, cxl_flg, term, vat_flg, hlg_tp_cd, io_bnd_cd, cfm_flg)
      * </pre>
      * @param {string, string, string, string, string, string, string}
      * @return 없음
      * @author 이남경
      * @version 2009.06.29
      */
     function comBkgCallPop0317(callback_func, bkg_no, t1_doc_flg, cstms_clr_no, all_in_rt_cd, curr_cd, trns_rev_amt, non_trns_rev_amt , add_rev_amt, add_rev_chg_cd, cxl_flg, term, vat_flg, hlg_tp_cd, io_bnd_cd, cfm_flg) {
         var param="?pgmNo=ESM_BKG_0317&bkg_no="+bkg_no;
         param += "&t1_doc_flg="+t1_doc_flg;
         param += "&cstms_clr_no="+cstms_clr_no;
         param += "&all_in_rt_cd="+all_in_rt_cd;
         param += "&curr_cd="+curr_cd;
         param += "&trns_rev_amt="+trns_rev_amt;
         param += "&non_trns_rev_amt="+non_trns_rev_amt;
         param += "&add_rev_amt="+add_rev_amt;
         param += "&add_rev_chg_cd="+add_rev_chg_cd;
         param += "&cxl_flg="+cxl_flg;
         param += "&term="+term;
         param += "&vat_flg="+vat_flg;
         param += "&hlg_tp_cd="+hlg_tp_cd;
         param += "&io_bnd_cd="+io_bnd_cd;
         param += "&cfm_flg="+cfm_flg;
         ComOpenPopup('ESM_BKG_0317.do'+param, 620, 460, callback_func, '1,0,1,1,1,1,1,1,1,1,1,1', false);
     }
     /**
      * Booking Notice Remark. <br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallPop0384(callback_func);
      * </pre>
      * @param {string} 팝업 값 select시 호출되어져야 할 self func</br>
      * @return 없음
      * @author 김기종
      * @version 2009.09.08
      */
     function comBkgCallPop0384(callback_func){
         ComOpenPopup("ESM_BKG_0384POP.do?pgmNo=ESM_BKG_0384", 620, 410, callback_func,"1,0,0,0,1,1", false);
      }
      /**
       * Reefer 팝업 호출<br>
       * <br><b>Example :</b>
       * <pre>
       *     comBkgCallPop0498(bkgNo, caFlg);
       * </pre>
       * @param  bkgNo
       * @param  caFlg
       * @return 없음
       * @author 이남경
       * @version 2009.12.14
       */
      function comBkgCallPop0498(bkgNo, caFlg){
          var param="?pgmNo=ESM_BKG_0498&bkg_no="+bkgNo + "&ca_flg="+caFlg;
          var sUrl="ESM_BKG_0498.do"+param;
          ComOpenWindowCenter(sUrl, "ESM_BKG_0498", 1020, 550, true);
      }
      /**
       * Booking History 팝업 호출<br>
       * <br><b>Example :</b>
       * <pre>
       *     comBkgCallPop0566(bkgNo);
       * </pre>
       * @param  bkg_no
       * @return 없음
       * @author 이남경
       * @version 2009.08.04
       */
      function comBkgCallPop0566(bkgNo,blNo){
          var param="?pgmNo=ESM_BKG_0566&bkg_no="+bkgNo+"&bl_no="+blNo;
          var sUrl="ESM_BKG_0566.do"+param;
          //ComOpenPopup('ESM_BKG_0566.do'+param, 900, 550, callback_func, '1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1', true);  //false
          ComOpenWindowCenter(sUrl, "ESM_BKG_0566", 1024,710, true);
      }
       /**
        * CA Inquiry Main 호출<br>
        * <br><b>Example :</b>
        * <pre>
        *     comBkgCallPop0567(bkgNo);
        * </pre>
        * @param  bkg_no
        * @return 없음
        * @author 이남경
        * @version 2009.08.28
        */
       function comBkgCallPop0567(bkgNo){
           var param="?bkg_no="+bkgNo+"&popFlg=N";
           var sUrl="ESM_BKG_0567.do"+param;
           ComOpenWindowCenter(sUrl, "ESM_BKG_0567", 1015, 710, true);
       }
        /**
         * CA Inquiry 팝업 호출<br>
         * <br><b>Example :</b>
         * <pre>
         *     comBkgCallPop0567_POP(bkgNo);
         * </pre>
         * @param  bkg_no

         * @return 없음
         * @author 이남경
         * @version 2009.08.28
         */
       function comBkgCallPop0567_POP(bkgNo){
           var param="?bkg_no="+bkgNo+"&popFlg=Y&pgmNo=ESM_BKG_0567";
           var sUrl="ESM_BKG_0567_POP.do"+param;
           ComOpenWindowCenter(sUrl, "ESM_BKG_0567_POP", 1015, 710, true);
       }
     /**
      * Customer Inquiry 팝업 호출. <br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallPop0652(callback_func, bkgCustTpCd, custCntCd, custSeq);
      * </pre>
      * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
      * @return 없음
      * @author 김병규
      * @version 2009.05.14
      */
     function comBkgCallPop0652(callback_func, bkgCustTpCd, custCntCd, custSeq, custNm){
     	ComOpenPopup("ESM_BKG_0652.do?pgmNo=ESM_BKG_0652&bkg_cust_tp_cd="+bkgCustTpCd+"&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm, 980, 540, callback_func,"0,1,1,1,1", true);
     }
    /**
     * Commodity Code를 입력하기 위해 Code를 검색. <br>
     * Model Popup으로 변경 - 김병규
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0653(callback_func, cmdt_cd);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func</br>
     * @param {string} 입력 yd_cd
     * @return 없음
     * @author 김기종
     * @version 2009.05.19
     */
    function comBkgCallPop0653(callback_func,cmdt_cd,rep_cmdt_cd,popName){
      var param="?pgmNo=ESM_BKG_0653&cmdt_cd="+cmdt_cd+"&rep_cmdt_cd="+rep_cmdt_cd;
      ComOpenPopup("ESM_BKG_0653.do"+param, 820, 500, callback_func, "1,0,1,1,1,1", true,true,0,0,0,popName);
    }
    /**
     * RFA Search 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0654(callback_func,bkgNo,bkgVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq,lodgDueDt,bkgStsCd);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
     * @return 없음
     * @author 김병규
     * @version 2009.07.22
     */
    function comBkgCallPop0654(callback_func,bkgNo,bkgVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq,lodgDueDt,bkgStsCd){
   	 if(bkgCtrlPtyCustCntCd == undefined){
   		 bkgCtrlPtyCustCntCd = '';
   	 }
   	 if(bkgCtrlPtyCustSeq == undefined){
   		 bkgCtrlPtyCustSeq = '';
   	 }
       ComOpenPopup("ESM_BKG_0654.do?pgmNo=ESM_BKG_0654&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&bkg_ctrl_pty_cust_cnt_cd="+bkgCtrlPtyCustCntCd+"&bkg_ctrl_pty_cust_seq="+bkgCtrlPtyCustSeq+"&lodg_due_dt="+lodgDueDt+"&bkg_sts_cd="+bkgStsCd, 860, 475, callback_func,"1,0", true);
    }
     /**
      * S/C Search 팝업 호출. <br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallPop0655(callback_func,bkgNo,bkgVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq,lodgDueDt,bkgStsCd);
      * </pre>
      * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
      * @return 없음
      * @author 김병규
      * @version 2009.07.22
      */
     function comBkgCallPop0655(callback_func,bkgNo,bkgVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq,lodgDueDt,bkgStsCd){
   	 if(bkgCtrlPtyCustCntCd == undefined){
    		 bkgCtrlPtyCustCntCd = '';
    	 }
    	 if(bkgCtrlPtyCustSeq == undefined){
    		 bkgCtrlPtyCustSeq = '';
    	 }
       ComOpenPopup("ESM_BKG_0655.do?pgmNo=ESM_BKG_0655&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&bkg_ctrl_pty_cust_cnt_cd="+bkgCtrlPtyCustCntCd+"&bkg_ctrl_pty_cust_seq="+bkgCtrlPtyCustSeq+"&lodg_due_dt="+lodgDueDt+"&bkg_sts_cd="+bkgStsCd, 1024, 480, callback_func,"1,0,1,1,1", true);
     }
       /**
       * RFA Commodity 팝업 호출. <br>
       * <br>
       * <b>Example :</b>
       *
       * <pre>
       * comBkgCallPop0656(ccallback_func, rfaNo, bkgNo, bkgVvd, porCd, delCd);
       * </pre>
       *
       * @param {string}
       *            팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
       * @return 없음
       * @author 김병규
       * @version 2009.07.22
       */
    function comBkgCallPop0656(callback_func, rfaNo, bkgNo, bkgVvd, porCd, delCd) {
       	if(bkgVvd.length!=9) bkgVvd = "";
       	ComOpenPopup("ESM_BKG_0656.do?bkg_no=" + bkgNo + "&bkg_vvd=" + bkgVvd + "&por_cd=" + porCd + "&del_cd=" + delCd + "&rfa_no=" + rfaNo, 700, 450, callback_func, "1,0", true);
    }
     /**
      * S/C Commodity 팝업 호출. <br>
      * <br>
      * <b>Example :</b>
      *
      * <pre>
      * comBkgCallPop0657(ccallback_func, scNo, bkgNo, bkgVvd, porCd, delCd);
      * </pre>
      *
      * @param {string}
      *            팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
      * @return 없음
      * @author 김병규
      * @version 2009.07.22
      */
     function comBkgCallPop0657(callback_func, scNo, bkgNo, bkgVvd, porCd, delCd) {
		if(bkgVvd.length!=9) bkgVvd = "";
		ComOpenPopup("ESM_BKG_0657.do?bkg_no=" + bkgNo + "&bkg_vvd=" + bkgVvd + "&por_cd=" + porCd + "&del_cd=" + delCd + "&sc_no=" + scNo, 850, 420, callback_func, "1,0", true);
     }
     /**
     * Stop Off Cargo Order 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0658(callback_func);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function comBkgCallPop0658(callback_func){
      ComOpenPopup("ESM_BKG_0658.do?pgmNo=ESM_BKG_0658",540, 300, callback_func,"1,0,1,1,1", true);
    }
     /**
     * Package Code 및 Description을 검색 및 조회. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0696(callback_func, pck_nm);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func</br>
     * @param {string} 입력 pck_no
     * @return 없음
     * @author 김기종
     * @version 2009.05.19
     */
    function comBkgCallPop0696(callback_func,pck_no){
   	 	ComOpenPopup("ESM_BKG_0696POP.do?pgmNo=ESM_BKG_0696&searcheKeyOpener="+pck_no, 600, 450, callback_func,"1,0", true);
    }
    function comBkgCallModal0696(callback_func,pck_no){
        ComOpenPopup("ESM_BKG_0696POP.do?pgmNo=ESM_BKG_0696&searcheKeyOpener="+pck_no, 600, 460, callback_func, "1,0", true);
    }
    /**
     * Cargo Closing Time 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0721(callback_func,bkgNo);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function comBkgCallPop0721() {
    	var formObj=document.form;
    	var param="?bkg_no=" + formObj.bkg_no.value;
    	ComOpenWindowCenter("/opuscntr/ESM_BKG_0721.do" + param, "PopupEsmBkg0721", 900, 390, true);
    }
    /**
     * BDR Booking No Status - Inquiry를 검색. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0727(callback_func,vvd_cd,pol_cd,pod_cd);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func</br>
     * @param {string} 입력 vvd_cd,pol_cd,pod_cd
     * @return 없음
     * @author 김기종
     * @version 2009.08.14
     */
    function comBkgCallPop0727(callback_func,vvd_cd,pol_cd,pod_cd){
        var param="?pgmNo=ESM_BKG_0727&vvd_cd="+vvd_cd +"&pol_cd="+pol_cd+"&pod_cd="+pod_cd;
        ComOpenPopup("ESM_BKG_0727POP.do"+param, 750, 320, callback_func,"0,1,1,1,1,1", false);
     }
       /**
        * Harmonized Tariff Code 선택 팝업 호출. <br>
        * <br><b>Example :</b>
        * <pre>
        *     comBkgCallPop0607(callback_func, hamo_trf_cd);
        * </pre>
        * @param {string} 팝업 값 select시 호출되어져야 할 self func</br>
        * @param {string} 입력 cntr_tpsz_cd
        * @return 없음
        * @author 김기종
        * @version 2009.05.06
        */
       function comBkgCallPop0607(callback_func,hamo_trf_cd){
         ComOpenPopup("ESM_BKG_0607_POP.do?pgmNo=ESM_BKG_0607&hamo_tp_cd="+hamo_trf_cd, 1010, 590, callback_func, "1,0,1,1,1", false);
       }
       function comBkgCallPop0607(callback_func,hamo_tp_cd,hamo_trf_cd){
           var param="?pgmNo=ESM_BKG_0607&hamo_tp_cd="+hamo_tp_cd+"&hamo_trf_cd="+hamo_trf_cd;
           ComOpenPopup("ESM_BKG_0607_POP.do"+param, 1010,590, callback_func, "1,0,1,1,1", false);
       }
    /**
     * C/A Issue Reason Selection 팝업 호출<br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0708('setCAIssueCallBack',  bkgNo, modeCd);
     *     comBkgCallPop0708('setCAReasonCallBack', bkgNo, modeCd);
     *     modeCd : S->StartCA, R->Reason
     * </pre>
     * @param  bkg_no
     * @return 없음
     * @author 이남경
     * @version 2009.08.31
     */
    function comBkgCallPop0708(callback_func, bkgNo, modeCd){
        var param="?pgmNo=ESM_BKG_0708&bkg_no="+bkgNo;
        param    += "&mode_cd="+modeCd;
        var sUrl="ESM_BKG_0708.do"+param;
        ComOpenPopup(sUrl, 500, 450, callback_func, '1,0,1,1,1', true);
    }
    /**
     * Booking TRO_TRO-Container Inquiry 선택 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0907('setCntrNoCallBack', bkg_no, io_bnd_cd);
     *     comBkgCallPop0907(callback_func, bkg_no, io_bnd_cd);
     * </pre>
     * @param {string, string, string} 팝업 값 select시 호출되어져야 할 self func, 입력param:bkg_no, 입력param:io_bnd_cd
     * @return 없음
     * @author 이남경
     * @version 2009.04.30
     */
    function comBkgCallPop0907(callback_func, bkg_no, io_bnd_cd){
      var param="?pgmNo=ESM_BKG_0907&bkg_no="+bkg_no+"&io_bnd_cd="+io_bnd_cd;
      ComOpenPopup('ESM_BKG_0907.do'+param, 750, 420, callback_func, '1,0,1,1,1,1,1,1,1,1,1,1', false);
    }
    /**
     * Booking TRO_Actual Customer 선택 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0905('setActCustCallBack', conti_cd, cnt_cd, bkg_no, dor_loc_cd, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm);
     *     comBkgCallPop0905(callback_func, conti_cd, cnt_cd, bkg_no, dor_loc_cd, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm);
     * </pre>
     * @param {string, string, string} 팝업 값 select시 호출되어져야 할 self func, 입력param:conti_cd(대륙코드), 입력param:cnt_cd(por국가코드)
     * @return 없음
     * @author 이남경
     * @version 2009.05.20
     */
    function comBkgCallPop0905(callback_func, conti_cd, cnt_cd, bkg_no, dor_loc_cd, act_shpr_cnt_cd, act_shpr_seq, act_shpr_nm,type) {
        var param="?pgmNo=ESM_BKG_0905&conti_cd="+conti_cd;
        param += "&cnt_cd="+cnt_cd;
        param += "&bkg_no="+bkg_no;
        param += "&dor_loc_cd="+dor_loc_cd;
        param += "&act_shpr_cnt_cd="+act_shpr_cnt_cd;
        param += "&act_shpr_seq="+act_shpr_seq;
        param += "&act_shpr_nm="+encodeURI(act_shpr_nm);
        param += "&type="+type;
        ComOpenPopup('ESM_BKG_0905.do'+param, 1200, 520, callback_func, '1,0,1,1,1,1,1,1,1,1,1,1', true);   // false
    }
     /**
      * Booking TRO_Copy 팝업 호출<br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallPop0920('setTroCopy', bkgNo, boundCd, troSeq);
      * </pre>
      * @param {string, string, string, string} callback용 func, bkgNo, boundCd, troSeq, uiId
      * @return 없음
      * @author 이남경
      * @version 2009.07.28
      */
    function comBkgCallPop0920(callback_func, bkgNo, boundCd, troSeq, uiId) {
        var param="?pgmNo=ESM_BKG_0920&bkg_no="+bkgNo;
        param += "&io_bnd_cd="+boundCd;
        param += "&tro_seq="+troSeq;
        param += "&ui_id="+uiId;
        ComOpenPopup('ESM_BKG_0920.do'+param, 316, 340, callback_func, '1,0,1,1', true);
    }
      /**
       * B/L Preview 팝업 호출<br>
       * <br><b>Example :</b>
       * <pre>
       *     comBkgCallPop0927(bkgNo, blNo);
       * </pre>
       * @param  bkg_no
       * @param  blNo
       * @return 없음
       * @author 이남경
       * @version 2009.12.11
       */
     function comBkgCallPop0927(bkgNo, blNo){
            var blTpCd="W";
            if (blNo.substring(blNo.length-1, blNo.length) != "W") {
                blTpCd="D";
            }
            var param="bkg_no="   +bkgNo+
                        "&bl_no="   +blNo+
                        "&bl_tp_cd="+blTpCd+
                        "&pgmNo=ESM_BKG_0927";
            //@ 타이틀 미 표기로 수정 2014.10.22
            ComOpenWindow("ESM_BKG_0927_POP.do?" + param, "PopupEsmBkg0927", "width=916, height=750, scrollbars=no, resizable=yes", false);
     }
     /**
      * TAA Search 팝업 호출. <br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallPop1062(callback_func,bkgNo,bkgVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,lodgDueDt,bkgStsCd);
      * </pre>
      * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
      * @return 없음
      * @author 김병규
      * @version 2009.07.22
      */
     function comBkgCallPop1062(callback_func,bkgNo,bkgVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq,bkgCtrlPtyCustCntCd,bkgCtrlPtyCustSeq,lodgDueDt,bkgStsCd){
    	 if(bkgCtrlPtyCustCntCd == undefined){
    		 bkgCtrlPtyCustCntCd = '';
    	 }
    	 if(bkgCtrlPtyCustSeq == undefined){
    		 bkgCtrlPtyCustSeq = '';
    	 }
        ComOpenPopup("ESM_BKG_1062.do?pgmNo=ESM_BKG_1062&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&s_cust_cnt_cd="+sCustCntCd+"&s_cust_seq="+sCustSeq+"&c_cust_cnt_cd="+cCustCntCd+"&c_cust_seq="+cCustSeq+"&bkg_ctrl_pty_cust_cnt_cd="+bkgCtrlPtyCustCntCd+"&bkg_ctrl_pty_cust_seq="+bkgCtrlPtyCustSeq+"&lodg_due_dt="+lodgDueDt+"&bkg_sts_cd="+bkgStsCd, 860, 475, callback_func,"1,0", true);
     }

     /**
      * CancellationMessage
      * @param callback_func
      * @param bkgNo
      * @param modeCd
      * @returns
      */
     function comBkgCallPop0620(callback_func){
         var param="?pgmNo=ESM_BKG_0620";
         var sUrl="ESM_BKG_0620.do"+param;
         ComOpenPopup(sUrl, 500, 460, callback_func, '1,0,1,1,1', true);
     }

     /**
      * TAA Commodity 팝업 호출. <br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallPop1078(ccallback_func,rfaNo,bkgNo,bkgVvd,porCd,delCd);
      * </pre>
      * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
      * @return 없음
      * @author 김병규
      * @version 2009.07.22
      */
     function comBkgCallPop1078(callback_func,taaNo,bkgNo,bkgVvd,porCd,delCd){
     	ComOpenPopup("ESM_BKG_1078.do?pgmNo=ESM_BKG_1078&bkg_no="+bkgNo+"&bkg_vvd="+bkgVvd+"&por_cd="+porCd+"&del_cd="+delCd+"&taa_no="+taaNo, 625, 497, callback_func,"1,0", true);
     }
     /**
      * EU DG Declare-Feeder Registry Pop-up 팝업 호출. <br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallPop1097(callback_func)
      * </pre>
      * @param
      * @return 없음
      * @author Maeda
      * @version 2015.03.31
      */
     function comBkgCallPop1097(callback_func){
    	 ComOpenPopup("ESM_BKG_1097.do", 800, 410, callback_func, "none", true);
     }
    /**
     * Booking Detail 팝업 호출<br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPopBkgDetail(bkgNo);
     * </pre>
     * @param  bkg_no
     * @return 없음
     * @author 김기종
     * @version 2009.09.30
     */
    function comBkgCallPopBkgDetail(bkgNo,bModal){

    	var sUrl="ESM_BKG_0079_Q_POP.do?pgmNo=ESM_BKG_0079_Q&bkg_no="+bkgNo;
//    	ComOpenWindow(sUrl, "PopupEsmBkg0927", "width=1250, height=750, scrollbars=no, resizable=yes", false);
    	if(bModal == undefined){
    		ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1250, 850, false, "yes");
    	}else{
    		ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1250, 850, bModal, "yes");
    	}
    }
     /**
      * Booking Detail 새창 호출<br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallBkgDetail(bkgNo);
      * </pre>
      * @param  bkg_no
      * @return 없음
      * @author 김기종
      * @version 2009.09.30
      */
	function comBkgCallBkgDetail(bkgNo){
		var sUrl="ESM_BKG_0079.do?&mainPage=true&pgmNo=ESM_BKG_0079&bkg_no=" + bkgNo;
    	window.open(sUrl);
	}
    /**
     * Booking Charge 팝업 호출<br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPopBkgCharge(bkgNo);
     * </pre>
     * @param  bkg_no
     * @return 없음
     * @author 김기종
     * @version 2009.09.30
     */
	function comBkgCallPopBkgCharge(bkgNo,bModal){
        var sUrl="ESM_BKG_0079_POP.do?pgmNo=ESM_BKG_0079&openTab=B9&bkg_no="+bkgNo;
    	if(bModal == undefined){
    		ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1250, 850, false, "yes");
    	}else{
    		ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1250, 850, bModal, "yes");
    	}
    }
    /**
     * Booking Spcl Application 팝업 호출<br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPopSpclAppication(spcl_cgo_type,bkgNo);
     * </pre>
     * @param  bkg_no
     * @return 없음
     * @author 김기종
     * @version 2009.09.30
     */
    function comBkgCallPopSpclAppication(spcl_cgo_type,bkgNo){
        var sUrl="";
        if (spcl_cgo_type == "AK"){
            sUrl="ESM_BKG_0055_POP.do?pgmNo=ESM_BKG_0055&bkg_no="+bkgNo;
        }else if (spcl_cgo_type == "BB"){
            sUrl="ESM_BKG_0106_POP.do?pgmNo=ESM_BKG_0106&bkg_no="+bkgNo;
        }else if (spcl_cgo_type == "DG"){
            sUrl="ESM_BKG_0200_POP.do?pgmNo=ESM_BKG_0200&bkg_no="+bkgNo;
        }else if (spcl_cgo_type == "RF"){
            sUrl="ESM_BKG_0498_POP.do?pgmNo=ESM_BKG_0498&bkg_no="+bkgNo;
        }
        //ComOpenWindow("opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^" + sUrl, "", "width=1024,height=768, resizable=yes, scrollbars=yes, status=no");
        ComOpenWindowCenter(sUrl, null, 1224, 768 );
    }
    /**
     * Special cargo type별 승인결과 조회화면 팝업 호출<br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPopSpclAppResult(bkgNo);
     * </pre>
     * @param  bkg_no
     * @return 없음
     * @author 김기종
     * @version 2009.09.30
     */
    function comBkgCallPopSpclAppResult(spcl_cgo_type,bkgNo,vsl_cd,skd_voy_no,skd_dir_cd){
        var height="1000";
        var width="450";
        var sUrl="&bkg_no="+bkgNo + "&vsl_cd="+vsl_cd +"&skd_voy_no="+skd_voy_no +"&skd_dir_cd="+skd_dir_cd;
        if (spcl_cgo_type == "AK"){
            ComOpenWindowCenter("VOP_SCG_1016.do?pgmNo=VOP_SCG_1016&scg_flg=AWK"+sUrl, "VOP_SCG_1016",height,width, false);
        }else if (spcl_cgo_type == "BB"){
            ComOpenWindowCenter("VOP_SCG_1017.do?pgmNo=VOP_SCG_1017&scg_flg=BB"+sUrl, "VOP_SCG_1017", height,width, false);
        }else if (spcl_cgo_type == "DG"){
            ComOpenWindowCenter("VOP_SCG_1015.do?pgmNo=VOP_SCG_1015&scg_flg=DG1"+sUrl, "VOP_SCG_1015", height,width, false);
        }else if (spcl_cgo_type == "RF"){
            ComOpenWindowCenter("VOP_SCG_1018.do?pgmNo=VOP_SCG_1018&scg_flg=RF"+sUrl, "VOP_SCG_1018",height,width, false);
        }
    }
    /**
     * Booking Office 팝업 호출<br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPopBkgOffice(bkgNo);
     * </pre>
     * @param  bkg_no
     * @return 없음
     * @author 김기종
     * @version 2009.09.30
     */
    function comBkgCallPopBkgOffice(bkgNo){
        var sUrl="ESM_BKG_0741.do?pgmNo=ESM_BKG_0741&bkg_no="+bkgNo;
        ComOpenWindowCenter(sUrl, "ESM_BKG_0741", "515","335", false);
    }
    /**
     * 링크를 강조한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgIndicateLink(sheetObj,"bkg_no");
     * </pre>
     * @param  {string, string)
     * @return 없음
     * @author 김기종
     * @version 2009.09.30
     */
    function comBkgIndicateLink(sheetObj,colName){
        with (sheetObj) {
            SetDataLinkMouse(colName,1);
            SetColFontUnderline(colName,1);
            SetColFontColor(colName,"#0000FF");
        }
    }
  /**
   * Save 후, 성공 메시지<br>
   * (그리드 여러개 처리시, 화면에서 제어위함)
   * @param    없음
   * @return   없음
    * @author  이남경
    * @version 2009.05.11
   */
  function ComBkgSaveCompleted() {
    ComShowCodeMessage('BKG00166');
  }
  function ComBkgDeleteCompleted() {
    ComShowCodeMessage('BKG00593');
  }
  /**
   * 필수입력체크 : (Caption명)메세지출력+컨트롤focus<br>
   *
   * @param    obj
   * @return   없음
    * @author  이남경
    * @version 2009.05.11
   */
  function ComBkgNessMessage(obj){
      ComShowCodeMessage("COM12200", obj.getAttribute("caption"));
      ComSetFocus(obj);
  }
    /**
     * HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 키보드로 입력되는 값을 영문대문자 또는 영문소문자로 자동 변경 제어한다. <br>
     * 예를 들어 다음과 같이 사용한다.<br>
     *     &lt;input type="text" name="txtName" <font color="red">style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')"</font>&gt; <br>
     * 인자로 사용되는 sFlag 인자의 설정값은 다음과 같다. <br>
     * sFlag = "upper"      : 영문대문자만 입력할수 있고, 대문자로 자동 변환된다. <br>
     * sFlag = "lower"      : 영문소문자만 입력할수 있고, 소문자로 자동 변환된다. <br>
     * sFlag = "uppernum"   : 영문대문자와 숫자만 입력할수 있고, 대문자로 자동 변환된다. <br>
     * sFlag = "lowernum"   : 영문소문자와 숫자만 입력할수 있고, 소문자로 자동 변환된다. <br>
     * sFlag = "num"        : 영문과 숫자 입력할수 있고, 자동 변환없이 그대로 표시한다. <br>
     * sFlag = 설정안한경우 : 영문만 입력할수 있고, 자동변환없이 그대로 표시한다. <br>
     * <font color="red">주의!</font> style="ime-mode:disabled"은 반드시 설정해야 기능이 정확히 처리된다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     &lt;input type="text" name="txtType" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('lower')"&gt;
     * </pre>
     * @param {string} sFlag 선택,영문모드, default=""
     * @returns 없음 <br>
     * @see #ComKeyAlphabetNChar
     */
    function ComKeyAlphabetNChar(sFlag)
    {
        try {
          var keyValue=ComGetEvent("keycode");
            var bCanNum=false;
            //ComDebug('key  = '+keyValue);
            if (sFlag==undefined || sFlag==null || sFlag.constructor!=String) sFlag="";
            sFlag=sFlag.toLowerCase();
            if (sFlag.length >= 3){
                if (sFlag.substr(sFlag.length-3)=="num") bCanNum=true;
                if (sFlag.length > 5) sFlag=sFlag.substr(0,5);
            }
            if(keyValue >= 97 && keyValue <= 122){                  //소문자
                if (sFlag=="upper") event.keyCode=keyValue + 65 - 97;
                event.returnValue=true;
            } else if(keyValue >= 65 && keyValue <= 90){            //대문자
                if (sFlag=="lower") event.keyCode=keyValue + 97 - 65;
                event.returnValue=true;
            } else if(bCanNum && keyValue >= 48 && keyValue <= 57) {//숫자
                event.returnValue=true;
            } else {
                event.returnValue=true;
            }
            return true;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
    * 반환받은 XML이 에러일 경우 SheetObj에 메시지를 보내고, false를 반환한다.
    * @author Park Mangeon
    * @param SheetObj
    * @param xmlStr
    * @return
    */
    function ComBkgErrMessage(SheetObj, xmlStr) {
        if (xmlStr == null  || xmlStr == "") return true;
        try {
            var vPrefix = xmlStr.substring(1, 6);
            if (vPrefix == "ERROR") {
                SheetObj.LoadSearchData(xmlStr, {Append:1, Sync:1});
                return false;
            } else {
                return true;
            }
        } catch(err) {ComFuncErrMsg(err.message);}
    }
    /**
     * 반환받은 XML이 에러일 경우 SheetObj에 메시지를 보내고, false를 반환한다.
     * (ComBkgErrMessage와 동일하나 LoadSearchData가 아닌 LoadSaveData를 사용
     *  - Err메세지후, 재조회 하지 않을 경우 이미 Sheet내에 존재하는 데이터에 문제가 발생하는 문제우회
     *  - 데이터가 분명 존재함에도 RowCount()가 0으로 인식된다던지..)
     * @author Park Mangeon
     * @param SheetObj
     * @param xmlStr
     * @return
     */
     function ComBkgErrMessage2(SheetObj, xmlStr) {
        if (xmlStr == null  || xmlStr == "") return true;
        try {
            var vPrefix = xmlStr.substring(1, 6);
            if (vPrefix == "ERROR") {
                SheetObj.LoadSaveData(xmlStr, {Append:1, Sync:1});
                return false;
            } else {
                return true;
            }
        } catch(err) {ComFuncErrMsg(err.message);}
    }
   /**
   * null을 blank("")로 변경<br>
   * @param   String
   * @return  String
   * @author  이남경
   * @version 2009.05.21
   */
   function nullToBlank(val) {
      return (val==null) ? "" : val;
   }
   /**
   * null을 특정문자로 변경<br>
   * @param   String
   * @return  String
   * @author  김병규
   * @version 2009.05.21
   */
   function BkgNullToString(val, str) {
       if(val == null || val.length < 1){
           return str;
       }else{
           return val;
       }
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
     * @param {string} dispCol 선택, 콤보에서 화면에 보여주는 코드값의 칼럼 val,desc 중 val값일 때 선택가능.
     * (코드|디스크립션 형태가 아닐 경우는 0으로 설정해야함)
     * @return
     * @author 공백진, jong 추가 수정
     * @version 2009.04.30
     */
    function setIBCombo(sheetObj, sXml, title, iBlank, sCol, dCode, dText, dispCol){
      var showCol=0;
       var bFlag=false;
       if (sCol != undefined && sCol !=""){
         showCol=sCol;
       }
       if (iBlank != undefined && iBlank !=""){
         bFlag=iBlank;
       }
       if (dispCol == undefined || dispCol ==""){
         dispCol="desc";
       }
      var arrData=ComBkgXml2ComboString(sXml, "val", dispCol);
      if (bFlag == true){
        arrData[1]=" \t |"+ arrData[1];
        arrData[0]=" |"+ arrData[0];
      }
      sheetObj.SetColProperty(title, {ComboText:arrData[1], ComboCode:arrData[0]} );
    }
    /**
     * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
     * IBSheet의 Combo에 연결할수 있는 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
     * Return되는 배열의 0번째는 Code문자열, 1번째는 Text문자열이 담겨있다.
     * <b>Example :</b>
     *
     * <pre>
     * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
     * var arrData = ComBkgXml2ComboString(xmlStr, &quot;cd&quot;, &quot;nm&quot;);
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
    function ComBkgXml2ComboString(xmlStr, codeCol, textCol) {
      var rtnArr=new Array();
      if (xmlStr == null || xmlStr == "") {
        return;
      }
      if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
        return;
      }
      try {
    	  var xmlDoc = ComGetXmlDoc(xmlStr);
    	  if (xmlDoc == null) return;
    	  var xmlRoot = xmlDoc.documentElement;

    	  var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);

        if (dataNode == null || dataNode.attributes.length < 3) {
          return;
        }
        var col=dataNode.getAttribute("COLORDER");
        var colArr=col.split("|");
        var sep=dataNode.getAttribute("COLSEPARATOR");
        var total=dataNode.getAttribute("TOTAL");
        var dataChildNodes=dataNode.childNodes;
        if (dataChildNodes == null) {
          return;
        }
        var colListIdx=Array();
        for (var i=0; i < colArr.length; i++) {
          if (colArr[i] == codeCol) {
            colListIdx[0]=i;
          }
          if (colArr[i] == textCol) {
            colListIdx[1]=i;
          }
        }
        var sCode="";
        var sText="";
        for (var i=0; i < dataChildNodes.length; i++) {
          if (dataChildNodes[i].nodeType != 1) {
            continue;
          }
          var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
          sCode += arrData[colListIdx[0]];
          sText += arrData[colListIdx[1]];
          if (i != dataChildNodes.length - 1) {
            sCode += "|";
            sText += "|";
          }
        }
        var sCodeEndChr = sCode.substring(sCode.length-1, sCode.length);
        var sCodelength = sCode.length;
        var sTextlength = sText.length;
        if(sCodeEndChr == "|"){
        	sCode=sCode.substring(0,sCodelength-1);
        	sText=sText.substring(0,sTextlength-1);
        }
        rtnArr.push(sCode);
        rtnArr.push(sText);
      } catch (err) {
        ComFuncErrMsg(err.message);
      }
      return rtnArr;
    }
    /*
    * 키입력시 마다 천단위 콤마를 찍는다.
    * 단 소수점 입력 지원은 하지 않습니다.
    * @param Object
    */
    function CommaInput(obj)
    {
      if (obj.value.substring(0,1) != "-") {
        obj.value=obj.value.replace(",","");
        rl=obj.value.length;
        l=obj.value.length-3;
        while(l > 0) {
          if(obj.value.substring(rl-1,1) == "."){
            return obj.value;
          }else {
            obj.value=obj.value.substr(0,l)+","+obj.value.substr(l);
            l-=3;
          }
        }
        return obj.value;
      }else {
        if (obj.value.length > 2) {
          f=obj.value.substring(1)
          f=obj.value.replace(/\D/g,"");
          l=obj.value.length-3;
          while(l > 0) {
          f=f.substr(0,l)+","+f.substr(l);
          l-=3;
          }
          obj.value="-"+f
        }
        return obj.value;
      }
    }
    /**
       * 소숫점이 포함된 수에 천단위의 콤마가 추가되는 메서드 <br>
       * <br><b>Example :</b>
       * <pre>
       *    CommaInputWithPoint( '23456.789', 3 );
       *    반환되는 값은 : 23,456.789
       * </pre>
       * @param String Type의 소숫점이 있거나 없는 수
       * @param Int Type의 소숫점 아래 자릿수의 갯수
       * @return 천단위의 콤마가 포함된 수
       * @author 정재엽
       * @version 2009.07.28
       */
      function CommaInputWithPoint( num, pointCnt )
      {
          var pointNum='';
          //num=num.replaceAll(",","");
          num=num.split(",").join("");
          var pointLoc=num.indexOf(".")
          if( pointLoc != -1 ){
            pointNum=num.substring(pointLoc, pointLoc + ( pointCnt + 1));
            num=num.substring(0, pointLoc);
          }
          var numLgt=num.length;
          var ptCnt=parseInt( numLgt/3 );
          var lest=numLgt%3 ;
          var numSum='';
          var arry=new Array();
          var tempLgt=0;
          //alert('ptCnt' + ptCnt);
          if( ptCnt>0 && lest != 0) ptCnt ++;
          for( var i=0; i<ptCnt; i++ ){
            arry[ptCnt-(i+1)]=num.substring( numLgt-3,numLgt );
            numLgt=numLgt-3;
          }
          if( arry.length != 0 ){
            for ( var j=0; j<arry.length; j ++ ){
                if(j!=0) numSum += ',';
                numSum += arry[j];
            }
          } else {
            numSum=num;
          }
          //alert(numSum);
          //return numSum + pointNum ; 123456789012
          return numSum + pointNum;
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
    function ComBkgXml2Array(xmlStr, colList) {
      var rtnArr=new Array();
      if (xmlStr == null || xmlStr == "" || colList == null || colList == "") {
        return;
      }
      try {
    	  var xmlDoc = ComGetXmlDoc(xmlStr);
    	  if (xmlDoc == null) return;
    	  var xmlRoot = xmlDoc.documentElement;

        var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
        if (dataNode == null || dataNode.attributes.length < 3) {
          return;
        }
        var col=dataNode.getAttribute("COLORDER");
        var colArr=col.split("|");
        var sep=dataNode.getAttribute("COLSEPARATOR");
        var total=dataNode.getAttribute("TOTAL");
        var dataChileNodes=dataNode.childNodes;
        if (dataChileNodes == null) {
          return;
        }
        var colListArr=colList.split("|");
        var colListIdx=Array();
        for (var i=0; i < colListArr.length; i++) {
          for (var j=0; j < colArr.length; j++) {
            if (colListArr[i] == colArr[j]) {
              colListIdx[i]=j;
              break;
            }
          }
        }
        for (var i=0; i < dataChileNodes.length; i++) {
          if (dataChileNodes[i].nodeType != 1) {
            continue;
          }
          var arrData=dataChileNodes[i].firstChild.nodeValue.split(sep);
          var subDataArr=new Array();
          var arrayCount = 0;
          for (var j=0; j < colListIdx.length; j++) {
            subDataArr[j]=arrData[colListIdx[j]];
          }
          rtnArr[i]=(subDataArr);
          arrayCount++;
        }
      } catch (err) {
        ComFuncErrMsg(err.message);
      }
      return rtnArr;
    }
    /**
       * input box  등 필수 값 입력 메세지<br>
       *
       * @param 메시지1, 메시지2, input box 등 object
       * @return 없음
        * @author 이승준
        * @version 2009.05.11
       */
      function ComBkgInputValueFailed(msg1,msg2,input) {
          ComShowCodeMessage("BKG95001",msg1,msg2);
          if(input != "")
              input.focus();
          return;
      }
      /**
       * 저장 등 여부를 묻는 메세지<br>
       *
       * @param 메시지1
       * @return 없음
        * @author 이승준
        * @version 2009.05.11
       */
      function ComBkgProcessYn(msg1) {
        return ComShowCodeConfirm("BKG95003",msg1);
      }
      /**
       * 저장 완료 등 종료 메세지<br>
       *
       * @param 메시지1
       * @return 없음
        * @author 이승준
        * @version 2009.05.11
       */
      function ComBkgProcessCompleted(msg1) {
        ComShowCodeMessage("BKG95004",msg1);
      }
      /**
       * 전체 Row 중에 Checkbox의 체크가 되어있는 Row들을 숨기고 상태를 삭제로 변경한다. <br>
       * check된 Checkbox가 없을 경우 현재 선택된 row를 삭제한다. (개발중)<br>
       * <br><b>Example :</b>
       * <pre>
       *     deleteRowCheck(sheetObj);
       *     deleteRowCheck(sheetObj, "sel_chk");
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {string} selColName 선택 화면에 보여지는 checkbox의 SaveName.
       *                               default="sel_chk"
       * @return 없음
       * @author 문동규
       * @version 2009.04.22
       */
      function deleteRowCheck(sheetObj, selColName) {
          if (arguments.length == 1) {
              selColName="sel_chk";
          }
          return ComRowHideDelete(sheetObj, selColName);
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
    	  var obj = ComGetObject(btnName);
    	  ComEnableObject(obj, true);
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
    	  var obj = ComGetObject(btnName);
    	  ComEnableObject(obj, false);
      }
      /**
       * Button Name으로 Button을 감싸고 있는 table element 를 찾는다. <br>
       *  <br>
       * <br><b>Example :</b>
       * <pre>
       *     getButtonTable("btn_Save");
       * </pre>
       * @param {string} btnName 필수 Button의 name
       * @return table element. 못찾을 경우 null을 return
       * @author 문동규
       * @version 2009.05.19
       */
      function getButtonTable(btnName) {
    	  return ComGetObject(btnName);
      }
     /**
       * Button Name으로 Button을 감싸고 있는 <TD> element 를 찾는다. <br>
       *  <br>
       * <br><b>Example :</b>
       * <pre>
       *     getBtnObject("btn_t6notupdated").style.color = "red";
       * </pre>
       * @param {string} btnName 필수 Button의 name
       * @return TD element. 못찾을 경우 null을 return
       * @author 김영출
       * @version 2009.04.20
       */
    function getBtnObject(btnName){
    	return ComGetObject(btnName);
    }
    /*
    * CheckBox 와 DataType같이 있을때 전체체크박스 선택/해제
    * @param sheet객체
    * @param true :전체선택 , false:전체해제
    * @param sheet colName명
    * @return
    * @author 최영희
    * @version 2009.06.04
    */
    function CellCheckAll(sheetObj,flag,colName){
    	if (sheetObj.SaveNameCol(colName) < 0 ) return;
    	sheetObj.CheckAll(colName, flag, 0);
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
          return (sheetObj.RowCount() - sheetObj.RowCount("D"));
      }
    /**
     * Radio Button 값가지고 오기
     * @param obj
     * @return
     */
    function getRadioValue(obj){
        if (obj.length != null) {
            for(var i=0; i<obj.length; i++) {
                if (obj[i].checked) {
                    return obj[i].value;
                }
            }
        } else {
            return obj.value;
        }
    }
    /**
     * Radio Button 값가지고 오기 - 체크 안되면 "" 리턴
     * @param obj
     * @return
     */
    function getRadioValue2(obj){
        var r_str="";
        if (obj.length != null) {
            for(var i=0; i<obj.length; i++) {
                if (obj[i].checked) {
                    r_str=obj[i].value;
                }
            }
        } else {
            if(obj.checked) r_str=obj.value;
        }
       return r_str;
    }
    /*
    * 시트 체크박스를 체크시 지정한 열이 같이것이 있으면 같이 체크/해제
    * @param sheet객체
    * @param Row : sheet onChangeEvent Row
    * @param Col : sheet onChangeEvent Col
        * @param Value : sheet onChangeEvent Value
    * @param ChkCol : sheet CheckBox Col
    * @param SameCol : sheet Col SameCol
    * @return
    * @author 최영희
    * @version 2009.06.10
    */
    function CheckSame(sheetObj,Row,Col,Value,ChkCol,SameCol){

      if (sheetObj.ColSaveName(Col)!=ChkCol) return;

	  var sblNO=sheetObj.GetCellValue(Row,SameCol);

	  for (var i=1;i<sheetObj.LastRow();i++ ){
		  if (sblNO == sheetObj.GetCellValue(i,SameCol)){
			  sheetObj.SetCellValue(i,ChkCol,Value,0);
		  }
	  }
    }
    /*
    * Rd 레포트 파마메트 생성 함수
    * @param Rd 레포트 파라메트 생성관련 문자열
    * <br><b>Example :</b>
      * <pre>
    *    var arr="'a'~'b'~1~2"
      *     retParam = rdParamSet(arr);
      * </pre>
    * @return Rd 파라메트 생성 문자열
    * @author 최영희
    * @version 2009.06.11
    */
    function rdParamSet(arrStr){
      var arrSplit=arrStr.split("~");
      var param="";
      for(var i=0;i<arrSplit.length;i++){
        param+="["+arrSplit[i]+"] ";
      }
      return param;
    }
    /*
    * 그리드 에서 여러 열에 대한 체크박스를 라디오버튼처리에 대한 split no 반환
    * Sheet_onChange 이벤트에서 호출
    * @param  sheetObj
    * @param  Row
    * @param  Col
    * @param  Value
        * @param  sheetTitle Sheet 제목
    * @return Rd 파라메트 생성 문자열
    * @author 최영희
    * @version 2009.06.26
    */
    function SheetColRadioCheck(sheetObj,Row,Col,Value,sheetTitle){
      for (var i=0;i<ComCountHeadTitle(sheetTitle);i++ ){
    	  if(typeof(sheetObj.GetCellValue(Row,i).length) =="undefined"){
           if (sheetObj.ColSaveName(Col)==sheetObj.ColSaveName(i)){
              sheetObj.SetCellValue(Row,Col,Value,0);
           }else{
             sheetObj.SetCellValue(Row,i,0,0);
           }
         }
       }
    }
       /**
        * 다중 저장시 PREFIX 붙여주기
        * @param sStr
        * @param sPrefix
        * @return
        */
       function ComSetPrifix(sStr, sPrefix) {
           if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
               return sStr;
           }
           var regexp=RegExp(/&/g);
           sStr=sPrefix + sStr.replace(regexp, "&" + sPrefix);
           return sStr;
       }
  /*
  * 그리드에 가변적 Booking Head 생성
  * @author 최영희
  * @version 2009.06.29
  */
  function SheetSetHeader(mode,lastno,count,strSheetTitle){
    var imeno=1;
    for (var i=lastno;i<count ;i++ ){
       if(mode.toUpperCase() =="C"){
            strSheetTitle+="|"+ComLpad(i+1,2,"0");
       }else{
           strSheetTitle+="|"+ComLpad(i+1,2,"9");
       }
    }
    return strSheetTitle;
  }
  /*
  * 그리드에 컬럼 정보 세팅
  * @author 최영희
  * @version 2009.06.29
  */
  function SheetSetInitCol(sheetObj,mode,idx,lastno,cnt,prefix){
    var imeno=1;
    var cols = [];
    for(var i=lastno;i<idx;i++){
      var colName="";
      if(mode.toUpperCase() =="C"){
        colName=prefix+ComLpad(i+1,2,"0");
       }else{
        colName=prefix+ComLpad(i+1,2,"9");
       }
      if (prefix=="sheet2_"){
    	cols.push({Type:"Float",      Width:25,  Align:"Right",  SaveName:colName, Format:"Float",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 });
      }else if (prefix=="sheet3_"){
      	cols.push({Type:"Float",      Width:60,  Align:"Right",  SaveName:colName, Format:"Float",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
      }else{
    	cols.push({Type:"CheckBox",  Width:25,  Align:"Center",  SaveName:colName, UpdateEdit:1,   InsertEdit:1 });
      }
    }
    return cols;
  }
  /*
  * 그리드에 Booking 메인에 있는 체크값 표시
  * @author 최영희
  * @version 2009.06.29
  */
  function setSplitNo(sheetObj,splitNo,sheetTitle,prefix,cntrCol,popflag){
    var arrKey=splitNo.split("~");
    for (var i=0;i<arrKey.length-1;i++){
      var arrNo=arrKey[i].split(":");
       //for(var idx=0;idx<arrNo.length;idx++){
        if (popflag=="Y"){
          //SheetRadioCheck(sheetObj,arrNo[1],sheetObj.SaveNameCol(prefix+arrNo[2]),arrNo[1],1,sheetTitle,cntrCol);
          SheetRadioCheck(sheetObj,arrNo[1],colHead(sheetObj,prefix+arrNo[2],sheetTitle),arrNo[1],1,sheetTitle,cntrCol);
        }else{
          //SheetRadioCheck(sheetObj,arrNo[1],sheetObj.SaveNameCol(prefix+arrNo[2]),arrNo[0],1,sheetTitle,cntrCol);
          SheetRadioCheck(sheetObj,arrNo[1],colHead(sheetObj,prefix+arrNo[2],sheetTitle),arrNo[0],1,sheetTitle,cntrCol);
        }
       //}
    }
  }
  /*
  * 그리드에 타이틀에 있는 컬럼인덱스 반환
  * @author 최영희
  * @version 2009.11.11
  */
  function colHead(sheetObj,Col,sheetTitle){
      var ret=sheetObj.SaveNameCol(Col);
      var strTitle=sheetTitle.split("|");
      if (ret=="-1") {
          var strTmp=Col.split("_");
          for(var i=0;i<strTitle.length;i++){
              if (strTmp[1]==strTitle[i]){
                  ret=i;
                  break;
              }
          }
      }
      return ret;
  }
  /*
  * 그리드 에서 여러 열에 대한 체크박스를 라디오버튼처리에 대한 split no 반환
  * @author 최영희
  * @version 2009.06.29
  */
  function SheetRadioCheck(sheetObj,Row,Col,cntrNo,Value,sheetTitle,cntrCol){
    if (Col ==-1) return;
    var sName = sheetObj.ColSaveName(Col);
//  for(var iRow=0;iRow<sheetObj.LastRow();iRow++){
    for(var iRow=1;iRow<sheetObj.LastRow()+1;iRow++){
      for (var i=0;i<ComCountHeadTitle(sheetTitle);i++ ){
    	  if(typeof(sheetObj.GetCellValue(iRow,i).length) =="undefined"){
           if (sName==sheetObj.ColSaveName(i)
        		   && sheetObj.GetCellValue(iRow,cntrCol)==cntrNo){
               sheetObj.SetCellValue(iRow,i,Value,0);
           }
         }
       }
    }
  }
  /*
  * booking split no 팝업창을 보이는 함수
  * @author 최영희
  * @version 2009.06.29
  */
  var isSplitNoOpen=false;
  function bkgSplitNoListPop(obj,list,top,left){
    if(list.indexOf("<option")<0){
        layList.style.display="none";
        return;
    }
    if(layList.style.display == ''){
        layList.style.display="none";
        return;
    }
    if (typeof(top)=="undefined"||typeof(parseInt(top,10))=="NaN"){
      top=10;
    }
    if (typeof(left)=="undefined"||typeof(parseInt(left,10))=="NaN"){
      left=10;
    }
    ifrm.document.getElementById('ContainerList').innerHTML=list;
    //$("#ContainerList", parent.frames["ifrm"].document).html(list);

    var stop = $(obj).offset().top;
    var sleft = $(obj).offset().left;

    layList.style.left=sleft+"px";
    layList.style.top=(stop+20)+"px";
    layList.style.display="";
    isSplitNoOpen=true;
    }
  /*
  * booking split no 팝업창에서 선택값을 object에 넣음
  * @author 최영희
  * @version 2009.06.29
  */
  function bkgSplitSet(splitno){
    document.form.bkg_no.value=splitno;
    document.form.bkg_no.focus();
    layList.style.display="none";
    isSplitNoOpen=false;
  }
  /*
  * booking split no 아이프레임 생성함수
  * @author 최영희
  * @version 2009.06.29
  */
  function CofigIframe(){

	  $(document).find("body").append("<div id='layList' name='layList' style='position:absolute;z-index:999;display:none' CELLPADDING=5 CELLSPACING=0 BORDER=0><IFRAME id='ifrm' name='ifrm' src='apps/opus/esm/bkg/bookingcommon/bookingutil/jsp/esm_booking_split_no.html' frameborder=0 marginHeight=0 marginWidth=0 width='120' height='82'  style='position:absolute;border:1 #e9e9e9 solid' CELLSPACING=0 scrolling='no'/></div>");
  }
  /*
   * boooking 에 대한 Split 반환
   * @author 최영희
   * @version 2009.07.02
   */
  function callParentSplitFunc(sheetObj,flag,prefix,key,bkgno,bkgsplitno,splitReason,strSheetTitle,popflag) {
    var rArray=null; //행데이터를 담고 있는 배열
    var idx=0;
    var ichk=0;
    var tmpbkgno="";
    rArray=new Array();
//    for(var iRow=0;iRow<sheetObj.LastRow();iRow++){
    for(var iRow=1;iRow<sheetObj.LastRow()+1;iRow++){
    	ichk=0;
    	for(var iCol=0;iCol<sheetObj.LastCol()+1;iCol++){
//    		if(typeof(sheetObj.GetCellValue(iRow,iCol).length) =="undefined"){
    		if(sheetObj.GetCellProperty(iRow,iCol,"Type") =="CheckBox"){
    			var str=sheetObj.ColSaveName(iCol).split("_");
    			if (splitReason=="C"){
    				if(ichk==0){
    					ichk++;
    					if (popflag=="Y"){
    						tmpbkgno=bkgno;
    					}else{
    						var strTmp=strSheetTitle.split("|");
    						str=["",strTmp[iCol]];
    						if(bkgsplitno!=""){
    							tmpbkgno=bkgsplitno.substring(0,10)+str[1];
    						}else{
    							tmpbkgno=bkgno.substring(0,10)+str[1];
    						}
    					}
    				}else{
    					if(bkgsplitno!=""){
    						tmpbkgno=bkgsplitno.substring(0,10)+str[1];
    					}else{
    						tmpbkgno=bkgno.substring(0,10)+str[1];
    					}
    				}
    			}else{
    				if(bkgsplitno!=""){
    					tmpbkgno=bkgsplitno.substring(0,10)+str[1];
    				}else{
    					tmpbkgno=bkgno.substring(0,10)+str[1];
    				}
    			}
    			if(sheetObj.GetCellValue(iRow,iCol)==1){
    				rArray[idx]=sheetObj.GetCellValue(iRow,prefix)+":"+sheetObj.GetCellValue(iRow,key)+":"+str[1]+":"+tmpbkgno;
    			}else{
    				rArray[idx]=sheetObj.GetCellValue(iRow,prefix)+":"+sheetObj.GetCellValue(iRow,key)+"::"+tmpbkgno;
    			}
    			idx++;
    		}
    	}
    }
    // 모달창인 경우는 window 객체로부터 opener를 획득
    if(!opener)
      opener=parent;
    try {
        opener.document.form.cntrPopExists.value=popflag;
        opener.getSplitCntr(rArray,flag);
        ComClosePopup();
    }
    catch(e) {
       ComShowCodeMessage("COM12111");
    }
  }
  /*
  * Booking 화면에 있는 Cntr 체크 범위안 여부
  * @author 최영희
  * @version 2009.07.02
    */
  function CheckCntrValidate(sheetObj,Col,cntNo,chkCntrValidate,prefix){
    var sdata=sheetObj.ColSaveName(Col).substring(sheetObj.ColSaveName(Col).indexOf("_")+1);
    var bRtn=false;
    for (var idx=0;idx<chkCntrValidate.length;idx++ ){
      var arrData=chkCntrValidate[idx].split(":");
      if (cntNo ==arrData[0] && (sdata ==arrData[1])){   // || Col<sheetObj.SaveNameCol(prefix+arrData[1])
        bRtn=true;
        break;
      }
    }
    return bRtn;
  }
    /*
  * Booking 화면에 있는 Cntr 체크 반환
  * @author 최영희
  * @version 2009.07.02
  */
  function CheckCntrSplit(splitData){
    var arrCnt=splitData.split("~");
    var chkCntrSplit=new Array(arrCnt.length-1);
    for(var idx=0;idx<arrCnt.length-1;idx++){
      var arrData=arrCnt[idx].split(":");
      chkCntrSplit[idx]=arrData[0]+":"+arrData[2];
    }
    return chkCntrSplit;
  }
  /*
  * Special Cargo Aplication Split 체크박스 복원
  * @author 최영희
  * @version 2009.07.02
  */
  function restoreCheck(sheetObj,strSheetTitle,prefix,cntrCol,popflag){
//	  for(var iRow=0;iRow<sheetObj.LastRow();iRow++){
	  for(var iRow=1;iRow<sheetObj.LastRow()+1;iRow++){
//      for(var iCol=0;iCol<sheetObj.LastCol()+1;iCol++){
      for(var iCol=1;iCol<sheetObj.LastCol()+1;iCol++){
//    	  if(typeof(sheetObj.GetCellValue(iRow,iCol).length) =="undefined"){
    	  if(sheetObj.GetCellProperty(iRow,iCol,"Type") =="CheckBox"){
           sheetObj.SetCellValue(iRow,iCol,0);
         }
      }
    }
    setSplitNo(sheetObj,document.form.splitCntrSplitNo.value,strSheetTitle,prefix,cntrCol,popflag);
  }
    /**
    * 날짜 From To 에대한 개월수를 초과하는지 검사하여 From + months >= To일 경우 false를 반대의 경우 True를 return 한다.
    * @author 박만건
    * @param fromDate 시작일
    * @param toDate 종료일
    * @param months 검사할 최대개월수
    * @param formatStr 날짜 포멧 문자
    * @return boolean
    * @version 2009.07.02
    */
    function ComBkgMonthsBetweenCheck(fromDate, toDate, months, formatStr){
       var fmtStr="";
       if (formatStr == null || formatStr == "") {
         fmtStr="-";
       } else {
         fmtStr=formatStr;
       }
       var ufFromDate=fromDate.replace(eval("/" + fmtStr + "/gi"), "");
         var ufToDate=toDate.replace(eval("/" + fmtStr + "/gi"), "");
       var fYear=parseInt(ufFromDate.substring(0,4));
       var fMonth=ufFromDate.substring(4,5)=="0"?parseInt(ufFromDate.substring(5,6))-1:parseInt(ufFromDate.substring(4,6))-1;
       var fDay=ufFromDate.substring(6,7)=="0"?parseInt(ufFromDate.substring(7,8)):parseInt(ufFromDate.substring(6,8));
       var tYear=parseInt(ufToDate.substring(0,4));
       var tMonth=ufToDate.substring(4,5)=="0"?parseInt(ufToDate.substring(5,6))-1:parseInt(ufToDate.substring(4,6))-1;
       var tDay=ufToDate.substring(6,7)=="0"?parseInt(ufToDate.substring(7,8)):parseInt(ufToDate.substring(6,8));
       var bLastDay=false;
       var iLastDay=ComGetLastDay(fYear, fMonth +1);
       if (iLastDay == fDay) { bLastDay=true; }
       // 월처리
       for (var i=0; i< months; i++ ) {
           fMonth=fMonth + 1;
           if (fMonth > 11) {
               fYear=fYear + 1;
               fMonth=0;
           }
       }
       // 말일이면 변경된 월의 말일을 가져온다.
       if(bLastDay) {
         fDay=ComGetLastDay(tYear, tMonth +1);;
       }
       var dAddedDate=new Date("" + fYear, "" + fMonth, "" + fDay);
       var dToDate=new Date("" + tYear, "" + tMonth , "" + tDay);
       diffDay=( dAddedDate - dToDate) /(1000*3600*24);
       if ( diffDay > 0) {
         return true;
       }
       return false;
    }
     /**
      * Check된 값을 Array에 담아 넘겨준다.
      * @author 김병규
      * @param sheetObj Sheet정보
      * @param chkName Sheet내 Check Save이름
      * @param colName 넘겨받을 Column
      * @return Array()
      * @version 2009.07.02
      */
     function getCheckedRowByName(sheetObj,chkName,colName) {
        var checkRows;
        var colsCnt=sheetObj.LastCol()+ 1;
        var rows=sheetObj.LastRow();
        var rArray=null; // 행데이터를 담고 있는 배열
        var cArray=null; // 열데이터를 담고 있는 배열
        checkRows=sheetObj.FindCheckedRow(chkName);
        if(checkRows == "") {
            return null;
        }else {
          var idx=0;
          var arrRow = checkRows.split("|");
          rArray=new Array(arrRow.length);
          for(idx=0; idx<arrRow.length; idx++){
        	  var row = arrRow[idx];
              cArray=null;
              // 특정 컬럼명이 지정된 경우
              if(colName != null && colName != "") {
              	cArray=sheetObj.GetCellValue(row, colName);
              } else {
                cArray=new Array(colsCnt);
                for(var j=0; j<cArray.length; j++) {
              	  cArray[j]=sheetObj.GetCellValue(row, j);
              	}
              }
              rArray[idx]=cArray;
             }
          }
          return rArray;
      }
  // ETC Data를 Form에 저장.(checkbox값 재설정)   김병규
  function BkgEtcDataXmlToForm(xmlStr, formObj){
      if (xmlStr == null || xmlStr == "")  return ComFuncErrMsg("XMLStr is necessary.");
      if (typeof(formObj) != "object")  return ComFuncErrMsg("[BkgEtcDataXmlToForm Error] It is not FORM TAG.");

      try {
          /* XML Parsing */
    	  var xmlDoc = ComGetXmlDoc(xmlStr);
    	  if (xmlDoc == null) return;
    	  var xmlRoot = xmlDoc.documentElement;

          var dataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
          var dataChildNodes=dataNode.childNodes;
          /* Form에 값을 대입 */
          var sName, sValue;
            var sObject=null;
          for (i=0; i<dataChildNodes.length; i++) {

        	  if (dataChildNodes[i].nodeType != 1)
    				continue;

                sName=dataChildNodes[i].attributes[0].nodeValue;
                sValue=dataChildNodes[i].firstChild.nodeValue;


              sValue=(sValue == null || sValue == 'null') ? '' : sValue;
              //alert(sName + " = " + sValue + " ==> " + formObj.elements[sName]);
              if(formObj.elements[sName] == undefined) continue;
              BkgSetObjValue(formObj.elements[sName], sValue);
          }
      } catch(err) {
          ComFuncErrMsg(err.message);
      }
  }

  function BkgSetObjValue(obj, sValue, bArgTrim){
      try {
          if (bArgTrim==undefined || bArgTrim == null) bArgTrim=false;
          if (bArgTrim) sValue=ComTrim(sValue);

          var sType=obj.type;
          if( obj.length > 1){
        	  sType=obj[0].type;
          }
          //type을 읽을수 있다는것은 Radio전체가 아니라 radio[0]... 임
          if (sType=="radio") {
              if (obj.name == null || obj.name=="") {
                  if (obj.checked) return obj.value;
                  else return "";
              }
              obj=document.all[obj.name];
          //Radio전체로는 obj.type으로 알수 없음.  radio[0].. 등 만 알수 있음
          }else if(obj.type == undefined && obj.length != undefined && obj[0].type == "radio") {
              sType="radio";
          }
          switch (sType) {
              case "radio":
                  if (obj.length != null) {
                      for(var i=0; i<obj.length; i++) {
                          if (obj[i].value == sValue) {
                              obj[i].checked=true;
                              break;
                          }
                      }
                  } else {
                      if (obj.value == sValue) obj.checked=true;
                  }
                  break;
              case "checkbox":
                if(obj.value == sValue){
                  obj.checked=true;
                }else{
                  obj.checked=false;
                }
                  break;
              case "select-one":
                  for (var idx=0; idx < obj.length; idx++) {
                      if (obj[idx].value == sValue) {
                          obj[idx].selected=true;
                          break;
                      }
                  }
                  break;
              case "select-multiple":
                  var aryValue=sValue.split("|");
                  if (bArgTrim){
                      for (i=0; i<aryValue.length; i++) {
                          aryValue[i]=ComTrim(aryValue[i]);
                      }
                  }
                  for(var idx=0; idx<obj.length; idx++) {
                      var bSelected=false;
                      for (i=0; i<aryValue.length; i++) {
                          if (obj[idx].value == aryValue[i])  {
                              bSelected=true;
                              break;
                          }
                      }
                      obj[idx].selected=bSelected;
                  }
                  break;
              default:
                  if (obj.value != undefined) obj.value=sValue;
          }

          if(obj.getAttribute("ibcb-delegate") == "true"){
        	  eval(obj.id).SetSelectCode(sValue);
          }

      } catch(err) { ComFuncErrMsg(err.message); }
  }
   /*
    * 사용법 :
    * 1 Endcode :
    * var sStr = "ddcc!@!#";
    * alert(sStr.URLEncode());
    *  alert(sStr.URLEncode().URLDecode());
    *     * */
String.prototype.URLEncode=function URLEncode( )
{
 var SAFECHARS="0123456789" +     // Numeric
     "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + // Alphabetic
     "abcdefghijklmnopqrstuvwxyz" +
     "-_.!~*'()";     // RFC2396 Mark characters
 var HEX="0123456789ABCDEF";
 var plaintext=this;
 var encoded="";
 for (var i=0; i < plaintext.length; i++ ) {
  var ch=plaintext.charAt(i);
     if (ch == " ") {
      encoded += "+";    // x-www-urlencoded, rather than %20
  } else if (SAFECHARS.indexOf(ch) != -1) {
      encoded += ch;
  } else {
      var charCode=ch.charCodeAt(0);
   if (charCode > 255) {
       alert( "Unicode Character '"
                        + ch
                        + "' cannot be encoded using standard URL encoding.\n" +
              "(URL encoding only supports 8-bit characters.)\n" +
        "A space (+) will be substituted." );
    encoded += "+";
   } else {
    encoded += "%";
    encoded += HEX.charAt((charCode >> 4) & 0xF);
    encoded += HEX.charAt(charCode & 0xF);
   }
  }
 } // for
 return encoded;
};
String.prototype.URLDecode=function URLDecode(  )
{
   var HEXCHARS="0123456789ABCDEFabcdef";
   var encoded=this;
   var plaintext="";
   var i=0;
   while (i < encoded.length) {
       var ch=encoded.charAt(i);
    if (ch == "+") {
        plaintext += " ";
     i++;
    } else if (ch == "%") {
   if (i < (encoded.length-2)
     && HEXCHARS.indexOf(encoded.charAt(i+1)) != -1
     && HEXCHARS.indexOf(encoded.charAt(i+2)) != -1 ) {
    plaintext += unescape( encoded.substr(i,3) );
    i += 3;
   } else {
    alert( 'Bad escape combination near ...' + encoded.substr(i) );
    plaintext += "%[ERROR]";
    i++;
   }
  } else {
     plaintext += ch;
     i++;
  }
 } // while
   return plaintext;
};
    /**
     * {@link #ComOpenWindow} 함수와 동일한 처리와 함께 팝업화면을 화면의 중앙에 활성화 한다. <br>
     * bModal 인자값에 따라 팝업창이 Modal 인지 Modaless(일반팝업) 인지 선택한다. <br>
     * bModal=true인 경우 window.showModalDialog 함수를 이용하고, bModal=false인 경우 window.open 함수를 이용한다. <br>
     * 팝업을 표시할 경우 가운데 표시하기위한 width, height, left, top 옵션은 자동으로 설정되고, 그외 다음과 같은 옵션이 설정된다. <br>
     * window.showModalDialog 함수의 옵션 : "scroll:no; status:no; help:no;"<br>
     * window.open 함수의 옵션 : "status=no, resizable=no, scrollbars=no"<br>
     * <br><b>Example :</b>
     * <pre>
     *     ComOpenWindowCenter("ESD_TPB_911.do", "ESD_TPB_911", 755, 460);
     *     ComOpenWindowCenter("ESD_TPB_911.do", null,          755, 460);
     *     pWin = ComOpenWindowCenter("ESD_TPB_911.do", null,   755, 460); //pWin은 팝업창 window object이다.
     * </pre>
     * @param {string} sUrl      선택,팝업창의 Url, default="about:blank"
     * @param {string} sWinName  선택,팝업창의 name 또는 dialogArguments, default=null
     * @param {string} iWidth    선택,팝업창의 넓이로 픽셀단위이며 최소100이상 설정
     * @param {string} iHeight   선택,팝업창의 높이로 픽셀단위이며 최소100이상 설정
     * @param {bool}   bModal    선택,팝업의 Modal 여부 (true:Modal, false:일반팝업), default=false
     * @param {bool}   sFeatures 선택,팝업창의 세부 설정, default=""
     * @returns object<br>
     *          bModal=false로 오픈된 경우 리턴값 : 팝업창의 window Object
     *          bModal=true로 오픈된 경우 리턴값  : 팝업창의 window.returnValue값
     * @see #ComOpenWindow
     */
    function ComOpenWindowCenter2(sUrl,sWinName,iWidth,iHeight, bModal,sFeatures) {
        try {
            var leftpos=(screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
            var toppos=(screen.height- iHeight)/2;   if(toppos<0)  toppos=0;
            if (bModal) {
              return ComOpenWindow(sUrl, sWinName, sFeatures+";dialogWidth:"+iWidth+"px;dialogHeight:"+iHeight+"px;dialogLeft:" + leftpos + ";dialogTop:"+toppos, true);
            } else {
              return ComOpenWindow(sUrl, sWinName, sFeatures+", width="+iWidth+", height="+iHeight+", left="+leftpos+", top="+toppos);
          }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
     * 문자열을 숫자(Int형)로 변환 함수.
     *
     * @param 숫자(문자열) <br>
     * @returns int 예) 1234 <br>
     * @author 김영출
     */
  function BkgParseInt(p){
    return (p == null || p == '') ? 0 : parseInt(p);
  }
    /**
     * 문자열을 숫자(Float형)로 변환 함수.
     *
     * @param 숫자(문자열) <br>
     * @returns float 예) 1234.56 <br>
     * @author 김영출
     */
  function BkgParseFloat(p){
    return (p == null || p == '') ? 0 : parseFloat(p);
  }
// ===========================================================================================================
    /**
     * 결과XML을 파싱하여 formObject의 Element에 값을 입력하는 함수.
     *
     * @param XmlString, formObject<br>
     * @returns 없음 <br>
     * @author 김영출
     */
  function ComEtcDataXmlToForm(xmlStr, formObj){
      if (xmlStr == null || xmlStr == "") return ComFuncErrMsg("XMLStr은 필수값 입니다.");
      if (typeof(formObj) != "object")  return ComFuncErrMsg("FORM 태그가 아닙니다.");

      try {
            /* XML Parsing */
    	  var xmlDoc = ComGetXmlDoc(xmlStr);
    	  if (xmlDoc == null) return;
    	  var xmlRoot = xmlDoc.documentElement;

          var dataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
          if (dataNode == null) return;

          var dataChildNodes=dataNode.childNodes;
          if (dataChildNodes == null) return;

          /* Form에 값을 대입 */
          var sType, sName, sValue;
          var frmObject=null;
          for (yn=0; yn<dataChildNodes.length; yn++) {

        	  if (dataChildNodes[yn].nodeType != 1)
  				continue;

              sName=dataChildNodes[yn].attributes[0].nodeValue;
              sValue=dataChildNodes[yn].firstChild.nodeValue;
              sValue=(sValue == undefined || sValue == "null") ? '' : sValue;
              frmObject=formObj.elements[sName];
              if(frmObject == undefined) continue;
              sType=frmObject.type;
              //alert(sName + " = " + formObj.elements[sName] + "(" + sType + ") -> " + sValue);
        // radio의 경우 frmObject가 배열형태가 되므로, frmObject.type으로는 타입을 알수 없다.
        if (sType==undefined && frmObject.length>0) sType=frmObject[0].type;
        // 타입별로 값을 설정한다.
        switch(sType) {
          case "button":
          case "reset":
          case "submit":
          break;
          case "radio":
            for (idx=0; idx<frmObject.length; idx++) {
              if(frmObject[idx].value == sValue) {
                frmObject[idx].checked=true;
                break;
              }
            }
          break;
          case "checkbox":
            frmObject.checked=(sValue=='Y'|| sValue==frmObject.value);
          break;
          default :
          frmObject.value=sValue;
        }//end of switch
          }
      } catch(err) {
          ComFuncErrMsg(err.message);
      }
  }
    /**
     * 결과XML을 파싱하여 sheetObject의 특정 Row의 값을 입력하는 함수.
     *
     * @param XmlString, sheetObject, RowNumber, 데이타가없을경우메세지  <br>
     * @returns 없음 <br>
     * @author 김영출
     */
  function ComEtcDataXmlToSheet(xmlStr, sheetObj, row, noDataMessage){
      if (xmlStr == null || xmlStr == "") {
    	  ComFuncErrMsg("XMLStr은 필수값 입니다.");
          return false;
      }
      if (typeof(sheetObj) != "object") {
    	  ComFuncErrMsg("SHEET OBJECT가 아닙니다.");
          return false;
      }
      //try {
          /* XML Parsing */
		  var xmlDoc = ComGetXmlDoc(xmlStr);
		  if (xmlDoc == null) return;
		  var xmlRoot = xmlDoc.documentElement;

          var dataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
          var dataChildNodes=dataNode.childNodes;
          var xName='';
          if(dataChildNodes.length > 0){
            for (ic=0; ic<dataChildNodes.length; ic++) {
              xName=dataChildNodes.item(ic).getAttribute("KEY");
              if(xName == "ibflag") continue;
              sheetObj.SetCellValue(row, xName,dataChildNodes.item(ic).text);
            }
            return true;
          }else{
            if(noDataMessage != undefined && noDataMessage != '') ComShowMessage(noDataMessage);
            return false;
          }
      //} catch(err) {
      //    return false;
      //}
  }
    /**
     * sheetObject의 특정 Row의 값을 Form의 각 Element에 복사하는 함수.
     *
     * @param sheetObject, RowNumber, FormObject, Prefix  <br>
     * @returns 없음 <br>
     * @author 김영출
     */
  function ComCopyRowToForm(sheetobj, row, formObj, prefix){
    //함수의 인자 유효성 확인-시작
	if ((!sheetobj) || (!sheetobj.IBSheetVersion)){
      return ComFuncErrMsg("sheetobj 인자는 IBSheet Object가 아닙니다.");
    } else if (formObj==null || typeof formObj != "object" || formObj.tagName != "FORM") {
      return ComFuncErrMsg("formObj 인자는 FORM 태그가 아닙니다.");
    }
    //HTML컨트롤의 name 앞에 붙는 글자
    if (prefix == null) prefix="";
    if (row == null || row == 0) row=sheetobj.GetSelectRow();
    // Sheet의 컬럼개수만큼 찾아서 HTML의 Form 각 Control에 값을 설정한다.
    for(col=0;col<=sheetobj.LastCol();col++){
      //컬럼의 별명을 문자열로 가져온다.
      var col_alias=sheetobj.ColSaveName(col)
      if(col_alias == '') continue;
      var cell_value=sheetobj.GetCellValue(row,col);
	  var frmchild=ComGetObject(prefix + col_alias);
      if(frmchild == undefined) continue;
      var sType=frmchild.type;
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
            if(frmchild[idx].value == cell_value) {
              frmchild[idx].checked=true;
              break;
            }
          }
        break;
        case "checkbox":
          frmchild.checked=(cell_value==1 || cell_value=='Y');
        break;
        default :
        frmchild.value=cell_value;
      }//end of switch
    }//end of for(col)
  }
    /**
     * Form의 Element값을 Row에 복사하는 함수.
     *
     * @param sheetObject, RowNumber, FormObject, Prefix  <br>
     * @returns 없음 <br>
     */
	 function CopyFormToRow(formobj, sheetobj, row, prefix){
	        //함수의 인자 유효성 확인-시작
	    	if ((!sheetobj) || (!sheetobj.IBSheetVersion)){
	            return alert("IBS_CopyFormToRow 함수의 sheetobj 인자는 IBSheet 태그가 아닙니다.");
	       }else if (formobj==null || typeof formobj != "object") {
	          return IBS_ShowErrMsg("IBS_CopyFormToRow 함수의 formobj 인자는 FORM 태그가 아닙니다.");
	        }else if (row!=null && (isNaN(row) || row < 0 || row > sheetobj.LastRow())) {
	          return  ;
	        }
	        //HTML컨트롤의 name 앞에 붙는 글자
	        if (prefix == null || prefix=="") prefix="";
	        if (row == null) row=sheetobj.GetSelectRow();
	        sheetobj.RenderSheet(0);
	        //Sheet의 컬럼개수만큼 찾아서 HTML의 Form 각 Control에 값을 설정한다.
	        //컬럼개수만큼 루프 실행
	        for(var col=0;col<=sheetobj.LastCol();col++){
	          //컬럼의 별명을 문자열로 가져온다.
	          var col_alias=sheetobj.ColSaveName(col)
	          if (col_alias=="") continue;
	          //폼에 있는 해당 이름의 컨트롤을 가져온다.예)"frm_CardNo"
	          var frmchild=formobj.elements[prefix +col_alias];
	          //폼에 해당하는 이름의 컨트롤이 없는 경우는 계속 진행한다.
	          if(frmchild==null || frmchild == undefined) continue;

	          var sType=frmchild.type;
	          var sValue;
	          //radio의 경우 frmchild가 배열형태가 되므로, frmchild.type으로는 타입을 알수 없다.
	          if (sType==undefined && frmchild.length>0) sType=frmchild[0].type;
	          //타입별로 값을 설정한다.
	          switch(sType) {
	            case undefined:
	            case "button":
	            case "reset":
	            case "submit":
	              break;
	            case "radio":
	              for (idx=0; idx<frmchild.length; idx++) {
	               if(frmchild[idx].checked) {
	                  sValue=frmchild[idx].value;
	                  break;
	                }
	              }
	              break;
	            case "checkbox":
	              sValue=(frmchild.checked)?1:0;
	              break;
	            default :
	              sValue=frmchild.value;
	          }//end of switch
	          sheetobj.SetCellValue(row,col,sValue,0);
	        }//end of for(col)
	        sheetobj.RenderSheet(1);
	      }
    /**
     * sheetObject의 특정 Coloumn명의 값이 주어진 값과 같을 경우, 다른 sheetObject에 입력하는 함수.
     *
     * @param FromObject, ToObject, Coloumn명, Column값  <br>
     * @returns 없음 <br>
     * @author 김영출
     */
  function ComFilteredSheetToSheet(fromSheet, toSheet, colName, colValue)  {
    //함수 인자 유효성 확인
	if ((!fromSheet) || (!fromSheet.IBSheetVersion))
      return ComFuncErrMsg("fromSheet 인자는 IBSheet가 아닙니다.");
	else if ((!toSheet) || (!toSheet.IBSheetVersion))
      return ComFuncErrMsg("toSheet 인자는 IBSheet가 아닙니다.");
    var arrRow=ComFindText(fromSheet, colName, colValue);
    for (yn=0; yn < arrRow.length; yn++) {
      if(arrRow[yn] == '') continue;
      var newRow=toSheet.DataInsert(-1);
      for(ic=0; ic <= fromSheet.LastCol(); ic++){
        try{
          if(fromSheet.ColSaveName(ic) == "ibflag") continue;
          toSheet.SetCellValue(newRow, ic,fromSheet.GetCellValue(arrRow[yn], ic),0);
        } catch(err) { }
      }
    }
  }
    /**
     * sheetObject의 특정 Column 값을 배열로 반환하는 함수.
     *
     * @param sheetObject, RowNumber, 해당Coloumn  <br>
     * @returns Array <br>
     * @author 김영출
     */
  function ComGetColumnData(sheetObj, colName){
    var rarr=new Array();
    for(yn=sheetObj.HeaderRows();yn<=sheetObj.LastRow();yn++ ){
    	if(sheetObj.GetRowStatus(yn) != 'D'){
    		rarr.push(sheetObj.GetCellValue(yn, colName));
      }
    }
    return rarr;
  }
    /**
     * sheetObject의 특정 Row 값을 배열로 반환하는 함수.
     *
     * @param sheetObject, RowNumber, 해당Coloumn  <br>
     * @returns Array <br>
     * @author 김영출
     */
  function ComGetRowData(sheetObj, rowNum, colNames){
    var rarr=new Array();
    for(ic=0; ic <= sheetObj.LastCol(); ic++){
      if(colNames == undefined || colNames == '') {
    	  rarr.push(sheetObj.GetCellValue(rowNum, ic));
      }else{
        if(colNames.indexOf(sheetObj.ColSaveName(ic)) >= 0){
        	rarr.push(sheetObj.GetCellValue(rowNum, ic));
        }
      }
    }
    return rarr;
  }
    /**
     * sheetObject의 값을 초기화하는 함수.
     *
     * @param sheetObject, RowNumber, 예외Coloumn  <br>
     * @returns 없음 <br>
     * @author 김영출
     */
  function ComMakeEmptyRow(sheetObj, row, exceptCol)  {
    //함수 인자 유효성 확인
	if ((!sheetObj) || (!sheetObj.IBSheetVersion))
        return ComFuncErrMsg("sheetObj 인자는 IBSheet가 아닙니다.");
    var excpFlag=true;
    var excpArr=null;
    if(exceptCol == undefined || exceptCol == ''){
      excpArr=new Array();
    }else{
      excpArr=exceptCol.split(',');
    }
    for(ic=0; ic <= sheetObj.LastCol(); ic++){
        excpFlag=true;
        var col_name=sheetObj.ColSaveName(ic);
        for(ia=0;ia<excpArr.length;ia++){
            if(col_name == excpArr[ia]){
                //alert("* except col. : " + col_name);
                excpFlag=false;
                break;
            }
        }
        if(excpFlag){
            sheetObj.SetCellValue(row, ic,'',0);
        }
    }
  }
    /**
     * formObject의 값을 초기화하는 함수.
     *
     * @param formObject, 예외Element  <br>
     * @returns 없음 <br>
     * @author 김영출
     */
  function ComMakeEmptyForm(formObj, exceptElm)  {
    //함수 인자 유효성 확인
    if (typeof(formObj) != "object") return ComFuncErrMsg("FORM 태그가 아닙니다.");
    var eName='';
    var eType='';
    var elmChild=null;
    var elmCnt=formObj.elements.length;
    for(ic=0; ic < elmCnt; ic++){
      elmChild=formObj.elements[ic];
      if(elmChild == undefined) continue;
      eName=elmChild.name;
      eType=elmChild.type;
      if(eName == undefined || eName == '') continue;
      if(eType == undefined || eType == '') continue;
      if(exceptElm != undefined && exceptElm != '' && exceptElm.indexOf(eName) >= 0) continue;
      // 타입별로 값을 설정한다.
      switch(eType) {
        case "submit":
        case "reset":
        case "button":
        break;
        case "radio":
          elmChild.defaultChecked=true;
        break;
        case "checkbox":
          elmChild.checked=false;
        break;
        default :
          elmChild.value='';
      }
    }
  }
    /**
     * sheetObject의 특정 컬럼의 합계를 구하는 함수.
     *
     * @param sheetObject, 컬럼명, hiddenRow미포함  <br>
     * @returns String <br>
     * @author 김영출
     */
  function ComColumnSum(sheetObj, colName, hiddenFlag){
    //함수 인자 유효성 확인
	if ((!sheetObj) || (!sheetObj.IBSheetVersion)) return ComFuncErrMsg("sheetObj 인자는 IBSheet가 아닙니다.");
    var hFlg=(hiddenFlag == undefined) ? false : ((hiddenFlag == true) ? true : false);
    var cval=null;
    var sum=0;
    for(yn=sheetObj.HeaderRows();yn<=sheetObj.LastRow();yn++ ) {
    	if(sheetObj.GetRowStatus(yn) != 'D'){
            //sum += ((sheetObj.CellValue(yn, colName).indexOf('.')<0)
            //    ? parseInt(sheetObj.CellValue(yn, colName))
            //    : parseFloat(sheetObj.CellValue(yn, colName)));
            if(hFlg && sheetObj.GetRowHidden(yn)) continue;
            cval=(sheetObj.GetCellValue(yn, colName) == undefined || sheetObj.GetCellValue(yn, colName) == '') ? '0' : sheetObj.GetCellValue(yn, colName);
            sum += isNaN(cval) ? 0 : parseFloat(cval);
        }
    }
    //var sSum = ''+sum;
    //return ((sSum.indexOf('.') != -1 && sSum.length > sSum.indexOf('.') + 4) ?  sSum.substring(0, sSum.indexOf('.') + 4) : sSum);
    return sum;
  }
    /**
     * sheetObject의 특정 컬럼의 조건에 맞는 Row만 합계를 구하는 함수.
     *
     * @param sheetObject, 컬럼명, 조건컬럼, 조건값, hiddenRow미포함 <br>
     * @returns String <br>
     * @author 김영출
     */
    function ComColumnSumByCond(sheetObj, colName, condCol, condVal, hiddenFlag){
        //함수 인자 유효성 확인
    	if ((!sheetObj) || (!sheetObj.IBSheetVersion)) return ComFuncErrMsg("sheetObj 인자는 IBSheet가 아닙니다.");
        var hFlg=(hiddenFlag == undefined) ? false : ((hiddenFlag == true) ? true : false);
        var cval=null;
        var sum=0;
        for(yn=sheetObj.HeaderRows();yn<=sheetObj.LastRow();yn++ ) {
        	if(sheetObj.GetRowStatus(yn) != 'D'){
                if(hFlg && sheetObj.GetRowHidden(yn)) continue;
                if(sheetObj.GetCellValue(yn, condCol) == condVal) {
                	cval=(sheetObj.GetCellValue(yn, colName) == undefined || sheetObj.GetCellValue(yn, colName) == '') ? '0' : sheetObj.GetCellValue(yn, colName);
                    sum += isNaN(cval) ? 0 : parseFloat(cval);
                }
            }
        }
        return sum;
    }
    /**
     * sheetObject의 특정 컬럼의 seq를 다시 설정하는 함수.
     *
     * @param sheetObject, 컬럼명  <br>
     * @returns 없음 <br>
     * @author 김영출
     */
  function ComRenumberSeq(sheetObj, seqColNm){
    var cSeq=(seqColNm==undefined || seqColNm=='') ? "seq" : seqColNm;
    var rSeq=1;
    if(sheetObj.LastRow()> 1) {
	    for(yn=sheetObj.HeaderRows();yn<=sheetObj.LastRow();yn++ ) {
	    	var rsts=sheetObj.GetRowStatus(yn);
	      if(rsts != 'D' && sheetObj.GetRowHidden(yn) == false){
	        sheetObj.SetCellValue(yn, cSeq,rSeq++,0);
	        //alert("gg"+sheetObj.LastRow()+" "+yn);
	        sheetObj.SetRowStatus(yn,rsts);
	      }
	    }
    }
  }
    /**
     * sheetObject의 특정 컬럼의 조건값에 해당하는 열을 숨기는 함수.
     *
     * @param sheetObject, 컬럼명, 조건값  <br>
     * @returns 없음 <br>
     * @author 김영출
     */
  function ComShowAndHideSheet(sheetObj, colName, colValue){
	if ((!sheetObj) || (!sheetObj.IBSheetVersion)) return ComFuncErrMsg("sheetObj 인자는 IBSheet가 아닙니다.");
    for(yn=sheetObj.HeaderRows();yn<=sheetObj.LastRow();yn++ ){
    	if(sheetObj.GetRowStatus(yn) != 'D' && sheetObj.GetCellValue(yn, colName) == colValue){
        sheetObj.SetRowHidden(yn,0);
      }else{
        sheetObj.SetRowHidden(yn,1);
      }
    }
  }
    /**
     * sheetObject의 특정 컬럼의 조건값에 해당하는 열을 삭제하는 함수.
     *
     * @param sheetObject, 컬럼명, 조건값  <br>
     * @returns 없음 <br>
     * @author 김영출
     */
  function ComRowDelete(sheetObj, colName, colValue){
    //함수 인자 유효성 확인
	if ((!sheetObj) || (!sheetObj.IBSheetVersion)) return ComFuncErrMsg("sheetObj 인자는 IBSheet가 아닙니다.");
    var arrRow=ComFindText(sheetObj, colName, colValue);
    for (yn=0; yn < arrRow.length; yn++) {
      if(arrRow[arrRow.length-1-yn]=='') continue;
      sheetObj.SetRowHidden(arrRow[arrRow.length-1-yn],1);
      sheetObj.SetRowStatus(arrRow[arrRow.length-1-yn],'D');
    }
  }
    /**
     * sheetObject의 특정 컬럼의 조건값에 해당하는 열을 완전히 삭제하는 함수.
     *
     * @param sheetObject, 컬럼명, 조건값  <br>
     * @returns 없음 <br>
     * @author 김영출
     */
  function ComRowDeleteComplete(sheetObj, colName, colValue){
    //함수 인자 유효성 확인
	  if ((!sheetObj) || (!sheetObj.IBSheetVersion)) return ComFuncErrMsg("sheetObj 인자는 IBSheet가 아닙니다.");
    var arrRow=ComFindText(sheetObj, colName, colValue);
    for (yn=arrRow.length-1; yn >=0 ; yn--) {
      if(arrRow[arrRow.length-1-yn]=='') continue;
      sheetObj.RowDelete(arrRow[arrRow.length-1-yn], false);
    }
  }
    /**
     * sheetObject의 특정 컬럼의 조건값에 해당하는 열의 Index를 구하는 함수.
     *
     * @param sheetObject, 컬럼명, 조건값  <br>
     * @returns Array <br>
     * @author 김영출
     */
  function ComFindText(sheetObj, colName, colValue){
    //함수 인자 유효성 확인
	if ((!sheetObj) || (!sheetObj.IBSheetVersion)) return ComFuncErrMsg("sheetObj 인자는 IBSheet가 아닙니다.");
    var idxs=new Array();
    for(yn=sheetObj.HeaderRows();yn<=sheetObj.LastRow();yn++ ) {
    	if(sheetObj.GetRowStatus(yn) != 'D' && sheetObj.GetCellValue(yn, colName) == colValue){
        idxs.push(''+yn);
      }
    }
    return idxs;
  }
    /**
     * sheetObject의 특정 컬럼의 최대값을 구하하는 함수.
     *
     * @param sheetObject, 컬럼명 <br>
     * @returns int <br>
     * @author 김영출
     */
  function ComGetMaxValue(sheetObj, colName){
    var maxVal=0;
    var rseq='';
    for(yn=sheetObj.HeaderRows();yn<=sheetObj.LastRow();yn++ ) {
    	rseq=sheetObj.GetCellValue(yn, colName);
    	maxVal=Math.max(maxVal, parseInt((rseq == undefined || rseq == '') ? 0 : rseq));
    }
    return maxVal;
  }
    /**
     * 결과 XML로 부터 MESSAGE를 추출하는 함수.
     *
     * @param 결과XML <br>
     * @returns String <br>
     * @author 김영출
     */
  function ComResultMessage(xmlStr){
	  return ComGetSelectSingleNode(xmlStr, "MESSAGE");
  }
    /**
     * 배열의 값을 ComboObject에 값을 입력하거나 참부하는 함수.
     *
     * @param 배열값, ComboObject, append여부 <br>
     * @returns 없음 <br>
     * @author 김영출
     */
  function ComArrayToOptions(arr, comboObj, appFlg){
    var isAppend=(appFlg == undefined) ? false : appFlg;
    if(!isAppend){
      var clen=(comboObj==null) ? 0 : comboObj.length;
      for(ic=0;ic<clen;ic++){
        comboObj.remove(clen-1-ic);
      }
    }
    var alen=(arr==null) ? 0 : arr.length;
    for(ia=0;ia<alen;ia++){
      comboObj.add(new Option(arr[ia], arr[ia]));
    }
  }
    /**
     * 주어진 포맷에 맞도록 숫자형식 변환 함수.
     *
     * @param 숫자(문자열), 숫자 포맷 <br>
     * @returns String 예) 1,234.56 <br>
     * @author 김영출
     */
    function ComAddComma3(sVal, sFormat){
        var str=(typeof(sVal) == "number") ? String(sVal) : sVal;
        try {
            switch(sFormat)  {
                case "#,###" :
                        return ComAddComma(str);
                break;
                case "#,###.0" :
                        p=str.split(".");
                        p[0]=ComAddComma(p[0]);
                        if      (p.length == 1) return p[0]+".0";
                        else if (p.length == 2) return p[0]+"."+ComNumberFixed(p[1], 1);
                        else return "";
                break;
                case "#,###.00" :
                        p=str.split(".");
                        p[0]=ComAddComma(p[0]);
                        if      (p.length == 1) return p[0]+".00";
                        else if (p.length == 2) return p[0]+"."+ComNumberFixed(p[1], 2);
                        else return "";
                break;
                case "#,###.000" :
                        p=str.split(".");
                        p[0]=ComAddComma(p[0]);
                        if      (p.length == 1) return p[0]+".000";
                        else if (p.length == 2) return p[0]+"."+ComNumberFixed(p[1], 3);
                        else return "";
                break;
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
     * 소수점 이하 자리 고정을 위한 함수.
     *
     * @param 숫자(문자열), 소숫점 길이 <br>
     * @returns String 예) 45 <br>
     * @author 김영출
     */
  function ComNumberFixed(sVal, iLen){
    try {
      var retStr="";
      var padCnt=Number(iLen) - sVal.length;
      if (padCnt>0) {
        retStr=new Array(padCnt+1).join('0');
        return sVal+retStr;
      }else{
        return sVal.substring(0, iLen);
      }
    } catch(err) { ComFuncErrMsg(err.message); }
  }
    /**
     * 현재 날자를 가져오는 함수.
     *
     * @param 없음 <br>
     * @returns String 예) 2009-07-01 <br>
     * @author 김영출
     */
  function getToday() {
    var today=new Date();
    var yy=today.getFullYear();
    var mm=today.getMonth() + 1;
    var dd=today.getDate();
    if(mm < 10) mm="0" + mm;
    if(dd < 10) dd="0" + dd;
    return (yy + "-" + mm + "-" + dd);
  }
    /*
    * 버튼 색상 변경하는 함수
    * @param name :버튼이름
    * @param color :색상값
    * @author 최영희
    * @version 2009.08.07
    */
    function ComBtnColor(name,color) {
        var tds=document.getElementsByTagName("td");
        for ( var i=0; i < tds.length; i++) {
            var td=tds[i];
            if (td.name == name){
                td.style.color=color;
                break;
            }
        }
     }
    /*
    * Split No 채번 배열 함수
    * @param splitreason : type
    * @param lastno : 마지막 split번호
    * @param splitcount : split 개수
    * @param orgBkgNo : 원본 booking 번호
    * @param bkgNo : 새로운 booking 번호
    * @author 최영희
    * @version 2009.08.21
    */
    function getSplitBkgNo(splitreason,lastno,splitcount,orgBkgNo,bkgNo){
        var imeno=0;
        var newSplitBkgNo=new Array();
        var idx=0;
        for (var i=lastno;i<=splitcount;i++ ){
             if(splitreason.toUpperCase() =="C"){
                if(idx==0){
                    newSplitBkgNo[idx]=orgBkgNo;
                }else{
                    newSplitBkgNo[idx]=bkgNo.substring(0,10)+ComLpad(i,2,"0");
                }
             }else{
                    newSplitBkgNo[idx]=bkgNo.substring(0,10)+ComLpad(i,2,"9");
             }
             idx++;
        }
        return newSplitBkgNo;
    }
    /*
    * Grid Checked 확인 함수
    * @param sheetObject : sheetObject
    * @param prefix : 해당컬럼
    * @author 최영희
    * @version 2009.09.09
    */
    function CheckRowGrid(sheetObject,prefix){
        var iCheckRow=sheetObject.FindCheckedRow(prefix);
        if (iCheckRow < 1) {
             ComShowCodeMessage("BKG00155");
            return false;
        }
        return true;
    }
    /*
    * CarrageReturn 갯수 체크하는 함수
    * @param string : 체크대상문자열
    * @author 김병규
    * @version 2009.09.01
    */
    function countLineBreaks (string) {
        var re=/\r\n|\r|\n/g;
        var n=0;
        while (re.exec(string))
            n++;
        return n;
    }
    /*
    * TextArea 글자수,Row수 제한 Validation 체크
    * @param rows : 최대Row수
    * @param cols : 한Row에 표시될 최대글자수
    * @param obj : Textarea Object
    * @author 김병규
    * @version 2009.09.01
    */
     function validateCols(rows, cols, obj, custTp){
    	 var str = "";
    	 if (event==undefined){
    		 str=obj.value;
    	 }else{
    		 str=ComBkgString(obj);
    	 }
    	 var displayText;
         var parseCols=parseInt(cols);
         var rowArr=str.split("\n");
         for(var i=0 ; i < rowArr.length ; i++){
             if(countLineBreaks(rowArr[i]) > 0){
                 if(rowArr[i].length > parseCols+1){
                     var loopCnt;
                     if(rowArr[i].length%parseCols > 0){
                         loopCnt=rowArr[i].length/parseCols + 1;
                     }else{
                         loopCnt=rowArr[i].length/parseCols;
                     }
                     for(var j=0 ; j < Math.floor(loopCnt) ; j++){
                         if(i < 1){
                             if(j < 1){
                                 displayText=rowArr[i].substring(0,parseCols*(j+1));
                             }else{
                                 displayText=displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
                             }
                         }else{
                             displayText=displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
                         }
                     }
                     if(countLineBreaks(displayText) > 0){
                         displayText=displayText.substring(0,displayText.length-1);
                     }
                 }else{
                     if(i < 1){
                         displayText=rowArr[i];
                     }else{
                         displayText=displayText + "\n" + rowArr[i];
                     }
                 }
             }else{
                 if(rowArr[i].length > parseCols){
                     var loopCnt;
                     if(rowArr[i].length%parseCols > 0){
                         loopCnt=rowArr[i].length/parseCols + 1;
                     }else{
                         loopCnt=rowArr[i].length/parseCols;
                     }
                     for(var j=0 ; j < Math.floor(loopCnt) ; j++){
                         if(i < 1){
                             if(j < 1){
                                 displayText=rowArr[i].substring(0,parseCols*(j+1));
                             }else{
                                 displayText=displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
                             }
                         }else{
                             displayText=displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
                         }
                     }
                 }else{
                     if(i < 1){
                         displayText=rowArr[i];
                     }else{
                         displayText=displayText + "\n" + rowArr[i];
                     }
                 }
             }
         }
         var enterCnt=countLineBreaks(displayText);
         if(rows-1 < enterCnt){
             ComShowCodeMessage("BKG02006", custTp, rows);
             obj.value = "";
             setTimeout(function() {
            	 obj.value = displayText;
            	 obj.focus();
 			 }, 0);
             return false;
         }else{
             obj.value = displayText;
         }
         return true;
     }
    /*
    * 결과값에 따라 Object 색 변경
    * @param objValue : Object의 값
    * @param equalValue : Object와 비교할 값
    * @param objId : Object ID
    * @param color : objValue 와 equalValue와 같을 경우 변경할 색(red,blue...)
    * @param className : objValue 와 equalValue와 같을 경우 변경할 ClassName (현재 사용 안함)
    * @author 김병규
    * @version 2009.09.01
    */
    function changeObjectColor(objValue, equalValue, objId, color, className){
        if(objValue == equalValue){
            ComGetObject(objId).style.setProperty("color", color, "important");
        }else{
        	//ComGetObject(objId).style.color="#737373";
        	ComGetObject(objId).style.setProperty("color", "#737373", "important");
        }
    }
    /*
    * 두 날짜의 차이
    * @author 김병규
    * @version 2009.09.01
    */
    function getDateDiff(etd, eta){
        var sdate=new Date(etd.substring(0,4),etd.substring(5,7),etd.substring(8,10),etd.substring(11,13),etd.substring(14,16));
        var edate=new Date(eta.substring(0,4),eta.substring(5,7),eta.substring(8,10),eta.substring(11,13),eta.substring(14,16));
        return (edate-sdate)/(1000*3600);
    }
    /*
    * Form안의 객체 활성/비활성 함수
    * @param  form : form 객체
    * @param objtype : 활성/비활성 예외 객체
    * @param flag : 활성/비활성 구분자(true:활성,false:비활성)
    * @author 최영희
    * @version 2009.09.17
    */
    function ContrlEnabled(frm,objtype,flag){
        var objs=frm;
        for(var i=0;i<objs.length; i++) {
            if (objs[i].getAttribute("type")==objtype){
                continue;
            }
             try {
                switch( objs[i].getAttribute("type") ) {
                    case "radio" :
                         objs[i].disabled=!flag;
                    case "checkbox" :
                         objs[i].disabled=!flag;
                         break;
                    case "text" :
                         objs[i].readOnly=!flag;
                          if (flag){
                            objs[i].style.background="#FFFFFF";
                          }else{
                            objs[i].style.background="#E8E7EC";
                          }
                         break;
                    case "textarea" :
                         objs[i].disabled=!flag;
                         break;
                    default:
                } // end switch
            } catch(err) { ComFuncErrMsg(err.message); }
        }
    }
    /**
    * 인자로 받은 HTML태그(Object)의 사용 가능/불가능 상태를 변경한다. <br>
    * &lt;input type="text"&gt;와 &lt;input type="password"&gt;의 경우 readOnly속성과 backgroundColor,color를 변경하고,  <br>
    * &lt;img&gt;의 경우 disable속성과  cursor,filter를 변경한다. <br>
    * 그외 HTML태그(Object) disable속성을 변경한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     ComEnableObject(txtName,  true);   // 결과 : &lt;input type="text" name="txtName"&gt;을 enable 상태로 설정한다.
    *     ComEnableObject(txtName,  false);  // 결과 : &lt;input type="text" name="txtName"&gt;을 disable 상태로 설정한다.
    *     ComEnableObject(btn_save, true);   // 결과 : &lt;img name="btn_save"&gt;을 enable 상태로 설정한다.
    *     ComEnableObject(btn_save, false);  // 결과 : &lt;img name="btn_save"&gt;을 disable 상태로 설정한다.
    * </pre>
    * @param {object} obj     필수,대상 HTML태그(Object)
    * @param {bool}   bEnable 필수,사용 가능/불가능 여부를 true/false로 설정한다.
    * @return 없음
    * @see #ComEnableManyObjects
    */
   function BkgEnableObject(obj, bEnable)
   {
       try {
        //disabled나 readOnly 설정하기
           switch( obj.type ) {
               case "password" :
               case "text" :
                obj.readOnly=!bEnable;
                   break;
               default:
                   obj.disabled=!bEnable;
           }
            //설정에 따라 css 처리하기
           switch( obj.type ) {
               case "select-one" :
               case "text" :
                   if (bEnable){
                       obj.className="input";    //흰색바탕
                   }else{
                       obj.className="input2";   //회색바탕
                   }
                   break;
               case "textarea":
                   if (bEnable){
                    obj.className="textarea";
                   } else {
                    obj.className="textarea2";
                   }
                   break;
                default :
                   if (obj.tagName=="IMG") {
                       if (bEnable){
                           obj.style.cursor="hand";
                           obj.style.filter="";
                       } else {
                           obj.style.cursor="default";
                           obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
                       }
                   }
           }
       } catch(err) { ComFuncErrMsg(err.message); }
   }
    /**
     * yyyy-mm-dd를 yyyymmdd로 변환
     * @param date
     * @return String
     * @author 류대영
     * @version 2009.10.30
     */
    function changeDateFormat(date){
      if(ComIsNull(date)) return "";
      return date.substring(0, 4) + date.substring(5, 7) + date.substring(8, 10);
    }
    /**
     * transMode를 PRI code에서 PRD code로 변환
     * @param transMode
     * @return String
     * @author 류대영
     * @version 2009.10.30
     */
    function changeTransMode(transMode){
      if(ComIsNull(transMode)){
          return "AL";
      } else if (transMode == "T"){
          return "TD";
      } else if (transMode == "R"){
          return "RD";
      } else if (transMode == "A"){
          return "TR";
      } else if (transMode == "B"){
          return "WD";
      } else if (transMode == "U"){
          return "TW";
      } else {
          return "AL";
      }
    }
    /**
     * Check Float (정수도 Float로 취급)
     * @param toCheck
     * @return true/false
     * @author 경종윤
     */
    function isFloat(toCheck)
    {
       var chkstr=toCheck+"" ;
       var isFloat=true;
       var chkPoint=false;
       var chkMinus=false;
       if ( toCheck == "" ) {
             return false;
       }
       for (j=0 ; isFloat && (j < toCheck.length); j++) {
           if ( (toCheck.substring(j,j+1) < "0") || (toCheck.substring(j,j+1) > "9")) {
              if ( toCheck.substring(j,j+1) == "." ) {
                 if ( !chkPoint ) chkPoint=true ;
                 else  isFloat=false ;
              } else if ( toCheck.substring(j,j+1) == "-" || toCheck.substring(j,j+1) == "+") {
                 if ( ( j == 0 ) && ( !chkMinus ) ) chkMinus=true ;
                 else isFloat=false;
              } else isFloat=false;
          }
      }
      return isFloat;
    }
    /**
     * 정수와 소수부분 자리수 체크
     * @param varNum : 실수
     * @param varLeft : 정수부분 자리수
     * @param varRight : 소수부분 자리수
     * @return true : 실수가 정/소수부분의 자리수를 초과하지 않는다.<br>
     *         false : 실수가 정/소수부분의 자리수를 초과한다.
     * @author 경종윤
     */
    function checkFloatType( varNum, varLeft, varRight ) {
        if(!isFloat(varNum)) return false;
        var resultFlag=true ;
        var leftLength=0;
        var rightLength=0;
        if ( varNum.charAt(0) == "-" ){
            varNum=varNum.substring(1,varNum.length);
        }
        var pointIndex=varNum.indexOf(".");
        if ( pointIndex < 0 ){
            if ( varNum.length > varLeft )
                resultFlag=false ;
        }else {
            leftLength=varNum.substring(0,pointIndex).length;
            rightLength=varNum.substring(pointIndex+1, varNum.length ).length;
            if ( (leftLength > varLeft) || (rightLength > varRight) )
             resultFlag=false ;
        }
        return resultFlag ;
    }
    /**
    * Vol Detail(ESM_BKG_0890) 호출시 Special Cargo 자동으로 체크해야할지 여부 확인
    * 사용화면 : ESM_BKG_007901,ESM_BKG_0890
    * @param
    * @return true : 자동 체크<br>
    *         false : 현재값 유지
    * @author 김병규
    */
    function isVolDetailAutoChk(){
        var formObj=document.form;
        var defaultCheckCnt=0;        // DG,RF,AK,BB 중 하나만 설정되어있는 경우 자동 체크하기 위한 Count 계산.
        if(ComGetObjValue(formObj.dcgo_flg) == "Y"){
            defaultCheckCnt++;
        }
        if(ComGetObjValue(formObj.rc_flg) == "Y"){
            defaultCheckCnt++;
        }
        if(ComGetObjValue(formObj.awk_cgo_flg) == "Y"){
            defaultCheckCnt++;
        }
        if(ComGetObjValue(formObj.bb_cgo_flg) == "Y"){
            defaultCheckCnt++;
        }
        if(defaultCheckCnt <= 1){
            return true;
        }else{
            return false;
        }
    }
    /**
    * Vol Detail(ESM_BKG_0890) 호출시 Special Cargo 자동으로 체크해야할지 여부 확인
    * 사용화면 : ESM_BKG_007901,ESM_BKG_0890
    * @param
    * @return true : 자동 체크<br>
    *         false : 현재값 유지
    * @author 김병규
    */
    function isAutoChk(){
        var formObj=document.form;
        var defaultCheckCnt=0;        // DG,RF,AK,BB 중 하나만 설정되어있는 경우 자동 체크하기 위한 Count 계산.
        if(ComGetObjValue(formObj.dcgo_flg) == "Y"){
            defaultCheckCnt++;
        }
        if(ComGetObjValue(formObj.rc_flg) == "Y"){
            defaultCheckCnt++;
        }
        if(ComGetObjValue(formObj.awk_cgo_flg) == "Y"){
            defaultCheckCnt++;
        }
        if(ComGetObjValue(formObj.bb_cgo_flg) == "Y"){
            defaultCheckCnt++;
        }
        if(defaultCheckCnt <= 1){
            return true;
        }else{
            return false;
        }
    }
    /**
    * Vol Detail(ESM_BKG_0890) 호출시 Special Cargo 자동 체크
    * 사용화면 : ESM_BKG_007901,ESM_BKG_0890
    * @param sheetObj
    * @param formObj
    * @param idx Sheet Row Index
    * @param rdFlag RD Flag
    * @return true : 자동 체크<br>
    *         false : 현재값 유지
    * @author 김병규
    */
    // DG,RF,AK,BB 중 하나만 설정되어 있는 경우 Default 체크한다.
    function setDefaultCheckCgTp(sheetObj, formObj, idx, rdFlag, qtySheetObj, hangerYn){
        var cntrTpSz="";
        if(sheetObj.GetCellValue(idx, "cntr_tpsz_cd") != "" && sheetObj.GetCellValue(idx, "cntr_tpsz_cd").length > 0){
        	cntrTpSz=sheetObj.GetCellValue(idx, "cntr_tpsz_cd").substring(0,1);
            if(ComGetObjValue(formObj.dcgo_flg) == "Y"){
                if(ComGetObjValue(formObj.hngr_flg) == "Y"){
                    // DG와 Hanger 인 경우 Hanger Vol != TotalVol 인 경우 Hanger는 DR, 나머진 DG
                	qtyRow=qtySheetObj.FindText("cntr_tpsz_cd", sheetObj.GetCellValue(idx, "cntr_tpsz_cd"));
                	if(parseFloat(qtySheetObj.GetCellValue(qtyRow,"op_cntr_qty")) != (parseFloat(qtySheetObj.GetCellValue(qtyRow,"crr_hngr_qty"))+parseFloat(qtySheetObj.GetCellValue(qtyRow,"mer_hngr_qty")))){
                        if(hangerYn == "Y"){
                            sheetObj.SetCellValue(idx, "dry_cgo_flg",1);
                        }else{
                            if(cntrTpSz == "D" || cntrTpSz == "T" || cntrTpSz == "F"){
                                sheetObj.SetCellValue(idx, "dcgo_flg",1);
                            }
                        }
                    }else{
                        if(cntrTpSz == "D" || cntrTpSz == "T" || cntrTpSz == "F"){
                            sheetObj.SetCellValue(idx, "dcgo_flg",1);
                        }
                    }
                }else{
                    if(cntrTpSz == "D" || cntrTpSz == "T" || cntrTpSz == "F" || cntrTpSz == "O"){
                        sheetObj.SetCellValue(idx, "dcgo_flg",1);
                    }
                }
            }else if(ComGetObjValue(formObj.rc_flg) == "Y"){
                if(cntrTpSz == "R"){
                    if(rdFlag == "RD" || rdFlag == "RF" || rdFlag.substring(0,1) == 'D'){
                        sheetObj.SetCellValue(idx, "dry_cgo_flg",1);
                        sheetObj.SetCellValue(idx, "rc_flg",0);
                    }else{
                        sheetObj.SetCellValue(idx, "rc_flg",1);
                        sheetObj.SetCellValue(idx, "dry_cgo_flg",0);
                    }
                }else if(sheetObj.GetCellValue(idx, "cntr_tpsz_cd") == 'T2' || sheetObj.GetCellValue(idx, "cntr_tpsz_cd") == 'T4'){
                	sheetObj.SetCellValue(idx, "rc_flg", 1);
                }else if(cntrTpSz == "D" || cntrTpSz == "T"){
                    sheetObj.SetCellValue(idx, "dry_cgo_flg",1);
                    sheetObj.SetCellValue(idx, "rc_flg",0);
                }
            }else if(ComGetObjValue(formObj.awk_cgo_flg) == "Y"){
                // 20100212 - 아대 조건에 따라 AK 자동 체크
            	if(cntrTpSz == "P" || cntrTpSz == "A" || cntrTpSz == "F" || cntrTpSz == "O" || cntrTpSz == "S" ||  cntrTpSz == "Q"){
                    sheetObj.SetCellValue(idx, "awk_cgo_flg",1);
                    sheetObj.SetCellValue(idx, "dry_cgo_flg",0);
                }else if(cntrTpSz == "D" || cntrTpSz == "T"){
                    sheetObj.SetCellValue(idx, "dry_cgo_flg",1);
                    sheetObj.SetCellValue(idx, "awk_cgo_flg",0);
                }
            }else if(ComGetObjValue(formObj.bb_cgo_flg) == "Y"){
                // 20100321 - BB 선택시 Q2, Q4에 BB check
            	if(cntrTpSz == "P" || cntrTpSz == "A" || cntrTpSz == "F" || cntrTpSz == "Q" || cntrTpSz == "B"){
                    sheetObj.SetCellValue(idx, "bb_cgo_flg",1);
                    sheetObj.SetCellValue(idx, "dry_cgo_flg",0);
                }else if(cntrTpSz == "D" || cntrTpSz == "T"){
                    sheetObj.SetCellValue(idx, "dry_cgo_flg",1);
                    sheetObj.SetCellValue(idx, "bb_cgo_flg",0);
                }
            }else if(ComGetObjValue(formObj.bb_cgo_flg) == "Y"){
                if(cntrTpSz == "P" || cntrTpSz == "A" || cntrTpSz == "F" || cntrTpSz == "B"){
                    sheetObj.SetCellValue(idx, "bb_cgo_flg",1);
                    sheetObj.SetCellValue(idx, "dry_cgo_flg",0);
                }else if(cntrTpSz == "D" || cntrTpSz == "T"){
                    sheetObj.SetCellValue(idx, "dry_cgo_flg",1);
                    sheetObj.SetCellValue(idx, "bb_cgo_flg",0);
                }
            }else{
                sheetObj.SetCellValue(idx, "dry_cgo_flg",1);
            }
        }
    }
    /**
     * Weight/Measure  단위 변환
     *
     * @param fromto 변환 단위
     * @param amt    변환할 양에 해당하는 숫자
     * @return  변환 된 양에 해당하는 숫자
     */
    function ComUnitConverter(fromto, amt){
        switch(fromto) {
            // KGS --> LBS
            case "KGSLBS":
                return (amt * 2.20459)
            break;
            // LBS --> KGS
            case "LBSKGS":
                return (amt * 0.45359)
            break;
            // CBM --> CBF
            case "CBMCBF":
                return (amt * 35.3147)
            break;
            // CBF --> CBM
            case "CBFCBM":
                return (amt * 0.02831)
            break;
            default:
                return amt;
        }
    }
     /**
      * Inquiry 사용자를 위한 버튼 설정
      * (Inbound 전용)
      * @return void
      */
     function ComBtnSetInquiry(){
         var pathName=window.location.pathname;
            //pathName = "ESM_BKG_Q.do";
            if(pathName.lastIndexOf("_Q") != -1){
                var obj=document.getElementsByName("inq");
                for(var i=0;i<obj.length;i++){
                    obj[i].style.display="none";
                }
            }
     }
     /**
      * Pseudo VVD 체크
      * @return boolean
      */
     function CheckPseudoVvd(val){
         if(val == null || val.length != 9){
             return false;
         }
         var postVvd=val.substring(0,4);
         if(postVvd == "COXX" || postVvd == "COYY" || postVvd == "COZZ"){
             return true;
         }else{
             return false;
         }
     }
    /*
     * GroupWare Main창 Open (공통)
     */
    function ComBkgGroupMailset(sheetObj, formObj, subject, contents){
//        var args = document.getElementsByName("gw_args");
//
//        ComSetObjValue(formObj.gw_subject,subject);
//        args[0].value ="reqcontents;"+contents;
//
//        ComOpenGroupwareMail(sheetObj,formObj);
       }
    /************************************************************************************************************
        Inbound Cargo Release (D/O) 공통 함수 구현 시작
    *************************************************************************************************************/
    /************************************************************************************************************
        Inbound Cargo Release (D/O) 공통 함수 구현 종료
    *************************************************************************************************************/
     /**
     * RAS 팝업 호출. <br>
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
    function comRASCallPop(popProgId, callProgId, popParams, callEtc) {
        var isMenuWin=true;
		var winNm="popWin" + popProgId + "_" + callProgId;
	    /***** 메뉴포함 POP - Start *****/
        var pgmNo=popProgId;
   		var pgmUrl="/opuscntr/" + popProgId + ".do";
    	var parentPgmNo=pgmNo.substring(0, 8) + 'M001';
		var src="&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo;
		var sFeatures="status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
		/****** 메뉴포함 POP - Edn ********************************************************/
		/***** 일반 POP - Start *****/
		/* ComOpenWindowCenter(sUrl, sWinName, iWidth, iHeight, bModal, sScroll); */
		var popWidth=1024;
		var popHeight=700;
		var isModal=false;
		var popScroll="no";
		/***** 일반 POP - End *****/
		switch(popProgId) {
			// PRI
			case "ESM_PRI_0004": break; // 0427, 0151, 0256, 0701, 1079, 1080
			case "ESM_PRI_2019": break; // 0427, 0151, 0256, 0701, 1079, 1080
			case "ESM_PRI_3007": break; // 0427, 0151, 0256, 0701, 1079, 1080
			// BKG

			case "ESM_BKG_0079":
				src="&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=ESM_BKG_0079-08&menuflag=true&mainPage=true&pid=ESM_BKG_M024";
				parentPgmNo="ESM_BKG_M024";
				break; // 0427, 0151, 0256, 0701, 1079, 1080
	        case "ESM_BKG_0426":
	        	break; // 0256, 1079, 1080
	        case "ESM_BKG_0698":        // 0256, 0701
	        	isMenuWin=false; popWidth=660; popHeight=400;
	        	break;
			case "ESM_BKG_0712": break; // 0427, 0701
	        case "ESM_BKG_1049":        // 0256, 0701
	            isMenuWin=false; popWidth=1000; popHeight=700;
				break;
	        case "ESM_BKG_1055":        // 0256, 0701
	        	isMenuWin=false; popWidth=600; popHeight=350;
	        	break;
	        case "ESM_BKG_5001":        // 0426, 0712=> Print - RD -> sheet 나 jsp name, type 등의 변경이 있을시 rd 확인...
	        	isMenuWin=false; popWidth=1024; popHeight=720;
	        	break;
        }
		if(isMenuWin){
        	var winObj=window.open(pgmUrl + "?parentPgmNo=" + parentPgmNo + src + "&" + popParams + "&mainMenuLinkFlag=true&MENU=Y");
		}else{
			ComOpenWindowCenter(pgmUrl + "?" + popParams, winNm, popWidth, popHeight, isModal, popScroll);
		}
    }
    /**
    * eBooking/Si 값 비교하여 색 변경 처리. <br>
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {string} bkgValue  : OPUS 쪽의 값 </br>
    * @param {string} eBkgValue : eBkg 쪽의 값 </br>
    * @param {string} eBkgItemNm: 변경하려는 항목 이름
    * @return 없음
    * @author 류대영
    * @version 2010.02.17
    */
    function setDiffCheckColor(bkgValue, eBkgValue, eBkgItemNm){
    	ComGetObject(eBkgItemNm).style.setProperty("color", (bkgValue!=eBkgValue)?BTN_RED:"#606060", "important") ;
    }
    /**
    * special cargo approval code 값 비교하여 button 색 변경 처리. <br>
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param sheetObj
    * @param {string} aproDspCd : special approval code를 화면에 표시하는 값</br>
    * @return RgbColor
    * @author 류대영
    * @version 2010.02.19
    */
	function getSpclCgoBtnColor(aproDspCd){
//		A:APPROVE -> Blue
//		N:REJECT  -> Red
// 		P:PENDING, R:RQST, OTHER:SPECIAL CARGO EXIST -> black
		if(aproDspCd=="A"){
			return "blue";
		} else if(aproDspCd=="N"){
			return BTN_RED ;
		} else {
			return "#737373";
		}
	}
    /**
    * Inbound 화면에서 ERP 호출하는 함수 <br>
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param 없음 </br>
    * @return 없음
    * @author 안진응
    * @version 2010.03.02
    */
    function callInboundErp(){
    	//  http://ktrp4vpg.opuscntr.com:8000/OA_HTML/AppsLocalLogin.jsp
    	ComOpenWindowCenter('http://erp.cyberlogitec.com/OA_HTML/OA.jsp?OAFunc=OAHOMEPAGE', "ERP", 1024, 700, true, "yes");
    }
    function haveOnlyNumber(value){
		var number="0123456789";
		for(var j=0;j<value.length-1;j++){
			if(number.indexOf(value.substring(j,j+1))<0){
				return false;
			}
		}
		return true;
    }
    //소숫점 절사 CutDecimalPoint(대상, 자릿수)
    function CutDecimalPoint(intTarget, intCutPosition) {
  		var intResult=0;
  		var strTarget=String(intTarget).split('.');
  		if (strTarget.length < 2){
  			return strTarget;
  		}
  		if(strTarget[1].length > intCutPosition) {
  			strTarget[1]=strTarget[1].slice(0, intCutPosition);
  		}
  		intResult=Number(strTarget[0]+'.'+strTarget[1]);
  		return intResult;
  	}
	   /**
	   *<PRE>
    * IN조건문에  1000개 이상 데이타가 입력되어야 할경우
    * 피봇팅 함수를 사용하여 가상 테이블로  IN 조건문에 대입해야한다.
    * 즉 BKG_SPLIT_CLOB_FNC메소드를 사용해서 피봇팅을 해야 하는데,
    * 문제는 4000바이트 이상 입력되면 에러가 발생한다.
    *
    * 따라서 아래 메소드를 사용하여, 문제를 해결한다.
    *
    * <br><b>Example :</b>
    * WHERE BKG_NO IN ( SELECT COLUMN_VALUE FROM table(BKG_SPLIT_CLOB_FNC(:bkg_nos)) )
    *  getStringToClobString("SEL000086100,SEL000088300,SEL000089400,SEL000090300",3)
    * :bkg_nos>> to_clob('SEL000086100,SEL000088300,SEL000089400,') || to_clob('SEL000090300')
    * <br>
    * </pre>
    * @param {string} src 조회대상, 필수
    * @param {number} cnt 묶음 개수 , default = 1
    * @param {string} 델리미터, default = ","
    * @param {string} before_str 묶음 앞 문자 default = "to_clob("
    * @param {string} after_str  묶음 뒤 문자 default = ")"
    * @return String
    * @author 김경섭
    * @version 2010.03.25
    */
	function getStringToClobString(src, cnt, del_str ,before_str, after_str){
	 if( src == null) return "";
	 if(before_str == null || before_str =="") before_str="to_clob(";
	 if(after_str == null  || after_str  =="") after_str=")";
	 if(cnt == null  || eval(cnt) == 0 ) cnt=1;
	 if(del_str == null  || del_str =="" ) del_str=",";
	 if (typeof(src) =="string")
			return getArrayToClobString(src.split(del_str), cnt, before_str, after_str,del_str);
	 else if (typeof(src) =="object")
			return getArrayToClobString(src, cnt, before_str, after_str,del_str);
	}
	//getStringToClobString 내부 메소드
	function getArrayToClobString(src, cnt, before_str, after_str,del_str){
		 var result_str="";
		 var real_cnt=1;
		 for (var i=0; i < src.length ; i++) {
				if(src[i] == null  || src[i] =="") continue;
				// 시작부분
				if( cnt == 1 || real_cnt%cnt ==1) {
				   //연결부분
					 if(real_cnt != 1 ) {
							result_str += "||";
					 }
					 result_str += before_str+"'";
				}
				//데이타 부분
				result_str += ComTrim(src[i]);
				if(i != src.length -1) {
					result_str +=del_str;
				}
				//마감부분
				if(cnt == 1 || (real_cnt != 1 && real_cnt%cnt ==0) ) {
					result_str += "'"+after_str;
				}
				real_cnt++;
		 }
				//마감부분
				if(cnt != 1 && (real_cnt-1)%cnt !=0)  {
					result_str += "'"+after_str;
				}
		 return result_str;
	}
    /**
     * Form오브젝트 안에 있는 컨트롤을 QueryString으로 구성한다. 이때, 한글은 인코딩하지 않는다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     var sCondParam=FormQueryString(document.frmSearch); //결과:"txtname=이경희&rdoYn=1&sltMoney=원화";
     * </pre>
     * @param {form} form Form 오브젝트
     * @return string
     * @version 1.0.0.0
     * @see #FormQueryStringEnc
     */
    function FormXterString(form) {
        if (typeof form != "object" ) {
        	ComFuncErrMsg("Error : Please contact the administrator\n" + "Detail : Parameter of FormQueryString Function is not a FORM Tag.");
            return "";
        }
        var name=new Array(form.elements.length);
        var value=new Array(form.elements.length);
        var j=0;
        var plain_text="";
        //사용가능한 컨트롤을 배열로 생성한다.
        len=form.elements.length;
        for (i=0; i < len; i++) {
          //클래스 아이디로 제품을 구분함-아래는 HTMl제품
          if(form.elements[i].classid==undefined){
        	  if ( "2" != form.elements[i].name.substr(form.elements[i].name,form.elements[i].name.length-1,form.elements[i].name.length) &&
        		   "2" != form.elements[i].className.substr(form.elements[i].className,form.elements[i].className.length-1,form.elements[i].className.length) ) {
	        	  //전송전에 폼의 마스크를 제거한다.
	//        	  ComClearSeparator(form.elements[i]);
		          switch (form.elements[i].type) {
		            case "button":
		            case "reset":
		            case "submit":
		              break;
		            case "radio":
		            case "checkbox":
		                        if (form.elements[i].checked == true) {
		                            name[j]=form.elements[i].name;
		                            value[j]=form.elements[i].value;
		                            j++;
		                        }
		                        break;
		                case "select-one":
		                        name[j]=form.elements[i].name;
		                        var ind=form.elements[i].selectedIndex;
		                        if(ind >= 0) {
		                            if (form.elements[i].options[ind].value != '')
		                                value[j]=form.elements[i].options[ind].value;
		                            else
		                                value[j]='';
		                        } else {
		                            value[j]="";
		                        }
		                        j++;
		                        break;
		                case "select-multiple":
		                        name[j]=form.elements[i].name;
		                        var llen=form.elements[i].length;
		                        var increased=0;
		                        for( k=0; k < llen; k++) {
		                            if (form.elements[i].options[k].selected) {
		                                name[j]=form.elements[i].name;
		                                if (form.elements[i].options[k].value != '')
		                                    value[j]=form.elements[i].options[k].value;
		                                else
		                                    value[j]='';
		                                j++;
		                                increased++;
		                            }
		                        }
		                        if(increased > 0) {
		                            j--;
		                        } else {
		                            value[j]="";
		                        }
		                        j++;
		                        break;
		                    default :
		                        name[j]=form.elements[i].name;
		                        value[j]=form.elements[i].value;
		                        j++;
		          }
            }
    	  	//전송후에 폼의 마스크를 다시 셋팅한다.
//          ComAddSeparator(form.elements[i]);
        //IB에서 제공하는 컨트롤의 값을 조합한다.
        }
       }
        for (i=0; i < j; i++) {
            // if (name[i] != '') plain_text += name[i]+ "=" + value[i] + "&";
            if (name[i] != '') plain_text += name[i]+ "=" + encodeURIComponent(value[i]) + "&";
        }

      //마지막에 &를 없애기 위함
      if (plain_text != "")
        plain_text=plain_text.substr(0, plain_text.length -1);
        return plain_text;
    }
    /**
     * 구주 위험물(0965, 0966) Bay-Plan 팝업 오픈<br>
     * @param formObj
     * @param openType (1: 조회시 열리는 팝업, 2:  Bay-Plan 팝업 버튼 클릭시)
     * @param modalType(true:modal, false:비 modal)
     * @return
     */
    function openBayPlanPop(formObj, openType, modalType) {
    	var vvdCd=formObj.vvd_cd.value;
    	var portCd=formObj.port_cd.value;
    	var etaDate=formObj.frm_eta_d.value;
    	var etaTime=formObj.frm_eta_t.value;
    	var etdDate=formObj.frm_etd_d.value;
    	var etdTime=formObj.frm_etd_t.value;
    	var currMainPageListCnt=formObj.currMainPageListCnt.value;
    	sUrl="ESM_BKG_0963.do?"; // Bay plan Setup 화면
    	sParam="vvdCd="+vvdCd+"&portCd="+portCd+"&etaDate="+etaDate+"&etaTime="+etaTime
    			+"&etdDate="+etdDate+"&etdTime="+etdTime+"&openType="+openType
    			+"&currMainPageListCnt="+currMainPageListCnt;
    	var rtnVal=ComOpenWindowCenter(sUrl+sParam, "ESM_BKG_0963", 800, 420, modalType);
    	return  rtnVal;
    }
    //탭전역변수(booking)
 	var bkgTabName = ["BKG Creation(1)","TRO/O","TRO/I","CNTR(4)","Customer(5)",
                      "M&D(6)","C/M(7)","Charge(8)","B/L Issue(9)","House B/L(10)"];
    //탭전역변수(eBooking)
	var eBkgTabName = ["Booking","Customer","Container","M&D","C/M","TRO/O",
	                   "Reefer","Danger","Awkward","House B/L 1","House B/L 2"];
	/**
     * 호출 화면에 해당 기능별 단축키를 적용한다.
     */
 	function applyShortcut() {
 		var obj;
		//search
 		obj=getShortcut("search");
 		setUnderline(obj,"R");
 		shortcut("alt+r",function(){runShortcut("search");});
 		//save
 		obj=getShortcut("save");
 		setUnderline(obj,"S");
 		shortcut("alt+s",function(){runShortcut("save");});
 		//new
 		obj=getShortcut("new");
 		setUnderline(obj,"N");
 		shortcut("alt+n",function(){runShortcut("new");});
 		//eBkg
 		if (0<location.href.indexOf("ESM_BKG_0229")) {
 			//upload
	 		obj=getShortcut("upload");
	 		setUnderline(obj,"l");
	 		shortcut("alt+l",function(){runShortcut("upload");});
 		}
 		//bkg-cntr
 		if (0<location.href.indexOf("ESM_BKG_0079_04")) {
 			//confirm
	 		obj=getShortcut("confirm");
	 		setUnderline(obj,"i",2);
	 		shortcut("alt+i",function(){runShortcut("confirm");});
 		}
 		//bkg-charge
	 	if (0<location.href.indexOf("ESM_BKG_0079_08")) {
	 		//autoRating
 			obj=getShortcut("autoRating");
	 		setUnderline(obj,"u");
	 		shortcut("alt+u",function(){runShortcut("autoRating");});
 		}
	 	//eBkg - bkg
	 	if (0<location.href.indexOf("ESM_BKG_0229_01")) {
	 		//gotoBkg
 			obj=getShortcut("gotoBkg");
	 		setUnderline(obj,"G");
	 		shortcut("alt+g",function(){runShortcut("gotoBkg");});
 		}
	 	//special bkg
	 	if (0<location.href.indexOf("ESM_BKG_0055") || 0<location.href.indexOf("ESM_BKG_0106") ||
	 		0<location.href.indexOf("ESM_BKG_0200") || 0<location.href.indexOf("ESM_BKG_0498") ||
	 		0<location.href.indexOf("ESM_BKG_0079_02B")) {
	 		//request
 			obj=getShortcut("request");
	 		setUnderline(obj,"q");
	 		shortcut("alt+q",function(){runShortcut("request");});
 		}
 		if (0<location.href.indexOf("ESM_BKG_0079") && document.form && document.form.shortcutTab && ""!=document.form.shortcutTab.value) {
	 		var shortcutTab=Number(document.form.shortcutTab.value);
	 		document.form.shortcutTab.value="";
	 		runShortcut("tab",bkgTabName[shortcutTab-1]);
	 	}
		setForceFocus();
 	}
	/**
     * CoBkg.js 가 include 되어있는 페이지에 단축키를 적용한다.
     */
  	shortcut("alt+1",function(){applyMainShortcut(1)});
//	shortcut("alt+2",function(){applyMainShortcut(2)});
//	shortcut("alt+3",function(){applyMainShortcut(3)});
	shortcut("alt+4",function(){applyMainShortcut(4)});
	shortcut("alt+5",function(){applyMainShortcut(5)});
	shortcut("alt+6",function(){applyMainShortcut(6)});
	shortcut("alt+7",function(){applyMainShortcut(7)});
	shortcut("alt+8",function(){applyMainShortcut(8)});
	shortcut("alt+9",function(){applyMainShortcut(9)});
	shortcut("alt+0",function(){applyMainShortcut(10)});
 	function applyMainShortcut(shortcutTab) {
 		if ("complete"==document.readyState) {
 			if (0<location.href.indexOf("ESM_BKG_0079") || 0<location.href.indexOf("ESM_BKG_0366")) {
// 				runShortcut("tab",bkgTabName[shortcutTab-(shortcutTab>6 ? 0 : 1)]);
 				runShortcut("tab",bkgTabName[shortcutTab - 1]); // Luc Duong fixes bug: #36568 (Tab display wrong and focus wrong when use shortcut key)
 			} else if (0<location.href.indexOf("ESM_BKG_0229")) {
 				if (parent.frames && 12==parent.frames.length) {
 					var t1frame_form=parent.frames("t1frame").form;
 					if (1==shortcutTab) {
 			 			runShortcut("tab",eBkgTabName[0]);
 			 		}
 					if (4==shortcutTab && "Y"==t1frame_form.save_cust_flag.value) {
 			 			runShortcut("tab",eBkgTabName[1]);
 			 		}
 			 		if (5==shortcutTab && "Y"==t1frame_form.save_cntr_flag.value) {
 			 			runShortcut("tab",eBkgTabName[2]);
 			 		}
 					if (6==shortcutTab && "Y"==t1frame_form.save_mnd_flag.value) {
 				 		runShortcut("tab",eBkgTabName[3]);
 					}
 					if (7==shortcutTab && "Y"==t1frame_form.save_cm_flag.value) {
 				 		runShortcut("tab",eBkgTabName[4]);
 					}
 					if (8==shortcutTab && "Y"==t1frame_form.save_tro_flag.value) {
 				 		runShortcut("tab",eBkgTabName[5]);
 					}
// 					if (7==shortcutTab && "Y"==t1frame_form.save_rf_flag.value) {
// 				 		runShortcut("tab",eBkgTabName[6]);
// 					}
// 					if (8==shortcutTab && "Y"==t1frame_form.save_dg_flag.value) {
// 				 		runShortcut("tab",eBkgTabName[7]);
// 					}
// 					if (9==shortcutTab && "Y"==t1frame_form.save_ak_flag.value) {
// 				 		runShortcut("tab",eBkgTabName[8]);
// 					}
// 					if (10==shortcutTab && "Y"==t1frame_form.save_bb_flag.value) {
// 				 		runShortcut("tab",eBkgTabName[9]);
// 					}
				}
 			} else {
 				var popupUrl = "";
				if (1==shortcutTab) {  //Booking Creation [Alt+1]
				    popupUrl = "ESM_BKG_0079.do?mainPage=true";
//				} else if (2==shortcutTab) {  //Container Information [Alt+2]
//				    popupUrl = "ESM_BKG_0079.do?openTab=B2&mainPage=true";
//				} else if (3==shortcutTab) {  //Container Information [Alt+3]
//				    popupUrl = "ESM_BKG_0079.do?openTab=B3&mainPage=true";
				} else if (4==shortcutTab) {  //Container Information [Alt+4]
		 		    popupUrl = "ESM_BKG_0079.do?openTab=B4&mainPage=true";
				} else if (5==shortcutTab) {  //Customer Information [Alt+5]
				    popupUrl = "ESM_BKG_0079.do?openTab=B5&mainPage=true";
				} else if (6==shortcutTab) {  //Mark & Description [Alt+6]
					popupUrl = "ESM_BKG_0079.do?openTab=B6&mainPage=true";
				} else if (7==shortcutTab) {  //C/M [Alt+7]
				    popupUrl = "ESM_BKG_0079.do?openTab=B7&mainPage=true";
				} else if (8==shortcutTab) {  //Freight & Charge [Alt+8]
				    popupUrl = "ESM_BKG_0079.do?openTab=B8&mainPage=true";
				} else if (9==shortcutTab) {  //B/L Issue [Alt+9]
				    popupUrl = "ESM_BKG_0079.do?openTab=B9&mainPage=true";
				} else if (10==shortcutTab) {  //House B/L [Alt+10]
				    popupUrl = "ESM_BKG_0079.do?openTab=B10&mainPage=true";
 				}
				if(popupUrl != ""){
//					ComOpenWindowCenter(popupUrl, "ESM_BKG_0079", 1025, 700, true, "false");
					window.open(popupUrl);
				}
 			}
 		}
    }
    /**
     * 단축키 버튼 element 를 가져온다.
     * - objRetList : 단축키(Search)를 적용할 화면에있는 버튼의 id 의 배열
     * - objSavList : 단축키(Save)를 적용할 화면에있는 버튼의 id 의 배열
     * - objNewList : 단축키(New)를 적용할 화면에있는 버튼의 id 의 배열
     * - objUplList : 단축키(Upload)를 적용할 화면에있는 버튼의 id 의 배열
     *
     * @param mode 단축키 기능 구분
     * @return obj 단축키 버튼 element
     */
	function getShortcut(mode) {
		var objRetList=["btn_Retrieve","btn_retrieve","btn_t1Retrieve","btn_t2aRetrieve","btn_t2bRetrieve","btn_t2cRetrieve","btn_t6retrieve","btn_t7Retrieve","btn_t8Retrieve","btn_t9Retrieve","btn_t10retrieve","btn_t11Retrieve","btn_retrive"];
		var objSavList=["btn_Save","btn_save","btn_t1Save","btn_t2aSaveSeq","btn_t2bSaveSeq","btn_t2cSaveSeq","btn_t6save","btn_t7Save","btn_t8Save","btn_t9Save","btn_t10save","btn_t11Save"];
		var objNewList=["btn_new","btn_t1New","btn_t7New","btn_t8New","btn_t11New"];
		var objUplList=["btn_upload"];
		var objCfmList=["btn_t6cntrconfirm"];
		var objRatList=["btn_t10auto_rating"];
		var objBkgList=["btn_gotobkg"];
		var objReqList=["btn_Request","btn_request","btn_t2bRequest"];
		var arr=tab=idx=null;
			 if ("search"  ==mode) arr=objRetList;
		else if ("save"      ==mode) arr=objSavList;
		else if ("new"       ==mode) arr=objNewList;
		else if ("upload"    ==mode) arr=objUplList;
		else if ("confirm"   ==mode) arr=objCfmList;
		else if ("autoRating"==mode) arr=objRatList;
		else if ("gotoBkg"   ==mode) arr=objBkgList;
		else if ("request"   ==mode) arr=objReqList;
		else if ("tab"       ==mode) {
			var ptab1 = parent.tab1;
			var ftab1;
			if(document.getElementById("DIV_tab1") == null || document.getElementById("DIV_tab1") == undefined ){
				ftab1 = parent.tab1;
			} else {
				ftab1 = tab1;
			}

			//parent에 tab1이 있으면 parent의 tab1이 우선.
			if (parent && parent.document && "complete"==parent.document.readyState && ptab1) {
				return ptab1;
			}
			if (document && "complete"==document.readyState && ftab1) {
				return ftab1;
			}
			arr=null;
		}
		if (arr) {
			if (parent && parent.document && "complete"==parent.document.readyState && ptab1) {
				idx=ptab1.GetSelectedIndex();
			}
			if (document && "complete"==document.readyState && ftab1) {
				idx=ftab1.GetSelectedIndex();
			}
			for (var i=0; i<arr.length; i++) {
				//현재 포커스에 obj가 있으면 현재 document가 우선, 그다음은 parent에서 찾고,
				//그래도 없으면 프레임내에서 찾는다.
				if (document && "complete"==document.readyState) {
					if (document.getElementById(arr[i])!=null) return document.getElementById(arr[i]);
					if (document.all(arr[i])!=undefined) return document.all(arr[i]);
				}
				if (parent && parent.document && "complete"==parent.document.readyState && parent.document.getElementById(arr[i])) {
					return parent.document.getElementById(arr[i]);
				}
				if (frames && frames[idx] && frames[idx].document && "complete"==frames[idx].document.readyState && frames[idx].document.getElementById(arr[i])) {
					return frames[idx].document.getElementById(arr[i]);
				}
			}
		}
		return null;
	}
    /**
     * 단축키 실행
     *
     * @param mode 단축키 기능 구분
     * @param tabName 탭만 적용 되는 파라미터
     */
	function runShortcut(mode,tabName) {
		var obj=getShortcut(mode);
		if (obj) {
			if ("tab"==mode) {
				if (ComGetObject("t1frame")) {

					var tid=setInterval(function(){
						if ("complete"==parent.t1frame.document.readyState) {
							clearInterval(tid);
							fireTab(obj,tabName);
						}
					},10);
				} else {
					fireTab(obj,tabName);
				}
			} else if (obj.tagName.toLowerCase()=="button"){
				obj.focus();
				$(obj).click();
			}
			setForceFocus();
		}
	}

    function fireTab(obj,tabName) {
		for (var idx=0; idx<obj.GetCount(); idx++) {
			if (tabName==obj.GetTabTitle(idx)) {
 				//obj.document.beforetab=10;
				obj.SetSelectedIndex(idx);
				break;
			}
		}
    }
    /**
     * 단축키 버튼 밑줄 표시
     *
     * @param obj 단축키 버튼 element
     * @param txt 단축키 문자
     * @param idx 단축키 문자 순번
     */
 	function setUnderline(obj,txt,idx) {
 		if (obj && $(obj).html() != undefined){
 			if (txt=="R") txt="r";	//조회버튼이 Search에서 Search로 바꼈음
 	 		var sBtnText = $(obj).html();
 	 		var ii=sBtnText.indexOf(txt);
 			if (idx) ii=sBtnText.indexOf(txt,1+ii);
 			$(obj).html(sBtnText.substring(0,ii) + "<span class='underline'>"+ txt +"</span>" + sBtnText.substr(ii+1));
 		}
 	}
 	/**
     * 강제focus
     */
    function setForceFocus() {
		var ptab1 = parent.tab1;
		var ftab1;
		if(document.getElementById("DIV_tab1") == null || document.getElementById("DIV_tab1") == undefined ){
			ftab1 = parent.tab1;
		} else {
			ftab1 = tab1;
		}

    	var idx=0;
		if (parent && parent.document) {
			if ("complete"==parent.document.readyState) {
				if (ptab1) {
					idx=ptab1.GetSelectedIndex();
				}
			} else return false;
		}
		if (document) {
			if ("complete"==document.readyState) {
				if (ftab1) {
					idx=ftab1.GetSelectedIndex();
				}
			} else return false;
		}
		if (frames && frames[idx] && frames[idx].document && frames[idx].document.form) {
			if (0<frames[idx].location.href.indexOf("ESM_BKG_0079_08")) {
				if (frames[idx].document.form.frm_t10sheet1_bkg_no) {
					ComSetFocus(frames[idx].document.form.frm_t10sheet1_bkg_no);
				}
			} else if (0<frames[idx].location.href.indexOf("ESM_BKG_0079_09")) {
				if (frames[idx].document.form.frm_t11sheet1_bkg_no) {
					ComSetFocus(frames[idx].document.form.frm_t11sheet1_bkg_no);
				}
			} else {
				if (frames[idx].document.form.bkg_no) {
					ComSetFocus(frames[idx].document.form.bkg_no);
				}
			}
		} else if (document && document.form) {
			if (0<location.href.indexOf("ESM_BKG_0079_08")) {
				if (document.form.frm_t10sheet1_bkg_no) {
					ComSetFocus(document.form.frm_t10sheet1_bkg_no);
				}
			} else if (0<location.href.indexOf("ESM_BKG_0079_09")) {
				if (document.form.frm_t11sheet1_bkg_no) {
					ComSetFocus(document.form.frm_t11sheet1_bkg_no);
				}
			} else {
				if (document.form.bkg_no) {
					ComSetFocus(document.form.bkg_no);
				}
			}
		}
		return true;
    }
	/**
	 * Shift + Tab을 누르면 그전 text의 value값을 지우는 기능<br>
	 * MaxLength가 되면 다음탭으로 자동으로 이동하는 경우<br>
	 * Shift + Tab을 누르면 그전 textbox에 focus가 가지 않아 이 기능을 추가함.
	 */
	function obj_KeyDownShiftTab() {
		var formObj=document.form;
		var srcName=ComGetEvent("name");
		var srcValue=ComGetEvent("value");
		if (ComGetEvent("keycode") == 9 && window.event.shiftKey) {
			for (var i=0; i<formObj.elements.length; i++) {
				if (formObj.elements[i].name == srcName && i > 0) {
					formObj.elements[i-1].value="";
					break;
				}
			}
		}
	}
    /**
     * sheet의 height를 계산한다.
     * (2007.2.14 - Kevin.KIM)
     *
     * @param sheetObj : sheet
     * @param retType : 추출방법 (MAX:최대값,MIN:최소값)
     * @param scrollCnt : 스크롤 여부 (0:없음, 1:있음) --> 단, MAX만 적용
     * @return heightCnt
     */
    function getSheetHeightCnt(sheetObj, retType, scrollCnt) {
		var basCnt=20;  //기본 height
		var maxCnt=100; //허용가능한 최대 height
		var heightCnt=0;
    	with (sheetObj) {
			if (retType.toUpperCase() == "MAX") {
        	    heightCnt=maxCnt;
           	    if (LastRow()> 0) {
       	            heightCnt=HeaderRows()+ LastRow()+ scrollCnt + 1; //예비 +1
        	    } else { //조회된 데이터가 없으면
        	        heightCnt=basCnt;
        	    }
			} if (retType.toUpperCase() == "MIN") {
       	        heightCnt=basCnt;
			}
    	}
        if (heightCnt > maxCnt) {
            heightCnt=maxCnt;
        }
        if (heightCnt < basCnt) {
            heightCnt=basCnt;
        }
    	return heightCnt;
    }
	 /**
     * Sheet를 초기화 하는 함수
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {int} idx 필수, Sheet의 인덱스
     * @return {void}
     * @author Park Mangeon
     * @version 2009.10.01
     */
    function fnInSetComboBox(element, codes, values, splitChr, othCode, othValue, bOthAppendFirst, initValue) {
        var bComboExists=false;
        for(var i=element.options.length;i >= 0;i--){
        	element.remove(i);
        }
        if (othCode != undefined && othCode != null ){
        	if (bOthAppendFirst) {
    	        var othCodeArr=othCode.split(splitChr);
    	        var othValueArr=othValue.split(splitChr);
    	        for(var m=0; m<othCodeArr.length; m++) {

    	            /*var oOption=document.createElement("OPTION");
    	            element.options.add(oOption);
    	            oOption.innerText=othValueArr[m];
    	            oOption.value=othCodeArr[m];     */
    	        	var selectedFlag = "";
    	            if(initValue == othCodeArr[m]){
    	            	selectedFlag = "selected";
    	                //oOption.selected=true;
    	                bComboExists=true;
    	            }

    	        	$(element).append("<option value='"+othCodeArr[m]+"' selectedFlag >"+othValueArr[m]+"</option>" );
    	        }
        	}
        }
        var codeArr=codes.split(splitChr);
        var valueArr=values.split(splitChr);
        for(var m=0; m<codeArr.length -1; m++) {
        	var selectedFlag = "";
            if(initValue == codeArr[m]){
            	selectedFlag = "selected";
                //oOption.selected=true;
                bComboExists=true;
            }

        	$(element).append("<option value='"+codeArr[m]+"' selectedFlag >"+valueArr[m]+"</option>" );
            /*var oOption=document.createElement("OPTION");
            element.options.add(oOption);
            oOption.innerText=valueArr[m];
            oOption.value=codeArr[m];
            if(initValue == codeArr[m]){
                oOption.selected=true;
                bComboExists=true;
            }*/
        }
        if (othCode != undefined && othCode != null ){
        	if (!bOthAppendFirst) {
    	        var othCodeArr=othCode.split(splitChr);
    	        var othValueArr=othValue.split(splitChr);
    	        for(var m=0; m<othCodeArr.length; m++) {
    	        	var selectedFlag = "";
    	            if(initValue == othCodeArr[m]){
    	            	selectedFlag = "selected";
    	                //oOption.selected=true;
    	                bComboExists=true;
    	            }

    	        	$(element).append("<option value='"+othCodeArr[m]+"' selectedFlag >"+valueArr[m]+"</option>" );
    	        	/*
    	            var oOption=document.createElement("OPTION");
    	            element.options.add(oOption);
    	            oOption.innerText=othValueArr[m];
    	            oOption.value=othCodeArr[m];
    	            if(initValue == othCodeArr[m]){
    	                oOption.selected=true;
    	                bComboExists=true;
    	            }
*/    	        }
        	}
        }
        if (!bComboExists) {
        	element.value=valueArr[0];
        }
    }
    function BkgIsEmailAddr(obj) {
 		try {
            var retArr=obj.split(";");
            for ( var i=0; i < retArr.length; i++) {
             if(retArr[i].trim() != ""){
            	 var sVal=getArgValue(retArr[i]);
            	  var format=/^\s*[\w\~\-\&\.]+\@[\w\~\-]+(\.[\w\~\-]+)+\s*$/g;
	            	if(sVal.search(format) == -1&& sVal != ""){
	            		break;
	            	}
              }else{
            	  if(sVal == "" || sVal == null||sVal == undefined){
            		  return;
            	  }
            	  break;
              }
            }
            return (sVal.search(format) != -1);
        } catch(err) { ComFuncErrMsg(err.message); }
    }



 // MemoPad를 위한 전역 변수
 var MEMO_FRAME_NAME = "_iFrameMemo_";
 var MEMO_DIV_NAME = "_DivMemo_";
 var MEMO_TEXT_NAME = "_MemoText_";
 var memoSheet = null, memoRow, memoCol;

 /**
  * IBSheet의 특정셀의 글자가 줄바꿈되어 한눈에 볼수 없을때 MemoPad를 이용하여 확인하거나 값을 변경할 때 사용한다. <br>
  * MemoPad는 TextArea와 버튼으로 구성되며, 값을 확인하고 MemoPad를 닫을때는 ESC키를 누르거나 Close 버튼을 누르거나
  * HTML 영역을 클릭한다. <br>
  * MemoPad가 표시될 위치의 셀은 반드시 편집불가능이어야 한다. <br>
  * <br>
  * <b>Example :</b>
  *
  * <pre>
  * function sheet1_OnClick(sheetObj, Row, Col, Value) {
  * 	//desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
  * 	if (sheetObj.ColSaveName(Col) == &quot;desc&quot;)
  * 		ComShowBkgMemoPad(sheetObj);
  * }
  * function sheet2_OnClick(sheetObj, Row, Col, Value) {
  * 	//desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집불가능)
  * 	if (sheetObj.ColSaveName(Col) == &quot;desc&quot;)
  * 		ComShowBkgMemoPad(sheetObj, Row, Col, true);
  * }
  * </pre>
  *
  * @param {ibsheet}
  *            sheetObj 필수,IBSheet Object
  * @param {int}
  *            row 선택,MemoPad를 표시할 셀의 행 Index, default=sheetObj.SelectRow
  * @param {int}
  *            col 선택,MemoPad를 표시할 셀의 컬럼 Index, default=sheetObj.SelectCol
  * @param {bool}
  *            bReadOnly 선택,MemoPad에 표시된 값의 편집가능 여부, default=true
  * @param {int}
  *            iWidth 선택,MemoPad의 넓이, default=200
  * @param {int}
  *            iHeight 선택,MemoPad의 높이, default=200
  * @param {boolean}
  * 		   bEventRaise	선택,MomoPad 입력 후 적용 시, Sheet 의 OnChange Event 발생 여부
  * @see #ComHideBkgMemoPad
  * @return 없음<br>
  */
 function ComShowBkgMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax, bEventRaise, fDate) {
 	try {
 		// 함수의 인자 default 값 설정하기
 		if (row == undefined || row == null)
 			row = sheetObj.GetSelectRow();
 		if (col == undefined || col == null)
 			col = sheetObj.GetSelectCol();
 		if (bReadOnly == undefined || bReadOnly == null)
 			bReadOnly = false;
 		if (iWidth == undefined || iWidth == null)
 			iWidth = 200;
 		if (iHeight == undefined || iHeight == null)
 			iHeight = 200;
 		if (iMax == undefined || iMax == null)
 			iMax = 4000;

 		// 메모를 위한 IBSheet 정보의 Validation 확인하기
 		if (sheetObj.GetCellEditable(row, col)) {
 			return ComShowMessage("[ComShowBkgMemoPad] " + sheetObj.id + "(" + row
 					+ "," + col + ") 셀은 편집불가능이어야 합니다.");
 		}
 		// 메모를 위한 IBSheet 정보 받기
 		if (!ComIsNumber(col))
 			col = sheetObj.SaveNameCol(col);
 		memoSheet = sheetObj;
 		memoRow = row;
 		memoCol = col;

 		// 메모메드 만들기
 		if (!initBkgMemoPad(iMax, bEventRaise, fDate)) return;

 		// 메모 DIV 표시할 위치 계산하기 (AnchorPosition_getPageOffsetLeft,
 		// AnchorPosition_getPageOffsetTop 함수는 ComCalendar.js 있는것을 사용함)
 		var iLeft = AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col);
 		var iTop = AnchorPosition_getPageOffsetTop(sheetObj)	+ sheetObj.RowTop(row);

 		// 현재페이지가 iframe이나 frame 안에 있고, 그것의 scrolling이 불가능한 경우 표시 위치를 변경함
 		if (top.document != document && window.frameElement.scrolling == "no") {
 			// 높이초과
 			if (iTop + iHeight > document.body.clientHeight) {
 				iBottom = iTop + sheetObj.GetRowHeight(row);
 				if (iBottom > document.body.clientHeight)
 					iBottom = document.body.clientHeight;
 				iTop = iBottom - iHeight;
 				if (iTop < 0)
 					iTop = 0
 			}

 			// 넓이초과
 			if (iLeft + iWidth > document.body.clientWidth) {
 				iLeft = document.body.clientWidth - iWidth;
 				if (iLeft < 0)
 					iLeft = 0;
 			}
 		}

 		var _divMemo = document.getElementById(MEMO_DIV_NAME);
 		var _frameDoc = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;

 		_frameDoc.getElementById("btn_apply").style.display = (bReadOnly) ? "none": "inline";
 		_frameDoc.getElementById(MEMO_TEXT_NAME).style.backgroundColor = bReadOnly ? "#E8E7EC": "";
 		_frameDoc.getElementById(MEMO_TEXT_NAME).style.fontFamily = sheetObj.GetSheetFontName();
 		_frameDoc.getElementById(MEMO_TEXT_NAME).style.fontSize = 11;
// 		_frameDoc.getElementById(MEMO_TEXT_NAME).style.height = iHeight - 50 +"px";
 		_frameDoc.getElementById(MEMO_TEXT_NAME).style.height = iHeight - 40 +"px";
 		_frameDoc.getElementById(MEMO_TEXT_NAME).style.width = iWidth +"px";
 		_frameDoc.getElementById(MEMO_TEXT_NAME).value = sheetObj.GetCellText(row, col);
 		_frameDoc.getElementById(MEMO_TEXT_NAME).readOnly = bReadOnly;

// 		_divMemo.style.width = (iWidth+30)+ "px";
 		_divMemo.style.width = (iWidth+20)+ "px";
 		_divMemo.style.height = (iHeight)+"px";
 		_divMemo.style.top = iTop + "px";
 		_divMemo.style.left = iLeft + "px";
 		_divMemo.style.visibility = "visible";
 		_divMemo.focus();

 		ComSetFocus(_frameDoc.getElementById(MEMO_TEXT_NAME));
 	} catch (err) {
 		ComFuncErrMsg(err.message);
 	}
 }

 /**
  * 표시된 MemoPad를 강제로 닫을때 이 함수를 사용한다. <br>
  *
  * @param {bool}
  *            bFocus 선택,닫은 후 처음열었던 IBSheet로 포커스를 설정할지 여부, default=false
  * @see #ComShowBkgMemoPad
  * @return 없음<br>
  */
 function ComHideBkgMemoPad(bFocus) {
 	try {
 		if (document.getElementById(MEMO_DIV_NAME) == null || memoSheet == null)
 			return;
 		document.getElementById(MEMO_DIV_NAME).style.visibility = "hidden";

 		var sheetObj = memoSheet;
 		memoSheet = null;

 		if (bFocus) {
 			sheetObj.focus(); // 포커스 하는 순간 이 함수가 또 호출되므로 sheetObj 변수로 다시 받았음
 			sheetObj.SelectCell(memoRow, memoCol, 0);
 		}
 	} catch (err) {
 		;
 	}
 }

 /**
  * MemoPad에서 Apply 버튼을 눌렀을때 이 함수를 호출하며, MemoPad의 값을 IBSheet의 특정셀로 설정한다. <br>
  * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
  */
 function setBkgMemoValue(sValue, iMax, bEventRaise) {
 	try {
 		if (sValue.length > iMax) {
 			ComShowMessage("characters long");
 			// document.getElementById(MEMO_FRAME_NAME).focus();
 			return;
 		} else {
 			if (memoSheet == null)
 				return;
 			if(bEventRaise) {
 	 			memoSheet.SetCellValue(memoRow, memoCol, sValue, 0);

 			}else{
 	 			memoSheet.SetCellValue(memoRow, memoCol, sValue, 0);

 	 			var data_type=memoSheet.GetCellProperty(memoRow, memoCol, 0);
 	 			if(data_type == dtData) {
 	 				memoSheet.SetCellValue(memoRow, memoCol,memoSheet.GetCellValue(memoRow, memoCol).toUpperCase(),0);
 	 			}

 			}
 			ComHideBkgMemoPad(true);
 		}
 	} catch (err) {
 		ComFuncErrMsg(err.message);
 	}
 }

 /**
  * MemoPad를 위한 DIV안에 iFrame을 만들고, iFrame안에 Textarea와 버튼을 생성한다. <br>
  * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
  */
 function initBkgMemoPad(iMax, bEventRaise, fDate) {
 	try {
 		// 메모용 Div가 없으면 생성한다.
 		if (document.getElementById(MEMO_DIV_NAME) != null)
 			return true;

 		// 메모용 Div 만들기
         var _divMemo=document.createElement("div");
         _divMemo.id=MEMO_DIV_NAME;
         _divMemo.style.position = "absolute";
         _divMemo.style.overflow = "hidden";
         _divMemo.style.width = "200px";
         _divMemo.style.height = "200px";
         _divMemo.style.zIndex = "1000";
         _divMemo.style.visibility="hidden";

         document.body.appendChild(_divMemo);

         //var _divMemo = document
 		//		.createElement("<div id='"
 		//				+ MEMO_DIV_NAME
 		//				+ "' style='position:absolute; overflow:hidden; width:200px; height:200px; visibility:hidden'/>");
 		//document.body.insertBefore(_divMemo);

 		// 메모용 Div 안에 iFrame 만들기(Select태그나 Object태그 위쪽으로 나타나게 하기 위함)
         _divMemo.innerHTML = "<iframe id='"+ MEMO_FRAME_NAME +"' style='width:100%;height:100%'></iframe>";
         var _frameMemo = document.getElementById(MEMO_FRAME_NAME);
 		//var _frameMemo = document
 		//		.createElement("<IFRAME id='"
 		//				+ MEMO_FRAME_NAME
 		//				+ "' frameborder='0' marginHeight='0' marginWidth='0' width='100%' height='100%' />");
 		//_divMemo.appendChild(_frameMemo);

 		var _FrameDoc = _frameMemo.contentWindow.document;

 		// iFrame안에 Div 태그 만들기(테두리 만들기,ESC키시 닫기처리 위함)
         var _FrameDiv=_FrameDoc.createElement("div");
         _FrameDiv.style.position = "absolute";
         _FrameDiv.style.overflow = "hidden";
         _FrameDiv.style.backgroundColor = "#E6EFF6";
//         _FrameDiv.style.width = "99%"; change percentage not to show scroll bars
//         _FrameDiv.style.height = "100%";
         _FrameDiv.style.width = "96%";
         _FrameDiv.style.height = "95%";
         if (_FrameDoc.body){
             _FrameDoc.body.appendChild(_FrameDiv);
         }else {
             _FrameDoc.appendChild(_FrameDiv);
         }

 		//var _FrameDiv = _FrameDoc
 		//		.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideBkgMemoPad(true);' style='border:1.2px solid #aaa; padding:1px; overflow:hidden; background-color:#E6EFF6; width:100%; height:100%;'/>");
 		//_FrameDoc.appendChild(_FrameDiv);

 		// Div안에 Textarea 만들기
         //var sHtml = "<link href=\"style/css/theme_default.css\" rel=\"stylesheet\" type=\"text/css\">";
         var sHtml;
         if(bEventRaise) {
        	 sHtml = "<textarea id='"+ MEMO_TEXT_NAME+ "' onkeydown='if(event.keyCode==27) parent.ComHideBkgMemoPad(true);if(event.keyCode==229)return false;' style='border:#7F9DB9 1px solid; height:175px; width:100%;text-transform:" + fDate + "' rows='10' cols='6'></textarea>"
             + "\n<button id='btn_apply' class='btn_etc' onclick='parent.setBkgMemoValue(document.getElementById(\""+ MEMO_TEXT_NAME + "\").value," + iMax + ", true);'>Apply</button>"
			  + "\n<button id='btn_close' class='btn_etc' onclick='parent.ComHideBkgMemoPad(true)'>Close</button>"
			  + "</body>";
         }else {
        	 sHtml = "<textarea id='"+ MEMO_TEXT_NAME+ "' onkeydown='if(event.keyCode==27) parent.ComHideBkgMemoPad(true);' style='border:#7F9DB9 1px solid; height:175px; width:100%;text-transform:" + fDate + "' rows='10' cols='6'></textarea>"
             + "\n<button id='btn_apply' class='btn_etc' onclick='parent.setBkgMemoValue(document.getElementById(\""+ MEMO_TEXT_NAME + "\").value," + iMax + ", false);'>Apply</button>"
			  + "\n<button id='btn_close' class='btn_etc' onclick='parent.ComHideBkgMemoPad(true)'>Close</button>"
			  + "</body>";
         }
         _FrameDiv.innerHTML=sHtml;

         //var _area = _FrameDoc
 		//		.createElement("<textarea id='"
 		//				+ MEMO_TEXT_NAME
 		//				+ "' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; color:#4f4f4f; height:175px; width:100%'/>");
 		//_FrameDiv.appendChild(_area);

         /*
 		// Div 안에 center 태그 만들기(버튼을 가운데 놓기 위함)
 		var _centerTag = _FrameDoc.createElement("<center>");
 		_FrameDiv.appendChild(_centerTag);

 		// Apply 버튼 만들기
 		var _button1 = _FrameDoc
 				.createElement("<span id='btn_apply' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.setBkgMemoValue(document.getElementById(\""
 						+ MEMO_TEXT_NAME + "\").value," + iMax + ");'/>");
 		_button1.innerHTML = "Apply";
 		_centerTag.appendChild(_button1);

 		// Close 버튼 만들기
 		var _button2 = _FrameDoc
 				.createElement("<span id='btn_close' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.ComHideBkgMemoPad(true)'/>");
 		_button2.innerHTML = "Close";
 		_centerTag.appendChild(_button2);
 		*/

 		// 메모용 iFrame 자동 닫기 처리
 		if (document.onmouseup == null
 				|| document.onmouseup.toString().indexOf("ComHideBkgMemoPad") < 0) {
 			// Axon에서 onmouseup을 쓰고 있으므로, 아래와 같은 방법으로 MemoPad 닫기 처리
 			window.popupMemoOldEventListener = document.onmouseup;
 			if (window.popupMemoOldEventListener != null) {
 				// alert("CoObject \n" +
 				// window.popupMemoOldEventListener.toString());
 				// 기존에 document.onmouseup에 정의된 함수가 있는 경우
 				document.onmouseup = new Function(
 						"window.popupMemoOldEventListener(); ComHideBkgMemoPad();");
 			} else {
 				// 기존에 document.onmouseup에 정의된 함수가 없는 경우
 				document.onmouseup = ComHideBkgMemoPad;
 			}

 			/*
 			// ActiveX에 포커스가 갔을때 메모DiV 닫기
 			var objs = document.getElementsByTagName("OBJECT")
 			window.popupMemoOldObjEventListener = new Array(objs.length);
 			for ( var i = 0; i < objs.length; i++) {
 				window.popupMemoOldObjEventListener[i] = objs[i].onfocus;
 				if (window.popupMemoOldObjEventListener[i] != null) {
 					// 기존에 document.onmouseup에 정의된 함수가 있는 경우
 					objs[i].onfocus = new Function(
 							"window.popupMemoOldObjEventListener[" + i
 									+ "](); ComHideBkgMemoPad();");
 				} else {
 					// 기존에 document.onmouseup에 정의된 함수가 없는 경우
 					objs[i].onfocus = ComHideBkgMemoPad;
 				}
 			}*/
 		}
 	} catch (err) {
 		ComFuncErrMsg(err.message);
 		return false;
 	}
 	return true;
 }


 function makeHiddenSkipColBKG(sobj){
	    var lc = sobj.LastCol();
	    var rtnStr = "";
	    for(var i=0;i<=lc;i++){
	    	if( ! ( 1==sobj.GetColHidden(i) || sobj.GetCellProperty(0,i,"Type") == "DummyCheck"
	    		|| sobj.GetCellProperty(0,i,"Type") == "Radio"||  sobj.GetCellProperty(0,i,"Type") == "Status"
	    		||  sobj.GetCellProperty(0,i,"Type") =="DelCheck" )){
	    		rtnStr += "|"+ i;
	    	}
	    }
	    return rtnStr.substring(1);
	}

//COM.CLT.FILEOPEN.DOMAIN property 파일로 대체....
function getFileDownPath(){
	var ICON_URL_EXIST = "http://" + location.hostname + ":" + location.port;
	var offset=location.href.indexOf(location.host)+location.host.length;
	var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
	return ICON_URL_EXIST+ctxPath+"/FileDownload?key=";
}

function ComBkgString(sobj){
    var start = sobj.selectionStart;
    var end = sobj.selectionEnd;
	var keyFlag = false;
	var str = "";
	var keyValue = "";
	if(typeof ComGetEvent("keycode") != "undefined") {
		keyValue = String.fromCharCode(ComGetEvent("keycode"));
		if(ComGetEvent("keycode") == "0" || ComGetEvent("keycode") == "1"){
			keyValue= "";
		}
	}
	str = sobj.value.substring(0,start)+ keyValue +sobj.value.substring(start);
	return str;
}

function validateRows(rows, obj, custTp){
	var lineHeight = obj.style.lineHeight.replace("px","");
	var taHeight = obj.scrollHeight;
	var numberOfLines = Math.floor(taHeight/lineHeight);
	if(rows < numberOfLines){
		ComShowCodeMessage("BKG02006", custTp, rows);
        obj.focus();
        return false;
	}
	return true;
}


/**
 * 한글, 영문, 숫자, 키보드 특수문자, 엔터값(\n)만 허용
 */
function checkSpecial(Obj) {
	var srcCharValue = Obj.value.toUpperCase();
	var pattern = /[^(가-힣ㄱ-ㅎㅏ-ㅣa-zA-Z0-9 `~!@#$%^&*()\[\]\{\}\\_+-=:;\/|<>?\"\'\n)]/gi;   // 특수문자 제거
	if(pattern.test(srcCharValue)){
		Obj.value = srcCharValue.replace(pattern,"");
    }else{
    	Obj.value = Obj.value.toUpperCase();
    }
}

/**
 * 한글, 영문, 숫자, 키보드 특수문자, 엔터값(\n)만 허용
 */
function chekcSpecialValue(value) {
//	var re_value = value;
	var srcCharValue = value.toUpperCase();
	var re_value = srcCharValue;
	var pattern = /[^(가-힣ㄱ-ㅎㅏ-ㅣa-zA-Z0-9 `~!@#$%^&*()\[\]\{\}\\_+-=:;\/|<>?\"\'\n\u4e00-\u9fff\u3400-\u4dff\uf900-\ufaff)]/gi;   // 특수문자 제거
	if(pattern.test(srcCharValue)){
		re_value = srcCharValue.replace(pattern,"");
    }
	return re_value;
}

/**
 * 화면에 마우스 드래그로 이동가능한 form형태의 노트 패드를 생성한다.
 * 이 함수는 ibSheet에 메모패드를 추가하는 ComShowMemoPad 관련 함수를 수정해서 만들었다.
 * 이 함수의 기능을 활용하기 위해서는 다음과 같은 조건을 만족해야 한다.
 * 2015.04.23 최문환
 *
 * 1) MEMO_DIV_NAME 값은 한 화면내의 다른 id값과 중복되어서는 안된다.
 * 2) 한건의 Memo를 만들더라도 MEMO_TEXT, MEMO_TEXT_TITL, MEMO_TEXT_VALUE, appScreenObj는 배열 형태로 선언되여야 한다.
 * 3) MEMO_TEXT, MEMO_TEXT_TITL, MEMO_TEXT_VALUE, appScreenObj의 배열 크기는 같아야 한다.
 * 4) Apply 버튼을 활성화하고 Memo에 있는 값을 화면의 특정 form에 값으로 넘길 경우 MEMO_TEXT_VALUE와 appScreenObj는 배열의 순서대로 1:1로 적용된다.
 * 5) screenObj, appScreenObj에 해당되는 값은 jsp에서 id 값을 할당하여야 한다.
 * <br>
 * <b>Example :</b>
 *
 * <pre>
 * var MEMO_TEXT_SH = ["memo_text_sh_01","memo_text_sh_02"];
 * var MEMO_TEXT_TITLE_SH = ["NAME","Address"];
 * var MEMO_TEXT_VALUE_SH = ["TEST_value_SH_01","TEST_value_SH_02"];
 * var shAppScreenObjList = ["sh_cust_nm", "sh_cust_addr"];
 * ComShowFormMemoPad("btn_t7Sh_detail", "memo_sh", MEMO_TEXT_SH, MEMO_TEXT_TITLE_SH, MEMO_TEXT_VALUE_SH, true, 0, 0, true, true, shAppScreenObjList);
 * </pre>
 *
 * @param {string}
 *            screenObj 필수, MemoPad를 호출하는 object의 id값.
 * @param {string}
 *            MEMO_DIV_NAME 필수, MemoPad를 생성할때 DIV의 id 값. 2개이상 기입시 수직으로 text area가 추가됨. 화면전체에서 중복이 되면 안됨.
 * @param {array}
 *            MEMO_TEXT_NAME 필수, MemoPad를 생성할때 생성되는 text area의 id 값. 화면전체에서 중복이 되면 안됨.
 * @param {array}
 *            MEMO_TEXT_TITLE 필수, MemoPad를 생성할때 생성되는 text area의 위에 기입될 text 값. 따로 id가 할당되지는 않으며 text 기입을 원하지 않을 경우 ""로 지정.
 * @param {array}
 *            MEMO_TEXT_VALUE 필수, MemoPad를 생성할때 text Area에 보여질 Text 값.
 * @param {bool}
 *            winScroll 선택, true로 값을 설정시 화면 해상도 기준으로 생성된 Memopad가 화면 해상도 바깥에 있을때 화면을 Memo 끝까지 보일 수 있게 화면을 자동 이동한다.
 *            Scroll bar는 생성하지는 않는다. , default=true
 * @param {int}
 *            hSpc 선택, 생성된 MemoPad를 screenObj 로부터 우측으로 이동 시킬 값. , 단위 px, default=0
 * @param {int}
 *            vSpc 선택, 생성된 MemoPad를 screenObj 로부터 하단으로 이동 시킬 값. , 단위 px, default=0
 * @param {bool}
 *            bReadOnly 선택,true로 값을 성정시 MemoPad에 표시된 값을 수정할 수 있다. , default=true
 * @param {bool}
 *            btnApply 선택, true로 값을 성정시 MemoPad에 표시된 값을 화면에 적용할 수 있는 Apply 버튼을 생성한다.
 *            Apply 버튼은 이 값뿐만 아니라 appScreenObj값이 설정되어 있어야 생성된다. , default=false
 * @param {array}
 *            appScreenObj 선택, Apply 버튼을 누를 시 값이 적용될 object 의 id값 배열. 이 값이 null이거나 정의가 안되어 있을 경우 btnApply가 true 라도
 *            Apply 버튼이 생성 된지 않는다., default=null
 * @param {int}
 *            iWidth 선택,MemoPad의 넓이, default=300
 * @param {int}
 *            iHeight 선택,MemoPad의 높이, default=80
 * @param {int}
 *            iMax 선택,MemoPad의 test area의 최대 text 수, default=4000
 * @see #ComHideMemoFormPad
 * @return 없음<br>
 */
function ComShowFormMemoPad(screenObj, MEMO_DIV_NAME, MEMO_TEXT_NAME, MEMO_TEXT_TITLE, MEMO_TEXT_VALUE, winScroll,hSpc, vSpc, bReadOnly, btnApply, appScreenObj, iWidth, iHeight, iMax) {
	try {
		var formObject=document.form;
		if (winScroll == undefined || winScroll == null)
			winScroll = true;
		if (hSpc == undefined || hSpc == null)
			hSpc = parseInt(0,10);
		if (vSpc == undefined || vSpc == null)
			hSpc = parseInt(0,10);
		if (bReadOnly == undefined || bReadOnly == null)
			bReadOnly = true;
		if (btnApply == undefined || btnApply == null)
			btnApply = false;
		if (appScreenObj == undefined || appScreenObj == null)
			appScreenObj = null;
		if (iWidth == undefined || iWidth == null)
			iWidth = 300;
		if (iHeight == undefined || iHeight == null)
			iHeight = 80;
		if (iMax == undefined || iMax == null)
			iMax = 4000;

		var iLeft = document.getElementById(screenObj).offsetLeft + hSpc;
		var iTop = document.getElementById(screenObj).offsetTop + vSpc;

		if (!initMemoFormPad(MEMO_DIV_NAME, MEMO_TEXT_NAME, MEMO_TEXT_TITLE, btnApply,appScreenObj,iMax, winScroll, iWidth, iHeight)) return;


		var _divMemo = document.getElementById(MEMO_DIV_NAME);

		for(var i = 0; i < MEMO_TEXT_NAME.length ; i++){
			document.getElementById(MEMO_TEXT_NAME[i]).style.backgroundColor = bReadOnly ? "#E8E7EC": "";
    		document.getElementById(MEMO_TEXT_NAME[i]).style.fontSize = 10;
    		document.getElementById(MEMO_TEXT_NAME[i]).style.height = iHeight+"px";
    		document.getElementById(MEMO_TEXT_NAME[i]).style.width = iWidth +"px";
    		document.getElementById(MEMO_TEXT_NAME[i]).value = MEMO_TEXT_VALUE[i];
    		document.getElementById(MEMO_TEXT_NAME[i]).readOnly = bReadOnly;
		}

		_divMemo.setAttribute("class", "opus_design_memo");
		_divMemo.style.width = iWidth+ "px";
		_divMemo.style.height = iHeight+"px";
		_divMemo.style.top = iTop + "px";
		_divMemo.style.left = iLeft + "px";
		_divMemo.style.marginTop = "";
		_divMemo.style.visibility = "visible";
		_divMemo.focus();

		var winWidth = $(window).width();
		var winHeight = $(window).height();

		if(winScroll){
			if(iLeft + iWidth > winWidth){
				document.body.scrollLeft = (parseInt(iLeft + iWidth +30,10));
			}
			if(iTop + iHeight > winHeight){
				document.body.scrollTop = (parseInt(iTop + iHeight +30,10));
			}
		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}


/**
 * ComShowFormMemoPad로부터 호출된 close 버튼을 통해 닫을때 이 함수를 사용한다.
 * 2015.04.23 최문환
 *
 * @param {string}
 *            MEMO_DIV_NAME 필수, MemoPad를 생성할때 DIV의 id 값. 2개이상 기입시 수직으로 text area가 추가됨. 화면전체에서 중복이 되면 안됨.
 * @param {bool}
 *            winScroll 필수, true로 값을 설정시 화면 해상도 기준으로 생성된 Memopad가 화면 해상도 바깥에 있을때 화면을 위치를 원상태로 복구시킨다.
 *            Scroll bar는 생성하지는 않는다. , default=true
 * @param {int}
 *            iWidth 필수,MemoPad의 넓이, default=300
 * @param {int}
 *            iHeight 필수,MemoPad의 높이, default=80
 * @see #ComShowFormMemoPad
 * 		#setMemoFormValue
 * @return 없음<br>
 */
function ComHideMemoFormPad(MEMO_DIV_NAME, winScroll, iWidth, iHeight) {
//	alert("MEMO_DIV_NAME : "+MEMO_DIV_NAME+", winScroll : "+winScroll+", iWidth*iHeight : "+ iWidth+"*"+iHeight);
	try {
		if (document.getElementById(MEMO_DIV_NAME) == null)
			return;

		document.getElementById(MEMO_DIV_NAME).style.visibility = "hidden";
		if(winScroll){
			document.documentElement.scrollLeft = (parseInt(iWidth-screen.width,10));
			document.body.scrollLeft = (parseInt(iWidth-screen.width,10));
			document.documentElement.scrollTop = (parseInt(iHeight-screen.height,10));
			document.body.scrollLeft = (parseInt(iWidth-screen.width,10));
		}
		return;

	} catch (err) {
		;
	}
}

/**
 * ComShowFormMemoPad로 부터 호출되는 실제 MemoPad를 초기화하기 위한 함수이다.
 * 2015.04.23 최문환
 *
 * @param {string}
 *            MEMO_DIV_NAME 필수, MemoPad를 생성할때 DIV의 id 값. 2개이상 기입시 수직으로 text area가 추가됨. 화면전체에서 중복이 되면 안됨.
 * @param {array}
 *            MEMO_TEXT_NAME 필수, MemoPad를 생성할때 생성되는 text area의 id 값. 화면전체에서 중복이 되면 안됨.
 * @param {array}
 *            MEMO_TEXT_TITLE 필수, MemoPad를 생성할때 생성되는 text area의 위에 기입될 text 값. 따로 id가 할당되지는 않으며 text 기입을 원하지 않을 경우 ""로 지정.
 * @param {bool}
 *            btnApply 필수, true로 값을 성정시 MemoPad에 표시된 값을 화면에 적용할 수 있는 Apply 버튼을 생성한다.
 *            Apply 버튼은 이 값뿐만 아니라 appScreenObj값이 설정되어 있어야 생성된다. , default=false
 * @param {array}
 *            appScreenObj 필수, Apply 버튼을 누를 시 값이 적용될 object 의 id값 배열. 이 값이 null이거나 정의가 안되어 있을 경우 btnApply가 true 라도
 *            Apply 버튼이 생성 된지 않는다., default=null
 * @param {int}
 *            iMax 필수,MemoPad의 text area의 최대 text 수, default=4000
 * @param {bool}
 *            winScroll 필수, true로 값을 설정시 화면 해상도 기준으로 생성된 Memopad가 화면 해상도 바깥에 있을때 화면을 Memo 끝까지 보일 수 있게 화면을 자동 이동한다.
 *            Scroll bar는 생성하지는 않는다. , default=true
 * @param {int}
 *            iWidth 필수,MemoPad의 넓이, default=300
 * @param {int}
 *            iHeight 필수,MemoPad의 높이, default=80

 * @see #ComHideMemoFormPad
 *      #setMemoFormValue
 * @return bool
 */
function initMemoFormPad(MEMO_DIV_NAME, MEMO_TEXT_NAME, MEMO_TEXT_TITLE, btnApply, appScreenObj, iMax, winScroll, iWidth, iHeight) {
	try {
		if (document.getElementById(MEMO_DIV_NAME) != null || document.getElementById(MEMO_TEXT_NAME) != null)
			return true;

        var _divMemo=document.createElement("div");
        _divMemo.id=MEMO_DIV_NAME;
        _divMemo.style.position = "absolute";
        _divMemo.style.overflow = "hidden";
        _divMemo.style.zIndex = "1000";
        _divMemo.style.visibility="hidden";

        document.body.appendChild(_divMemo);

        var appScreenObjStr = "";
        var memoTextNameStr = "";
        if(appScreenObj != null && appScreenObj != undefined){
        	for(var i =0 ; i < appScreenObj.length; i++){
        		if(i == 0){
        			appScreenObjStr = appScreenObj[0];
        		}else{
        			appScreenObjStr = appScreenObjStr+","+appScreenObj[i];
        		}

        	}
        }
        if(MEMO_TEXT_NAME != null && MEMO_TEXT_NAME != undefined){
        	for(var i =0 ; i < MEMO_TEXT_NAME.length; i++){
        		if(i == 0){
        			memoTextNameStr = MEMO_TEXT_NAME[0];
        		}else{
        			memoTextNameStr = memoTextNameStr+","+MEMO_TEXT_NAME[i];
        		}
        	}
        }
        var sHtml = "";
        for(var i = 0; i < MEMO_TEXT_NAME.length ; i++){
        	if(MEMO_TEXT_TITLE[i] != "" && MEMO_TEXT_TITLE[i] != null){
        		sHtml = sHtml + "<h4 class=\"title_design\" style = \"vertical-align:middle;text-align:left;\">"+MEMO_TEXT_TITLE[i]+"</h4> ";
        	}
        	sHtml = sHtml + "<textarea id='"+ MEMO_TEXT_NAME[i]+ "' onkeydown='if(event.keyCode==27) ComHideMemoFormPad(\""+MEMO_DIV_NAME+"\","+winScroll+","+iWidth+","+iHeight+");' style='border:#7F9DB9 1px solid; height:100%; width:100%' rows='1' cols='6'></textarea>"
        }
        sHtml = sHtml + "\n<div class='opus_design_btn align_center'>"
        if(btnApply && appScreenObj != null && appScreenObj != undefined){
        	sHtml = sHtml + "\n<button id='btn_mapply' class='btn_normal' onclick='setMemoFormValue(\""+ memoTextNameStr+ "\",\"" +appScreenObjStr+ "\"," + iMax + ",\""+MEMO_DIV_NAME+"\","+winScroll+","+iWidth+","+iHeight+");'>Apply</button>"
        }
        sHtml = sHtml
                  + "\n<button id='btn_mclose' class='btn_normal' onclick='ComHideMemoFormPad(\""+MEMO_DIV_NAME+"\","+winScroll+","+iWidth+","+iHeight+")'>Close</button>"
				  + "\n</div>";
	    _divMemo.innerHTML=sHtml;

	    var _memoScript=document.createElement("script");
	    var sScript = "";

	    document.body.appendChild(_memoScript);
	    _memoScript.type = "text/javascript";

	    sScript = sScript + "\n $(function() {$(\"#"+MEMO_DIV_NAME+"\").draggable()})";

	    _memoScript.innerHTML=sScript;

		if (document.onmousedown == null || document.onmousedown.toString().indexOf("ComHideMemoFormPad") < 0) {
			window.popupMemoOldEventListener = document.onmousedown;
			if (window.popupMemoOldEventListener != null) {
				document.onmousedown = new Function(
						"window.popupMemoOldEventListener(); ComHideMemoFormPad(\""+MEMO_DIV_NAME+"\","+winScroll+","+iWidth+","+iHeight+");");
			} else {
				document.onmousedown = ComHideMemoFormPad;
			}
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
		return false;
	}
	return true;
}
/**
 * ComShowFormMemoPad로 부터 호출된 MemoPad의 값을 화면의 특정 object에 넣을떄 쓰는 함수이다.
 * 값 설정 후 ComHideMemoFormPad를 호출하여 MemoPad를 받는다.
 * 2015.04.23 최문환
 *
 * @param {string}
 *            memoListArr 필수, 값 설정을 위하여 Memo의 text Area id를 ','로 구분된 string 형태로 받아온다. 이 string은 함수내에서 다시 배열로 저장된다.
 * @param {array}
 *            appObjListArr 필수, 값이 설정될 object의 id를 ','로 구분된 string 형태로 받아온다. 이 string은 함수내에서 다시 배열로 저장된다.
 * @param {int}
 *            iMax 필수,MemoPad의 text area의 최대 text 수, default=4000
 * @param {bool}
 *            winScroll 필수, true로 값을 설정시 화면 해상도 기준으로 생성된 Memopad가 화면 해상도 바깥에 있을때 화면을 Memo 끝까지 보일 수 있게 화면을 자동 이동한다.
 *            Scroll bar는 생성하지는 않는다. , default=true
 * @param {int}
 *            iWidth 필수,MemoPad의 넓이, default=300
 * @param {int}
 *            iHeight 필수,MemoPad의 높이, default=80

 * @see #ComHideMemoFormPad
 * @return 없음<br>
 */

function setMemoFormValue(memoListArr, appObjListArr, iMax, MEMO_DIV_NAME,winScroll, iWidth, iHeight){
	if(memoListArr != ""){
		var memoList = memoListArr.split(",");
	}
	if(appObjListArr != ""){
		var appObjList = appObjListArr.split(",");
	}
	if(appObjListArr != ""){
		for(var i = 0 ;i<appObjList.length; i++){
    		document.getElementById(appObjList[i]).value = document.getElementById(memoList[i]).value;
    	}
		ComHideMemoFormPad(MEMO_DIV_NAME, winScroll, iWidth, iHeight);
	}
}

/* e-booking 화면에서 사용 */
var isOpenWaitWindow = false;
function ComOpenWait(flag, bOpenLayer){
    try {
        if(flag == isOpenWaitWindow ) return;
        isOpenWaitWindow = flag;
        if(flag) {
        	var waitW   = 60;
        	var waitH   = 60;
        	var waitImage = "img/waiting.gif";

        	var ifr = document.getElementById("waitiframe");
        	if (ifr==null){
            	$('<div class="layer_wait"> </div>').appendTo("body");
            	$('<img name="waitiframe" id="waitiframe" src="'+waitImage+ '">').appendTo(".layer_wait");

            	$("body").prepend("<div class='layer_wait_bg'></div>");
        	}

        	//open wait image
        	$(".layer_wait_bg,.layer_wait").fadeIn(100);

        	//position center
        	$(".layer_wait").css({
            	marginTop : parseInt("-" + $(".layer_wait").outerHeight()/2),
            	marginLeft : parseInt("-" + $(".layer_wait").outerWidth()/2)
        	});
        } else {
        	//close wait image
        	$(".layer_wait_bg,.layer_wait").fadeOut(100);
        }
    } catch(err) {ComFuncErrMsg(err.message); }
    return true;
}

/**
 *
 */
function rdParameterErrorCheckStr(param){
	if(param.indexOf(":(") > -1){
		ComShowMessage('":(" canoot be used from Remark list.\n":(" wil be removed so please check later.');
		param = param.split(":(").join("");
	}
	return param
}

/**
 * space check logic
 */
function isWhitespaceNotEmpty(val)
{
    try
    {
        var format=/^\s*$/;		//space check
        return (val.search(format) != -1);
    }
    catch(err)
    {
    	ComFuncErrMsg(err.message);
    }
}

function getBlRdFileName(bkgNo, form_type, type){
	var file_name = "";
	if(type==undefined){
		type = "";
	}
	var d = new Date();
	var month = d.getMonth() + 1;
	var date = d.getDate();
	var hour = d.getHours();
	var minute = d.getMinutes();
	var second = d.getSeconds();

	month = (month < 10 ? "0" : "") + month;
	date = (date < 10 ? "0" : "") + date;
	hour = (hour < 10 ? "0" : "") + hour;
	minute = (minute < 10 ? "0" : "") + minute;
	second = (second < 10 ? "0" : "") + second;

	var TimeStamp = d.getFullYear() + month + date + hour + minute + second;

	if(form_type == "4"){
		file_name = "NYKS"+bkgNo+"_original_"+type+TimeStamp;
	}else if(form_type == "5"){
		file_name = "NYKS"+bkgNo+"_seaway_"+type+TimeStamp;
	}else if(form_type == "7"){
		file_name = "NYKS"+bkgNo+"_draft_"+type+TimeStamp;
	}else{
		file_name = "NYKS"+bkgNo+"_noncopy_"+type+TimeStamp;
	}
	return file_name;

}

function ComDownLoad(url, paeameters){
	 // url과 data를 입력받음
  if( url && paeameters ){
      // data 는  string 또는 array/object 를 파라미터로 받는다.
  		paeameters = typeof paeameters == 'string' ? paeameters : jQuery.param(paeameters);
      // 파라미터를 form의  input으로 만든다.
      var inputs = '';
      $.each(paeameters.split('&'), function(){
          var pair = this.split('=');
          inputs+='<input type="hidden" name="'+ pair[0] +'" value="'+ pair[1] +'" />';
      });
      // request를 보낸다.
      $('<form action="'+ url +'" method="post">'+inputs+'</form>').appendTo('body').submit().remove();
  }
}

/**
 * stx, etx.. 등등 삭제
 */
function RemoveIsNonAscii (str){
	if (str == null){
        return null;
    }
	var tempStr = '';
	for (var i = 0; i < str.length; i++) {
		var ch = str.charCodeAt(i);
		if(ch < 32 && ch != 10) tempStr += '';
		else tempStr += str.charAt(i);
	}
    return tempStr;
}

/**
 * 부킹메인에서 CAIssue 체크 로직
 */
function saveCAIssueConFirmCheck(){
	if(!opener)
	      opener=parent;

	var formObj = opener.document.form;
	if(formObj.ca_flg.value == 'Y'){
		if(ComShowConfirm('Do you want to Confirm C/A now')){
			formObj.btn_CAConfirm.click();
		}
	}
}

/**
 * 중복된 부킹넘버 체크
 */
function duplicateBkgNoCheck(multiObjId){
	/* 부킹번호 list */
	var bkgNoList = $("#" + multiObjId).val().split("\n");
	var str = $("#" + multiObjId).val();
	/* 중복된 부킹번호 저장 */
	var duplicateBkgNo = new Array();
	var duplicateStr = "";
	var newBkgNo = "";
	/* 중복 부킹번호 체크 */
	for (var i = 0; i < bkgNoList.length; i++) {
		/* 값이 없느면 넘김 */
		if(bkgNoList[i] == "") continue;

		/* 해당 부킹번호가 중복됐는지 확인 */
		var bkgNo = bkgNoList[i].split(" ").join("");
		var tempCheck = str.split(bkgNo);
		/* length가 2보다 크면 중복된 부킹넘버 */
		if(tempCheck.length > 2){
			var temp = false;
			/* 중복된 부킹번호가 이미 처리됐는지 확인 */
			for (var j = 0; j < duplicateBkgNo.length; j++) {
				if(duplicateBkgNo[j] == bkgNo){
					temp = true;
					break;
				}
			}
			/* 부킹번호 저장 */
			if(!temp){
				if(duplicateBkgNo.length > 0) duplicateStr += " , ";
				duplicateStr += bkgNo;
				duplicateBkgNo[duplicateBkgNo.length] = bkgNo;
			}
		}
		/* 중복되지 않은 부킹번호 */
		else{
			newBkgNo += bkgNo + "\n";
		}
	}

	if(duplicateBkgNo.length > 0){
		duplicateStrMsg(duplicateStr);
		for (var i = 0; i < duplicateBkgNo.length; i++) {
			newBkgNo += duplicateBkgNo[i];
			if((i+1) < duplicateBkgNo.length) newBkgNo += "\n";
		}
		$("#" + multiObjId).val(newBkgNo);
		if($("#" + multiObjId).val() != ""){
    		var newLines = $("#" + multiObjId).val().split("\n").length;
    		$("#rows").text(leadingZeros(newLines, 3));
    		if(newLines > lines) {
    			$("#rows").css('color', 'red');
            }else {
            	$("#rows").css('color', '');
            }
    	}else{
    		$("#rows").css('color', '');
			$("#rows").text(leadingZeros(0, 3));
    	}
	}

	$("#layList").hide();
}

/**
 * 중복 메세지
 */
function duplicateStrMsg(duplicateStr){
	ComShowMessage('Multiple Inquiry data! has been duplicated.\n' + duplicateStr);
}

var lines = 100;
/**
 *
 */
function multiBkgTextArea(type, multiObjId){
	if(type == 1){
		$("#" + multiObjId).val("");
		$("#layList").hide();
		$("#btn_multBkgNo").css({'background':'url(./style/images/theme_default/sprite_common.png) -98px -157px no-repeat' , 'background-color':'#fff'});
	}else if(type == 2){
		$("#bkg_no").val("");
		$("#btn_multBkgNo").css({'background':'url(./style/images/theme_default/sprite_common.png) -152px -157px no-repeat' , 'background-color':'#fff'});
	}

	if($("#" + multiObjId).val() != ""){
		var newLines = $("#" + multiObjId).val().split("\n").length;
		$("#rows").text(leadingZeros(newLines, 3));
		if(newLines > lines) {
			$("#rows").css('color', 'red');
        }else {
        	$("#rows").css('color', '');
        }
	}else{
		$("#rows").css('color', '');
		$("#rows").text(leadingZeros(0, 3));
	}
}

function leadingZeros(n, digits) {
	var zero = '';
	n = n.toString();
	if (n.length < digits) {
		for (i = 0; i < digits - n.length; i++) {
			zero += '0';
		}
	}
	return zero + n;
}

function ComGetErrorMessage(sXml){
	var message = ComResultMessage(sXml);
	if(message != null){
		var rmsg = message.split("<||>");
		if(rmsg[2] != undefined && rmsg[2].length > 0) {
			ComShowMessage(rmsg[1] + '\n' + rmsg[2]);
		}
	}
}

/**
 *
 * @param url
 * @param paeameters
 * @param callbackfunction
 * @param callbackErrorfunction
 */
function ComSearchAsync(url, paeameters, callbackfunction, callbackErrorfunction){
	$.ajax({
	    type: "POST",
	    url: url,
	    async: true,
	    dataType: "text",
	    data: paeameters,
	    success: function(data){
	    	if(callbackfunction != undefined && callbackfunction != null){
	    		data = data.split('').join('').split('').join('').split('').join('');
	    		callbackfunction(data);
	    	}
	    },

	    error: function(xhr){
	    	ComOpenWait(false);
	    	if(callbackErrorfunction != undefined)
	    		callbackErrorfunction(xhr);
	    }
	});
}

/**
 * RD 공통소스 사용
 * @returns
 */
function rdOpen(viewType){
	var rdDatas = getRdData(viewType);
	var appendReport = [];
	if ( viewType == "print" ) {
		var rdData = rdDatas[0];
		if($.isArray(rdData)){
			for (var i = 0; i < rdData.length; i++) {
				var rdParam = rdData[i].rdParam;
				var rdFile = rdData[i].rdFile;
				var rdUrl = rdData[i].rdUrl;
				appendReport[appendReport.length] = {mrdPath : RD_path + rdUrl + rdFile, mrdParam : RDServer + rdParam+ " /riprnmargin /rwait"}
			}
		}else{
			var rdParam = rdData.rdParam;
			var rdFile = rdData.rdFile;
			var rdUrl = rdData.rdUrl;
			appendReport[appendReport.length] = {mrdPath : RD_path + rdUrl + rdFile, mrdParam : RDServer + rdParam+ " /riprnmargin /rwait"}
		}

		directReportDownload(appendReport);
	} else {
		var rdParam = rdDatas[0].rdParam;
		var rdUrl = rdDatas[0].rdUrl;
		var rdFile = rdDatas[0].rdFile;
		var width = rdDatas[0].width;
		var height = rdDatas[0].height;
		var append = rdDatas[0].append;
		if(append == 1){
			document.form.com_mrdPath.value = rdUrl;
			document.form.com_mrdArguments.value = rdParam;
		}else{
			document.form.com_mrdPath.value = rdUrl + rdFile;
			document.form.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";
		}
		var option = 'resizable=yes';
		if(width != null && width != '') option += ',width=' + width;
		if(height != null && height != '') option += ',height=' + height;
		ComOpenRDPopup(option);
	}
}

/**
 * Post 방식으로 RD Popup을 띄운다. Popup창의 Size 조절 가능
 * 참조 - ComOpenRDPopup
 * @param sFeatures
 */
function ComBkgOpenRDPopup(sFeatures) {
	if(sFeatures == undefined){
	 	ComPostOpenWindow("/opuscntr/ESM_BKG_RD_COMMON_POPUP.do", "ReportDesignerBkgPopup", "width=1010, height=660, status=no");
	} else{
		ComPostOpenWindow("/opuscntr/ESM_BKG_RD_COMMON_POPUP.do", "ReportDesignerBkgPopup", sFeatures);
	}
} 


/**
 * (2016.12.23 - 김상수)
 * Sheet내의 Check된 row들 중에 중복된 데이터를 찾아서 메세지 후 포커스
 *
 * @param {object}sheetObj 중복체크 할 데이터가 있는 SheetObject
 * @param {string}chkColNm 체크박스 컬럼명
 * @param {string}dupColNm 중복체크 할 컬럼명
 * @return boolean - 중복시 false
 *
 * ex.) if (!ComBkgChkDupInSheetRows(sheetObj, "chk", "bl_no")) return;
 */
function ComBkgChkDupInSheetRows(sheetObj, chkColNm, dupColNm) {
	var chkRowArr = sheetObj.FindCheckedRow(chkColNm).split("|");    // 체크된 row no.수집
	var dupValArr = new Array();
	$.each(chkRowArr, function(k, chkRow) {    // 체크된 각 row no.의 해당 데이터 수집
		dupValArr.push(sheetObj.GetCellValue(chkRow, dupColNm));
	});

	var uniqValArr = new Array();
	$.each(dupValArr, function(i, dupVal) {    // 수집된 데이터 간의 중복체크
		if ($.inArray(dupVal, uniqValArr) == -1) {
			uniqValArr.push(dupVal);
		} else {
			ComShowCodeMessage("BKG00460", dupVal);    // "Duplication occurred.({?msg1})"
			var dupValRow = ComFindAll(sheetObj, dupColNm, dupVal).split("|")[1];
			sheetObj.SelectCell(dupValRow, dupColNm, 1);
			return false;
		}
	});
	return true;
}
