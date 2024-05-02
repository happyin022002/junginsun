/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchDoRefInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchDoRefInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * D/O Release를 위한 기본 Reference정보를 조회한다.
	  * 2012.02.22 김보배 [CHM-201216247] [BKG] PSA DG EDI 추가 요청 건
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchDoRefInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchDoRefInfoRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append("/* 2015.08.03 한진그룹 코드 표준화  AUHBS > AUHSO */" ).append("\n"); 
		query.append("#if (${ofc_cd} == 'AUHSO')  " ).append("\n"); 
		query.append(",  'Importer Code' AS CSTMS_REF_NM" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",	NVL(CSTMS_REF_NM,DECODE(@[cnt_cd],'SG','CNTR_OPR','Customs Ref. No.') )   AS CSTMS_REF_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	DECODE(@[cnt_cd],'SG','SM',CSTMS_REF_CTNT)                                AS CSTMS_REF_CTNT" ).append("\n"); 
		query.append(",	NVL(CSTMS_ASGN_NM,DECODE(@[cnt_cd],'SG','PARTY_CD','Customs Ref. No.') )  AS CSTMS_ASGN_NM" ).append("\n"); 
		query.append(",	CSTMS_ASGN_CTNT" ).append("\n"); 
		query.append(",	INTER_RMK" ).append("\n"); 
		query.append(",	DO_HLD_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	INFO_CGO_FLG" ).append("\n"); 
		query.append(",	IDA_IMP_GEN_MF_NO" ).append("\n"); 
		query.append(",	IDA_CGOR_ORD_YR" ).append("\n"); 
		query.append(",	IDA_CSTMS_ASGN_LINE_NO" ).append("\n"); 
		query.append(",	DO_SPLIT_FLG" ).append("\n"); 
		query.append(",	CY_OP_CD" ).append("\n"); 
		query.append(",   IDA_DO_YD_CD" ).append("\n"); 
		query.append(",   NVL2(DO_VTY_DT,TO_CHAR (DO_VTY_DT, 'YYYY-MM-DD'), (SELECT " ).append("\n"); 
		query.append(" FT_END_DT" ).append("\n"); 
		query.append("FROM (SELECT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" MIN (TO_CHAR (C.FT_END_DT, 'YYYY-MM-DD')) OVER (PARTITION BY C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO, C.DMDT_TRF_CD, C.DMDT_CHG_LOC_DIV_CD)" ).append("\n"); 
		query.append("AS FT_END_DT" ).append("\n"); 
		query.append("FROM DMT_CHG_CALC C" ).append("\n"); 
		query.append("WHERE (C.SYS_AREA_GRP_ID, C.CNTR_NO, C.CNTR_CYC_NO) IN (" ).append("\n"); 
		query.append("SELECT D.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",D.CNTR_NO" ).append("\n"); 
		query.append(",D.CNTR_CYC_NO" ).append("\n"); 
		query.append("FROM DMT_CHG_BKG_CNTR D" ).append("\n"); 
		query.append("WHERE D.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("AND C.DMDT_CHG_STS_CD IN ('F', 'C', 'I', 'L', 'N', 'U')" ).append("\n"); 
		query.append("AND (   (    C.DMDT_TRF_CD = 'DMIF'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD = 'POD')" ).append("\n"); 
		query.append("OR (    C.DMDT_TRF_CD = 'CTIC'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD = 'DEL')" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("WHERE ROWNUM < 2)) DO_VTY_DT" ).append("\n"); 
		query.append(", A.ATTR_CTNT1" ).append("\n"); 
		query.append(", A.ATTR_CTNT2" ).append("\n"); 
		query.append(", A.ATTR_CTNT3" ).append("\n"); 
		query.append(", A.ATTR_CTNT4" ).append("\n"); 
		query.append(", A.ATTR_CTNT5" ).append("\n"); 
		query.append(", A.ATTR_CTNT6" ).append("\n"); 
		query.append("FROM BKG_DO_REF A, ( SELECT @[bkg_no] BKG_NO FROM DUAL) B" ).append("\n"); 
		query.append("WHERE	B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     A.BKG_NO(+) = B.BKG_NO" ).append("\n"); 

	}
}