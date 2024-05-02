/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiPsaEdoCtntRSQL.java
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

public class CargoReleaseOrderDBDAOsearchEdiPsaEdoCtntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA D/O Release Order EDI (Coreor)를 전송 Flat File 본문 정보를 조회한다.
	  * 2012.02.22 김보배 [CHM-201216247] [BKG] PSA DG EDI 추가 요청 건
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiPsaEdoCtntRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("recTp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiPsaEdoCtntRSQL").append("\n"); 
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
		query.append("SELECT CHR(10) || '{PSAEDO'                                         || CHR(10)" ).append("\n"); 
		query.append("      ||'REC_TYPE:'         || REC_TYPE                             || CHR(10)" ).append("\n"); 
		query.append("      ||'AUTH_NO:'          || DECODE(REC_TYPE,'FU',PSA_AUTH_NO" ).append("\n"); 
		query.append("											  ,'FD',PSA_AUTH_NO" ).append("\n"); 
		query.append("                                              ,'EU',PSA_AUTH_NO" ).append("\n"); 
		query.append("                                              ,'ED',PSA_AUTH_NO,'') || CHR(10)" ).append("\n"); 
		query.append("      ||'CNTR_NO:'          || CNTR_NO                              || CHR(10)" ).append("\n"); 
		query.append("      ||'BL_NO:'            || BL_NO                                || CHR(10)" ).append("\n"); 
		query.append("      ||'VSL_NM:'           || VSL_ENG_NM                           || CHR(10)" ).append("\n"); 
		query.append("      ||'VVD:'              || VVD                                  || CHR(10)" ).append("\n"); 
		query.append("      ||'CNTR_OPR:'         || CNTR_OPR                             || CHR(10)" ).append("\n"); 
		query.append("      ||'PARTY_CD:'         || PARTY_CD                             || CHR(10)" ).append("\n"); 
		query.append("      ||'LOLO_IND:'         || 'Y'                                  || CHR(10)" ).append("\n"); 
		query.append("      ||'SPE_CONF_CNTR_IND:'|| ''                                   || CHR(10)" ).append("\n"); 
		query.append("      ||'BOXCARE_IND:'      || ''                                   || CHR(10)" ).append("\n"); 
		query.append("      ||'EXPIRE_DATE:'      || ''                                   || CHR(10)" ).append("\n"); 
		query.append("      ||'DEPOT_CODE:'       || ''                                   || CHR(10)" ).append("\n"); 
		query.append("      ||'FREE_PERIOD:'      || ''                                   || CHR(10)" ).append("\n"); 
		query.append("      ||'REMARK:'           || ''                                   || CHR(10)" ).append("\n"); 
		query.append("      ||'}PSAEDO' || CHR(10)      " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("   ( " ).append("\n"); 
		query.append("        SELECT    nvl(@[recTp],'')                                    AS REC_TYPE" ).append("\n"); 
		query.append("                , BKGM.BL_NO                                          AS BL_NO" ).append("\n"); 
		query.append("                , BCNT.CNTR_NO                                        AS CNTR_NO" ).append("\n"); 
		query.append("                , UPPER(TRIM(VSL.PSA_VSL_NM))                         AS VSL_ENG_NM" ).append("\n"); 
		query.append("                , UPPER(TRIM(VSL.PSA_VOY_DIR_CD))                     AS VVD" ).append("\n"); 
		query.append("                , 'SM'                                 				  AS CNTR_OPR" ).append("\n"); 
		query.append("                , BKDR.CSTMS_ASGN_CTNT                       		  AS PARTY_CD" ).append("\n"); 
		query.append(" 				, ( SELECT /*+ INDEX_DESC(RLOG XPKBKG_PSA_EDO_RCV_LOG ) */ PSA_AUTH_NO" ).append("\n"); 
		query.append("                    FROM  BKG_PSA_EDO_RCV_LOG RLOG" ).append("\n"); 
		query.append("                    WHERE BL_NO=BCNT.BKG_NO" ).append("\n"); 
		query.append("                    AND   CNTR_NO=BCNT.CNTR_NO" ).append("\n"); 
		query.append("                    AND   ROWNUM = 1 ) 								   AS PSA_AUTH_NO" ).append("\n"); 
		query.append("        FROM   BKG_DO             BKDO" ).append("\n"); 
		query.append("             , BKG_DO_REF         BKDR" ).append("\n"); 
		query.append("             , BKG_BOOKING        BKGM" ).append("\n"); 
		query.append("             , BKG_CONTAINER      BCNT " ).append("\n"); 
		query.append("             , BKG_VVD            BVVD" ).append("\n"); 
		query.append("             , BKG_CSTMS_PSA_VVD  VSL" ).append("\n"); 
		query.append("        WHERE BKDO.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("        AND   BKDR.BKG_NO       = BKDO.BKG_NO" ).append("\n"); 
		query.append("        AND   BKGM.BKG_NO       = BKDO.BKG_NO" ).append("\n"); 
		query.append("        AND   BCNT.BKG_NO       = BKDO.BKG_NO" ).append("\n"); 
		query.append("        AND   BVVD.BKG_NO(+)    = BKGM.BKG_NO  " ).append("\n"); 
		query.append("        AND   BVVD.POD_CD(+)    = BKGM.POD_CD " ).append("\n"); 
		query.append("        AND   VSL.VSL_CD(+)     = BVVD.VSL_CD   " ).append("\n"); 
		query.append("        AND   VSL.SKD_VOY_NO(+) = BVVD.SKD_VOY_NO   " ).append("\n"); 
		query.append("        AND   VSL.SKD_DIR_CD(+) = BVVD.SKD_DIR_CD   " ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}