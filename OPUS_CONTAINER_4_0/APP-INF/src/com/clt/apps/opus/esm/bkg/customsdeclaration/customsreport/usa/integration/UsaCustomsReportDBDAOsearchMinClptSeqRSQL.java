/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchMinClptSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.21 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchMinClptSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMinClptSeq
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchMinClptSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mbl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ams_file_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchMinClptSeqRSQL").append("\n"); 
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
		query.append("SELECT MIN(CLPT_SEQ) AS CLPT_SEQ" ).append("\n"); 
		query.append(",VSL.VSL_CD" ).append("\n"); 
		query.append(",VSL.SKD_VOY_NO" ).append("\n"); 
		query.append(",VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BKG.BKG_NO" ).append("\n"); 
		query.append(",BKG.BL_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${mbl_no} != '')" ).append("\n"); 
		query.append("AND BKG.BL_NO = @[mbl_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${ams_file_no} != '')" ).append("\n"); 
		query.append("AND BKG.BL_NO = @[ams_file_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT BKG.BKG_NO" ).append("\n"); 
		query.append(",HBL.CNTR_MF_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append(",BKG_HBL HBL" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = HBL.BKG_NO" ).append("\n"); 
		query.append("#if (${mbl_no} != '')" ).append("\n"); 
		query.append("AND BKG.BL_NO = @[mbl_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${ams_file_no} != '')" ).append("\n"); 
		query.append("AND HBL.BKG_NO > ' '" ).append("\n"); 
		query.append("AND HBL.CNTR_MF_NO = @[ams_file_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") BKG" ).append("\n"); 
		query.append(",BKG_VVD VVD" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD VSL" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND VVD.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VSL.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("AND VSL.VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND VVD.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol} != '')" ).append("\n"); 
		query.append("AND VVD.POL_CD = @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("AND VVD.POD_CD = @[pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY VSL.VSL_CD, VSL.SKD_VOY_NO, VSL.SKD_DIR_CD" ).append("\n"); 

	}
}