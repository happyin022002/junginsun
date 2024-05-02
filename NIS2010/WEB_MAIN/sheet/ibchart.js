/*
 * @(#)ibchart.js	1.0.9 03/11/13
 *
 * Copyright 2003 IB Leaders Co., Ltd. All Rights Reserved.
 *
 * @author hessie
 */

// IBC_AngleUnitConstants
var ibcAngleUnitDegree=1,ibcAngleUnitRadian=2,ibcAngleUnitGrad=3;
// IBC_AnnotationPlacementConstants
var ibcAnnotationPlacementAuto=0,ibcAnnotationPlacementOrigin=1,ibcAnnotationPlacementMinimum=2,ibcAnnotationPlacementMaximum=3;
// IBC_AnnotationTypeConstants
var ibcAnnotationTypeValues=0,ibcAnnotationTypePointLabels=1,ibcAnnotationTypeValueLabels=2;
// IBC_AxisIdConstants
var ibcAxisX=1,ibcAxisY=2,ibcAxisY2=3;
// IBC_AxisScaleConstants
var ibcAxisScaleLinear=0,ibcAxisScaleLogarithmic=1;
// IBC_BubbleFormTypeConstants
var ibcBubbleDiameter=1,ibcBubbleArea=2;
// IBC_ChartIdConstants
var ibcChartPrimary=1,ibcChartSecondary=2;
// IBC_ChartTypeConstants
var ibcType2dPlot=16,ibcType2dPlotStacked=17,ibcType2dPlotStacked100=19,ibcType3dPlot=20,ibcType3dPlotStacked=21,ibcType3dPlotStacked100=23,ibcType2dBar=32,ibcType2dBarStacked=33,ibcType2dBarStacked100=35,ibcType3dBar=36,ibcType3dBarStacked=37,ibcType3dBarStacked100=39,ibcType2dPie=64,ibcType3dPie=68,ibcType2dArea=128,ibcType2dAreaStacked=129,ibcType2dAreaStacked100=131,ibcType3dArea=132,ibcType3dAreaStacked=133,ibcType3dAreaStacked100=135,ibcType2dHiLo=256,ibcType2dHiLoOpenClose=512,ibcType2dCandle=1024,ibcType2dPolar=2048,ibcType2dPolarStacked=2049,ibcType2dPolarStacked100=2051,ibcType2dRadar=4096,ibcType2dRadarStacked=4097,ibcType2dRadarStacked100=4099,ibcType2dFilledRadar=8192,ibcType2dFilledRadarStacked=8193,ibcType2dFilledRadarStacked100=8195,ibcType2dBubble=16384;
// IBC_FillPatternConstants
var ibcFillNone=1,ibcFillSolid=2,ibcFill25Percent=3,ibcFill50Percent=4,ibcFill75Percent=5,ibcFillHorizontalStripe=6,ibcFillVerticalStripe=7,ibcFill45DegreeStripe=8,ibcFill135DegreeStripe=9,ibcFillDiagHatched=10,ibcFillCrossHatched=11,ibcFillBackwardDiagonal=12,ibcFillCross=13,ibcFillDiagonalCross=14,ibcFillForwardDiagonal=15,ibcFillHorizontal=16,ibcFillVertical=17;
// IBC_FrameStyleConstants
var ibcFrameStyleNone=0,ibcFrameStyle3DOut=1,ibcFrameStyle3DIn=2,ibcFrameStyleShadow=3,ibcFrameStylePlain=4,ibcFrameStyleEtchedIn=5,ibcFrameStyleEtchedOut=6,ibcFrameStyleFrameIn=7,ibcFrameStyleFrameOut=8,ibcFrameStyleBevel=9;
// IBC_LabelLayoutConstants
var ibcLabelLayoutCenter=0,ibcLabelLayoutEast=1,ibcLabelLayoutWest=2,ibcLabelLayoutNorth=16,ibcLabelLayoutSouth=32,ibcLabelLayoutNorthEast=17,ibcLabelLayoutNorthWest=18,ibcLabelLayoutSouthEast=33,ibcLabelLayoutSouthWest=34,ibcLabelLayoutAuto=256;
// IBC_LegendLayoutConstants
var ibcLegendLayoutEast=1,ibcLegendLayoutWest=2,ibcLegendLayoutNorth=16,ibcLegendLayoutSouth=32,ibcLegendLayoutNorthEast=17,ibcLegendLayoutNorthWest=18,ibcLegendLayoutSouthEast=33,ibcLegendLayoutSouthWest=34;
// IBC_LinePatternConstants
var ibcLineNone=1,ibcLineSolid=2,ibcLineLongDash=3,ibcLineDotted=4,ibcLineShortDash=5,ibcLineLongShortLongDash=6,ibcLineDashDot=7;
// IBC_OrientConstants
var ibcOrientVertical=1,ibcOrientHorizontal=2;
// IBC_RotationConstants
var ibcRotationNone=1,ibcRotation90Degrees=2,ibcRotation270Degrees=3,ibcRotation45Degrees=4,ibcRotation315Degrees=5;
// IBC_ShadingConstants
var ibcShadingColor=1,ibcShadingDithered=2,ibcShadingNone=3;
// IBC_SortOrderConstants
var ibcSortOrderAscending=1,ibcSortOrderDescending=2,ibcSortOrderNone=3;
// IBC_SymbolShapeConstants
var ibcSymbolNone=1,ibcSymbolDot=2,ibcSymbolBox=3,ibcSymbolTri=4,ibcSymbolDiamond=5,ibcSymbolStar=6,ibcSymbolVertLine=7,ibcSymbolHorizLine=8,ibcSymbolCross=9,ibcSymbolCircle=10,ibcSymbolSquare=11,ibcSymbolInvertTri=12,ibcSymbolDiagCross=13,ibcSymbolOpenTri=14,ibcSymbolOpenDiamond=15,ibcSymbolOpenInvertTri=16;
// IBC_TextAlignConstants
var ibcTextAlignLeft=1,ibcTextAlignRight=2,ibcTextAlignCenter=3;
// IBC_ThresholdTypeConstants
var ibcThresholdSliceCutoff=1,ibcThresholdPercentile=2;
// IBC_HOLEVALUE
var ibcHolevalue=1e+308;
// IBC_HOLEVALUE
var IBC_FLAGDEBUG = false;

