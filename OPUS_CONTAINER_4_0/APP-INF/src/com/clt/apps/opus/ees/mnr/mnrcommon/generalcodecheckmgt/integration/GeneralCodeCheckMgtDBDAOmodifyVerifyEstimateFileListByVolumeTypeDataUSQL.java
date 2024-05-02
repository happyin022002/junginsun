/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByVolumeTypeDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.20
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2010.02.20 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByVolumeTypeDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyVerifyEstimateFileListByVolumeTypeData
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByVolumeTypeDataUSQL(){
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
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByVolumeTypeDataUSQL").append("\n"); 
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
		query.append("SET A.INP_MSG4 = 'VT'" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM MNR_RPR_TRF_HDR MRTH," ).append("\n"); 
		query.append("MNR_RPR_TRF_DTL MRTD" ).append("\n"); 
		query.append("WHERE MRTH.TRF_NO = MRTD.TRF_NO" ).append("\n"); 
		query.append("AND   MRTH.TRF_NO IN (" ).append("\n"); 
		query.append("SELECT MAX(MRTH.TRF_NO)" ).append("\n"); 
		query.append("FROM MNR_RPR_TRF_HDR MRTH" ).append("\n"); 
		query.append("WHERE MRTH.MNR_TRF_KND_CD = 'STD'" ).append("\n"); 
		query.append("AND MRTH.MNR_TRF_STS_CD = 'HA'" ).append("\n"); 
		query.append("AND TO_CHAR(MRTH.EFF_DT, 'YYYYMMDD') <= TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append("GROUP BY MRTH.EQ_KND_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SUBSTRB(A.INP_MSG19, 1, 3) = SUBSTR(MRTD.COST_GRP_CD, 1, 3)" ).append("\n"); 
		query.append("AND A.INP_MSG2 = MRTD.EQ_CMPO_CD" ).append("\n"); 
		query.append("AND A.INP_MSG5 = MRTD.EQ_RPR_CD" ).append("\n"); 
		query.append("AND NVL(RTRIM(A.INP_MSG7), 'XXXX') = NVL(RTRIM(MRTD.TRF_DIV_CD), 'XXXX')" ).append("\n"); 
		query.append("AND   A.INP_MSG8                   <> MRTD.VOL_TP_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}