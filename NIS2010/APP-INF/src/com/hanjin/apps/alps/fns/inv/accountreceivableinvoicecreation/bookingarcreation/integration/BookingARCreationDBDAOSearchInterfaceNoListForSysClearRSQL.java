/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchInterfaceNoListForSysClearRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.05.11 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchInterfaceNoListForSysClearRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SYS CLEAR 대상 INTERFACE NUMBER를 구한다.
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchInterfaceNoListForSysClearRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchInterfaceNoListForSysClearRSQL").append("\n"); 
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
		query.append("WITH  INV_AR_MN_TEMP  AS" ).append("\n"); 
		query.append("       (SELECT  AR_IF_NO, AR_OFC_CD, BL_SRC_NO, ACT_CUST_CNT_CD, ACT_CUST_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, DECODE(REV_TP_CD,'M','M','B','B','C','B') REV_TP_CD          " ).append("\n"); 
		query.append("        FROM    INV_AR_MN" ).append("\n"); 
		query.append("        WHERE   AR_OFC_CD = @[ar_ofc_cd] --:OFC_CD        " ).append("\n"); 
		query.append("        #if (${bl_src_no} != '')" ).append("\n"); 
		query.append("        AND BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("        AND ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("        AND ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("        AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("        AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("        AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("        AND BL_INV_CFM_DT IS NOT NULL  " ).append("\n"); 
		query.append("        AND NVL(INV_DELT_DIV_CD,'N') <> 'Y'   " ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("SELECT  A.AR_IF_NO" ).append("\n"); 
		query.append("FROM    INV_AR_MN_TEMP  A," ).append("\n"); 
		query.append("       (SELECT  AR_OFC_CD, BL_SRC_NO, ACT_CUST_CNT_CD, ACT_CUST_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_TP_CD" ).append("\n"); 
		query.append("        FROM   (SELECT  /*+ ORDERED USE_NL(A B) INDEX(B XAK3INV_AR_CHG) */" ).append("\n"); 
		query.append("                        A.AR_OFC_CD, A.BL_SRC_NO, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_TP_CD, B.CURR_CD," ).append("\n"); 
		query.append("                        SUM(B.CHG_AMT)              SUM_CHG_AMT," ).append("\n"); 
		query.append("                        COUNT(DISTINCT A.AR_IF_NO)  CNT_AR_IF_NO" ).append("\n"); 
		query.append("                FROM    INV_AR_MN_TEMP   A," ).append("\n"); 
		query.append("                        INV_AR_CHG  B" ).append("\n"); 
		query.append("                WHERE   A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                GROUP BY A.AR_OFC_CD, A.BL_SRC_NO, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_TP_CD, B.CURR_CD, B.INV_XCH_RT" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("        GROUP BY AR_OFC_CD, BL_SRC_NO, ACT_CUST_CNT_CD, ACT_CUST_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_TP_CD" ).append("\n"); 
		query.append("        HAVING MIN(CNT_AR_IF_NO) > 1  AND  MAX(ABS(SUM_CHG_AMT)) = 0" ).append("\n"); 
		query.append("       )  B" ).append("\n"); 
		query.append("WHERE   A.AR_OFC_CD       = B.AR_OFC_CD" ).append("\n"); 
		query.append("AND     A.BL_SRC_NO       = B.BL_SRC_NO" ).append("\n"); 
		query.append("AND     A.ACT_CUST_CNT_CD = B.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND     A.ACT_CUST_SEQ    = B.ACT_CUST_SEQ" ).append("\n"); 
		query.append("AND     A.VSL_CD          = B.VSL_CD" ).append("\n"); 
		query.append("AND     A.SKD_VOY_NO      = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     A.SKD_DIR_CD      = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     A.REV_TP_CD       = B.REV_TP_CD" ).append("\n"); 

	}
}