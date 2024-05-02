/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaCntrListVO.java
*@FileTitle : FaCntrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.20 이호선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FaCntrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FaCntrListVO> models = new ArrayList<FaCntrListVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locationSegment = null;
	/* Column Info */
	private String assetType = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String totalCount = null;
	/* Column Info */
	private String attribute21 = null;
	/* Column Info */
	private String lifid = null;
	/* Column Info */
	private String categorySegment = null;
	/* Column Info */
	private String datePlacedInService = null;
	/* Column Info */
	private String cost = null;
	/* Column Info */
	private String lastUpdateDate = null;
	/* Column Info */
	private String attribute4 = null;
	/* Column Info */
	private String creationDate = null;
	/* Column Info */
	private String createdBy = null;
	/* Column Info */
	private String acqMth = null;
	/* Column Info */
	private String manufacturer = null;
	/* Column Info */
	private String lastUpdatedBy = null;
	/* Column Info */
	private String assetDescription = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String tagNumber = null;
	/* Column Info */
	private String bookTypeCode = null;
	/* Column Info */
	private String attribute1 = null;
	/* Column Info */
	private String attribute2 = null;
	/* Column Info */
	private String attribute3 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FaCntrListVO() {}

	public FaCntrListVO(String ibflag, String pagerows, String lifid, String seq, String totalCount, String rnum, String bookTypeCode, String assetDescription, String assetType, String categorySegment, String cost, String locationSegment, String datePlacedInService, String tagNumber, String attribute1, String attribute2, String attribute3, String attribute4, String createdBy, String creationDate, String lastUpdatedBy, String lastUpdateDate, String manufacturer, String attribute21, String acqMth) {
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locationSegment = locationSegment;
		this.assetType = assetType;
		this.rnum = rnum;
		this.totalCount = totalCount;
		this.attribute21 = attribute21;
		this.lifid = lifid;
		this.categorySegment = categorySegment;
		this.datePlacedInService = datePlacedInService;
		this.cost = cost;
		this.lastUpdateDate = lastUpdateDate;
		this.attribute4 = attribute4;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.acqMth = acqMth;
		this.manufacturer = manufacturer;
		this.lastUpdatedBy = lastUpdatedBy;
		this.assetDescription = assetDescription;
		this.seq = seq;
		this.tagNumber = tagNumber;
		this.bookTypeCode = bookTypeCode;
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("location_segment", getLocationSegment());
		this.hashColumns.put("asset_type", getAssetType());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("total_count", getTotalCount());
		this.hashColumns.put("attribute21", getAttribute21());
		this.hashColumns.put("lifid", getLifid());
		this.hashColumns.put("category_segment", getCategorySegment());
		this.hashColumns.put("date_placed_in_service", getDatePlacedInService());
		this.hashColumns.put("cost", getCost());
		this.hashColumns.put("last_update_date", getLastUpdateDate());
		this.hashColumns.put("attribute4", getAttribute4());
		this.hashColumns.put("creation_date", getCreationDate());
		this.hashColumns.put("created_by", getCreatedBy());
		this.hashColumns.put("acq_mth", getAcqMth());
		this.hashColumns.put("manufacturer", getManufacturer());
		this.hashColumns.put("last_updated_by", getLastUpdatedBy());
		this.hashColumns.put("asset_description", getAssetDescription());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("tag_number", getTagNumber());
		this.hashColumns.put("book_type_code", getBookTypeCode());
		this.hashColumns.put("attribute1", getAttribute1());
		this.hashColumns.put("attribute2", getAttribute2());
		this.hashColumns.put("attribute3", getAttribute3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("location_segment", "locationSegment");
		this.hashFields.put("asset_type", "assetType");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("total_count", "totalCount");
		this.hashFields.put("attribute21", "attribute21");
		this.hashFields.put("lifid", "lifid");
		this.hashFields.put("category_segment", "categorySegment");
		this.hashFields.put("date_placed_in_service", "datePlacedInService");
		this.hashFields.put("cost", "cost");
		this.hashFields.put("last_update_date", "lastUpdateDate");
		this.hashFields.put("attribute4", "attribute4");
		this.hashFields.put("creation_date", "creationDate");
		this.hashFields.put("created_by", "createdBy");
		this.hashFields.put("acq_mth", "acqMth");
		this.hashFields.put("manufacturer", "manufacturer");
		this.hashFields.put("last_updated_by", "lastUpdatedBy");
		this.hashFields.put("asset_description", "assetDescription");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("tag_number", "tagNumber");
		this.hashFields.put("book_type_code", "bookTypeCode");
		this.hashFields.put("attribute1", "attribute1");
		this.hashFields.put("attribute2", "attribute2");
		this.hashFields.put("attribute3", "attribute3");
		return this.hashFields;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return locationSegment
	 */
	public String getLocationSegment() {
		return this.locationSegment;
	}
	
	/**
	 * Column Info
	 * @return assetType
	 */
	public String getAssetType() {
		return this.assetType;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return totalCount
	 */
	public String getTotalCount() {
		return this.totalCount;
	}
	
	/**
	 * Column Info
	 * @return attribute21
	 */
	public String getAttribute21() {
		return this.attribute21;
	}
	
	/**
	 * Column Info
	 * @return lifid
	 */
	public String getLifid() {
		return this.lifid;
	}
	
	/**
	 * Column Info
	 * @return categorySegment
	 */
	public String getCategorySegment() {
		return this.categorySegment;
	}
	
	/**
	 * Column Info
	 * @return datePlacedInService
	 */
	public String getDatePlacedInService() {
		return this.datePlacedInService;
	}
	
	/**
	 * Column Info
	 * @return cost
	 */
	public String getCost() {
		return this.cost;
	}
	
	/**
	 * Column Info
	 * @return lastUpdateDate
	 */
	public String getLastUpdateDate() {
		return this.lastUpdateDate;
	}
	
	/**
	 * Column Info
	 * @return attribute4
	 */
	public String getAttribute4() {
		return this.attribute4;
	}
	
	/**
	 * Column Info
	 * @return creationDate
	 */
	public String getCreationDate() {
		return this.creationDate;
	}
	
	/**
	 * Column Info
	 * @return createdBy
	 */
	public String getCreatedBy() {
		return this.createdBy;
	}
	
	/**
	 * Column Info
	 * @return acqMth
	 */
	public String getAcqMth() {
		return this.acqMth;
	}
	
	/**
	 * Column Info
	 * @return manufacturer
	 */
	public String getManufacturer() {
		return this.manufacturer;
	}
	
	/**
	 * Column Info
	 * @return lastUpdatedBy
	 */
	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}
	
	/**
	 * Column Info
	 * @return assetDescription
	 */
	public String getAssetDescription() {
		return this.assetDescription;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return tagNumber
	 */
	public String getTagNumber() {
		return this.tagNumber;
	}
	
	/**
	 * Column Info
	 * @return bookTypeCode
	 */
	public String getBookTypeCode() {
		return this.bookTypeCode;
	}
	
	/**
	 * Column Info
	 * @return attribute1
	 */
	public String getAttribute1() {
		return this.attribute1;
	}
	
	/**
	 * Column Info
	 * @return attribute2
	 */
	public String getAttribute2() {
		return this.attribute2;
	}
	
	/**
	 * Column Info
	 * @return attribute3
	 */
	public String getAttribute3() {
		return this.attribute3;
	}
	

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param locationSegment
	 */
	public void setLocationSegment(String locationSegment) {
		this.locationSegment = locationSegment;
	}
	
	/**
	 * Column Info
	 * @param assetType
	 */
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param totalCount
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * Column Info
	 * @param attribute21
	 */
	public void setAttribute21(String attribute21) {
		this.attribute21 = attribute21;
	}
	
	/**
	 * Column Info
	 * @param lifid
	 */
	public void setLifid(String lifid) {
		this.lifid = lifid;
	}
	
	/**
	 * Column Info
	 * @param categorySegment
	 */
	public void setCategorySegment(String categorySegment) {
		this.categorySegment = categorySegment;
	}
	
	/**
	 * Column Info
	 * @param datePlacedInService
	 */
	public void setDatePlacedInService(String datePlacedInService) {
		this.datePlacedInService = datePlacedInService;
	}
	
	/**
	 * Column Info
	 * @param cost
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	/**
	 * Column Info
	 * @param lastUpdateDate
	 */
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	/**
	 * Column Info
	 * @param attribute4
	 */
	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}
	
	/**
	 * Column Info
	 * @param creationDate
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	 * Column Info
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * Column Info
	 * @param acqMth
	 */
	public void setAcqMth(String acqMth) {
		this.acqMth = acqMth;
	}
	
	/**
	 * Column Info
	 * @param manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	/**
	 * Column Info
	 * @param lastUpdatedBy
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	/**
	 * Column Info
	 * @param assetDescription
	 */
	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param tagNumber
	 */
	public void setTagNumber(String tagNumber) {
		this.tagNumber = tagNumber;
	}
	
	/**
	 * Column Info
	 * @param bookTypeCode
	 */
	public void setBookTypeCode(String bookTypeCode) {
		this.bookTypeCode = bookTypeCode;
	}
	
	/**
	 * Column Info
	 * @param attribute1
	 */
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	
	/**
	 * Column Info
	 * @param attribute2
	 */
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	
	/**
	 * Column Info
	 * @param attribute3
	 */
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocationSegment(JSPUtil.getParameter(request, "location_segment", ""));
		setAssetType(JSPUtil.getParameter(request, "asset_type", ""));
		setRnum(JSPUtil.getParameter(request, "rnum", ""));
		setTotalCount(JSPUtil.getParameter(request, "total_count", ""));
		setAttribute21(JSPUtil.getParameter(request, "attribute21", ""));
		setLifid(JSPUtil.getParameter(request, "lifid", ""));
		setCategorySegment(JSPUtil.getParameter(request, "category_segment", ""));
		setDatePlacedInService(JSPUtil.getParameter(request, "date_placed_in_service", ""));
		setCost(JSPUtil.getParameter(request, "cost", ""));
		setLastUpdateDate(JSPUtil.getParameter(request, "last_update_date", ""));
		setAttribute4(JSPUtil.getParameter(request, "attribute4", ""));
		setCreationDate(JSPUtil.getParameter(request, "creation_date", ""));
		setCreatedBy(JSPUtil.getParameter(request, "created_by", ""));
		setAcqMth(JSPUtil.getParameter(request, "acq_mth", ""));
		setManufacturer(JSPUtil.getParameter(request, "manufacturer", ""));
		setLastUpdatedBy(JSPUtil.getParameter(request, "last_updated_by", ""));
		setAssetDescription(JSPUtil.getParameter(request, "asset_description", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setTagNumber(JSPUtil.getParameter(request, "tag_number", ""));
		setBookTypeCode(JSPUtil.getParameter(request, "book_type_code", ""));
		setAttribute1(JSPUtil.getParameter(request, "attribute1", ""));
		setAttribute2(JSPUtil.getParameter(request, "attribute2", ""));
		setAttribute3(JSPUtil.getParameter(request, "attribute3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FaCntrListVO[]
	 */
	public FaCntrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FaCntrListVO[]
	 */
	public FaCntrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FaCntrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locationSegment = (JSPUtil.getParameter(request, prefix	+ "location_segment", length));
			String[] assetType = (JSPUtil.getParameter(request, prefix	+ "asset_type", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] totalCount = (JSPUtil.getParameter(request, prefix	+ "total_count", length));
			String[] attribute21 = (JSPUtil.getParameter(request, prefix	+ "attribute21", length));
			String[] lifid = (JSPUtil.getParameter(request, prefix	+ "lifid", length));
			String[] categorySegment = (JSPUtil.getParameter(request, prefix	+ "category_segment", length));
			String[] datePlacedInService = (JSPUtil.getParameter(request, prefix	+ "date_placed_in_service", length));
			String[] cost = (JSPUtil.getParameter(request, prefix	+ "cost", length));
			String[] lastUpdateDate = (JSPUtil.getParameter(request, prefix	+ "last_update_date", length));
			String[] attribute4 = (JSPUtil.getParameter(request, prefix	+ "attribute4", length));
			String[] creationDate = (JSPUtil.getParameter(request, prefix	+ "creation_date", length));
			String[] createdBy = (JSPUtil.getParameter(request, prefix	+ "created_by", length));
			String[] acqMth = (JSPUtil.getParameter(request, prefix	+ "acq_mth", length));
			String[] manufacturer = (JSPUtil.getParameter(request, prefix	+ "manufacturer", length));
			String[] lastUpdatedBy = (JSPUtil.getParameter(request, prefix	+ "last_updated_by", length));
			String[] assetDescription = (JSPUtil.getParameter(request, prefix	+ "asset_description", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] tagNumber = (JSPUtil.getParameter(request, prefix	+ "tag_number", length));
			String[] bookTypeCode = (JSPUtil.getParameter(request, prefix	+ "book_type_code", length));
			String[] attribute1 = (JSPUtil.getParameter(request, prefix	+ "attribute1", length));
			String[] attribute2 = (JSPUtil.getParameter(request, prefix	+ "attribute2", length));
			String[] attribute3 = (JSPUtil.getParameter(request, prefix	+ "attribute3", length));
			
			for (int i = 0; i < length; i++) {
				model = new FaCntrListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locationSegment[i] != null)
					model.setLocationSegment(locationSegment[i]);
				if (assetType[i] != null)
					model.setAssetType(assetType[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (totalCount[i] != null)
					model.setTotalCount(totalCount[i]);
				if (attribute21[i] != null)
					model.setAttribute21(attribute21[i]);
				if (lifid[i] != null)
					model.setLifid(lifid[i]);
				if (categorySegment[i] != null)
					model.setCategorySegment(categorySegment[i]);
				if (datePlacedInService[i] != null)
					model.setDatePlacedInService(datePlacedInService[i]);
				if (cost[i] != null)
					model.setCost(cost[i]);
				if (lastUpdateDate[i] != null)
					model.setLastUpdateDate(lastUpdateDate[i]);
				if (attribute4[i] != null)
					model.setAttribute4(attribute4[i]);
				if (creationDate[i] != null)
					model.setCreationDate(creationDate[i]);
				if (createdBy[i] != null)
					model.setCreatedBy(createdBy[i]);
				if (acqMth[i] != null)
					model.setAcqMth(acqMth[i]);
				if (manufacturer[i] != null)
					model.setManufacturer(manufacturer[i]);
				if (lastUpdatedBy[i] != null)
					model.setLastUpdatedBy(lastUpdatedBy[i]);
				if (assetDescription[i] != null)
					model.setAssetDescription(assetDescription[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (tagNumber[i] != null)
					model.setTagNumber(tagNumber[i]);
				if (bookTypeCode[i] != null)
					model.setBookTypeCode(bookTypeCode[i]);
				if (attribute1[i] != null)
					model.setAttribute1(attribute1[i]);
				if (attribute2[i] != null)
					model.setAttribute2(attribute2[i]);
				if (attribute3[i] != null)
					model.setAttribute3(attribute3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFaCntrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FaCntrListVO[]
	 */
	public FaCntrListVO[] getFaCntrListVOs(){
		FaCntrListVO[] vos = (FaCntrListVO[])models.toArray(new FaCntrListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationSegment = this.locationSegment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assetType = this.assetType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCount = this.totalCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute21 = this.attribute21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lifid = this.lifid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.categorySegment = this.categorySegment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datePlacedInService = this.datePlacedInService .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost = this.cost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastUpdateDate = this.lastUpdateDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute4 = this.attribute4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creationDate = this.creationDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.createdBy = this.createdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acqMth = this.acqMth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manufacturer = this.manufacturer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastUpdatedBy = this.lastUpdatedBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assetDescription = this.assetDescription .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tagNumber = this.tagNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookTypeCode = this.bookTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute1 = this.attribute1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute2 = this.attribute2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute3 = this.attribute3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
