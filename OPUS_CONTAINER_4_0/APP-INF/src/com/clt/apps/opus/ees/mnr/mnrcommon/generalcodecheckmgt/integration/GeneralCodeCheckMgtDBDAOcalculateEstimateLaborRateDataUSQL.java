/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOcalculateEstimateLaborRateDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOcalculateEstimateLaborRateDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * calculateEstimateLaborRateData
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOcalculateEstimateLaborRateDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOcalculateEstimateLaborRateDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DAT_VRFY A" ).append("\n"); 
		query.append("SET (A.INP_MSG18, A.INP_MSG37)" ).append("\n"); 
		query.append("    = ( SELECT NVL(MAR.AGMT_RT_AMT, 0), 'Y'||(CASE WHEN (SELECT MNR_CD_DESC FROM MNR_GEN_CD" ).append("\n"); 
		query.append("                    WHERE PRNT_CD_ID ='CD00096'" ).append("\n"); 
		query.append("                    AND   MNR_CD_ID='TC' ) = 'N' " ).append("\n"); 
		query.append("              THEN 'YY'" ).append("\n"); 
		query.append("              ELSE 'NN'" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        FROM MNR_AGMT_HDR MAH, MNR_AGMT_RT MAR" ).append("\n"); 
		query.append("        WHERE A.INP_MSG35              = MAH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND   A.INP_MSG36              = MAH.AGMT_SEQ" ).append("\n"); 
		query.append("        AND   MAH.AGMT_LST_VER_FLG     = 'Y'" ).append("\n"); 
		query.append("        AND   MAH.AGMT_OFC_CTY_CD      = MAR.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND   MAH.AGMT_SEQ             = MAR.AGMT_SEQ" ).append("\n"); 
		query.append("        AND   MAH.AGMT_VER_NO          = MAR.AGMT_VER_NO" ).append("\n"); 
		query.append("        AND   A.INP_MSG19              = MAR.COST_CD(+)" ).append("\n"); 
		query.append("        AND   A.INP_MSG20              = MAR.COST_DTL_CD(+)" ).append("\n"); 
		query.append("        AND   ROWNUM =1" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND   A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("AND   EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("  FROM MNR_AGMT_HDR MAH, MNR_AGMT_RT MAR" ).append("\n"); 
		query.append("  WHERE A.INP_MSG35              = MAH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND   A.INP_MSG36              = MAH.AGMT_SEQ" ).append("\n"); 
		query.append("  AND   MAH.AGMT_LST_VER_FLG     = 'Y'" ).append("\n"); 
		query.append("  AND   MAH.AGMT_OFC_CTY_CD      = MAR.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND   MAH.AGMT_SEQ             = MAR.AGMT_SEQ" ).append("\n"); 
		query.append("  AND   MAH.AGMT_VER_NO          = MAR.AGMT_VER_NO" ).append("\n"); 
		query.append("  AND   A.INP_MSG19              = MAR.COST_CD(+)" ).append("\n"); 
		query.append("  AND   A.INP_MSG20              = MAR.COST_DTL_CD(+)" ).append("\n"); 
		query.append("  AND   ROWNUM =1" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}