function IBC_fetchUrlData(ibchart, url, forms) {
  var args=IBC_fetchUrlData.arguments;if(args.length<=2){ibchart.FetchDataUrl(H_getAbsoluteUrl(url));}else{
  var paramObj=ibchart.CreateHttpParameters();for(var i=2;i<args.length;i++)IBC_setHttpParameters(paramObj,args[i]);
  ibchart.FetchDataUrl(H_getAbsoluteUrl(url),paramObj);}
}

function IBC_fetchUrlDataAppend(ibchart, url, forms) {
  var args=IBC_fetchUrlDataAppend.arguments;if(args.length<=2){ibchart.FetchDataUrlAppend(H_getAbsoluteUrl(url));
  }else{var paramObj=ibchart.CreateHttpParameters();for(var i=2;i<args.length;i++)IBC_setHttpParameters(paramObj,args[i]);
  ibchart.FetchDataUrlAppend(H_getAbsoluteUrl(url),paramObj);}
}

function IBC_getExtraValue(ibchart, name) {
  return ibchart.ExtraData.GetValue(name);
}

function IBC_getExtraValues(ibchart, name) {
  var arr=new Array();try{var vbcol=ibchart.ExtraData.GetValues(name);for(var i=1;i<=vbcol.Count();i++){
  arr[arr.length]=vbcol(i);}}catch(e){if(IBC_FLAGDEBUG) alert(e.message);}return arr;
}

function IBC_setSheetData(chart, ibsheet, cols, rowStart, rowEnd) {
  try{chart.SetPointYIBCArray2D(IBC_createSheetIBCArray2D(chart,ibsheet,cols,rowStart,rowEnd));
  }catch(e){if(IBC_FLAGDEBUG) alert(e.message);}
}


function IBC_setSheetDataVerti(chart, ibsheet, cols, rowStart, rowEnd) {
  try{chart.SetPointYIBCArray2D(IBC_createSheetIBCArray2DVerti(chart,ibsheet,cols,rowStart,rowEnd));
  }catch(e){if(IBC_FLAGDEBUG) alert(e.message);}
}

function IBC_setSheetDataHoriz(chart, ibsheet, rows, colStart, colEnd) {
  try{chart.SetPointYIBCArray2D(IBC_createSheetIBCArray2DHoriz(chart,ibsheet,rows,colStart,colEnd));
  }catch(e){if(IBC_FLAGDEBUG) alert(e.message);}
}


