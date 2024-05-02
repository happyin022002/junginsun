/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyCalculateEstimateResultNtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyCalculateEstimateResultNtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyCalculateEstimateResultNt
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyCalculateEstimateResultNtUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyCalculateEstimateResultNtUSQL").append("\n"); 
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
		query.append("UPDATE   MNR_DAT_VRFY B" ).append("\n"); 
		query.append("SET      INP_MSG4 =" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   DECODE(TRF_CHK_0||TRF_CHK_1||TRF_CHK_2||TRF_CHK_3||TRF_CHK_4, '00000', 'LN', '10000', 'LC', '11000', 'LR', '11000', 'LD','LZ')" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   TMP_DTL_SEQ AS AAAA" ).append("\n"); 
		query.append("                             , NVL((" ).append("\n"); 
		query.append("                                     SELECT   1 AS TRF_CHK_0" ).append("\n"); 
		query.append("                                     FROM     MNR_AGMT_HDR MAH" ).append("\n"); 
		query.append("                                     WHERE    1 = 1" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG35 = MAH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG36 = MAH.AGMT_SEQ" ).append("\n"); 
		query.append("                                     AND      MAH.AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("                                     AND      A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG4 = 'NT'" ).append("\n"); 
		query.append("                                     AND      MAH.TRF_NO IS NOT NULL" ).append("\n"); 
		query.append("                                     GROUP BY TMP_DTL_SEQ" ).append("\n"); 
		query.append("                               ), 0) AS TRF_CHK_0" ).append("\n"); 
		query.append("                             , NVL((" ).append("\n"); 
		query.append("                                     SELECT   1 AS TRF_CHK_1" ).append("\n"); 
		query.append("                                     FROM     MNR_AGMT_HDR MAH" ).append("\n"); 
		query.append("                                            , MNR_RPR_TRF_DTL MRTD" ).append("\n"); 
		query.append("                                     WHERE    1 = 1" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG35 = MAH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG36 = MAH.AGMT_SEQ" ).append("\n"); 
		query.append("                                     AND      MAH.AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("                                     AND      MAH.TRF_NO = MRTD.TRF_NO" ).append("\n"); 
		query.append("                                     AND      SUBSTRB(A.INP_MSG19, 1, 3) = SUBSTR(MRTD.COST_GRP_CD, 1, 3)" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG2 = MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                                     AND      A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG4 = 'NT'" ).append("\n"); 
		query.append("                                     GROUP BY TMP_DTL_SEQ" ).append("\n"); 
		query.append("                               ), 0) AS TRF_CHK_1" ).append("\n"); 
		query.append("                             , NVL((" ).append("\n"); 
		query.append("                                     SELECT   1 AS TRF_CHK_2" ).append("\n"); 
		query.append("                                     FROM     MNR_AGMT_HDR MAH" ).append("\n"); 
		query.append("                                            , MNR_RPR_TRF_DTL MRTD" ).append("\n"); 
		query.append("                                     WHERE    1 = 1" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG35 = MAH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG36 = MAH.AGMT_SEQ" ).append("\n"); 
		query.append("                                     AND      MAH.AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("                                     AND      MAH.TRF_NO = MRTD.TRF_NO" ).append("\n"); 
		query.append("                                     AND      SUBSTRB(A.INP_MSG19, 1, 3) = SUBSTR(MRTD.COST_GRP_CD, 1, 3)" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG2 = MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG5 = MRTD.EQ_RPR_CD" ).append("\n"); 
		query.append("                                     AND      A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG4 = 'NT'" ).append("\n"); 
		query.append("                                     GROUP BY TMP_DTL_SEQ" ).append("\n"); 
		query.append("                               ), 0) AS TRF_CHK_2" ).append("\n"); 
		query.append("                             , NVL((" ).append("\n"); 
		query.append("                                     SELECT   1 AS TRF_CHK_2" ).append("\n"); 
		query.append("                                     FROM     MNR_AGMT_HDR MAH" ).append("\n"); 
		query.append("                                            , MNR_RPR_TRF_DTL MRTD" ).append("\n"); 
		query.append("                                     WHERE    1 = 1" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG35 = MAH.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG36 = MAH.AGMT_SEQ" ).append("\n"); 
		query.append("                                     AND      MAH.AGMT_LST_VER_FLG = 'Y'" ).append("\n"); 
		query.append("                                     AND      MAH.TRF_NO = MRTD.TRF_NO" ).append("\n"); 
		query.append("                                     AND      SUBSTRB(A.INP_MSG19, 1, 3) = SUBSTR(MRTD.COST_GRP_CD, 1, 3)" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG2 = MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG5 = MRTD.EQ_RPR_CD" ).append("\n"); 
		query.append("                                     AND      A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("                                     AND      A.INP_MSG4 = 'NT'" ).append("\n"); 
		query.append("                                     AND      NVL(RTRIM(A.INP_MSG7), 'XXXX') = NVL(RTRIM(MRTD.TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("                                     GROUP BY TMP_DTL_SEQ" ).append("\n"); 
		query.append("                               ), 0) AS TRF_CHK_3" ).append("\n"); 
		query.append("                             , 0 AS TRF_CHK_4" ).append("\n"); 
		query.append("                      FROM     MNR_DAT_VRFY A" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("                      AND      A.INP_MSG4 = 'NT'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      B.TMP_DTL_SEQ = AAAA" ).append("\n"); 
		query.append("           AND      B.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("           AND      B.INP_MSG4 = 'NT'" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      B.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND      B.INP_MSG4 = 'NT'" ).append("\n"); 

	}
}