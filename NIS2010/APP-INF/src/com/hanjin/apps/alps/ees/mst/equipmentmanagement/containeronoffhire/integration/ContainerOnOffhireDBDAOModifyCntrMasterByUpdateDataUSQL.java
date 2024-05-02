/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrMasterByUpdateDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.19
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.10.19 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyCntrMasterByUpdateDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrMasterByUpdateData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyCntrMasterByUpdateDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyCntrMasterByUpdateDataUSQL").append("\n"); 
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
		query.append("UPDATE MST_CONTAINER A" ).append("\n"); 
		query.append("SET     UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("        UPD_DT = SYSDATE" ).append("\n"); 
		query.append("      ,(CNTR_STS_CD,LST_STS_YD_CD,LST_STS_SEQ) " ).append("\n"); 
		query.append("        =(SELECT /*+ INDEX_DESC(B XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("            B.CNTR_STS_CD, B.YD_CD, B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("        FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO=B.CNTR_NO" ).append("\n"); 
		query.append("        AND ROWNUM=1)" ).append("\n"); 
		query.append("     ,(LSTM_CD,AGMT_CTY_CD,AGMT_SEQ,VNDR_SEQ,ONH_FREE_DYS,MIN_ONH_DYS)" ).append("\n"); 
		query.append("        =(SELECT /*+ INDEX_DESC(B XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("              (SELECT C.LSTM_CD" ).append("\n"); 
		query.append("              FROM LSE_AGREEMENT C" ).append("\n"); 
		query.append("              WHERE B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("              AND   B.AGMT_SEQ = C.AGMT_SEQ), " ).append("\n"); 
		query.append("              B.AGMT_CTY_CD,B.AGMT_SEQ," ).append("\n"); 
		query.append("             (SELECT C.VNDR_SEQ" ).append("\n"); 
		query.append("              FROM LSE_AGREEMENT C" ).append("\n"); 
		query.append("              WHERE B.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("              AND   B.AGMT_SEQ = C.AGMT_SEQ)," ).append("\n"); 
		query.append("              B.RNTL_CHG_FREE_DYS,B.CNTR_MIN_ONH_DYS" ).append("\n"); 
		query.append("        FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO=B.CNTR_NO" ).append("\n"); 
		query.append("        AND   B.CNTR_STS_CD IN('LSI','OWN','DII')" ).append("\n"); 
		query.append("        AND ROWNUM=1)" ).append("\n"); 
		query.append("    ,(ONH_CNTR_STS_CD,ONH_DT,ONH_YD_CD,ONH_STS_SEQ) " ).append("\n"); 
		query.append("        = (SELECT B.CNTR_STS_CD,B.CNTR_STS_EVNT_DT,B.YD_CD,B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("           FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("           WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("           AND   B.CNTR_STS_SEQ = MST_ONH_STS_SEQ_FNC(A.CNTR_NO))" ).append("\n"); 
		query.append("    ,(CNMV_STS_CD,ACIAC_DIV_CD," ).append("\n"); 
		query.append("      SYS_AREA_GRP_ID,CNMV_YR,CNMV_ID_NO,CNMV_SEQ,CNMV_SPLIT_NO,CNMV_CYC_NO," ).append("\n"); 
		query.append("      CNMV_DT,CNMV_GDT," ).append("\n"); 
		query.append("      PRE_STS_FLG,BKG_NO,BKG_KNT,FULL_FLG," ).append("\n"); 
		query.append("      CRNT_YD_CD,LOC_CD," ).append("\n"); 
		query.append("      SCC_CD,LCC_CD,ECC_CD,RCC_CD," ).append("\n"); 
		query.append("      DEST_YD_CD,VSL_CD,SKD_VOY_NO,SKD_DIR_CD)" ).append("\n"); 
		query.append("      =(SELECT /*+ INDEX_DESC(B XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("             B.MVMT_STS_CD,DECODE(B.MVMT_STS_CD,'XX','I','A')," ).append("\n"); 
		query.append("             B.SYS_AREA_GRP_ID,B.CNMV_YR,CNMV_ID_NO,B.CNMV_SEQ,B.CNMV_SPLIT_NO,B.CNMV_CYC_NO," ).append("\n"); 
		query.append("             B.CNMV_EVNT_DT,GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(B.ORG_YD_CD,1,5),B.CNMV_EVNT_DT,'GMT')," ).append("\n"); 
		query.append("             B.PRE_STS_FLG,B.BKG_NO,B.BKG_KNT,NVL(B.FCNTR_FLG,'N')," ).append("\n"); 
		query.append("             B.ORG_YD_CD,SUBSTR(B.ORG_YD_CD,1,5)," ).append("\n"); 
		query.append("             MST_LOC_FNC(SUBSTR(B.ORG_YD_CD,1,5),'SCC'),MST_LOC_FNC(SUBSTR(B.ORG_YD_CD,1,5),'LCC')," ).append("\n"); 
		query.append("             MST_LOC_FNC(SUBSTR(B.ORG_YD_CD,1,5),'ECC'),MST_LOC_FNC(SUBSTR(B.ORG_YD_CD,1,5),'RCC')," ).append("\n"); 
		query.append("             B.DEST_YD_CD,B.CRNT_VSL_CD,B.CRNT_SKD_VOY_NO,B.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("        FROM CTM_MOVEMENT B" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO=B.CNTR_NO" ).append("\n"); 
		query.append("        AND ROWNUM=1" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(B XAK1MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("              DECODE(B.CNTR_STS_CD,'LSI','MT','OWN','MT','DII','MT','SBI','MT','MUI','MT','FND','MT','SRI','MT','XX')," ).append("\n"); 
		query.append("              DECODE(B.CNTR_STS_CD,'LSI','A','OWN','A','DII','A','SBI','A','MUI','A','FND','A','SRI','A','I')," ).append("\n"); 
		query.append("             (SELECT C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("              FROM COM_SYS_AREA_GRP_ID C" ).append("\n"); 
		query.append("              WHERE C.CNT_CD = SUBSTR(B.YD_CD,1,2)" ).append("\n"); 
		query.append("              AND   C.CO_IND_CD = 'H') SYS_AREA_GRP_ID, " ).append("\n"); 
		query.append("              TO_CHAR(B.CNTR_STS_EVNT_DT,'YYYY') CNMV_YR," ).append("\n"); 
		query.append("              10 CNMV_ID_NO," ).append("\n"); 
		query.append("              10 CNMV_SEQ," ).append("\n"); 
		query.append("              ' ' CNMV_SPLIT_NO," ).append("\n"); 
		query.append("              (SELECT M.CNMV_CYC_NO" ).append("\n"); 
		query.append("               FROM MST_CONTAINER M" ).append("\n"); 
		query.append("               WHERE A.CNTR_NO=M.CNTR_NO)," ).append("\n"); 
		query.append("              B.CNTR_STS_EVNT_DT,GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(B.YD_CD,1,5),B.CNTR_STS_EVNT_DT,'GMT')," ).append("\n"); 
		query.append("             'N' PRE_STS_FLG,'' BKG_NO, 0 BKG_KNT,'N' FCNTR_FLG," ).append("\n"); 
		query.append("             B.YD_CD,SUBSTR(B.YD_CD,1,5)," ).append("\n"); 
		query.append("             MST_LOC_FNC(SUBSTR(B.YD_CD,1,5),'SCC'),MST_LOC_FNC(SUBSTR(B.YD_CD,1,5),'LCC')," ).append("\n"); 
		query.append("             MST_LOC_FNC(SUBSTR(B.YD_CD,1,5),'ECC'),MST_LOC_FNC(SUBSTR(B.YD_CD,1,5),'RCC')," ).append("\n"); 
		query.append("             '' DEST_YD_CD,'' CRNT_VSL_CD,'' CRNT_SKD_VOY_NO,'' CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("        FROM MST_CNTR_STS_HIS B" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO=B.CNTR_NO" ).append("\n"); 
		query.append("        AND  0 = (SELECT COUNT(*)" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT M" ).append("\n"); 
		query.append("                  WHERE A.CNTR_NO=M.CNTR_NO" ).append("\n"); 
		query.append("                  AND   ROWNUM=1)" ).append("\n"); 
		query.append("        AND ROWNUM=1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}