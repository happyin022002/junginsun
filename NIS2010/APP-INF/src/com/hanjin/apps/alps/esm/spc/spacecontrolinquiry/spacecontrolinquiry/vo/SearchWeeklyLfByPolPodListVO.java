/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchWeeklyLfByPolPodListVO.java
*@FileTitle : SearchWeeklyLfByPolPodListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.05
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.07.05 최윤성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchWeeklyLfByPolPodListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchWeeklyLfByPolPodListVO> models = new ArrayList<SearchWeeklyLfByPolPodListVO>();
	
	/* Column Info */
	private String wk5OthQty = null;
	/* Column Info */
	private String wk4YmlQty = null;
	/* Column Info */
	private String wk4PolWgt = null;
	/* Column Info */
	private String wk5CosWgt = null;
	/* Column Info */
	private String wk2PolQty = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String gtlOthWgt = null;
	/* Column Info */
	private String wk4OthQty = null;
	/* Column Info */
	private String wk3YmlQty = null;
	/* Column Info */
	private String wk3HjsQty = null;
	/* Column Info */
	private String wk1KklWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String wk5OthWgt = null;
	/* Column Info */
	private String wk2CosQty = null;
	/* Column Info */
	private String wk4PolQty = null;
	/* Column Info */
	private String lvl0 = null;
	/* Column Info */
	private String wk3PolQty = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String wk3KklQty = null;
	/* Column Info */
	private String wk4CosQty = null;
	/* Column Info */
	private String wk3KklWgt = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String wk2KklWgt = null;
	/* Column Info */
	private String wk4HjsWgt = null;
	/* Column Info */
	private String wk2YmlWgt = null;
	/* Column Info */
	private String wk3YmlWgt = null;
	/* Column Info */
	private String gtlYmlWgt = null;
	/* Column Info */
	private String wk1HjsQty = null;
	/* Column Info */
	private String wk1YmlQty = null;
	/* Column Info */
	private String wk1YmlWgt = null;
	/* Column Info */
	private String subRlaneCd = null;
	/* Column Info */
	private String wk2OthWgt = null;
	/* Column Info */
	private String wk5HjsWgt = null;
	/* Column Info */
	private String wk2CosWgt = null;
	/* Column Info */
	private String gtlCosQty = null;
	/* Column Info */
	private String gtlPolWgt = null;
	/* Column Info */
	private String wk5KklQty = null;
	/* Column Info */
	private String wk1OthWgt = null;
	/* Column Info */
	private String wk5YmlWgt = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String gtlKklQty = null;
	/* Column Info */
	private String bsa = null;
	/* Column Info */
	private String wk2HjsQty = null;
	/* Column Info */
	private String wk1PolQty = null;
	/* Column Info */
	private String wk5KklWgt = null;
	/* Column Info */
	private String wk2YmlQty = null;
	/* Column Info */
	private String wk1HjsWgt = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String wk5CosQty = null;
	/* Column Info */
	private String wk1KklQty = null;
	/* Column Info */
	private String wk2KklQty = null;
	/* Column Info */
	private String wk3CosWgt = null;
	/* Column Info */
	private String wk1CosQty = null;
	/* Column Info */
	private String wk5YmlQty = null;
	/* Column Info */
	private String wk3CosQty = null;
	/* Column Info */
	private String wk4CosWgt = null;
	/* Column Info */
	private String wk3HjsWgt = null;
	/* Column Info */
	private String wk4HjsQty = null;
	/* Column Info */
	private String gtlHjsQty = null;
	/* Column Info */
	private String grpId = null;
	/* Column Info */
	private String gtlPolQty = null;
	/* Column Info */
	private String wk5PolQty = null;
	/* Column Info */
	private String gtlCosWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gtlKklWgt = null;
	/* Column Info */
	private String wk5PolWgt = null;
	/* Column Info */
	private String wk3OthWgt = null;
	/* Column Info */
	private String wk5HjsQty = null;
	/* Column Info */
	private String gtlHjsWgt = null;
	/* Column Info */
	private String wk2PolWgt = null;
	/* Column Info */
	private String wk1CosWgt = null;
	/* Column Info */
	private String gtlOthQty = null;
	/* Column Info */
	private String wk4OthWgt = null;
	/* Column Info */
	private String wk3OthQty = null;
	/* Column Info */
	private String wk1PolWgt = null;
	/* Column Info */
	private String wk3PolWgt = null;
	/* Column Info */
	private String wk1OthQty = null;
	/* Column Info */
	private String wk2HjsWgt = null;
	/* Column Info */
	private String wk4YmlWgt = null;
	/* Column Info */
	private String wk4KklWgt = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String gtlYmlQty = null;
	/* Column Info */
	private String wk4KklQty = null;
	/* Column Info */
	private String wk2OthQty = null;
	/* Column Info */
	private String costYrwk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchWeeklyLfByPolPodListVO() {}

	public SearchWeeklyLfByPolPodListVO(String ibflag, String pagerows, String lvl0, String lvl, String seq, String grpId, String trdCd, String subTrdCd, String subRlaneCd, String pod, String pol, String bsa, String wk1HjsQty, String wk1HjsWgt, String wk1CosQty, String wk1CosWgt, String wk1KklQty, String wk1KklWgt, String wk1YmlQty, String wk1YmlWgt, String wk1OthQty, String wk1OthWgt, String wk1PolQty, String wk1PolWgt, String wk2HjsQty, String wk2HjsWgt, String wk2CosQty, String wk2CosWgt, String wk2KklQty, String wk2KklWgt, String wk2YmlQty, String wk2YmlWgt, String wk2OthQty, String wk2OthWgt, String wk2PolQty, String wk2PolWgt, String wk3HjsQty, String wk3HjsWgt, String wk3CosQty, String wk3CosWgt, String wk3KklQty, String wk3KklWgt, String wk3YmlQty, String wk3YmlWgt, String wk3OthQty, String wk3OthWgt, String wk3PolQty, String wk3PolWgt, String wk4HjsQty, String wk4HjsWgt, String wk4CosQty, String wk4CosWgt, String wk4KklQty, String wk4KklWgt, String wk4YmlQty, String wk4YmlWgt, String wk4OthQty, String wk4OthWgt, String wk4PolQty, String wk4PolWgt, String wk5HjsQty, String wk5HjsWgt, String wk5CosQty, String wk5CosWgt, String wk5KklQty, String wk5KklWgt, String wk5YmlQty, String wk5YmlWgt, String wk5OthQty, String wk5OthWgt, String wk5PolQty, String wk5PolWgt, String gtlHjsQty, String gtlHjsWgt, String gtlCosQty, String gtlCosWgt, String gtlKklQty, String gtlKklWgt, String gtlYmlQty, String gtlYmlWgt, String gtlOthQty, String gtlOthWgt, String gtlPolQty, String gtlPolWgt, String costYrwk) {
		this.wk5OthQty = wk5OthQty;
		this.wk4YmlQty = wk4YmlQty;
		this.wk4PolWgt = wk4PolWgt;
		this.wk5CosWgt = wk5CosWgt;
		this.wk2PolQty = wk2PolQty;
		this.trdCd = trdCd;
		this.gtlOthWgt = gtlOthWgt;
		this.wk4OthQty = wk4OthQty;
		this.wk3YmlQty = wk3YmlQty;
		this.wk3HjsQty = wk3HjsQty;
		this.wk1KklWgt = wk1KklWgt;
		this.pagerows = pagerows;
		this.wk5OthWgt = wk5OthWgt;
		this.wk2CosQty = wk2CosQty;
		this.wk4PolQty = wk4PolQty;
		this.lvl0 = lvl0;
		this.wk3PolQty = wk3PolQty;
		this.pol = pol;
		this.wk3KklQty = wk3KklQty;
		this.wk4CosQty = wk4CosQty;
		this.wk3KklWgt = wk3KklWgt;
		this.pod = pod;
		this.wk2KklWgt = wk2KklWgt;
		this.wk4HjsWgt = wk4HjsWgt;
		this.wk2YmlWgt = wk2YmlWgt;
		this.wk3YmlWgt = wk3YmlWgt;
		this.gtlYmlWgt = gtlYmlWgt;
		this.wk1HjsQty = wk1HjsQty;
		this.wk1YmlQty = wk1YmlQty;
		this.wk1YmlWgt = wk1YmlWgt;
		this.subRlaneCd = subRlaneCd;
		this.wk2OthWgt = wk2OthWgt;
		this.wk5HjsWgt = wk5HjsWgt;
		this.wk2CosWgt = wk2CosWgt;
		this.gtlCosQty = gtlCosQty;
		this.gtlPolWgt = gtlPolWgt;
		this.wk5KklQty = wk5KklQty;
		this.wk1OthWgt = wk1OthWgt;
		this.wk5YmlWgt = wk5YmlWgt;
		this.lvl = lvl;
		this.gtlKklQty = gtlKklQty;
		this.bsa = bsa;
		this.wk2HjsQty = wk2HjsQty;
		this.wk1PolQty = wk1PolQty;
		this.wk5KklWgt = wk5KklWgt;
		this.wk2YmlQty = wk2YmlQty;
		this.wk1HjsWgt = wk1HjsWgt;
		this.subTrdCd = subTrdCd;
		this.wk5CosQty = wk5CosQty;
		this.wk1KklQty = wk1KklQty;
		this.wk2KklQty = wk2KklQty;
		this.wk3CosWgt = wk3CosWgt;
		this.wk1CosQty = wk1CosQty;
		this.wk5YmlQty = wk5YmlQty;
		this.wk3CosQty = wk3CosQty;
		this.wk4CosWgt = wk4CosWgt;
		this.wk3HjsWgt = wk3HjsWgt;
		this.wk4HjsQty = wk4HjsQty;
		this.gtlHjsQty = gtlHjsQty;
		this.grpId = grpId;
		this.gtlPolQty = gtlPolQty;
		this.wk5PolQty = wk5PolQty;
		this.gtlCosWgt = gtlCosWgt;
		this.ibflag = ibflag;
		this.gtlKklWgt = gtlKklWgt;
		this.wk5PolWgt = wk5PolWgt;
		this.wk3OthWgt = wk3OthWgt;
		this.wk5HjsQty = wk5HjsQty;
		this.gtlHjsWgt = gtlHjsWgt;
		this.wk2PolWgt = wk2PolWgt;
		this.wk1CosWgt = wk1CosWgt;
		this.gtlOthQty = gtlOthQty;
		this.wk4OthWgt = wk4OthWgt;
		this.wk3OthQty = wk3OthQty;
		this.wk1PolWgt = wk1PolWgt;
		this.wk3PolWgt = wk3PolWgt;
		this.wk1OthQty = wk1OthQty;
		this.wk2HjsWgt = wk2HjsWgt;
		this.wk4YmlWgt = wk4YmlWgt;
		this.wk4KklWgt = wk4KklWgt;
		this.seq = seq;
		this.gtlYmlQty = gtlYmlQty;
		this.wk4KklQty = wk4KklQty;
		this.wk2OthQty = wk2OthQty;
		this.costYrwk = costYrwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("wk5_oth_qty", getWk5OthQty());
		this.hashColumns.put("wk4_yml_qty", getWk4YmlQty());
		this.hashColumns.put("wk4_pol_wgt", getWk4PolWgt());
		this.hashColumns.put("wk5_cos_wgt", getWk5CosWgt());
		this.hashColumns.put("wk2_pol_qty", getWk2PolQty());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("gtl_oth_wgt", getGtlOthWgt());
		this.hashColumns.put("wk4_oth_qty", getWk4OthQty());
		this.hashColumns.put("wk3_yml_qty", getWk3YmlQty());
		this.hashColumns.put("wk3_hjs_qty", getWk3HjsQty());
		this.hashColumns.put("wk1_kkl_wgt", getWk1KklWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("wk5_oth_wgt", getWk5OthWgt());
		this.hashColumns.put("wk2_cos_qty", getWk2CosQty());
		this.hashColumns.put("wk4_pol_qty", getWk4PolQty());
		this.hashColumns.put("lvl0", getLvl0());
		this.hashColumns.put("wk3_pol_qty", getWk3PolQty());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("wk3_kkl_qty", getWk3KklQty());
		this.hashColumns.put("wk4_cos_qty", getWk4CosQty());
		this.hashColumns.put("wk3_kkl_wgt", getWk3KklWgt());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("wk2_kkl_wgt", getWk2KklWgt());
		this.hashColumns.put("wk4_hjs_wgt", getWk4HjsWgt());
		this.hashColumns.put("wk2_yml_wgt", getWk2YmlWgt());
		this.hashColumns.put("wk3_yml_wgt", getWk3YmlWgt());
		this.hashColumns.put("gtl_yml_wgt", getGtlYmlWgt());
		this.hashColumns.put("wk1_hjs_qty", getWk1HjsQty());
		this.hashColumns.put("wk1_yml_qty", getWk1YmlQty());
		this.hashColumns.put("wk1_yml_wgt", getWk1YmlWgt());
		this.hashColumns.put("sub_rlane_cd", getSubRlaneCd());
		this.hashColumns.put("wk2_oth_wgt", getWk2OthWgt());
		this.hashColumns.put("wk5_hjs_wgt", getWk5HjsWgt());
		this.hashColumns.put("wk2_cos_wgt", getWk2CosWgt());
		this.hashColumns.put("gtl_cos_qty", getGtlCosQty());
		this.hashColumns.put("gtl_pol_wgt", getGtlPolWgt());
		this.hashColumns.put("wk5_kkl_qty", getWk5KklQty());
		this.hashColumns.put("wk1_oth_wgt", getWk1OthWgt());
		this.hashColumns.put("wk5_yml_wgt", getWk5YmlWgt());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("gtl_kkl_qty", getGtlKklQty());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("wk2_hjs_qty", getWk2HjsQty());
		this.hashColumns.put("wk1_pol_qty", getWk1PolQty());
		this.hashColumns.put("wk5_kkl_wgt", getWk5KklWgt());
		this.hashColumns.put("wk2_yml_qty", getWk2YmlQty());
		this.hashColumns.put("wk1_hjs_wgt", getWk1HjsWgt());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("wk5_cos_qty", getWk5CosQty());
		this.hashColumns.put("wk1_kkl_qty", getWk1KklQty());
		this.hashColumns.put("wk2_kkl_qty", getWk2KklQty());
		this.hashColumns.put("wk3_cos_wgt", getWk3CosWgt());
		this.hashColumns.put("wk1_cos_qty", getWk1CosQty());
		this.hashColumns.put("wk5_yml_qty", getWk5YmlQty());
		this.hashColumns.put("wk3_cos_qty", getWk3CosQty());
		this.hashColumns.put("wk4_cos_wgt", getWk4CosWgt());
		this.hashColumns.put("wk3_hjs_wgt", getWk3HjsWgt());
		this.hashColumns.put("wk4_hjs_qty", getWk4HjsQty());
		this.hashColumns.put("gtl_hjs_qty", getGtlHjsQty());
		this.hashColumns.put("grp_id", getGrpId());
		this.hashColumns.put("gtl_pol_qty", getGtlPolQty());
		this.hashColumns.put("wk5_pol_qty", getWk5PolQty());
		this.hashColumns.put("gtl_cos_wgt", getGtlCosWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gtl_kkl_wgt", getGtlKklWgt());
		this.hashColumns.put("wk5_pol_wgt", getWk5PolWgt());
		this.hashColumns.put("wk3_oth_wgt", getWk3OthWgt());
		this.hashColumns.put("wk5_hjs_qty", getWk5HjsQty());
		this.hashColumns.put("gtl_hjs_wgt", getGtlHjsWgt());
		this.hashColumns.put("wk2_pol_wgt", getWk2PolWgt());
		this.hashColumns.put("wk1_cos_wgt", getWk1CosWgt());
		this.hashColumns.put("gtl_oth_qty", getGtlOthQty());
		this.hashColumns.put("wk4_oth_wgt", getWk4OthWgt());
		this.hashColumns.put("wk3_oth_qty", getWk3OthQty());
		this.hashColumns.put("wk1_pol_wgt", getWk1PolWgt());
		this.hashColumns.put("wk3_pol_wgt", getWk3PolWgt());
		this.hashColumns.put("wk1_oth_qty", getWk1OthQty());
		this.hashColumns.put("wk2_hjs_wgt", getWk2HjsWgt());
		this.hashColumns.put("wk4_yml_wgt", getWk4YmlWgt());
		this.hashColumns.put("wk4_kkl_wgt", getWk4KklWgt());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("gtl_yml_qty", getGtlYmlQty());
		this.hashColumns.put("wk4_kkl_qty", getWk4KklQty());
		this.hashColumns.put("wk2_oth_qty", getWk2OthQty());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("wk5_oth_qty", "wk5OthQty");
		this.hashFields.put("wk4_yml_qty", "wk4YmlQty");
		this.hashFields.put("wk4_pol_wgt", "wk4PolWgt");
		this.hashFields.put("wk5_cos_wgt", "wk5CosWgt");
		this.hashFields.put("wk2_pol_qty", "wk2PolQty");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("gtl_oth_wgt", "gtlOthWgt");
		this.hashFields.put("wk4_oth_qty", "wk4OthQty");
		this.hashFields.put("wk3_yml_qty", "wk3YmlQty");
		this.hashFields.put("wk3_hjs_qty", "wk3HjsQty");
		this.hashFields.put("wk1_kkl_wgt", "wk1KklWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("wk5_oth_wgt", "wk5OthWgt");
		this.hashFields.put("wk2_cos_qty", "wk2CosQty");
		this.hashFields.put("wk4_pol_qty", "wk4PolQty");
		this.hashFields.put("lvl0", "lvl0");
		this.hashFields.put("wk3_pol_qty", "wk3PolQty");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("wk3_kkl_qty", "wk3KklQty");
		this.hashFields.put("wk4_cos_qty", "wk4CosQty");
		this.hashFields.put("wk3_kkl_wgt", "wk3KklWgt");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("wk2_kkl_wgt", "wk2KklWgt");
		this.hashFields.put("wk4_hjs_wgt", "wk4HjsWgt");
		this.hashFields.put("wk2_yml_wgt", "wk2YmlWgt");
		this.hashFields.put("wk3_yml_wgt", "wk3YmlWgt");
		this.hashFields.put("gtl_yml_wgt", "gtlYmlWgt");
		this.hashFields.put("wk1_hjs_qty", "wk1HjsQty");
		this.hashFields.put("wk1_yml_qty", "wk1YmlQty");
		this.hashFields.put("wk1_yml_wgt", "wk1YmlWgt");
		this.hashFields.put("sub_rlane_cd", "subRlaneCd");
		this.hashFields.put("wk2_oth_wgt", "wk2OthWgt");
		this.hashFields.put("wk5_hjs_wgt", "wk5HjsWgt");
		this.hashFields.put("wk2_cos_wgt", "wk2CosWgt");
		this.hashFields.put("gtl_cos_qty", "gtlCosQty");
		this.hashFields.put("gtl_pol_wgt", "gtlPolWgt");
		this.hashFields.put("wk5_kkl_qty", "wk5KklQty");
		this.hashFields.put("wk1_oth_wgt", "wk1OthWgt");
		this.hashFields.put("wk5_yml_wgt", "wk5YmlWgt");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("gtl_kkl_qty", "gtlKklQty");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("wk2_hjs_qty", "wk2HjsQty");
		this.hashFields.put("wk1_pol_qty", "wk1PolQty");
		this.hashFields.put("wk5_kkl_wgt", "wk5KklWgt");
		this.hashFields.put("wk2_yml_qty", "wk2YmlQty");
		this.hashFields.put("wk1_hjs_wgt", "wk1HjsWgt");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("wk5_cos_qty", "wk5CosQty");
		this.hashFields.put("wk1_kkl_qty", "wk1KklQty");
		this.hashFields.put("wk2_kkl_qty", "wk2KklQty");
		this.hashFields.put("wk3_cos_wgt", "wk3CosWgt");
		this.hashFields.put("wk1_cos_qty", "wk1CosQty");
		this.hashFields.put("wk5_yml_qty", "wk5YmlQty");
		this.hashFields.put("wk3_cos_qty", "wk3CosQty");
		this.hashFields.put("wk4_cos_wgt", "wk4CosWgt");
		this.hashFields.put("wk3_hjs_wgt", "wk3HjsWgt");
		this.hashFields.put("wk4_hjs_qty", "wk4HjsQty");
		this.hashFields.put("gtl_hjs_qty", "gtlHjsQty");
		this.hashFields.put("grp_id", "grpId");
		this.hashFields.put("gtl_pol_qty", "gtlPolQty");
		this.hashFields.put("wk5_pol_qty", "wk5PolQty");
		this.hashFields.put("gtl_cos_wgt", "gtlCosWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gtl_kkl_wgt", "gtlKklWgt");
		this.hashFields.put("wk5_pol_wgt", "wk5PolWgt");
		this.hashFields.put("wk3_oth_wgt", "wk3OthWgt");
		this.hashFields.put("wk5_hjs_qty", "wk5HjsQty");
		this.hashFields.put("gtl_hjs_wgt", "gtlHjsWgt");
		this.hashFields.put("wk2_pol_wgt", "wk2PolWgt");
		this.hashFields.put("wk1_cos_wgt", "wk1CosWgt");
		this.hashFields.put("gtl_oth_qty", "gtlOthQty");
		this.hashFields.put("wk4_oth_wgt", "wk4OthWgt");
		this.hashFields.put("wk3_oth_qty", "wk3OthQty");
		this.hashFields.put("wk1_pol_wgt", "wk1PolWgt");
		this.hashFields.put("wk3_pol_wgt", "wk3PolWgt");
		this.hashFields.put("wk1_oth_qty", "wk1OthQty");
		this.hashFields.put("wk2_hjs_wgt", "wk2HjsWgt");
		this.hashFields.put("wk4_yml_wgt", "wk4YmlWgt");
		this.hashFields.put("wk4_kkl_wgt", "wk4KklWgt");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("gtl_yml_qty", "gtlYmlQty");
		this.hashFields.put("wk4_kkl_qty", "wk4KklQty");
		this.hashFields.put("wk2_oth_qty", "wk2OthQty");
		this.hashFields.put("cost_yrwk", "costYrwk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return wk5OthQty
	 */
	public String getWk5OthQty() {
		return this.wk5OthQty;
	}
	
	/**
	 * Column Info
	 * @return wk4YmlQty
	 */
	public String getWk4YmlQty() {
		return this.wk4YmlQty;
	}
	
	/**
	 * Column Info
	 * @return wk4PolWgt
	 */
	public String getWk4PolWgt() {
		return this.wk4PolWgt;
	}
	
	/**
	 * Column Info
	 * @return wk5CosWgt
	 */
	public String getWk5CosWgt() {
		return this.wk5CosWgt;
	}
	
	/**
	 * Column Info
	 * @return wk2PolQty
	 */
	public String getWk2PolQty() {
		return this.wk2PolQty;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return gtlOthWgt
	 */
	public String getGtlOthWgt() {
		return this.gtlOthWgt;
	}
	
	/**
	 * Column Info
	 * @return wk4OthQty
	 */
	public String getWk4OthQty() {
		return this.wk4OthQty;
	}
	
	/**
	 * Column Info
	 * @return wk3YmlQty
	 */
	public String getWk3YmlQty() {
		return this.wk3YmlQty;
	}
	
	/**
	 * Column Info
	 * @return wk3HjsQty
	 */
	public String getWk3HjsQty() {
		return this.wk3HjsQty;
	}
	
	/**
	 * Column Info
	 * @return wk1KklWgt
	 */
	public String getWk1KklWgt() {
		return this.wk1KklWgt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return wk5OthWgt
	 */
	public String getWk5OthWgt() {
		return this.wk5OthWgt;
	}
	
	/**
	 * Column Info
	 * @return wk2CosQty
	 */
	public String getWk2CosQty() {
		return this.wk2CosQty;
	}
	
	/**
	 * Column Info
	 * @return wk4PolQty
	 */
	public String getWk4PolQty() {
		return this.wk4PolQty;
	}
	
	/**
	 * Column Info
	 * @return lvl0
	 */
	public String getLvl0() {
		return this.lvl0;
	}
	
	/**
	 * Column Info
	 * @return wk3PolQty
	 */
	public String getWk3PolQty() {
		return this.wk3PolQty;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return wk3KklQty
	 */
	public String getWk3KklQty() {
		return this.wk3KklQty;
	}
	
	/**
	 * Column Info
	 * @return wk4CosQty
	 */
	public String getWk4CosQty() {
		return this.wk4CosQty;
	}
	
	/**
	 * Column Info
	 * @return wk3KklWgt
	 */
	public String getWk3KklWgt() {
		return this.wk3KklWgt;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return wk2KklWgt
	 */
	public String getWk2KklWgt() {
		return this.wk2KklWgt;
	}
	
	/**
	 * Column Info
	 * @return wk4HjsWgt
	 */
	public String getWk4HjsWgt() {
		return this.wk4HjsWgt;
	}
	
	/**
	 * Column Info
	 * @return wk2YmlWgt
	 */
	public String getWk2YmlWgt() {
		return this.wk2YmlWgt;
	}
	
	/**
	 * Column Info
	 * @return wk3YmlWgt
	 */
	public String getWk3YmlWgt() {
		return this.wk3YmlWgt;
	}
	
	/**
	 * Column Info
	 * @return gtlYmlWgt
	 */
	public String getGtlYmlWgt() {
		return this.gtlYmlWgt;
	}
	
	/**
	 * Column Info
	 * @return wk1HjsQty
	 */
	public String getWk1HjsQty() {
		return this.wk1HjsQty;
	}
	
	/**
	 * Column Info
	 * @return wk1YmlQty
	 */
	public String getWk1YmlQty() {
		return this.wk1YmlQty;
	}
	
	/**
	 * Column Info
	 * @return wk1YmlWgt
	 */
	public String getWk1YmlWgt() {
		return this.wk1YmlWgt;
	}
	
	/**
	 * Column Info
	 * @return subRlaneCd
	 */
	public String getSubRlaneCd() {
		return this.subRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return wk2OthWgt
	 */
	public String getWk2OthWgt() {
		return this.wk2OthWgt;
	}
	
	/**
	 * Column Info
	 * @return wk5HjsWgt
	 */
	public String getWk5HjsWgt() {
		return this.wk5HjsWgt;
	}
	
	/**
	 * Column Info
	 * @return wk2CosWgt
	 */
	public String getWk2CosWgt() {
		return this.wk2CosWgt;
	}
	
	/**
	 * Column Info
	 * @return gtlCosQty
	 */
	public String getGtlCosQty() {
		return this.gtlCosQty;
	}
	
	/**
	 * Column Info
	 * @return gtlPolWgt
	 */
	public String getGtlPolWgt() {
		return this.gtlPolWgt;
	}
	
	/**
	 * Column Info
	 * @return wk5KklQty
	 */
	public String getWk5KklQty() {
		return this.wk5KklQty;
	}
	
	/**
	 * Column Info
	 * @return wk1OthWgt
	 */
	public String getWk1OthWgt() {
		return this.wk1OthWgt;
	}
	
	/**
	 * Column Info
	 * @return wk5YmlWgt
	 */
	public String getWk5YmlWgt() {
		return this.wk5YmlWgt;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return gtlKklQty
	 */
	public String getGtlKklQty() {
		return this.gtlKklQty;
	}
	
	/**
	 * Column Info
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
	}
	
	/**
	 * Column Info
	 * @return wk2HjsQty
	 */
	public String getWk2HjsQty() {
		return this.wk2HjsQty;
	}
	
	/**
	 * Column Info
	 * @return wk1PolQty
	 */
	public String getWk1PolQty() {
		return this.wk1PolQty;
	}
	
	/**
	 * Column Info
	 * @return wk5KklWgt
	 */
	public String getWk5KklWgt() {
		return this.wk5KklWgt;
	}
	
	/**
	 * Column Info
	 * @return wk2YmlQty
	 */
	public String getWk2YmlQty() {
		return this.wk2YmlQty;
	}
	
	/**
	 * Column Info
	 * @return wk1HjsWgt
	 */
	public String getWk1HjsWgt() {
		return this.wk1HjsWgt;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return wk5CosQty
	 */
	public String getWk5CosQty() {
		return this.wk5CosQty;
	}
	
	/**
	 * Column Info
	 * @return wk1KklQty
	 */
	public String getWk1KklQty() {
		return this.wk1KklQty;
	}
	
	/**
	 * Column Info
	 * @return wk2KklQty
	 */
	public String getWk2KklQty() {
		return this.wk2KklQty;
	}
	
	/**
	 * Column Info
	 * @return wk3CosWgt
	 */
	public String getWk3CosWgt() {
		return this.wk3CosWgt;
	}
	
	/**
	 * Column Info
	 * @return wk1CosQty
	 */
	public String getWk1CosQty() {
		return this.wk1CosQty;
	}
	
	/**
	 * Column Info
	 * @return wk5YmlQty
	 */
	public String getWk5YmlQty() {
		return this.wk5YmlQty;
	}
	
	/**
	 * Column Info
	 * @return wk3CosQty
	 */
	public String getWk3CosQty() {
		return this.wk3CosQty;
	}
	
	/**
	 * Column Info
	 * @return wk4CosWgt
	 */
	public String getWk4CosWgt() {
		return this.wk4CosWgt;
	}
	
	/**
	 * Column Info
	 * @return wk3HjsWgt
	 */
	public String getWk3HjsWgt() {
		return this.wk3HjsWgt;
	}
	
	/**
	 * Column Info
	 * @return wk4HjsQty
	 */
	public String getWk4HjsQty() {
		return this.wk4HjsQty;
	}
	
	/**
	 * Column Info
	 * @return gtlHjsQty
	 */
	public String getGtlHjsQty() {
		return this.gtlHjsQty;
	}
	
	/**
	 * Column Info
	 * @return grpId
	 */
	public String getGrpId() {
		return this.grpId;
	}
	
	/**
	 * Column Info
	 * @return gtlPolQty
	 */
	public String getGtlPolQty() {
		return this.gtlPolQty;
	}
	
	/**
	 * Column Info
	 * @return wk5PolQty
	 */
	public String getWk5PolQty() {
		return this.wk5PolQty;
	}
	
	/**
	 * Column Info
	 * @return gtlCosWgt
	 */
	public String getGtlCosWgt() {
		return this.gtlCosWgt;
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
	 * @return gtlKklWgt
	 */
	public String getGtlKklWgt() {
		return this.gtlKklWgt;
	}
	
	/**
	 * Column Info
	 * @return wk5PolWgt
	 */
	public String getWk5PolWgt() {
		return this.wk5PolWgt;
	}
	
	/**
	 * Column Info
	 * @return wk3OthWgt
	 */
	public String getWk3OthWgt() {
		return this.wk3OthWgt;
	}
	
	/**
	 * Column Info
	 * @return wk5HjsQty
	 */
	public String getWk5HjsQty() {
		return this.wk5HjsQty;
	}
	
	/**
	 * Column Info
	 * @return gtlHjsWgt
	 */
	public String getGtlHjsWgt() {
		return this.gtlHjsWgt;
	}
	
	/**
	 * Column Info
	 * @return wk2PolWgt
	 */
	public String getWk2PolWgt() {
		return this.wk2PolWgt;
	}
	
	/**
	 * Column Info
	 * @return wk1CosWgt
	 */
	public String getWk1CosWgt() {
		return this.wk1CosWgt;
	}
	
	/**
	 * Column Info
	 * @return gtlOthQty
	 */
	public String getGtlOthQty() {
		return this.gtlOthQty;
	}
	
	/**
	 * Column Info
	 * @return wk4OthWgt
	 */
	public String getWk4OthWgt() {
		return this.wk4OthWgt;
	}
	
	/**
	 * Column Info
	 * @return wk3OthQty
	 */
	public String getWk3OthQty() {
		return this.wk3OthQty;
	}
	
	/**
	 * Column Info
	 * @return wk1PolWgt
	 */
	public String getWk1PolWgt() {
		return this.wk1PolWgt;
	}
	
	/**
	 * Column Info
	 * @return wk3PolWgt
	 */
	public String getWk3PolWgt() {
		return this.wk3PolWgt;
	}
	
	/**
	 * Column Info
	 * @return wk1OthQty
	 */
	public String getWk1OthQty() {
		return this.wk1OthQty;
	}
	
	/**
	 * Column Info
	 * @return wk2HjsWgt
	 */
	public String getWk2HjsWgt() {
		return this.wk2HjsWgt;
	}
	
	/**
	 * Column Info
	 * @return wk4YmlWgt
	 */
	public String getWk4YmlWgt() {
		return this.wk4YmlWgt;
	}
	
	/**
	 * Column Info
	 * @return wk4KklWgt
	 */
	public String getWk4KklWgt() {
		return this.wk4KklWgt;
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
	 * @return gtlYmlQty
	 */
	public String getGtlYmlQty() {
		return this.gtlYmlQty;
	}
	
	/**
	 * Column Info
	 * @return wk4KklQty
	 */
	public String getWk4KklQty() {
		return this.wk4KklQty;
	}
	
	/**
	 * Column Info
	 * @return wk2OthQty
	 */
	public String getWk2OthQty() {
		return this.wk2OthQty;
	}
	
	/**
	 * Column Info
	 * @return costYrwk
	 */
	public String getCostYrwk() {
		return this.costYrwk;
	}
	

	/**
	 * Column Info
	 * @param wk5OthQty
	 */
	public void setWk5OthQty(String wk5OthQty) {
		this.wk5OthQty = wk5OthQty;
	}
	
	/**
	 * Column Info
	 * @param wk4YmlQty
	 */
	public void setWk4YmlQty(String wk4YmlQty) {
		this.wk4YmlQty = wk4YmlQty;
	}
	
	/**
	 * Column Info
	 * @param wk4PolWgt
	 */
	public void setWk4PolWgt(String wk4PolWgt) {
		this.wk4PolWgt = wk4PolWgt;
	}
	
	/**
	 * Column Info
	 * @param wk5CosWgt
	 */
	public void setWk5CosWgt(String wk5CosWgt) {
		this.wk5CosWgt = wk5CosWgt;
	}
	
	/**
	 * Column Info
	 * @param wk2PolQty
	 */
	public void setWk2PolQty(String wk2PolQty) {
		this.wk2PolQty = wk2PolQty;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param gtlOthWgt
	 */
	public void setGtlOthWgt(String gtlOthWgt) {
		this.gtlOthWgt = gtlOthWgt;
	}
	
	/**
	 * Column Info
	 * @param wk4OthQty
	 */
	public void setWk4OthQty(String wk4OthQty) {
		this.wk4OthQty = wk4OthQty;
	}
	
	/**
	 * Column Info
	 * @param wk3YmlQty
	 */
	public void setWk3YmlQty(String wk3YmlQty) {
		this.wk3YmlQty = wk3YmlQty;
	}
	
	/**
	 * Column Info
	 * @param wk3HjsQty
	 */
	public void setWk3HjsQty(String wk3HjsQty) {
		this.wk3HjsQty = wk3HjsQty;
	}
	
	/**
	 * Column Info
	 * @param wk1KklWgt
	 */
	public void setWk1KklWgt(String wk1KklWgt) {
		this.wk1KklWgt = wk1KklWgt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param wk5OthWgt
	 */
	public void setWk5OthWgt(String wk5OthWgt) {
		this.wk5OthWgt = wk5OthWgt;
	}
	
	/**
	 * Column Info
	 * @param wk2CosQty
	 */
	public void setWk2CosQty(String wk2CosQty) {
		this.wk2CosQty = wk2CosQty;
	}
	
	/**
	 * Column Info
	 * @param wk4PolQty
	 */
	public void setWk4PolQty(String wk4PolQty) {
		this.wk4PolQty = wk4PolQty;
	}
	
	/**
	 * Column Info
	 * @param lvl0
	 */
	public void setLvl0(String lvl0) {
		this.lvl0 = lvl0;
	}
	
	/**
	 * Column Info
	 * @param wk3PolQty
	 */
	public void setWk3PolQty(String wk3PolQty) {
		this.wk3PolQty = wk3PolQty;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param wk3KklQty
	 */
	public void setWk3KklQty(String wk3KklQty) {
		this.wk3KklQty = wk3KklQty;
	}
	
	/**
	 * Column Info
	 * @param wk4CosQty
	 */
	public void setWk4CosQty(String wk4CosQty) {
		this.wk4CosQty = wk4CosQty;
	}
	
	/**
	 * Column Info
	 * @param wk3KklWgt
	 */
	public void setWk3KklWgt(String wk3KklWgt) {
		this.wk3KklWgt = wk3KklWgt;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param wk2KklWgt
	 */
	public void setWk2KklWgt(String wk2KklWgt) {
		this.wk2KklWgt = wk2KklWgt;
	}
	
	/**
	 * Column Info
	 * @param wk4HjsWgt
	 */
	public void setWk4HjsWgt(String wk4HjsWgt) {
		this.wk4HjsWgt = wk4HjsWgt;
	}
	
	/**
	 * Column Info
	 * @param wk2YmlWgt
	 */
	public void setWk2YmlWgt(String wk2YmlWgt) {
		this.wk2YmlWgt = wk2YmlWgt;
	}
	
	/**
	 * Column Info
	 * @param wk3YmlWgt
	 */
	public void setWk3YmlWgt(String wk3YmlWgt) {
		this.wk3YmlWgt = wk3YmlWgt;
	}
	
	/**
	 * Column Info
	 * @param gtlYmlWgt
	 */
	public void setGtlYmlWgt(String gtlYmlWgt) {
		this.gtlYmlWgt = gtlYmlWgt;
	}
	
	/**
	 * Column Info
	 * @param wk1HjsQty
	 */
	public void setWk1HjsQty(String wk1HjsQty) {
		this.wk1HjsQty = wk1HjsQty;
	}
	
	/**
	 * Column Info
	 * @param wk1YmlQty
	 */
	public void setWk1YmlQty(String wk1YmlQty) {
		this.wk1YmlQty = wk1YmlQty;
	}
	
	/**
	 * Column Info
	 * @param wk1YmlWgt
	 */
	public void setWk1YmlWgt(String wk1YmlWgt) {
		this.wk1YmlWgt = wk1YmlWgt;
	}
	
	/**
	 * Column Info
	 * @param subRlaneCd
	 */
	public void setSubRlaneCd(String subRlaneCd) {
		this.subRlaneCd = subRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param wk2OthWgt
	 */
	public void setWk2OthWgt(String wk2OthWgt) {
		this.wk2OthWgt = wk2OthWgt;
	}
	
	/**
	 * Column Info
	 * @param wk5HjsWgt
	 */
	public void setWk5HjsWgt(String wk5HjsWgt) {
		this.wk5HjsWgt = wk5HjsWgt;
	}
	
	/**
	 * Column Info
	 * @param wk2CosWgt
	 */
	public void setWk2CosWgt(String wk2CosWgt) {
		this.wk2CosWgt = wk2CosWgt;
	}
	
	/**
	 * Column Info
	 * @param gtlCosQty
	 */
	public void setGtlCosQty(String gtlCosQty) {
		this.gtlCosQty = gtlCosQty;
	}
	
	/**
	 * Column Info
	 * @param gtlPolWgt
	 */
	public void setGtlPolWgt(String gtlPolWgt) {
		this.gtlPolWgt = gtlPolWgt;
	}
	
	/**
	 * Column Info
	 * @param wk5KklQty
	 */
	public void setWk5KklQty(String wk5KklQty) {
		this.wk5KklQty = wk5KklQty;
	}
	
	/**
	 * Column Info
	 * @param wk1OthWgt
	 */
	public void setWk1OthWgt(String wk1OthWgt) {
		this.wk1OthWgt = wk1OthWgt;
	}
	
	/**
	 * Column Info
	 * @param wk5YmlWgt
	 */
	public void setWk5YmlWgt(String wk5YmlWgt) {
		this.wk5YmlWgt = wk5YmlWgt;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param gtlKklQty
	 */
	public void setGtlKklQty(String gtlKklQty) {
		this.gtlKklQty = gtlKklQty;
	}
	
	/**
	 * Column Info
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
	}
	
	/**
	 * Column Info
	 * @param wk2HjsQty
	 */
	public void setWk2HjsQty(String wk2HjsQty) {
		this.wk2HjsQty = wk2HjsQty;
	}
	
	/**
	 * Column Info
	 * @param wk1PolQty
	 */
	public void setWk1PolQty(String wk1PolQty) {
		this.wk1PolQty = wk1PolQty;
	}
	
	/**
	 * Column Info
	 * @param wk5KklWgt
	 */
	public void setWk5KklWgt(String wk5KklWgt) {
		this.wk5KklWgt = wk5KklWgt;
	}
	
	/**
	 * Column Info
	 * @param wk2YmlQty
	 */
	public void setWk2YmlQty(String wk2YmlQty) {
		this.wk2YmlQty = wk2YmlQty;
	}
	
	/**
	 * Column Info
	 * @param wk1HjsWgt
	 */
	public void setWk1HjsWgt(String wk1HjsWgt) {
		this.wk1HjsWgt = wk1HjsWgt;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param wk5CosQty
	 */
	public void setWk5CosQty(String wk5CosQty) {
		this.wk5CosQty = wk5CosQty;
	}
	
	/**
	 * Column Info
	 * @param wk1KklQty
	 */
	public void setWk1KklQty(String wk1KklQty) {
		this.wk1KklQty = wk1KklQty;
	}
	
	/**
	 * Column Info
	 * @param wk2KklQty
	 */
	public void setWk2KklQty(String wk2KklQty) {
		this.wk2KklQty = wk2KklQty;
	}
	
	/**
	 * Column Info
	 * @param wk3CosWgt
	 */
	public void setWk3CosWgt(String wk3CosWgt) {
		this.wk3CosWgt = wk3CosWgt;
	}
	
	/**
	 * Column Info
	 * @param wk1CosQty
	 */
	public void setWk1CosQty(String wk1CosQty) {
		this.wk1CosQty = wk1CosQty;
	}
	
	/**
	 * Column Info
	 * @param wk5YmlQty
	 */
	public void setWk5YmlQty(String wk5YmlQty) {
		this.wk5YmlQty = wk5YmlQty;
	}
	
	/**
	 * Column Info
	 * @param wk3CosQty
	 */
	public void setWk3CosQty(String wk3CosQty) {
		this.wk3CosQty = wk3CosQty;
	}
	
	/**
	 * Column Info
	 * @param wk4CosWgt
	 */
	public void setWk4CosWgt(String wk4CosWgt) {
		this.wk4CosWgt = wk4CosWgt;
	}
	
	/**
	 * Column Info
	 * @param wk3HjsWgt
	 */
	public void setWk3HjsWgt(String wk3HjsWgt) {
		this.wk3HjsWgt = wk3HjsWgt;
	}
	
	/**
	 * Column Info
	 * @param wk4HjsQty
	 */
	public void setWk4HjsQty(String wk4HjsQty) {
		this.wk4HjsQty = wk4HjsQty;
	}
	
	/**
	 * Column Info
	 * @param gtlHjsQty
	 */
	public void setGtlHjsQty(String gtlHjsQty) {
		this.gtlHjsQty = gtlHjsQty;
	}
	
	/**
	 * Column Info
	 * @param grpId
	 */
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}
	
	/**
	 * Column Info
	 * @param gtlPolQty
	 */
	public void setGtlPolQty(String gtlPolQty) {
		this.gtlPolQty = gtlPolQty;
	}
	
	/**
	 * Column Info
	 * @param wk5PolQty
	 */
	public void setWk5PolQty(String wk5PolQty) {
		this.wk5PolQty = wk5PolQty;
	}
	
	/**
	 * Column Info
	 * @param gtlCosWgt
	 */
	public void setGtlCosWgt(String gtlCosWgt) {
		this.gtlCosWgt = gtlCosWgt;
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
	 * @param gtlKklWgt
	 */
	public void setGtlKklWgt(String gtlKklWgt) {
		this.gtlKklWgt = gtlKklWgt;
	}
	
	/**
	 * Column Info
	 * @param wk5PolWgt
	 */
	public void setWk5PolWgt(String wk5PolWgt) {
		this.wk5PolWgt = wk5PolWgt;
	}
	
	/**
	 * Column Info
	 * @param wk3OthWgt
	 */
	public void setWk3OthWgt(String wk3OthWgt) {
		this.wk3OthWgt = wk3OthWgt;
	}
	
	/**
	 * Column Info
	 * @param wk5HjsQty
	 */
	public void setWk5HjsQty(String wk5HjsQty) {
		this.wk5HjsQty = wk5HjsQty;
	}
	
	/**
	 * Column Info
	 * @param gtlHjsWgt
	 */
	public void setGtlHjsWgt(String gtlHjsWgt) {
		this.gtlHjsWgt = gtlHjsWgt;
	}
	
	/**
	 * Column Info
	 * @param wk2PolWgt
	 */
	public void setWk2PolWgt(String wk2PolWgt) {
		this.wk2PolWgt = wk2PolWgt;
	}
	
	/**
	 * Column Info
	 * @param wk1CosWgt
	 */
	public void setWk1CosWgt(String wk1CosWgt) {
		this.wk1CosWgt = wk1CosWgt;
	}
	
	/**
	 * Column Info
	 * @param gtlOthQty
	 */
	public void setGtlOthQty(String gtlOthQty) {
		this.gtlOthQty = gtlOthQty;
	}
	
	/**
	 * Column Info
	 * @param wk4OthWgt
	 */
	public void setWk4OthWgt(String wk4OthWgt) {
		this.wk4OthWgt = wk4OthWgt;
	}
	
	/**
	 * Column Info
	 * @param wk3OthQty
	 */
	public void setWk3OthQty(String wk3OthQty) {
		this.wk3OthQty = wk3OthQty;
	}
	
	/**
	 * Column Info
	 * @param wk1PolWgt
	 */
	public void setWk1PolWgt(String wk1PolWgt) {
		this.wk1PolWgt = wk1PolWgt;
	}
	
	/**
	 * Column Info
	 * @param wk3PolWgt
	 */
	public void setWk3PolWgt(String wk3PolWgt) {
		this.wk3PolWgt = wk3PolWgt;
	}
	
	/**
	 * Column Info
	 * @param wk1OthQty
	 */
	public void setWk1OthQty(String wk1OthQty) {
		this.wk1OthQty = wk1OthQty;
	}
	
	/**
	 * Column Info
	 * @param wk2HjsWgt
	 */
	public void setWk2HjsWgt(String wk2HjsWgt) {
		this.wk2HjsWgt = wk2HjsWgt;
	}
	
	/**
	 * Column Info
	 * @param wk4YmlWgt
	 */
	public void setWk4YmlWgt(String wk4YmlWgt) {
		this.wk4YmlWgt = wk4YmlWgt;
	}
	
	/**
	 * Column Info
	 * @param wk4KklWgt
	 */
	public void setWk4KklWgt(String wk4KklWgt) {
		this.wk4KklWgt = wk4KklWgt;
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
	 * @param gtlYmlQty
	 */
	public void setGtlYmlQty(String gtlYmlQty) {
		this.gtlYmlQty = gtlYmlQty;
	}
	
	/**
	 * Column Info
	 * @param wk4KklQty
	 */
	public void setWk4KklQty(String wk4KklQty) {
		this.wk4KklQty = wk4KklQty;
	}
	
	/**
	 * Column Info
	 * @param wk2OthQty
	 */
	public void setWk2OthQty(String wk2OthQty) {
		this.wk2OthQty = wk2OthQty;
	}
	
	/**
	 * Column Info
	 * @param costYrwk
	 */
	public void setCostYrwk(String costYrwk) {
		this.costYrwk = costYrwk;
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
		setWk5OthQty(JSPUtil.getParameter(request, prefix + "wk5_oth_qty", ""));
		setWk4YmlQty(JSPUtil.getParameter(request, prefix + "wk4_yml_qty", ""));
		setWk4PolWgt(JSPUtil.getParameter(request, prefix + "wk4_pol_wgt", ""));
		setWk5CosWgt(JSPUtil.getParameter(request, prefix + "wk5_cos_wgt", ""));
		setWk2PolQty(JSPUtil.getParameter(request, prefix + "wk2_pol_qty", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setGtlOthWgt(JSPUtil.getParameter(request, prefix + "gtl_oth_wgt", ""));
		setWk4OthQty(JSPUtil.getParameter(request, prefix + "wk4_oth_qty", ""));
		setWk3YmlQty(JSPUtil.getParameter(request, prefix + "wk3_yml_qty", ""));
		setWk3HjsQty(JSPUtil.getParameter(request, prefix + "wk3_hjs_qty", ""));
		setWk1KklWgt(JSPUtil.getParameter(request, prefix + "wk1_kkl_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setWk5OthWgt(JSPUtil.getParameter(request, prefix + "wk5_oth_wgt", ""));
		setWk2CosQty(JSPUtil.getParameter(request, prefix + "wk2_cos_qty", ""));
		setWk4PolQty(JSPUtil.getParameter(request, prefix + "wk4_pol_qty", ""));
		setLvl0(JSPUtil.getParameter(request, prefix + "lvl0", ""));
		setWk3PolQty(JSPUtil.getParameter(request, prefix + "wk3_pol_qty", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setWk3KklQty(JSPUtil.getParameter(request, prefix + "wk3_kkl_qty", ""));
		setWk4CosQty(JSPUtil.getParameter(request, prefix + "wk4_cos_qty", ""));
		setWk3KklWgt(JSPUtil.getParameter(request, prefix + "wk3_kkl_wgt", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setWk2KklWgt(JSPUtil.getParameter(request, prefix + "wk2_kkl_wgt", ""));
		setWk4HjsWgt(JSPUtil.getParameter(request, prefix + "wk4_hjs_wgt", ""));
		setWk2YmlWgt(JSPUtil.getParameter(request, prefix + "wk2_yml_wgt", ""));
		setWk3YmlWgt(JSPUtil.getParameter(request, prefix + "wk3_yml_wgt", ""));
		setGtlYmlWgt(JSPUtil.getParameter(request, prefix + "gtl_yml_wgt", ""));
		setWk1HjsQty(JSPUtil.getParameter(request, prefix + "wk1_hjs_qty", ""));
		setWk1YmlQty(JSPUtil.getParameter(request, prefix + "wk1_yml_qty", ""));
		setWk1YmlWgt(JSPUtil.getParameter(request, prefix + "wk1_yml_wgt", ""));
		setSubRlaneCd(JSPUtil.getParameter(request, prefix + "sub_rlane_cd", ""));
		setWk2OthWgt(JSPUtil.getParameter(request, prefix + "wk2_oth_wgt", ""));
		setWk5HjsWgt(JSPUtil.getParameter(request, prefix + "wk5_hjs_wgt", ""));
		setWk2CosWgt(JSPUtil.getParameter(request, prefix + "wk2_cos_wgt", ""));
		setGtlCosQty(JSPUtil.getParameter(request, prefix + "gtl_cos_qty", ""));
		setGtlPolWgt(JSPUtil.getParameter(request, prefix + "gtl_pol_wgt", ""));
		setWk5KklQty(JSPUtil.getParameter(request, prefix + "wk5_kkl_qty", ""));
		setWk1OthWgt(JSPUtil.getParameter(request, prefix + "wk1_oth_wgt", ""));
		setWk5YmlWgt(JSPUtil.getParameter(request, prefix + "wk5_yml_wgt", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setGtlKklQty(JSPUtil.getParameter(request, prefix + "gtl_kkl_qty", ""));
		setBsa(JSPUtil.getParameter(request, prefix + "bsa", ""));
		setWk2HjsQty(JSPUtil.getParameter(request, prefix + "wk2_hjs_qty", ""));
		setWk1PolQty(JSPUtil.getParameter(request, prefix + "wk1_pol_qty", ""));
		setWk5KklWgt(JSPUtil.getParameter(request, prefix + "wk5_kkl_wgt", ""));
		setWk2YmlQty(JSPUtil.getParameter(request, prefix + "wk2_yml_qty", ""));
		setWk1HjsWgt(JSPUtil.getParameter(request, prefix + "wk1_hjs_wgt", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setWk5CosQty(JSPUtil.getParameter(request, prefix + "wk5_cos_qty", ""));
		setWk1KklQty(JSPUtil.getParameter(request, prefix + "wk1_kkl_qty", ""));
		setWk2KklQty(JSPUtil.getParameter(request, prefix + "wk2_kkl_qty", ""));
		setWk3CosWgt(JSPUtil.getParameter(request, prefix + "wk3_cos_wgt", ""));
		setWk1CosQty(JSPUtil.getParameter(request, prefix + "wk1_cos_qty", ""));
		setWk5YmlQty(JSPUtil.getParameter(request, prefix + "wk5_yml_qty", ""));
		setWk3CosQty(JSPUtil.getParameter(request, prefix + "wk3_cos_qty", ""));
		setWk4CosWgt(JSPUtil.getParameter(request, prefix + "wk4_cos_wgt", ""));
		setWk3HjsWgt(JSPUtil.getParameter(request, prefix + "wk3_hjs_wgt", ""));
		setWk4HjsQty(JSPUtil.getParameter(request, prefix + "wk4_hjs_qty", ""));
		setGtlHjsQty(JSPUtil.getParameter(request, prefix + "gtl_hjs_qty", ""));
		setGrpId(JSPUtil.getParameter(request, prefix + "grp_id", ""));
		setGtlPolQty(JSPUtil.getParameter(request, prefix + "gtl_pol_qty", ""));
		setWk5PolQty(JSPUtil.getParameter(request, prefix + "wk5_pol_qty", ""));
		setGtlCosWgt(JSPUtil.getParameter(request, prefix + "gtl_cos_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGtlKklWgt(JSPUtil.getParameter(request, prefix + "gtl_kkl_wgt", ""));
		setWk5PolWgt(JSPUtil.getParameter(request, prefix + "wk5_pol_wgt", ""));
		setWk3OthWgt(JSPUtil.getParameter(request, prefix + "wk3_oth_wgt", ""));
		setWk5HjsQty(JSPUtil.getParameter(request, prefix + "wk5_hjs_qty", ""));
		setGtlHjsWgt(JSPUtil.getParameter(request, prefix + "gtl_hjs_wgt", ""));
		setWk2PolWgt(JSPUtil.getParameter(request, prefix + "wk2_pol_wgt", ""));
		setWk1CosWgt(JSPUtil.getParameter(request, prefix + "wk1_cos_wgt", ""));
		setGtlOthQty(JSPUtil.getParameter(request, prefix + "gtl_oth_qty", ""));
		setWk4OthWgt(JSPUtil.getParameter(request, prefix + "wk4_oth_wgt", ""));
		setWk3OthQty(JSPUtil.getParameter(request, prefix + "wk3_oth_qty", ""));
		setWk1PolWgt(JSPUtil.getParameter(request, prefix + "wk1_pol_wgt", ""));
		setWk3PolWgt(JSPUtil.getParameter(request, prefix + "wk3_pol_wgt", ""));
		setWk1OthQty(JSPUtil.getParameter(request, prefix + "wk1_oth_qty", ""));
		setWk2HjsWgt(JSPUtil.getParameter(request, prefix + "wk2_hjs_wgt", ""));
		setWk4YmlWgt(JSPUtil.getParameter(request, prefix + "wk4_yml_wgt", ""));
		setWk4KklWgt(JSPUtil.getParameter(request, prefix + "wk4_kkl_wgt", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setGtlYmlQty(JSPUtil.getParameter(request, prefix + "gtl_yml_qty", ""));
		setWk4KklQty(JSPUtil.getParameter(request, prefix + "wk4_kkl_qty", ""));
		setWk2OthQty(JSPUtil.getParameter(request, prefix + "wk2_oth_qty", ""));
		setCostYrwk(JSPUtil.getParameter(request, prefix + "cost_yrwk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchWeeklyLfByPolPodListVO[]
	 */
	public SearchWeeklyLfByPolPodListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchWeeklyLfByPolPodListVO[]
	 */
	public SearchWeeklyLfByPolPodListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchWeeklyLfByPolPodListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] wk5OthQty = (JSPUtil.getParameter(request, prefix	+ "wk5_oth_qty", length));
			String[] wk4YmlQty = (JSPUtil.getParameter(request, prefix	+ "wk4_yml_qty", length));
			String[] wk4PolWgt = (JSPUtil.getParameter(request, prefix	+ "wk4_pol_wgt", length));
			String[] wk5CosWgt = (JSPUtil.getParameter(request, prefix	+ "wk5_cos_wgt", length));
			String[] wk2PolQty = (JSPUtil.getParameter(request, prefix	+ "wk2_pol_qty", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] gtlOthWgt = (JSPUtil.getParameter(request, prefix	+ "gtl_oth_wgt", length));
			String[] wk4OthQty = (JSPUtil.getParameter(request, prefix	+ "wk4_oth_qty", length));
			String[] wk3YmlQty = (JSPUtil.getParameter(request, prefix	+ "wk3_yml_qty", length));
			String[] wk3HjsQty = (JSPUtil.getParameter(request, prefix	+ "wk3_hjs_qty", length));
			String[] wk1KklWgt = (JSPUtil.getParameter(request, prefix	+ "wk1_kkl_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] wk5OthWgt = (JSPUtil.getParameter(request, prefix	+ "wk5_oth_wgt", length));
			String[] wk2CosQty = (JSPUtil.getParameter(request, prefix	+ "wk2_cos_qty", length));
			String[] wk4PolQty = (JSPUtil.getParameter(request, prefix	+ "wk4_pol_qty", length));
			String[] lvl0 = (JSPUtil.getParameter(request, prefix	+ "lvl0", length));
			String[] wk3PolQty = (JSPUtil.getParameter(request, prefix	+ "wk3_pol_qty", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] wk3KklQty = (JSPUtil.getParameter(request, prefix	+ "wk3_kkl_qty", length));
			String[] wk4CosQty = (JSPUtil.getParameter(request, prefix	+ "wk4_cos_qty", length));
			String[] wk3KklWgt = (JSPUtil.getParameter(request, prefix	+ "wk3_kkl_wgt", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] wk2KklWgt = (JSPUtil.getParameter(request, prefix	+ "wk2_kkl_wgt", length));
			String[] wk4HjsWgt = (JSPUtil.getParameter(request, prefix	+ "wk4_hjs_wgt", length));
			String[] wk2YmlWgt = (JSPUtil.getParameter(request, prefix	+ "wk2_yml_wgt", length));
			String[] wk3YmlWgt = (JSPUtil.getParameter(request, prefix	+ "wk3_yml_wgt", length));
			String[] gtlYmlWgt = (JSPUtil.getParameter(request, prefix	+ "gtl_yml_wgt", length));
			String[] wk1HjsQty = (JSPUtil.getParameter(request, prefix	+ "wk1_hjs_qty", length));
			String[] wk1YmlQty = (JSPUtil.getParameter(request, prefix	+ "wk1_yml_qty", length));
			String[] wk1YmlWgt = (JSPUtil.getParameter(request, prefix	+ "wk1_yml_wgt", length));
			String[] subRlaneCd = (JSPUtil.getParameter(request, prefix	+ "sub_rlane_cd", length));
			String[] wk2OthWgt = (JSPUtil.getParameter(request, prefix	+ "wk2_oth_wgt", length));
			String[] wk5HjsWgt = (JSPUtil.getParameter(request, prefix	+ "wk5_hjs_wgt", length));
			String[] wk2CosWgt = (JSPUtil.getParameter(request, prefix	+ "wk2_cos_wgt", length));
			String[] gtlCosQty = (JSPUtil.getParameter(request, prefix	+ "gtl_cos_qty", length));
			String[] gtlPolWgt = (JSPUtil.getParameter(request, prefix	+ "gtl_pol_wgt", length));
			String[] wk5KklQty = (JSPUtil.getParameter(request, prefix	+ "wk5_kkl_qty", length));
			String[] wk1OthWgt = (JSPUtil.getParameter(request, prefix	+ "wk1_oth_wgt", length));
			String[] wk5YmlWgt = (JSPUtil.getParameter(request, prefix	+ "wk5_yml_wgt", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] gtlKklQty = (JSPUtil.getParameter(request, prefix	+ "gtl_kkl_qty", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] wk2HjsQty = (JSPUtil.getParameter(request, prefix	+ "wk2_hjs_qty", length));
			String[] wk1PolQty = (JSPUtil.getParameter(request, prefix	+ "wk1_pol_qty", length));
			String[] wk5KklWgt = (JSPUtil.getParameter(request, prefix	+ "wk5_kkl_wgt", length));
			String[] wk2YmlQty = (JSPUtil.getParameter(request, prefix	+ "wk2_yml_qty", length));
			String[] wk1HjsWgt = (JSPUtil.getParameter(request, prefix	+ "wk1_hjs_wgt", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] wk5CosQty = (JSPUtil.getParameter(request, prefix	+ "wk5_cos_qty", length));
			String[] wk1KklQty = (JSPUtil.getParameter(request, prefix	+ "wk1_kkl_qty", length));
			String[] wk2KklQty = (JSPUtil.getParameter(request, prefix	+ "wk2_kkl_qty", length));
			String[] wk3CosWgt = (JSPUtil.getParameter(request, prefix	+ "wk3_cos_wgt", length));
			String[] wk1CosQty = (JSPUtil.getParameter(request, prefix	+ "wk1_cos_qty", length));
			String[] wk5YmlQty = (JSPUtil.getParameter(request, prefix	+ "wk5_yml_qty", length));
			String[] wk3CosQty = (JSPUtil.getParameter(request, prefix	+ "wk3_cos_qty", length));
			String[] wk4CosWgt = (JSPUtil.getParameter(request, prefix	+ "wk4_cos_wgt", length));
			String[] wk3HjsWgt = (JSPUtil.getParameter(request, prefix	+ "wk3_hjs_wgt", length));
			String[] wk4HjsQty = (JSPUtil.getParameter(request, prefix	+ "wk4_hjs_qty", length));
			String[] gtlHjsQty = (JSPUtil.getParameter(request, prefix	+ "gtl_hjs_qty", length));
			String[] grpId = (JSPUtil.getParameter(request, prefix	+ "grp_id", length));
			String[] gtlPolQty = (JSPUtil.getParameter(request, prefix	+ "gtl_pol_qty", length));
			String[] wk5PolQty = (JSPUtil.getParameter(request, prefix	+ "wk5_pol_qty", length));
			String[] gtlCosWgt = (JSPUtil.getParameter(request, prefix	+ "gtl_cos_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gtlKklWgt = (JSPUtil.getParameter(request, prefix	+ "gtl_kkl_wgt", length));
			String[] wk5PolWgt = (JSPUtil.getParameter(request, prefix	+ "wk5_pol_wgt", length));
			String[] wk3OthWgt = (JSPUtil.getParameter(request, prefix	+ "wk3_oth_wgt", length));
			String[] wk5HjsQty = (JSPUtil.getParameter(request, prefix	+ "wk5_hjs_qty", length));
			String[] gtlHjsWgt = (JSPUtil.getParameter(request, prefix	+ "gtl_hjs_wgt", length));
			String[] wk2PolWgt = (JSPUtil.getParameter(request, prefix	+ "wk2_pol_wgt", length));
			String[] wk1CosWgt = (JSPUtil.getParameter(request, prefix	+ "wk1_cos_wgt", length));
			String[] gtlOthQty = (JSPUtil.getParameter(request, prefix	+ "gtl_oth_qty", length));
			String[] wk4OthWgt = (JSPUtil.getParameter(request, prefix	+ "wk4_oth_wgt", length));
			String[] wk3OthQty = (JSPUtil.getParameter(request, prefix	+ "wk3_oth_qty", length));
			String[] wk1PolWgt = (JSPUtil.getParameter(request, prefix	+ "wk1_pol_wgt", length));
			String[] wk3PolWgt = (JSPUtil.getParameter(request, prefix	+ "wk3_pol_wgt", length));
			String[] wk1OthQty = (JSPUtil.getParameter(request, prefix	+ "wk1_oth_qty", length));
			String[] wk2HjsWgt = (JSPUtil.getParameter(request, prefix	+ "wk2_hjs_wgt", length));
			String[] wk4YmlWgt = (JSPUtil.getParameter(request, prefix	+ "wk4_yml_wgt", length));
			String[] wk4KklWgt = (JSPUtil.getParameter(request, prefix	+ "wk4_kkl_wgt", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] gtlYmlQty = (JSPUtil.getParameter(request, prefix	+ "gtl_yml_qty", length));
			String[] wk4KklQty = (JSPUtil.getParameter(request, prefix	+ "wk4_kkl_qty", length));
			String[] wk2OthQty = (JSPUtil.getParameter(request, prefix	+ "wk2_oth_qty", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchWeeklyLfByPolPodListVO();
				if (wk5OthQty[i] != null)
					model.setWk5OthQty(wk5OthQty[i]);
				if (wk4YmlQty[i] != null)
					model.setWk4YmlQty(wk4YmlQty[i]);
				if (wk4PolWgt[i] != null)
					model.setWk4PolWgt(wk4PolWgt[i]);
				if (wk5CosWgt[i] != null)
					model.setWk5CosWgt(wk5CosWgt[i]);
				if (wk2PolQty[i] != null)
					model.setWk2PolQty(wk2PolQty[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (gtlOthWgt[i] != null)
					model.setGtlOthWgt(gtlOthWgt[i]);
				if (wk4OthQty[i] != null)
					model.setWk4OthQty(wk4OthQty[i]);
				if (wk3YmlQty[i] != null)
					model.setWk3YmlQty(wk3YmlQty[i]);
				if (wk3HjsQty[i] != null)
					model.setWk3HjsQty(wk3HjsQty[i]);
				if (wk1KklWgt[i] != null)
					model.setWk1KklWgt(wk1KklWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (wk5OthWgt[i] != null)
					model.setWk5OthWgt(wk5OthWgt[i]);
				if (wk2CosQty[i] != null)
					model.setWk2CosQty(wk2CosQty[i]);
				if (wk4PolQty[i] != null)
					model.setWk4PolQty(wk4PolQty[i]);
				if (lvl0[i] != null)
					model.setLvl0(lvl0[i]);
				if (wk3PolQty[i] != null)
					model.setWk3PolQty(wk3PolQty[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (wk3KklQty[i] != null)
					model.setWk3KklQty(wk3KklQty[i]);
				if (wk4CosQty[i] != null)
					model.setWk4CosQty(wk4CosQty[i]);
				if (wk3KklWgt[i] != null)
					model.setWk3KklWgt(wk3KklWgt[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (wk2KklWgt[i] != null)
					model.setWk2KklWgt(wk2KklWgt[i]);
				if (wk4HjsWgt[i] != null)
					model.setWk4HjsWgt(wk4HjsWgt[i]);
				if (wk2YmlWgt[i] != null)
					model.setWk2YmlWgt(wk2YmlWgt[i]);
				if (wk3YmlWgt[i] != null)
					model.setWk3YmlWgt(wk3YmlWgt[i]);
				if (gtlYmlWgt[i] != null)
					model.setGtlYmlWgt(gtlYmlWgt[i]);
				if (wk1HjsQty[i] != null)
					model.setWk1HjsQty(wk1HjsQty[i]);
				if (wk1YmlQty[i] != null)
					model.setWk1YmlQty(wk1YmlQty[i]);
				if (wk1YmlWgt[i] != null)
					model.setWk1YmlWgt(wk1YmlWgt[i]);
				if (subRlaneCd[i] != null)
					model.setSubRlaneCd(subRlaneCd[i]);
				if (wk2OthWgt[i] != null)
					model.setWk2OthWgt(wk2OthWgt[i]);
				if (wk5HjsWgt[i] != null)
					model.setWk5HjsWgt(wk5HjsWgt[i]);
				if (wk2CosWgt[i] != null)
					model.setWk2CosWgt(wk2CosWgt[i]);
				if (gtlCosQty[i] != null)
					model.setGtlCosQty(gtlCosQty[i]);
				if (gtlPolWgt[i] != null)
					model.setGtlPolWgt(gtlPolWgt[i]);
				if (wk5KklQty[i] != null)
					model.setWk5KklQty(wk5KklQty[i]);
				if (wk1OthWgt[i] != null)
					model.setWk1OthWgt(wk1OthWgt[i]);
				if (wk5YmlWgt[i] != null)
					model.setWk5YmlWgt(wk5YmlWgt[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (gtlKklQty[i] != null)
					model.setGtlKklQty(gtlKklQty[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (wk2HjsQty[i] != null)
					model.setWk2HjsQty(wk2HjsQty[i]);
				if (wk1PolQty[i] != null)
					model.setWk1PolQty(wk1PolQty[i]);
				if (wk5KklWgt[i] != null)
					model.setWk5KklWgt(wk5KklWgt[i]);
				if (wk2YmlQty[i] != null)
					model.setWk2YmlQty(wk2YmlQty[i]);
				if (wk1HjsWgt[i] != null)
					model.setWk1HjsWgt(wk1HjsWgt[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (wk5CosQty[i] != null)
					model.setWk5CosQty(wk5CosQty[i]);
				if (wk1KklQty[i] != null)
					model.setWk1KklQty(wk1KklQty[i]);
				if (wk2KklQty[i] != null)
					model.setWk2KklQty(wk2KklQty[i]);
				if (wk3CosWgt[i] != null)
					model.setWk3CosWgt(wk3CosWgt[i]);
				if (wk1CosQty[i] != null)
					model.setWk1CosQty(wk1CosQty[i]);
				if (wk5YmlQty[i] != null)
					model.setWk5YmlQty(wk5YmlQty[i]);
				if (wk3CosQty[i] != null)
					model.setWk3CosQty(wk3CosQty[i]);
				if (wk4CosWgt[i] != null)
					model.setWk4CosWgt(wk4CosWgt[i]);
				if (wk3HjsWgt[i] != null)
					model.setWk3HjsWgt(wk3HjsWgt[i]);
				if (wk4HjsQty[i] != null)
					model.setWk4HjsQty(wk4HjsQty[i]);
				if (gtlHjsQty[i] != null)
					model.setGtlHjsQty(gtlHjsQty[i]);
				if (grpId[i] != null)
					model.setGrpId(grpId[i]);
				if (gtlPolQty[i] != null)
					model.setGtlPolQty(gtlPolQty[i]);
				if (wk5PolQty[i] != null)
					model.setWk5PolQty(wk5PolQty[i]);
				if (gtlCosWgt[i] != null)
					model.setGtlCosWgt(gtlCosWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gtlKklWgt[i] != null)
					model.setGtlKklWgt(gtlKklWgt[i]);
				if (wk5PolWgt[i] != null)
					model.setWk5PolWgt(wk5PolWgt[i]);
				if (wk3OthWgt[i] != null)
					model.setWk3OthWgt(wk3OthWgt[i]);
				if (wk5HjsQty[i] != null)
					model.setWk5HjsQty(wk5HjsQty[i]);
				if (gtlHjsWgt[i] != null)
					model.setGtlHjsWgt(gtlHjsWgt[i]);
				if (wk2PolWgt[i] != null)
					model.setWk2PolWgt(wk2PolWgt[i]);
				if (wk1CosWgt[i] != null)
					model.setWk1CosWgt(wk1CosWgt[i]);
				if (gtlOthQty[i] != null)
					model.setGtlOthQty(gtlOthQty[i]);
				if (wk4OthWgt[i] != null)
					model.setWk4OthWgt(wk4OthWgt[i]);
				if (wk3OthQty[i] != null)
					model.setWk3OthQty(wk3OthQty[i]);
				if (wk1PolWgt[i] != null)
					model.setWk1PolWgt(wk1PolWgt[i]);
				if (wk3PolWgt[i] != null)
					model.setWk3PolWgt(wk3PolWgt[i]);
				if (wk1OthQty[i] != null)
					model.setWk1OthQty(wk1OthQty[i]);
				if (wk2HjsWgt[i] != null)
					model.setWk2HjsWgt(wk2HjsWgt[i]);
				if (wk4YmlWgt[i] != null)
					model.setWk4YmlWgt(wk4YmlWgt[i]);
				if (wk4KklWgt[i] != null)
					model.setWk4KklWgt(wk4KklWgt[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (gtlYmlQty[i] != null)
					model.setGtlYmlQty(gtlYmlQty[i]);
				if (wk4KklQty[i] != null)
					model.setWk4KklQty(wk4KklQty[i]);
				if (wk2OthQty[i] != null)
					model.setWk2OthQty(wk2OthQty[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchWeeklyLfByPolPodListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchWeeklyLfByPolPodListVO[]
	 */
	public SearchWeeklyLfByPolPodListVO[] getSearchWeeklyLfByPolPodListVOs(){
		SearchWeeklyLfByPolPodListVO[] vos = (SearchWeeklyLfByPolPodListVO[])models.toArray(new SearchWeeklyLfByPolPodListVO[models.size()]);
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
		this.wk5OthQty = this.wk5OthQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk4YmlQty = this.wk4YmlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk4PolWgt = this.wk4PolWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk5CosWgt = this.wk5CosWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk2PolQty = this.wk2PolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtlOthWgt = this.gtlOthWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk4OthQty = this.wk4OthQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk3YmlQty = this.wk3YmlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk3HjsQty = this.wk3HjsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk1KklWgt = this.wk1KklWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk5OthWgt = this.wk5OthWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk2CosQty = this.wk2CosQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk4PolQty = this.wk4PolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl0 = this.lvl0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk3PolQty = this.wk3PolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk3KklQty = this.wk3KklQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk4CosQty = this.wk4CosQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk3KklWgt = this.wk3KklWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk2KklWgt = this.wk2KklWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk4HjsWgt = this.wk4HjsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk2YmlWgt = this.wk2YmlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk3YmlWgt = this.wk3YmlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtlYmlWgt = this.gtlYmlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk1HjsQty = this.wk1HjsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk1YmlQty = this.wk1YmlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk1YmlWgt = this.wk1YmlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subRlaneCd = this.subRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk2OthWgt = this.wk2OthWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk5HjsWgt = this.wk5HjsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk2CosWgt = this.wk2CosWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtlCosQty = this.gtlCosQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtlPolWgt = this.gtlPolWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk5KklQty = this.wk5KklQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk1OthWgt = this.wk1OthWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk5YmlWgt = this.wk5YmlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtlKklQty = this.gtlKklQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk2HjsQty = this.wk2HjsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk1PolQty = this.wk1PolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk5KklWgt = this.wk5KklWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk2YmlQty = this.wk2YmlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk1HjsWgt = this.wk1HjsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk5CosQty = this.wk5CosQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk1KklQty = this.wk1KklQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk2KklQty = this.wk2KklQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk3CosWgt = this.wk3CosWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk1CosQty = this.wk1CosQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk5YmlQty = this.wk5YmlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk3CosQty = this.wk3CosQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk4CosWgt = this.wk4CosWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk3HjsWgt = this.wk3HjsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk4HjsQty = this.wk4HjsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtlHjsQty = this.gtlHjsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpId = this.grpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtlPolQty = this.gtlPolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk5PolQty = this.wk5PolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtlCosWgt = this.gtlCosWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtlKklWgt = this.gtlKklWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk5PolWgt = this.wk5PolWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk3OthWgt = this.wk3OthWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk5HjsQty = this.wk5HjsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtlHjsWgt = this.gtlHjsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk2PolWgt = this.wk2PolWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk1CosWgt = this.wk1CosWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtlOthQty = this.gtlOthQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk4OthWgt = this.wk4OthWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk3OthQty = this.wk3OthQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk1PolWgt = this.wk1PolWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk3PolWgt = this.wk3PolWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk1OthQty = this.wk1OthQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk2HjsWgt = this.wk2HjsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk4YmlWgt = this.wk4YmlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk4KklWgt = this.wk4KklWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtlYmlQty = this.gtlYmlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk4KklQty = this.wk4KklQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wk2OthQty = this.wk2OthQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
