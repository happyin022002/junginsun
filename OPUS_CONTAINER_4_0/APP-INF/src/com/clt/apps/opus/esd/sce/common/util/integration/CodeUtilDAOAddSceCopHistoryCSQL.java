/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CodeUtilDAOAddSceCopHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.13
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.12.13 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.util.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeUtilDAOAddSceCopHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSceCopHistory
	  * </pre>
	  */
	public CodeUtilDAOAddSceCopHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scs_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.util.integration").append("\n"); 
		query.append("FileName : CodeUtilDAOAddSceCopHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_COP_HIS" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        COP_NO," ).append("\n"); 
		query.append("        ACCL_SEQ," ).append("\n"); 
		query.append("        CNTR_NO," ).append("\n"); 
		query.append("        BKG_NO," ).append("\n"); 
		query.append("        CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        PCTL_NO," ).append("\n"); 
		query.append("        BKG_STS_CD," ).append("\n"); 
		query.append("        COP_STS_CD," ).append("\n"); 
		query.append("        BKG_EVNT_TP_CD," ).append("\n"); 
		query.append("        UMCH_STS_CD," ).append("\n"); 
		query.append("        OB_TRO_SEQ," ).append("\n"); 
		query.append("        OB_TRO_SUB_SEQ," ).append("\n"); 
		query.append("        IB_TRO_SEQ," ).append("\n"); 
		query.append("        IB_TRO_SUB_SEQ," ).append("\n"); 
		query.append("		SCS_FLG," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT," ).append("\n"); 
		query.append("		MST_COP_NO" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    H.COP_NO," ).append("\n"); 
		query.append("    SCE_COP_HIS_SEQ.NEXTVAL  ACCL_SEQ," ).append("\n"); 
		query.append("    H.CNTR_NO," ).append("\n"); 
		query.append("    H.BKG_NO," ).append("\n"); 
		query.append("    H.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("    H.PCTL_NO," ).append("\n"); 
		query.append("    B.BKG_STS_CD," ).append("\n"); 
		query.append("    H.COP_STS_CD," ).append("\n"); 
		query.append("    @[event_cd] EVNT_CD," ).append("\n"); 
		query.append("    H.UMCH_STS_CD," ).append("\n"); 
		query.append("    DECODE(SUBSTR(OB_TRO,1,1),'O',TO_NUMBER(SUBSTR(OB_TRO,2,4))) OB_TRO_SEQ," ).append("\n"); 
		query.append("    DECODE(SUBSTR(OB_TRO,1,1),'O',TO_NUMBER(SUBSTR(OB_TRO,6,4))) OB_TRO_SUB_SEQ," ).append("\n"); 
		query.append("    DECODE(SUBSTR(OB_TRO,1,1),'I',TO_NUMBER(SUBSTR(OB_TRO,2,4))) IB_TRO_SEQ," ).append("\n"); 
		query.append("    DECODE(SUBSTR(OB_TRO,1,1),'I',TO_NUMBER(SUBSTR(OB_TRO,6,4))) IB_TRO_SUB_SEQ," ).append("\n"); 
		query.append("	@[scs_flg] AS SCS_FLG," ).append("\n"); 
		query.append("    @[usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("    SYSDATE CRE_DT," ).append("\n"); 
		query.append("    @[usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("    SYSDATE UPD_DT," ).append("\n"); 
		query.append("	MST_COP_NO" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    SCE_COP_HDR H, BKG_BOOKING B" ).append("\n"); 
		query.append("    ,(SELECT T.COP_NO" ).append("\n"); 
		query.append("            ,MIN(T.IO_BND_CD||TRIM(TO_CHAR(T.TRO_SEQ,'0000'))||TRIM(TO_CHAR(T.TRO_SUB_SEQ,'0000'))) IB_TRO" ).append("\n"); 
		query.append("            ,MAX(T.IO_BND_CD||TRIM(TO_CHAR(T.TRO_SEQ,'0000'))||TRIM(TO_CHAR(T.TRO_SUB_SEQ,'0000'))) OB_TRO" ).append("\n"); 
		query.append("      FROM  SCE_TRO_MAPG T" ).append("\n"); 
		query.append("      WHERE T.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("      GROUP BY T.COP_NO" ).append("\n"); 
		query.append("     ) TT" ).append("\n"); 
		query.append("    WHERE   H.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("    AND     H.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    AND    TT.COP_NO (+) = H.COP_NO" ).append("\n"); 

	}
}