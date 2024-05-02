/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurDgListVO.java
*@FileTitle : EurDgListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.15  
* 1.0 Creation 
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurDgListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurDgListVO> models = new ArrayList<EurDgListVO>();
	
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String no = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String listNm = null;
	/* Column Info */
	private String lodCd = null;
	/* Column Info */
	private String tzCd = null;
	/* Column Info */
	private String properShippingName = null;
	/* Column Info */
	private String fp = null;
	/* Column Info */
	private String mrdFileName = null;
	/* Column Info */
	private String opload = null;
	/* Column Info */
	private String rdParam = null;
	/* Column Info */
	private String unNo = null;
	/* Column Info */
	private String cellposition = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String dchgCd = null;
	/* Column Info */
	private String pg = null;
	/* Column Info */
	private String email = null;
	/* Column Info */
	private String mstName = null;
	/* Column Info */
	private String nWeight = null;
	/* Column Info */
	private String hzdDesc = null;
	/* Column Info */
	private String stwgFlg = null;
	/* Column Info */
	private String ems1 = null;
	/* Column Info */
	private String mpa = null;
	/* Column Info */
	private String ems2 = null;
	/* Column Info */
	private String mrdTitle = null;
	/* Column Info */
	private String gWeight = null;
	/* Column Info */
	private String mrdNm = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String agntName = null;
	/* Column Info */
	private String emergencyTel = null;
	/* Column Info */
	private String clsSub = null;
	/* Column Info */
	private String qtyPackageType = null;
	/* Column Info */
	private String stowage = null;
	/* Column Info */
	private String mrdArguments = null;
	/* Column Info */
	private String opdischarge = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String podName = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String polName = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String mp = null;
	/* Column Info */
	private String listType = null;
	/* Column Info */
	private String mrdPath = null;
	/* Column Info */
	private String pic = null;
	/* Column Info */
	private String optranzit = null;
	/* Column Info */
	private String operator = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String mrdBodyTitle = null;
	/* Column Info */
	private String imdgLmtQtyFlg = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String obCssmVoyNo = null;
	/* Column Info */
	private String ibCssmVoyNo = null;
	/* Column Info */
	private String cgoOprCd = null;
	/* Column Info */
	private String innerPackageDetail = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EurDgListVO() {}

	public EurDgListVO(String ibflag, String pagerows, String port, String opload, String cellposition, String optranzit, String crrCd, String operator, String opdischarge, String dchgCd, String userId, String stwgFlg, String portCd, String lodCd, String tzCd, String mrdNm, String rdParam, String email, String mrdPath, String mrdArguments, String mrdTitle, String mrdBodyTitle, String mrdFileName, String listNm, String no, String cntrNo, String cntrTpszCd, String blNo, String gWeight, String nWeight, String properShippingName, String hzdDesc, String clsSub, String unNo, String pg, String fp, String ems1, String ems2, String mp, String mpa, String emergencyTel, String pic, String qtyPackageType, String remark, String stowage, String imdgLmtQtyFlg, String polCd, String podCd, String bkgDelCd, String polName, String podName, String vvdCd, String listType, String agntName, String mstName, String vslNm, String obCssmVoyNo, String ibCssmVoyNo, String cgoOprCd, String innerPackageDetail) {
		this.remark = remark;
		this.no = no;
		this.blNo = blNo;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.userId = userId;
		this.cntrTpszCd = cntrTpszCd;
		this.listNm = listNm;
		this.lodCd = lodCd;
		this.tzCd = tzCd;
		this.properShippingName = properShippingName;
		this.fp = fp;
		this.mrdFileName = mrdFileName;
		this.opload = opload;
		this.rdParam = rdParam;
		this.unNo = unNo;
		this.cellposition = cellposition;
		this.podCd = podCd;
		this.dchgCd = dchgCd;
		this.pg = pg;
		this.email = email;
		this.mstName = mstName;
		this.nWeight = nWeight;
		this.hzdDesc = hzdDesc;
		this.stwgFlg = stwgFlg;
		this.ems1 = ems1;
		this.mpa = mpa;
		this.ems2 = ems2;
		this.mrdTitle = mrdTitle;
		this.gWeight = gWeight;
		this.mrdNm = mrdNm;
		this.port = port;
		this.agntName = agntName;
		this.emergencyTel = emergencyTel;
		this.clsSub = clsSub;
		this.qtyPackageType = qtyPackageType;
		this.stowage = stowage;
		this.mrdArguments = mrdArguments;
		this.opdischarge = opdischarge;
		this.ibflag = ibflag;
		this.podName = podName;
		this.bkgDelCd = bkgDelCd;
		this.polName = polName;
		this.portCd = portCd;
		this.mp = mp;
		this.listType = listType;
		this.mrdPath = mrdPath;
		this.pic = pic;
		this.optranzit = optranzit;
		this.operator = operator;
		this.cntrNo = cntrNo;
		this.mrdBodyTitle = mrdBodyTitle;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
		this.vslNm = vslNm;
		this.obCssmVoyNo = obCssmVoyNo;
		this.ibCssmVoyNo = ibCssmVoyNo;
		this.cgoOprCd = cgoOprCd;
		this.innerPackageDetail = innerPackageDetail;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("no", getNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("list_nm", getListNm());
		this.hashColumns.put("lod_cd", getLodCd());
		this.hashColumns.put("tz_cd", getTzCd());
		this.hashColumns.put("proper_shipping_name", getProperShippingName());
		this.hashColumns.put("fp", getFp());
		this.hashColumns.put("mrd_file_name", getMrdFileName());
		this.hashColumns.put("opload", getOpload());
		this.hashColumns.put("rd_param", getRdParam());
		this.hashColumns.put("un_no", getUnNo());
		this.hashColumns.put("cellposition", getCellposition());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("dchg_cd", getDchgCd());
		this.hashColumns.put("pg", getPg());
		this.hashColumns.put("email", getEmail());
		this.hashColumns.put("mst_name", getMstName());
		this.hashColumns.put("n_weight", getNWeight());
		this.hashColumns.put("hzd_desc", getHzdDesc());
		this.hashColumns.put("stwg_flg", getStwgFlg());
		this.hashColumns.put("ems1", getEms1());
		this.hashColumns.put("mpa", getMpa());
		this.hashColumns.put("ems2", getEms2());
		this.hashColumns.put("mrd_title", getMrdTitle());
		this.hashColumns.put("g_weight", getGWeight());
		this.hashColumns.put("mrd_nm", getMrdNm());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("agnt_name", getAgntName());
		this.hashColumns.put("emergency_tel", getEmergencyTel());
		this.hashColumns.put("cls_sub", getClsSub());
		this.hashColumns.put("qty_package_type", getQtyPackageType());
		this.hashColumns.put("stowage", getStowage());
		this.hashColumns.put("mrd_arguments", getMrdArguments());
		this.hashColumns.put("opdischarge", getOpdischarge());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_name", getPodName());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("pol_name", getPolName());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("mp", getMp());
		this.hashColumns.put("list_type", getListType());
		this.hashColumns.put("mrd_path", getMrdPath());
		this.hashColumns.put("pic", getPic());
		this.hashColumns.put("optranzit", getOptranzit());
		this.hashColumns.put("operator", getOperator());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("mrd_body_title", getMrdBodyTitle());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
		this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
		this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
		this.hashColumns.put("inner_package_detail", getInnerPackageDetail());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("remark", "remark");
		this.hashFields.put("no", "no");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("list_nm", "listNm");
		this.hashFields.put("lod_cd", "lodCd");
		this.hashFields.put("tz_cd", "tzCd");
		this.hashFields.put("proper_shipping_name", "properShippingName");
		this.hashFields.put("fp", "fp");
		this.hashFields.put("mrd_file_name", "mrdFileName");
		this.hashFields.put("opload", "opload");
		this.hashFields.put("rd_param", "rdParam");
		this.hashFields.put("un_no", "unNo");
		this.hashFields.put("cellposition", "cellposition");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("dchg_cd", "dchgCd");
		this.hashFields.put("pg", "pg");
		this.hashFields.put("email", "email");
		this.hashFields.put("mst_name", "mstName");
		this.hashFields.put("n_weight", "nWeight");
		this.hashFields.put("hzd_desc", "hzdDesc");
		this.hashFields.put("stwg_flg", "stwgFlg");
		this.hashFields.put("ems1", "ems1");
		this.hashFields.put("mpa", "mpa");
		this.hashFields.put("ems2", "ems2");
		this.hashFields.put("mrd_title", "mrdTitle");
		this.hashFields.put("g_weight", "gWeight");
		this.hashFields.put("mrd_nm", "mrdNm");
		this.hashFields.put("port", "port");
		this.hashFields.put("agnt_name", "agntName");
		this.hashFields.put("emergency_tel", "emergencyTel");
		this.hashFields.put("cls_sub", "clsSub");
		this.hashFields.put("qty_package_type", "qtyPackageType");
		this.hashFields.put("stowage", "stowage");
		this.hashFields.put("mrd_arguments", "mrdArguments");
		this.hashFields.put("opdischarge", "opdischarge");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_name", "podName");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("pol_name", "polName");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("mp", "mp");
		this.hashFields.put("list_type", "listType");
		this.hashFields.put("mrd_path", "mrdPath");
		this.hashFields.put("pic", "pic");
		this.hashFields.put("optranzit", "optranzit");
		this.hashFields.put("operator", "operator");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("mrd_body_title", "mrdBodyTitle");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
		this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
		this.hashFields.put("cgo_opr_cd", "cgoOprCd");
		this.hashFields.put("inner_package_detail", "innerPackageDetail");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return no
	 */
	public String getNo() {
		return this.no;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return listNm
	 */
	public String getListNm() {
		return this.listNm;
	}
	
	/**
	 * Column Info
	 * @return lodCd
	 */
	public String getLodCd() {
		return this.lodCd;
	}
	
	/**
	 * Column Info
	 * @return tzCd
	 */
	public String getTzCd() {
		return this.tzCd;
	}
	
	/**
	 * Column Info
	 * @return properShippingName
	 */
	public String getProperShippingName() {
		return this.properShippingName;
	}
	
	/**
	 * Column Info
	 * @return fp
	 */
	public String getFp() {
		return this.fp;
	}
	
	/**
	 * Column Info
	 * @return mrdFileName
	 */
	public String getMrdFileName() {
		return this.mrdFileName;
	}
	
	/**
	 * Column Info
	 * @return opload
	 */
	public String getOpload() {
		return this.opload;
	}
	
	/**
	 * Column Info
	 * @return rdParam
	 */
	public String getRdParam() {
		return this.rdParam;
	}
	
	/**
	 * Column Info
	 * @return unNo
	 */
	public String getUnNo() {
		return this.unNo;
	}
	
	/**
	 * Column Info
	 * @return cellposition
	 */
	public String getCellposition() {
		return this.cellposition;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return dchgCd
	 */
	public String getDchgCd() {
		return this.dchgCd;
	}
	
	/**
	 * Column Info
	 * @return pg
	 */
	public String getPg() {
		return this.pg;
	}
	
	/**
	 * Column Info
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Column Info
	 * @return mstName
	 */
	public String getMstName() {
		return this.mstName;
	}
	
	/**
	 * Column Info
	 * @return nWeight
	 */
	public String getNWeight() {
		return this.nWeight;
	}
	
	/**
	 * Column Info
	 * @return hzdDesc
	 */
	public String getHzdDesc() {
		return this.hzdDesc;
	}
	
	/**
	 * Column Info
	 * @return stwgFlg
	 */
	public String getStwgFlg() {
		return this.stwgFlg;
	}
	
	/**
	 * Column Info
	 * @return ems1
	 */
	public String getEms1() {
		return this.ems1;
	}
	
	/**
	 * Column Info
	 * @return mpa
	 */
	public String getMpa() {
		return this.mpa;
	}
	
	/**
	 * Column Info
	 * @return ems2
	 */
	public String getEms2() {
		return this.ems2;
	}
	
	/**
	 * Column Info
	 * @return mrdTitle
	 */
	public String getMrdTitle() {
		return this.mrdTitle;
	}
	
	/**
	 * Column Info
	 * @return gWeight
	 */
	public String getGWeight() {
		return this.gWeight;
	}
	
	/**
	 * Column Info
	 * @return mrdNm
	 */
	public String getMrdNm() {
		return this.mrdNm;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return agntName
	 */
	public String getAgntName() {
		return this.agntName;
	}
	
	/**
	 * Column Info
	 * @return emergencyTel
	 */
	public String getEmergencyTel() {
		return this.emergencyTel;
	}
	
	/**
	 * Column Info
	 * @return clsSub
	 */
	public String getClsSub() {
		return this.clsSub;
	}
	
	/**
	 * Column Info
	 * @return qtyPackageType
	 */
	public String getQtyPackageType() {
		return this.qtyPackageType;
	}
	
	/**
	 * Column Info
	 * @return stowage
	 */
	public String getStowage() {
		return this.stowage;
	}
	
	/**
	 * Column Info
	 * @return mrdArguments
	 */
	public String getMrdArguments() {
		return this.mrdArguments;
	}
	
	/**
	 * Column Info
	 * @return opdischarge
	 */
	public String getOpdischarge() {
		return this.opdischarge;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return podName
	 */
	public String getPodName() {
		return this.podName;
	}
	
	/**
	 * Column Info
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @return polName
	 */
	public String getPolName() {
		return this.polName;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return mp
	 */
	public String getMp() {
		return this.mp;
	}
	
	/**
	 * Column Info
	 * @return listType
	 */
	public String getListType() {
		return this.listType;
	}
	
	/**
	 * Column Info
	 * @return mrdPath
	 */
	public String getMrdPath() {
		return this.mrdPath;
	}
	
	/**
	 * Column Info
	 * @return pic
	 */
	public String getPic() {
		return this.pic;
	}
	
	/**
	 * Column Info
	 * @return optranzit
	 */
	public String getOptranzit() {
		return this.optranzit;
	}
	
	/**
	 * Column Info
	 * @return operator
	 */
	public String getOperator() {
		return this.operator;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return mrdBodyTitle
	 */
	public String getMrdBodyTitle() {
		return this.mrdBodyTitle;
	}
	
	/**
	 * Column Info
	 * @return imdgLmtQtyFlg
	 */
	public String getImdgLmtQtyFlg() {
		return this.imdgLmtQtyFlg;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return ibCssmVoyNo
	 */
	public String getIbCssmVoyNo() {
		return this.ibCssmVoyNo;
	}

	
	/**
	 * Column Info
	 * @return obCssmVoyNo
	 */
	public String getObCssmVoyNo() {
		return this.obCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @return cgoOprCd
	 */
	public String getCgoOprCd() {
		return this.cgoOprCd;
	}
	
	/**
	 * Column Info
	 * @return innerPackageDetail
	 */
	public String getInnerPackageDetail() {
		return this.innerPackageDetail;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param no
	 */
	public void setNo(String no) {
		this.no = no;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param listNm
	 */
	public void setListNm(String listNm) {
		this.listNm = listNm;
	}
	
	/**
	 * Column Info
	 * @param lodCd
	 */
	public void setLodCd(String lodCd) {
		this.lodCd = lodCd;
	}
	
	/**
	 * Column Info
	 * @param tzCd
	 */
	public void setTzCd(String tzCd) {
		this.tzCd = tzCd;
	}
	
	/**
	 * Column Info
	 * @param properShippingName
	 */
	public void setProperShippingName(String properShippingName) {
		this.properShippingName = properShippingName;
	}
	
	/**
	 * Column Info
	 * @param fp
	 */
	public void setFp(String fp) {
		this.fp = fp;
	}
	
	/**
	 * Column Info
	 * @param mrdFileName
	 */
	public void setMrdFileName(String mrdFileName) {
		this.mrdFileName = mrdFileName;
	}
	
	/**
	 * Column Info
	 * @param opload
	 */
	public void setOpload(String opload) {
		this.opload = opload;
	}
	
	/**
	 * Column Info
	 * @param rdParam
	 */
	public void setRdParam(String rdParam) {
		this.rdParam = rdParam;
	}
	
	/**
	 * Column Info
	 * @param unNo
	 */
	public void setUnNo(String unNo) {
		this.unNo = unNo;
	}
	
	/**
	 * Column Info
	 * @param cellposition
	 */
	public void setCellposition(String cellposition) {
		this.cellposition = cellposition;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param dchgCd
	 */
	public void setDchgCd(String dchgCd) {
		this.dchgCd = dchgCd;
	}
	
	/**
	 * Column Info
	 * @param pg
	 */
	public void setPg(String pg) {
		this.pg = pg;
	}
	
	/**
	 * Column Info
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Column Info
	 * @param mstName
	 */
	public void setMstName(String mstName) {
		this.mstName = mstName;
	}
	
	/**
	 * Column Info
	 * @param nWeight
	 */
	public void setNWeight(String nWeight) {
		this.nWeight = nWeight;
	}
	
	/**
	 * Column Info
	 * @param hzdDesc
	 */
	public void setHzdDesc(String hzdDesc) {
		this.hzdDesc = hzdDesc;
	}
	
	/**
	 * Column Info
	 * @param stwgFlg
	 */
	public void setStwgFlg(String stwgFlg) {
		this.stwgFlg = stwgFlg;
	}
	
	/**
	 * Column Info
	 * @param ems1
	 */
	public void setEms1(String ems1) {
		this.ems1 = ems1;
	}
	
	/**
	 * Column Info
	 * @param mpa
	 */
	public void setMpa(String mpa) {
		this.mpa = mpa;
	}
	
	/**
	 * Column Info
	 * @param ems2
	 */
	public void setEms2(String ems2) {
		this.ems2 = ems2;
	}
	
	/**
	 * Column Info
	 * @param mrdTitle
	 */
	public void setMrdTitle(String mrdTitle) {
		this.mrdTitle = mrdTitle;
	}
	
	/**
	 * Column Info
	 * @param gWeight
	 */
	public void setGWeight(String gWeight) {
		this.gWeight = gWeight;
	}
	
	/**
	 * Column Info
	 * @param mrdNm
	 */
	public void setMrdNm(String mrdNm) {
		this.mrdNm = mrdNm;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param agntName
	 */
	public void setAgntName(String agntName) {
		this.agntName = agntName;
	}
	
	/**
	 * Column Info
	 * @param emergencyTel
	 */
	public void setEmergencyTel(String emergencyTel) {
		this.emergencyTel = emergencyTel;
	}
	
	/**
	 * Column Info
	 * @param clsSub
	 */
	public void setClsSub(String clsSub) {
		this.clsSub = clsSub;
	}
	
	/**
	 * Column Info
	 * @param qtyPackageType
	 */
	public void setQtyPackageType(String qtyPackageType) {
		this.qtyPackageType = qtyPackageType;
	}
	
	/**
	 * Column Info
	 * @param stowage
	 */
	public void setStowage(String stowage) {
		this.stowage = stowage;
	}
	
	/**
	 * Column Info
	 * @param mrdArguments
	 */
	public void setMrdArguments(String mrdArguments) {
		this.mrdArguments = mrdArguments;
	}
	
	/**
	 * Column Info
	 * @param opdischarge
	 */
	public void setOpdischarge(String opdischarge) {
		this.opdischarge = opdischarge;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param podName
	 */
	public void setPodName(String podName) {
		this.podName = podName;
	}
	
	/**
	 * Column Info
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @param polName
	 */
	public void setPolName(String polName) {
		this.polName = polName;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param mp
	 */
	public void setMp(String mp) {
		this.mp = mp;
	}
	
	/**
	 * Column Info
	 * @param listType
	 */
	public void setListType(String listType) {
		this.listType = listType;
	}
	
	/**
	 * Column Info
	 * @param mrdPath
	 */
	public void setMrdPath(String mrdPath) {
		this.mrdPath = mrdPath;
	}
	
	/**
	 * Column Info
	 * @param pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	/**
	 * Column Info
	 * @param optranzit
	 */
	public void setOptranzit(String optranzit) {
		this.optranzit = optranzit;
	}
	
	/**
	 * Column Info
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param mrdBodyTitle
	 */
	public void setMrdBodyTitle(String mrdBodyTitle) {
		this.mrdBodyTitle = mrdBodyTitle;
	}
	
	/**
	 * Column Info
	 * @param imdgLmtQtyFlg
	 */
	public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param obCssmVoyNo
	 */
	public void setObCssmVoyNo(String obCssmVoyNo) {
		this.obCssmVoyNo = obCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @param ibCssmVoyNo
	 */
	public void setIbCssmVoyNo(String ibCssmVoyNo) {
		this.ibCssmVoyNo = ibCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @param cgoOprCd
	 */
	public void setCgoOprCd(String cgoOprCd) {
		this.cgoOprCd = cgoOprCd;
	}
	
	/**
	 * Column Info
	 * @param innerPackageDetail
	 */
	public void setInnerPackageDetail(String innerPackageDetail) {
		this.innerPackageDetail = innerPackageDetail;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setNo(JSPUtil.getParameter(request, prefix + "no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setListNm(JSPUtil.getParameter(request, prefix + "list_nm", ""));
		setLodCd(JSPUtil.getParameter(request, prefix + "lod_cd", ""));
		setTzCd(JSPUtil.getParameter(request, prefix + "tz_cd", ""));
		setProperShippingName(JSPUtil.getParameter(request, prefix + "proper_shipping_name", ""));
		setFp(JSPUtil.getParameter(request, prefix + "fp", ""));
		setMrdFileName(JSPUtil.getParameter(request, prefix + "mrd_file_name", ""));
		setOpload(JSPUtil.getParameter(request, prefix + "opload", ""));
		setRdParam(JSPUtil.getParameter(request, prefix + "rd_param", ""));
		setUnNo(JSPUtil.getParameter(request, prefix + "un_no", ""));
		setCellposition(JSPUtil.getParameter(request, prefix + "cellposition", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDchgCd(JSPUtil.getParameter(request, prefix + "dchg_cd", ""));
		setPg(JSPUtil.getParameter(request, prefix + "pg", ""));
		setEmail(JSPUtil.getParameter(request, prefix + "email", ""));
		setMstName(JSPUtil.getParameter(request, prefix + "mst_name", ""));
		setNWeight(JSPUtil.getParameter(request, prefix + "n_weight", ""));
		setHzdDesc(JSPUtil.getParameter(request, prefix + "hzd_desc", ""));
		setStwgFlg(JSPUtil.getParameter(request, prefix + "stwg_flg", ""));
		setEms1(JSPUtil.getParameter(request, prefix + "ems1", ""));
		setMpa(JSPUtil.getParameter(request, prefix + "mpa", ""));
		setEms2(JSPUtil.getParameter(request, prefix + "ems2", ""));
		setMrdTitle(JSPUtil.getParameter(request, prefix + "mrd_title", ""));
		setGWeight(JSPUtil.getParameter(request, prefix + "g_weight", ""));
		setMrdNm(JSPUtil.getParameter(request, prefix + "mrd_nm", ""));
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setAgntName(JSPUtil.getParameter(request, prefix + "agnt_name", ""));
		setEmergencyTel(JSPUtil.getParameter(request, prefix + "emergency_tel", ""));
		setClsSub(JSPUtil.getParameter(request, prefix + "cls_sub", ""));
		setQtyPackageType(JSPUtil.getParameter(request, prefix + "qty_package_type", ""));
		setStowage(JSPUtil.getParameter(request, prefix + "stowage", ""));
		setMrdArguments(JSPUtil.getParameter(request, prefix + "mrd_arguments", ""));
		setOpdischarge(JSPUtil.getParameter(request, prefix + "opdischarge", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPodName(JSPUtil.getParameter(request, prefix + "pod_name", ""));
		setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
		setPolName(JSPUtil.getParameter(request, prefix + "pol_name", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setMp(JSPUtil.getParameter(request, prefix + "mp", ""));
		setListType(JSPUtil.getParameter(request, prefix + "list_type", ""));
		setMrdPath(JSPUtil.getParameter(request, prefix + "mrd_path", ""));
		setPic(JSPUtil.getParameter(request, prefix + "pic", ""));
		setOptranzit(JSPUtil.getParameter(request, prefix + "optranzit", ""));
		setOperator(JSPUtil.getParameter(request, prefix + "operator", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setMrdBodyTitle(JSPUtil.getParameter(request, prefix + "mrd_body_title", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setObCssmVoyNo(JSPUtil.getParameter(request, prefix + "ob_cssm_voy_no", ""));
		setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
		setCgoOprCd(JSPUtil.getParameter(request, prefix + "cgo_opr_cd", ""));
		setInnerPackageDetail(JSPUtil.getParameter(request, prefix + "inner_package_detail", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurDgListVO[]
	 */
	public EurDgListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurDgListVO[]
	 */
	public EurDgListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurDgListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] no = (JSPUtil.getParameter(request, prefix	+ "no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] listNm = (JSPUtil.getParameter(request, prefix	+ "list_nm", length));
			String[] lodCd = (JSPUtil.getParameter(request, prefix	+ "lod_cd", length));
			String[] tzCd = (JSPUtil.getParameter(request, prefix	+ "tz_cd", length));
			String[] properShippingName = (JSPUtil.getParameter(request, prefix	+ "proper_shipping_name", length));
			String[] fp = (JSPUtil.getParameter(request, prefix	+ "fp", length));
			String[] mrdFileName = (JSPUtil.getParameter(request, prefix	+ "mrd_file_name", length));
			String[] opload = (JSPUtil.getParameter(request, prefix	+ "opload", length));
			String[] rdParam = (JSPUtil.getParameter(request, prefix	+ "rd_param", length));
			String[] unNo = (JSPUtil.getParameter(request, prefix	+ "un_no", length));
			String[] cellposition = (JSPUtil.getParameter(request, prefix	+ "cellposition", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] dchgCd = (JSPUtil.getParameter(request, prefix	+ "dchg_cd", length));
			String[] pg = (JSPUtil.getParameter(request, prefix	+ "pg", length));
			String[] email = (JSPUtil.getParameter(request, prefix	+ "email", length));
			String[] mstName = (JSPUtil.getParameter(request, prefix	+ "mst_name", length));
			String[] nWeight = (JSPUtil.getParameter(request, prefix	+ "n_weight", length));
			String[] hzdDesc = (JSPUtil.getParameter(request, prefix	+ "hzd_desc", length));
			String[] stwgFlg = (JSPUtil.getParameter(request, prefix	+ "stwg_flg", length));
			String[] ems1 = (JSPUtil.getParameter(request, prefix	+ "ems1", length));
			String[] mpa = (JSPUtil.getParameter(request, prefix	+ "mpa", length));
			String[] ems2 = (JSPUtil.getParameter(request, prefix	+ "ems2", length));
			String[] mrdTitle = (JSPUtil.getParameter(request, prefix	+ "mrd_title", length));
			String[] gWeight = (JSPUtil.getParameter(request, prefix	+ "g_weight", length));
			String[] mrdNm = (JSPUtil.getParameter(request, prefix	+ "mrd_nm", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] agntName = (JSPUtil.getParameter(request, prefix	+ "agnt_name", length));
			String[] emergencyTel = (JSPUtil.getParameter(request, prefix	+ "emergency_tel", length));
			String[] clsSub = (JSPUtil.getParameter(request, prefix	+ "cls_sub", length));
			String[] qtyPackageType = (JSPUtil.getParameter(request, prefix	+ "qty_package_type", length));
			String[] stowage = (JSPUtil.getParameter(request, prefix	+ "stowage", length));
			String[] mrdArguments = (JSPUtil.getParameter(request, prefix	+ "mrd_arguments", length));
			String[] opdischarge = (JSPUtil.getParameter(request, prefix	+ "opdischarge", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podName = (JSPUtil.getParameter(request, prefix	+ "pod_name", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] polName = (JSPUtil.getParameter(request, prefix	+ "pol_name", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] mp = (JSPUtil.getParameter(request, prefix	+ "mp", length));
			String[] listType = (JSPUtil.getParameter(request, prefix	+ "list_type", length));
			String[] mrdPath = (JSPUtil.getParameter(request, prefix	+ "mrd_path", length));
			String[] pic = (JSPUtil.getParameter(request, prefix	+ "pic", length));
			String[] optranzit = (JSPUtil.getParameter(request, prefix	+ "optranzit", length));
			String[] operator = (JSPUtil.getParameter(request, prefix	+ "operator", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] mrdBodyTitle = (JSPUtil.getParameter(request, prefix	+ "mrd_body_title", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] obCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ob_cssm_voy_no", length));
			String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_cssm_voy_no", length));
			String[] cgoOprCd = (JSPUtil.getParameter(request, prefix	+ "cgo_opr_cd", length));
			String[] innerPackageDetail = (JSPUtil.getParameter(request, prefix	+ "inner_package_detail", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurDgListVO();
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (no[i] != null)
					model.setNo(no[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (listNm[i] != null)
					model.setListNm(listNm[i]);
				if (lodCd[i] != null)
					model.setLodCd(lodCd[i]);
				if (tzCd[i] != null)
					model.setTzCd(tzCd[i]);
				if (properShippingName[i] != null)
					model.setProperShippingName(properShippingName[i]);
				if (fp[i] != null)
					model.setFp(fp[i]);
				if (mrdFileName[i] != null)
					model.setMrdFileName(mrdFileName[i]);
				if (opload[i] != null)
					model.setOpload(opload[i]);
				if (rdParam[i] != null)
					model.setRdParam(rdParam[i]);
				if (unNo[i] != null)
					model.setUnNo(unNo[i]);
				if (cellposition[i] != null)
					model.setCellposition(cellposition[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (dchgCd[i] != null)
					model.setDchgCd(dchgCd[i]);
				if (pg[i] != null)
					model.setPg(pg[i]);
				if (email[i] != null)
					model.setEmail(email[i]);
				if (mstName[i] != null)
					model.setMstName(mstName[i]);
				if (nWeight[i] != null)
					model.setNWeight(nWeight[i]);
				if (hzdDesc[i] != null)
					model.setHzdDesc(hzdDesc[i]);
				if (stwgFlg[i] != null)
					model.setStwgFlg(stwgFlg[i]);
				if (ems1[i] != null)
					model.setEms1(ems1[i]);
				if (mpa[i] != null)
					model.setMpa(mpa[i]);
				if (ems2[i] != null)
					model.setEms2(ems2[i]);
				if (mrdTitle[i] != null)
					model.setMrdTitle(mrdTitle[i]);
				if (gWeight[i] != null)
					model.setGWeight(gWeight[i]);
				if (mrdNm[i] != null)
					model.setMrdNm(mrdNm[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (agntName[i] != null)
					model.setAgntName(agntName[i]);
				if (emergencyTel[i] != null)
					model.setEmergencyTel(emergencyTel[i]);
				if (clsSub[i] != null)
					model.setClsSub(clsSub[i]);
				if (qtyPackageType[i] != null)
					model.setQtyPackageType(qtyPackageType[i]);
				if (stowage[i] != null)
					model.setStowage(stowage[i]);
				if (mrdArguments[i] != null)
					model.setMrdArguments(mrdArguments[i]);
				if (opdischarge[i] != null)
					model.setOpdischarge(opdischarge[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podName[i] != null)
					model.setPodName(podName[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (polName[i] != null)
					model.setPolName(polName[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (mp[i] != null)
					model.setMp(mp[i]);
				if (listType[i] != null)
					model.setListType(listType[i]);
				if (mrdPath[i] != null)
					model.setMrdPath(mrdPath[i]);
				if (pic[i] != null)
					model.setPic(pic[i]);
				if (optranzit[i] != null)
					model.setOptranzit(optranzit[i]);
				if (operator[i] != null)
					model.setOperator(operator[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (mrdBodyTitle[i] != null)
					model.setMrdBodyTitle(mrdBodyTitle[i]);
				if (imdgLmtQtyFlg[i] != null)
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (obCssmVoyNo[i] != null)
					model.setObCssmVoyNo(obCssmVoyNo[i]);
				if (ibCssmVoyNo[i] != null)
					model.setIbCssmVoyNo(ibCssmVoyNo[i]);
				if (cgoOprCd[i] != null)
					model.setCgoOprCd(cgoOprCd[i]);
				if (innerPackageDetail[i] != null)
					model.setInnerPackageDetail(innerPackageDetail[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurDgListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurDgListVO[]
	 */
	public EurDgListVO[] getEurDgListVOs(){
		EurDgListVO[] vos = (EurDgListVO[])models.toArray(new EurDgListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.no = this.no .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.listNm = this.listNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodCd = this.lodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tzCd = this.tzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.properShippingName = this.properShippingName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fp = this.fp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdFileName = this.mrdFileName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opload = this.opload .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdParam = this.rdParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unNo = this.unNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cellposition = this.cellposition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgCd = this.dchgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pg = this.pg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.email = this.email .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstName = this.mstName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nWeight = this.nWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdDesc = this.hzdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgFlg = this.stwgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ems1 = this.ems1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mpa = this.mpa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ems2 = this.ems2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdTitle = this.mrdTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gWeight = this.gWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdNm = this.mrdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agntName = this.agntName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emergencyTel = this.emergencyTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clsSub = this.clsSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyPackageType = this.qtyPackageType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stowage = this.stowage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdArguments = this.mrdArguments .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opdischarge = this.opdischarge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podName = this.podName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polName = this.polName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mp = this.mp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.listType = this.listType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdPath = this.mrdPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic = this.pic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optranzit = this.optranzit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operator = this.operator .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdBodyTitle = this.mrdBodyTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCssmVoyNo = this.obCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCssmVoyNo = this.ibCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoOprCd = this.cgoOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.innerPackageDetail = this.innerPackageDetail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
