/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SearchContracNoListByVesselVO.java
 *@FileTitle : SearchContracNoListByVesselVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.05.15
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.05.15  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 愿��젴	Event�뿉�꽌	�옉�꽦,	�꽌踰꾩떎�뻾�슂泥��떆	PDTO�쓽 �뿭�븷�쓣 �닔�뻾�븯�뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class SearchContracNoListByVesselVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SearchContracNoListByVesselVO>  models =	new	ArrayList<SearchContracNoListByVesselVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 vslEngNm   =  null;
	/*	Column Info	*/
	private  String	 fletCtrtNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 fletCtrtTpCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SearchContracNoListByVesselVO(){}

	public SearchContracNoListByVesselVO(String ibflag,String vslCd,String vslEngNm,String fletCtrtNo,String pagerows,String fletCtrtTpCd)	{
		this.ibflag  = ibflag ;
		this.vslCd  = vslCd ;
		this.vslEngNm  = vslEngNm ;
		this.fletCtrtNo  = fletCtrtNo ;
		this.pagerows  = pagerows ;
		this.fletCtrtTpCd  = fletCtrtTpCd ;
	}


	/**
	 * �뀒�씠釉� 而щ읆�뿉 ���옣�븷 媛믪쓣 Hashtable<"column_name", "value">	濡� 諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());		
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	���쓳�릺�뒗 硫ㅻ쾭蹂��닔紐낆쓣	���옣�븯�뿬 Hashtable<"column_name", "variable"> 濡� 諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  ibflag
	*/
	public void	setIbflag( String	ibflag ) {
		this.ibflag =	ibflag;
	}
 
	/**
	 * Column Info
	 * @return	ibflag
	 */
	 public	 String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  vslCd
	*/
	public void	setVslCd( String	vslCd ) {
		this.vslCd =	vslCd;
	}
 
	/**
	 * Column Info
	 * @return	vslCd
	 */
	 public	 String	getVslCd() {
		 return	this.vslCd;
	 } 
 	/**
	* Column Info
	* @param  vslEngNm
	*/
	public void	setVslEngNm( String	vslEngNm ) {
		this.vslEngNm =	vslEngNm;
	}
 
	/**
	 * Column Info
	 * @return	vslEngNm
	 */
	 public	 String	getVslEngNm() {
		 return	this.vslEngNm;
	 } 
 	/**
	* Column Info
	* @param  fletCtrtNo
	*/
	public void	setFletCtrtNo( String	fletCtrtNo ) {
		this.fletCtrtNo =	fletCtrtNo;
	}
 
	/**
	 * Column Info
	 * @return	fletCtrtNo
	 */
	 public	 String	getFletCtrtNo() {
		 return	this.fletCtrtNo;
	 } 
 	/**
	* Column Info
	* @param  pagerows
	*/
	public void	setPagerows( String	pagerows ) {
		this.pagerows =	pagerows;
	}
 
	/**
	 * Column Info
	 * @return	pagerows
	 */
	 public	 String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  fletCtrtTpCd
	*/
	public void	setFletCtrtTpCd( String	fletCtrtTpCd ) {
		this.fletCtrtTpCd =	fletCtrtTpCd;
	}
 
	/**
	 * Column Info
	 * @return	fletCtrtTpCd
	 */
	 public	 String	getFletCtrtTpCd() {
		 return	this.fletCtrtTpCd;
	 } 

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request,	prefix + "vsl_eng_nm", ""));
		setFletCtrtNo(JSPUtil.getParameter(request,	prefix + "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request,	prefix + "flet_ctrt_tp_cd", ""));
	}
	
	/**
	 * Request �쓽 �뜲�씠�꽣瑜� VO 諛곗뿴濡� 蹂��솚�븯�뿬 諛섑솚.
	 * @param request
	 * @return SearchContracNoListByVesselVO[]
	 */
	public SearchContracNoListByVesselVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �꽆�뼱�삩 �뿬�윭 嫄�	DATA瑜� VO Class �뿉 �떞�뒗�떎.
	 * @param request
	 * @param prefix
	 * @return SearchContracNoListByVesselVO[]
	 */
	public SearchContracNoListByVesselVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SearchContracNoListByVesselVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] vslEngNm =	(JSPUtil.getParameter(request, prefix +	"vsl_eng_nm".trim(),	length));
				String[] fletCtrtNo =	(JSPUtil.getParameter(request, prefix +	"flet_ctrt_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] fletCtrtTpCd =	(JSPUtil.getParameter(request, prefix +	"flet_ctrt_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SearchContracNoListByVesselVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( vslEngNm[i] !=	null)
						model.setVslEngNm( vslEngNm[i]);
						if ( fletCtrtNo[i] !=	null)
						model.setFletCtrtNo( fletCtrtNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( fletCtrtTpCd[i] !=	null)
						model.setFletCtrtTpCd( fletCtrtTpCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSearchContracNoListByVesselVOs();
	}

	/**
	 *  VO 諛곗뿴�쓣 諛섑솚
	 * @return SearchContracNoListByVesselVO[]
	 */
	public SearchContracNoListByVesselVO[]	 getSearchContracNoListByVesselVOs(){
		SearchContracNoListByVesselVO[] vos = (SearchContracNoListByVesselVO[])models.toArray(new	SearchContracNoListByVesselVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class�쓽 �궡�슜�쓣 String�쑝濡� 蹂��솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �룷留룻똿�맂 臾몄옄�뿴�뿉�꽌 �듅�닔臾몄옄 �젣嫄�("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm =	this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo =	this.fletCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd =	this.fletCtrtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}