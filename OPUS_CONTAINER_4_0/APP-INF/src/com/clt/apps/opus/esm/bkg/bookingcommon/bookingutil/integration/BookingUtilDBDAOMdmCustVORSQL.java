/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingUtilDBDAOMdmCustVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.03.07 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang HO Chae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOMdmCustVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAOMdmCustVO
	  * </pre>
	  */
	public BookingUtilDBDAOMdmCustVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOMdmCustVORSQL").append("\n"); 
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
		query.append("select  finc_sts_lvl_cd block_flag," ).append("\n"); 
		query.append("        indiv_corp_div_cd cust_tp_cd," ).append("\n"); 
		query.append("        UPPER(cust_lgl_eng_nm) name," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            select  UPPER(bzet_addr)" ).append("\n"); 
		query.append("            from    mdm_cust_addr" ).append("\n"); 
		query.append("            where   cust_cnt_cd = cust.cust_cnt_cd" ).append("\n"); 
		query.append("            and     cust_seq = cust.cust_seq" ).append("\n"); 
		query.append("            and     prmry_chk_flg = 'Y'" ).append("\n"); 
		query.append("            and     rownum = 1" ).append("\n"); 
		query.append("        ) address," ).append("\n"); 
		query.append("		CASE WHEN SLS_DELT_EFF_DT IS NOT NULL THEN 'Y' " ).append("\n"); 
		query.append("			 ELSE 'N' END no_use_flg," ).append("\n"); 
		query.append("		delt_flg, " ).append("\n"); 
		query.append("		cust_cnt_cd," ).append("\n"); 
		query.append("		cust_seq," ).append("\n"); 
		query.append("		FRT_FWRD_FMC_NO," ).append("\n"); 
		query.append("	    CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("		NVL(NMD_CUST_FLG, 'N') nmd_cust_flg" ).append("\n"); 
		query.append("from    mdm_customer cust" ).append("\n"); 
		query.append("where   cust_cnt_cd = @[cust_cnt_cd]" ).append("\n"); 
		query.append("and     CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND     CNTR_DIV_FLG = 'Y'" ).append("\n"); 

	}
}