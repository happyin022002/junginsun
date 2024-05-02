/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchEstimateAGMTDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.27
*@LastModifier : 신혜정
*@LastVersion : 1.0
* 2012.06.27 
* 1.0 Creation
--------------------------------------------------------
* History
* 2012.06.15 신혜정 [CHM-201218436] [Calculation] 버튼 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchEstimateAGMTDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEstimateAGMTData
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchEstimateAGMTDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchEstimateAGMTDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	, C.AGMT_SEQ" ).append("\n"); 
		query.append("	, C.AGMT_VER_NO" ).append("\n"); 
		query.append("	, C.TRF_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		ROW_NUMBER() OVER (ORDER BY A.AGMT_SEQ DESC) ROWNM" ).append("\n"); 
		query.append("		, A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		, A.AGMT_SEQ" ).append("\n"); 
		query.append("		, A.AGMT_VER_NO" ).append("\n"); 
		query.append("		, A.TRF_NO" ).append("\n"); 
		query.append("	FROM MNR_AGMT_HDR A,MNR_PARTNER D" ).append("\n"); 
		query.append("	WHERE " ).append("\n"); 
		query.append("		A.AGMT_LST_VER_FLG = 'Y' " ).append("\n"); 
		query.append("		AND D.MNR_GRP_TP_CD = 'RPR' " ).append("\n"); 
		query.append("		AND D.MNR_PRNR_SEQ = A.VNDR_SEQ  " ).append("\n"); 
		query.append("		AND D.CTRL_OFC_CD = A.AGMT_OFC_CD " ).append("\n"); 
		query.append("		AND D.EDI_ID = @[edi_id]" ).append("\n"); 
		query.append("		AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("	) C" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	ROWNM = 1" ).append("\n"); 

	}
}