function IBC_appendSheetData(chart, ibsheet, cols, rowStart, rowEnd) {
  try{chart.AppendPointYIBCArray2D(IBC_createSheetIBCArray2D(chart,ibsheet,cols,rowStart,rowEnd));
  }catch(e){if(IBC_FLAGDEBUG) alert(e.message);}
}

function IBC_appendSheetDataHoriz(chart, ibsheet, rows, colStart, colEnd) {
  try{chart.AppendPointYIBCArray2D(IBC_createSheetIBCArray2DHoriz(chart,ibsheet,rows,colStart,colEnd));
  }catch(e){if(IBC_FLAGDEBUG) alert(e.message);}
}

function IBC_setSheetLabel(chart, ibsheet, colLabel, rowStart, rowEnd) {
  try{chart.SetPointLabelIBCArray(IBC_createSheetLabelIBCArray(chart,ibsheet,colLabel,rowStart,rowEnd));
  }catch(e){if(IBC_FLAGDEBUG) alert(e.message);}
}

function IBC_setSheetLabelHoriz(chart, ibsheet, rowLabel, colStart, colEnd) {
  try{chart.SetPointLabelIBCArray(IBC_createSheetLabelIBCArrayHoriz(chart,ibsheet,rowLabel,colStart,colEnd));
  }catch(e){if(IBC_FLAGDEBUG) alert(e.message);}
}

function IBC_appendSheetLabel(chart, ibsheet, colLabel, rowStart, rowEnd, pointIndex) {
  try{chart.SetPointLabelIBCArray(IBC_createSheetLabelIBCArray(chart,ibsheet,colLabel,rowStart,rowEnd),pointIndex);
  }catch(e){if(IBC_FLAGDEBUG) alert(e.message);}
}

function IBC_appendSheetLabelHoriz(chart, ibsheet, rowLabel, colStart, colEnd, pointIndex) {
  try{chart.SetPointLabelIBCArray(IBC_createSheetLabelIBCArrayHoriz(chart,ibsheet,rowLabel,colStart,colEnd),pointIndex);
  }catch(e){if(IBC_FLAGDEBUG) alert(e.message);}
}

function IBC_retrieveChartLabels(ibchart, formatString) {
  try{var labels=ibchart.ChartLabels,label,isFormatted=(IBC_retrieveChartLabels.arguments.length>1),chart,series,point;
  for(var i=1;i<=labels.Count;i++){label=labels(i);if(label.AttachChart>0&&label.AttachSeries>0&&label.AttachPoint>0){
  chart=ibchart.Chart(label.AttachChart);if(label.AttachSeries<=chart.Series.Count){series=chart.Series(label.AttachSeries);
  if(label.AttachPoint<=series.Point.Count){point=series.Point(label.AttachPoint);
  label.Text=(isFormatted?ibchart.UtilFormat(point.Y,formatString):point.Y);}}}}}catch(e){if(IBC_FLAGDEBUG) alert(e.message);}
}

function IBC_createSheetIBCArray2D(chart, ibsheet, cols, rowStart, rowEnd) {
  var values,v,step=1,end2_1,end2_2,arr_col=String(cols).split('|');if(rowStart>rowEnd)step=-1;end2_2=chart.Series.Count;
  end2_1=Math.min(end2_2,arr_col.length);values=chart.CreateIBCArray2D(1,step*(rowEnd-rowStart+1),1,end2_2);
  for(var i=rowStart;i<=rowEnd;i+=step){for(var j=1;j<=end2_1;j++){v=H_trim(String(ibsheet.CellValue(i,arr_col[j-1])));
  values(i-rowStart+1,j)=((v!=''&&!isNaN(v))?v:ibcHolevalue);}for(;j<=end2_2;j++){v=H_trim((ibsheet.CellValue(i,arr_col[j-1])));
  values(i-rowStart+1,j)=((v!=''&&!isNaN(v))?v:ibcHolevalue);}}return values;
}

