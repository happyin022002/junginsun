/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOmodifyClearanceTypebyScUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.07
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.09.07 이영헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOmodifyClearanceTypebyScUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyClearanceTypebySc
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOmodifyClearanceTypebyScUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etr_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("it_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ftz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOmodifyClearanceTypebyScUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_ADV_CLR_TP CT" ).append("\n"); 
		query.append("USING ( " ).append("\n"); 
		query.append("    SELECT SUBSTR(@[cust_cd],1,2) AS CUST_CNT_CD, " ).append("\n"); 
		query.append("           SUBSTR(@[cust_cd],3)   AS CUST_SEQ,  " ).append("\n"); 
		query.append("                        @[pod_cd] AS POD_CD,  " ).append("\n"); 
		query.append("                        @[del_cd] AS DEL_CD" ).append("\n"); 
		query.append("    FROM DUAL " ).append("\n"); 
		query.append(") TM" ).append("\n"); 
		query.append("ON ( " ).append("\n"); 
		query.append("	CT.CUST_CNT_CD = TM.CUST_CNT_CD AND " ).append("\n"); 
		query.append("    CT.CUST_SEQ    = TM.CUST_SEQ    AND " ).append("\n"); 
		query.append("    CT.POD_CD      = TM.POD_CD      AND " ).append("\n"); 
		query.append("    CT.DEL_CD      = TM.DEL_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE     " ).append("\n"); 
		query.append("        SET 	 SC_NO           = @[sc_no]" ).append("\n"); 
		query.append("		,        CMDT_CD 		 = @[cmdt_cd]" ).append("\n"); 
		query.append("        ,        CSTMS_CLR_TP_CD = @[etr_tp]" ).append("\n"); 
		query.append("        ,        FREE_TRD_ZN_FLG = @[ftz_flg]" ).append("\n"); 
		query.append("        ,        CNTR_TP_CD      = @[cntr_tp_cd]" ).append("\n"); 
		query.append("        ,        DELT_FLG        = @[delt_flg]" ).append("\n"); 
		query.append("		#if (${delt_flg} == 'Y')" ).append("\n"); 
		query.append("        ,        DELT_USR_ID     = @[delt_usr_id]" ).append("\n"); 
		query.append("        ,        DELT_DT         = TO_DATE(@[delt_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		,        UPD_OFC_CD      = @[upd_ofc_cd]" ).append("\n"); 
		query.append("        ,        UPD_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append("        ,        UPD_DT          = TO_DATE(@[upd_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("        ,        HUB_LOC_CD      = @[hub_loc_cd]" ).append("\n"); 
		query.append("        ,        IBD_TRSP_TP_CD  = @[it_tp]" ).append("\n"); 
		query.append("		,        CSTMS_LOC_CD    = @[cstms_loc_cd]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT ( CUST_CNT_CD" ).append("\n"); 
		query.append("        		,CUST_SEQ" ).append("\n"); 
		query.append("        		,POD_CD" ).append("\n"); 
		query.append("        		,DEL_CD" ).append("\n"); 
		query.append("				,CLR_TP_SEQ" ).append("\n"); 
		query.append("        		,CMDT_CD" ).append("\n"); 
		query.append("        		,SC_NO" ).append("\n"); 
		query.append("        		,CSTMS_CLR_TP_CD" ).append("\n"); 
		query.append("        		,FREE_TRD_ZN_FLG" ).append("\n"); 
		query.append("        		,CNTR_TP_CD" ).append("\n"); 
		query.append("        		,DELT_FLG" ).append("\n"); 
		query.append("				,CRE_OFC_CD" ).append("\n"); 
		query.append("        		,CRE_USR_ID" ).append("\n"); 
		query.append("        		,CRE_DT" ).append("\n"); 
		query.append("				,UPD_OFC_CD" ).append("\n"); 
		query.append("        		,UPD_USR_ID" ).append("\n"); 
		query.append("        		,UPD_DT " ).append("\n"); 
		query.append("        		,HUB_LOC_CD" ).append("\n"); 
		query.append("				,IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("				,CSTMS_LOC_CD" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		VALUES ( SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("        		,SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("        		,@[pod_cd]" ).append("\n"); 
		query.append("        		,@[del_cd]" ).append("\n"); 
		query.append("				,NVL((SELECT /*+ index_desc(A XPKBKG_CSTMS_ADV_CLR_TP)  */   " ).append("\n"); 
		query.append("						     CLR_TP_SEQ" ).append("\n"); 
		query.append(" 					  FROM   BKG_CSTMS_ADV_CLR_TP A" ).append("\n"); 
		query.append("					  WHERE  1=1" ).append("\n"); 
		query.append("					  AND	 CUST_CNT_CD  = SUBSTR(@[cust_cd],1,2)  " ).append("\n"); 
		query.append("					  AND    CUST_SEQ     = SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("					  AND    POD_CD 	  = @[pod_cd] " ).append("\n"); 
		query.append("					  AND    DEL_CD 	  = @[del_cd] " ).append("\n"); 
		query.append("					  AND    ROWNUM 	  = 1   " ).append("\n"); 
		query.append("				),0)+1" ).append("\n"); 
		query.append("        		,@[cmdt_cd]" ).append("\n"); 
		query.append("        		,@[sc_no]" ).append("\n"); 
		query.append("        		,@[etr_tp]" ).append("\n"); 
		query.append("        		,NVL(@[ftz_flg],'N')" ).append("\n"); 
		query.append("        		,@[cntr_tp_cd]" ).append("\n"); 
		query.append("        		,@[delt_flg]" ).append("\n"); 
		query.append("        		,@[cre_ofc_cd]" ).append("\n"); 
		query.append("        		,@[cre_usr_id]" ).append("\n"); 
		query.append("        		,TO_DATE(@[cre_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("        		,@[upd_ofc_cd]" ).append("\n"); 
		query.append("        		,@[upd_usr_id]" ).append("\n"); 
		query.append("        		,TO_DATE(@[upd_dt],'YYYYMMDDHH24MISS') " ).append("\n"); 
		query.append("        		,@[hub_loc_cd]" ).append("\n"); 
		query.append("				,@[it_tp]" ).append("\n"); 
		query.append("        		,@[cstms_loc_cd]" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}