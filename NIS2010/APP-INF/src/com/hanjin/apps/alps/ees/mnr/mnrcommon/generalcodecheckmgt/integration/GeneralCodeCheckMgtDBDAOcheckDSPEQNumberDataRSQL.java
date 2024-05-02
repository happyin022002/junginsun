/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOcheckDSPEQNumberDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.29 
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

public class GeneralCodeCheckMgtDBDAOcheckDSPEQNumberDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkDSPEQNumberData
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOcheckDSPEQNumberDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOcheckDSPEQNumberDataRSQL").append("\n"); 
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
		query.append("SELECT ESV.EQ_NO AS CD_ID," ).append("\n"); 
		query.append("NVL((SELECT 'Aleady Diposal Processed'" ).append("\n"); 
		query.append("FROM MNR_DISP_DTL MDD,MNR_DISP_HDR MDH" ).append("\n"); 
		query.append("WHERE MDD.EQ_NO = ESV.EQ_NO" ).append("\n"); 
		query.append("AND MDD.DISP_NO = MDH.DISP_NO" ).append("\n"); 
		query.append("AND MDH.DISP_STS_CD <> 'HD'" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("#if(${disp_no} != 'NEW' && ${disp_no} != '')" ).append("\n"); 
		query.append("AND MDD.DISP_NO <> @[disp_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("), 'OK') AS CD_DESC" ).append("\n"); 
		query.append("FROM MNR_EQ_STS_V ESV" ).append("\n"); 
		query.append("WHERE ESV.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND ESV.EQ_TYPE = @[eq_type]" ).append("\n"); 
		query.append("#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND ESV.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ESV.DSP_SEL_FLAG = 'Y'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}