function IBC_createSheetIBCArray2DVerti(chart, ibsheet, cols, rowStart, rowEnd) {
  var values,v,step=1,end2_1,end2_2,arr_col=String(cols).split('|');if(rowStart>rowEnd)step=-1;end2_2=chart.Series.Count;
  end2_1=Math.min(end2_2,arr_col.length);values=chart.CreateIBCArray2D(1,step*(rowEnd-rowStart+1),1,end2_2);
  for(var i=rowStart;i<=rowEnd;i+=step){for(var j=1;j<=end2_1;j++){v=H_trim(String(ibsheet.CellValue(i,arr_col[j-1])));
  values(i-rowStart+1,j)=((v!=''&&!isNaN(v))?v:ibcHolevalue);}for(;j<=end2_2;j++){v=H_trim((ibsheet.CellValue(i,arr_col[j-1])));
  values(i-rowStart+1,j)=((v!=''&&!isNaN(v))?v:ibcHolevalue);}}return values;
}

function IBC_createSheetIBCArray2DHoriz(chart, ibsheet, rows, colStart, colEnd) {
  var values,v,step=1,end2_1,end2_2,arr_row=String(rows).split('|');if(colStart>colEnd)step=-1;end2_2=chart.Series.Count;
  end2_1=Math.min(end2_2,arr_row.length);values=chart.CreateIBCArray2D(1,step*(colEnd-colStart+1),1,end2_2);
  for(var i=colStart;i<=colEnd;i+=step){for(var j=1;j<=end2_1;j++){v=H_trim(String(ibsheet.CellValue(arr_row[j-1],i)));
  values(i-colStart+1,j)=((v!=''&&!isNaN(v))?v:ibcHolevalue);}for(;j<=end2_2;j++){v=H_trim((ibsheet.CellValue(arr_row[j-1],i)));
  values(i-colStart+1,j)=((v!=''&&!isNaN(v))?v:ibcHolevalue);}}return values;
}

function IBC_createSheetLabelIBCArray(chart, ibsheet, colLabel, rowStart, rowEnd) {
  var values,step=1;if(rowStart>rowEnd)step=-1;values=chart.CreateIBCArray(1,step*(rowEnd-rowStart+1));
  for(var i=rowStart;i<=rowEnd;i+=step){values(i-rowStart+1)=H_trim(String(ibsheet.CellValue(i,colLabel)));}return values;
}

function IBC_createSheetLabelIBCArrayHoriz(chart, ibsheet, rowLabel, colStart, colEnd) {
  var values,step=1;if(colStart>colEnd)step=-1;values=chart.CreateIBCArray(1,step*(colEnd-colStart+1));
  for(var i=colStart;i<=colEnd;i+=step){values(i-colStart+1)=H_trim(String(ibsheet.CellValue(rowLabel,i)));}return values;
}

function IBC_setHttpParameters(paramObj, formObj) {
  var e,o;for(var i=0;i<formObj.elements.length;i++) {e=formObj.elements[i];if(!e.disabled && e.name!='')
  {switch(e.type) {case 'text':case 'textarea':case 'hidden':case 'password':case 'file':paramObj.AddValue(e.name,e.value);
  break;case 'checkbox':case 'radio':if(e.checked)paramObj.AddValue(e.name,e.getAttribute('value'));
  break;case 'select-one':if(e.options.length > 0)paramObj.AddValue(e.name,e.value);break;
  case 'select-multiple':for(var j=0;j<e.options.length;j++) {o=e.options[j];if(e.selected)
  paramObj.AddValue(e.name,o.value);}break;case 'submit':case 'button':case 'reset':default:break;}}}
}

function H_trim(text) { // by hessie, 2001
  var count=text.length;var len=count,st=0;while(st<len&&text.charAt(st)<=' ')st++;while
  (st<len&&text.charAt(len-1)<=' ')len--;return (st>0||len<count)?text.substring(st,len):text;
}

function H_getAbsoluteUrl(url){ // by hessie, 2001
  var value='',t0=url.replace(/\\/g,'/'),idlm=t0.concat('/').indexOf('/'),ipcol=t0.indexOf(':');if(ipcol<idlm&&ipcol>0)
  value=t0;else{var t=H_trim(t0);if(t.indexOf('/')==0)value=location.protocol+'//'+location.host+t;
  else{var arrp=String(location.pathname).replace(/\\/g,'/').split('/'),arrt=t.split('/');
  arrp.length=arrp.length-1;for(var i in arrt){switch(arrt[i]){case '..':if(arrp.length>1)arrp.length=arrp.length-1;else
  arrp[arrp.length]=arrt[i];break;case '.':case '':break;default:arrp[arrp.length]=arrt[i];break;}}value=
  location.protocol+'//'+location.host+arrp.join('/');}}return value;
}