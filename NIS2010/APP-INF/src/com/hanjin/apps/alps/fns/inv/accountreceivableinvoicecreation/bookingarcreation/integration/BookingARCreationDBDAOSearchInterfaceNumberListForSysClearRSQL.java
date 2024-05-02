/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchInterfaceNumberListForSysClearRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.03.05 최도순
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

public class BookingARCreationDBDAOSearchInterfaceNumberListForSysClearRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SYS CLEAR 대상 INTERFACE NUMBER를 구한다.
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchInterfaceNumberListForSysClearRSQL(){
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
		query.append("FileName : BookingARCreationDBDAOSearchInterfaceNumberListForSysClearRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT AR_IF_NO   -- 반드시 DISTINCT를 반드시 사용해야 함. 삭제하지 말것" ).append("\n"); 
		query.append("  FROM (SELECT Y.BL_SRC_NO ,Y.REV_TP_CD, Y.ACT_CUST_CNT_CD, Y.ACT_CUST_SEQ, Y.VSL_CD, Y.SKD_VOY_NO, Y.SKD_DIR_CD        " ).append("\n"); 
		query.append("          FROM (SELECT AR_OFC_CD,BL_SRC_NO,REV_TP_CD,CURR_CD,SUM(CHG_AMT) S_CHG_AMT, ACT_CUST_CNT_CD, ACT_CUST_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                  FROM (SELECT A.AR_IF_NO,A.AR_OFC_CD,A.BL_SRC_NO,A.ACT_CUST_CNT_CD,A.ACT_CUST_SEQ,A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD" ).append("\n"); 
		query.append("                               ,DECODE(A.REV_TP_CD,'M','M','B','B','C','B') REV_TP_CD,B.CURR_CD,SUM(B.CHG_AMT) CHG_AMT     -- 5) M 은 M 끼리 , B,C 는 합쳐서" ).append("\n"); 
		query.append("                           FROM INV_AR_MN A,INV_AR_CHG B" ).append("\n"); 
		query.append("                          WHERE A.AR_OFC_CD = @[ar_ofc_cd]   " ).append("\n"); 
		query.append("                            AND A.INV_ISS_FLG ='N'                          -- 4) 이 때, INV_AR_MN 테이블이므로 주의할것" ).append("\n"); 
		query.append("                            AND A.BL_INV_CFM_DT IS NOT NULL                 -- 3)" ).append("\n"); 
		query.append("                            AND NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'           -- 2)" ).append("\n"); 
		query.append("                            AND A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                            #if (${bl_src_no} != '')" ).append("\n"); 
		query.append("                            AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                            AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("                            AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                            AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("                            AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("                            AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                          GROUP BY A.AR_IF_NO, A.AR_OFC_CD, A.BL_SRC_NO, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, DECODE(A.REV_TP_CD,'M','M','B','B','C','B'), B.CURR_CD" ).append("\n"); 
		query.append("                    )  " ).append("\n"); 
		query.append("                  GROUP BY AR_OFC_CD, BL_SRC_NO, REV_TP_CD, CURR_CD, ACT_CUST_CNT_CD, ACT_CUST_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                 HAVING COUNT(AR_IF_NO) > 1                                         -- 7)" ).append("\n"); 
		query.append("                )X," ).append("\n"); 
		query.append("                (SELECT A.BL_SRC_NO, CURR_CD, SUM(B.CHG_AMT) CHG_AMT, DECODE(A.REV_TP_CD,'M','M','B','B','C','B') REV_TP_CD" ).append("\n"); 
		query.append("                        , A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("                           FROM INV_AR_MN A,INV_AR_CHG B" ).append("\n"); 
		query.append("                          WHERE A.AR_OFC_CD = @[ar_ofc_cd]  " ).append("\n"); 
		query.append("                            AND A.INV_ISS_FLG ='N'                          -- 4) 이 때, INV_AR_MN 테이블이므로 주의할것" ).append("\n"); 
		query.append("                            AND A.BL_INV_CFM_DT IS NOT NULL                 -- 3)" ).append("\n"); 
		query.append("                            AND NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'           -- 2)" ).append("\n"); 
		query.append("                            AND A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                            #if (${bl_src_no} != '')" ).append("\n"); 
		query.append("                            AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                            AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("                            AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                            AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("                            AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                            #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("                            AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                          GROUP BY A.BL_SRC_NO, CURR_CD, DECODE(A.REV_TP_CD,'M','M','B','B','C','B'), A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("                          , A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("                )Y" ).append("\n"); 
		query.append("          WHERE X.BL_SRC_NO = Y.BL_SRC_NO" ).append("\n"); 
		query.append("            AND X.REV_TP_CD = Y.REV_TP_CD" ).append("\n"); 
		query.append("            AND X.ACT_CUST_CNT_CD = Y.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("            AND X.ACT_CUST_SEQ = Y.ACT_CUST_SEQ" ).append("\n"); 
		query.append("            AND X.VSL_CD = Y.VSL_CD" ).append("\n"); 
		query.append("            AND X.SKD_VOY_NO = Y.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND X.SKD_DIR_CD = Y.SKD_DIR_CD" ).append("\n"); 
		query.append("          GROUP BY Y.BL_SRC_NO ,Y.REV_TP_CD, Y.ACT_CUST_CNT_CD, Y.ACT_CUST_SEQ, Y.VSL_CD, Y.SKD_VOY_NO, Y.SKD_DIR_CD        " ).append("\n"); 
		query.append("         HAVING SUM(DECODE(CHG_AMT,0,0,1)) = 0                        -- 6)" ).append("\n"); 
		query.append("       ) A," ).append("\n"); 
		query.append("       (SELECT A.AR_IF_NO,A.BL_SRC_NO" ).append("\n"); 
		query.append("              ,DECODE(A.REV_TP_CD,'M','M','B','B','C','B') REV_TP_CD" ).append("\n"); 
		query.append("               , A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("          FROM INV_AR_MN A,INV_AR_CHG B" ).append("\n"); 
		query.append("         WHERE A.AR_OFC_CD = @[ar_ofc_cd]   " ).append("\n"); 
		query.append("           AND A.INV_ISS_FLG ='N'  -- 이 때, INV_AR_MN 테이블이므로 주의할것" ).append("\n"); 
		query.append("           AND A.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("           AND NVL(A.INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("           AND A.AR_IF_NO = B.AR_IF_NO " ).append("\n"); 
		query.append("           #if (${bl_src_no} != '')" ).append("\n"); 
		query.append("            AND A.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("            AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${act_cust_seq} != '')" ).append("\n"); 
		query.append("            AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("            AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("            AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("  WHERE A.BL_SRC_NO = B.BL_SRC_NO " ).append("\n"); 
		query.append("    AND A.REV_TP_CD = B.REV_TP_CD" ).append("\n"); 
		query.append("    AND A.ACT_CUST_CNT_CD = B.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("    AND A.ACT_CUST_SEQ = B.ACT_CUST_SEQ" ).append("\n"); 
		query.append("    AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND A.SKD_DIR_CD = B.SKD_DIR_CD    " ).append("\n"); 

	}
}