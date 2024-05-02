/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchNlFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchNlFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 bkg이 NL 지역에 들리는 지 조회
	  * </pre>
	  */
	public BookingUtilDBDAOSearchNlFlagRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchNlFlagRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("select 'Y' RESULT" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("from bkg_vvd_his vvd, bkg_bkg_his bk" ).append("\n"); 
		query.append("where bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("and bk.corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("and vvd.corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("from bkg_vvd vvd, bkg_booking bk" ).append("\n"); 
		query.append("where bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--and (vvd.pol_cd like 'NL%' or vvd.pod_cd like 'NL%' or bk.pod_cd like 'NL%' or bk.del_cd like 'NL%')" ).append("\n"); 
		query.append("and (   SUBSTR(vvd.pod_cd, 1, 2) IN (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD ='EU'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID='EU_MEMBER_CNT' )" ).append("\n"); 
		query.append("OR SUBSTR(bk.pod_cd, 1, 2) IN (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD ='EU'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID='EU_MEMBER_CNT' )) -- EU대상 국가로 조회" ).append("\n"); 
		query.append("and exists (select 'x'" ).append("\n"); 
		query.append("from mdm_vsl_cntr mdm" ).append("\n"); 
		query.append("where vvd.vsl_cd = mdm.vsl_cd" ).append("\n"); 
		query.append("and mdm.fdr_div_cd = 'T')" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 

	}
}