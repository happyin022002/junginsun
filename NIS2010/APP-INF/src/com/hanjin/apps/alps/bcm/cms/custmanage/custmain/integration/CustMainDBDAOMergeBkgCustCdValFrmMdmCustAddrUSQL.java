/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOMergeBkgCustCdValFrmMdmCustAddrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.21
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOMergeBkgCustCdValFrmMdmCustAddrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Merge cust addr
	  * </pre>
	  */
	public CustMainDBDAOMergeBkgCustCdValFrmMdmCustAddrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOMergeBkgCustCdValFrmMdmCustAddrUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CUST_CD_VAL a										" ).append("\n"); 
		query.append(" USING ( select cust_cnt_cd, cust_seq, MC.CUST_LGL_ENG_NM, MC.NMD_CUST_FLG, MC.DELT_FLG from mdm_customer mc where mc.cust_cnt_cd = @[cust_cnt_cd] and mc.cust_seq = @[cust_seq] ) b           " ).append("\n"); 
		query.append(" ON (a.cust_cnt_cd = b.cust_cnt_cd and a.cust_seq = b.cust_seq )  " ).append("\n"); 
		query.append(" WHEN MATCHED THEN                                                " ).append("\n"); 
		query.append(" UPDATE                                                           " ).append("\n"); 
		query.append(" SET      " ).append("\n"); 
		query.append("    VAL_CUST_NM = BKG_IB_CUST_NM_VAL_FNC(B.CUST_CNT_CD, B.CUST_LGL_ENG_NM)" ).append("\n"); 
		query.append("    ,VAL_CUST_ADDR = NVL((" ).append("\n"); 
		query.append("							SELECT /*+ INDEX_DESC(ADDR XPKMDM_CUST_ADDR) */" ).append("\n"); 
		query.append("                     ADDR.BZET_ADDR" ).append("\n"); 
		query.append("                FROM MDM_CUST_ADDR ADDR " ).append("\n"); 
		query.append("               WHERE ADDR.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("                 AND ADDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                 AND ADDR.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("                 AND ADDR.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("                 AND ADDR.ADDR_TP_CD ='1'" ).append("\n"); 
		query.append("                 AND ROWNUM = 1 " ).append("\n"); 
		query.append("					), VAL_CUST_ADDR )" ).append("\n"); 
		query.append("    ,NMD_CUST_FLG = B.NMD_CUST_FLG" ).append("\n"); 
		query.append("    ,DELT_FLG = B.DELT_FLG" ).append("\n"); 
		query.append("    ,upd_usr_id  = NVL(@[upd_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append(" 	  ,upd_dt      = sysdate" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN                                            " ).append("\n"); 
		query.append(" INSERT                                                           " ).append("\n"); 
		query.append(" (                                                                " ).append("\n"); 
		query.append("    CUST_CNT_CD" ).append("\n"); 
		query.append("    ,CUST_SEQ" ).append("\n"); 
		query.append("    ,VAL_CUST_NM" ).append("\n"); 
		query.append("    ,VAL_CUST_ADDR" ).append("\n"); 
		query.append("    ,NMD_CUST_FLG" ).append("\n"); 
		query.append("    ,DELT_FLG" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append(" )                                                                " ).append("\n"); 
		query.append(" values                                                           " ).append("\n"); 
		query.append(" (                                                                " ).append("\n"); 
		query.append(" 	B.CUST_CNT_CD" ).append("\n"); 
		query.append(" 	,B.CUST_SEQ" ).append("\n"); 
		query.append(" 	,BKG_IB_CUST_NM_VAL_FNC(B.CUST_CNT_CD, B.CUST_LGL_ENG_NM)" ).append("\n"); 
		query.append("  ,  (  	SELECT /*+ INDEX_DESC(ADDR XPKMDM_CUST_ADDR) */" ).append("\n"); 
		query.append("			           ADDR.BZET_ADDR" ).append("\n"); 
		query.append("		      FROM MDM_CUST_ADDR ADDR " ).append("\n"); 
		query.append("         WHERE ADDR.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("           AND ADDR.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND ADDR.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND ADDR.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("           AND ADDR.ADDR_TP_CD ='1'" ).append("\n"); 
		query.append("           AND ROWNUM = 1 )" ).append("\n"); 
		query.append(" 	,B.NMD_CUST_FLG" ).append("\n"); 
		query.append(" 	,B.DELT_FLG" ).append("\n"); 
		query.append(" 	,NVL(@[cre_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append(" 	,NVL(to_date(@[cre_dt],'yyyymmddhh24miss'), sysdate)" ).append("\n"); 
		query.append(" 	,NVL(@[upd_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append(" 	,NVL(to_date(@[upd_dt],'yyyymmddhh24miss'), sysdate)               			" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}