/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOcheckVGMMinMaxRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOcheckVGMMinMaxRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VGM Min, Max check
	  * </pre>
	  */
	public BLDocumentationCMDBDAOcheckVGMMinMaxRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp_sz",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOcheckVGMMinMaxRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN TO_NUMBER(@[vgm_wgt_qty]) BETWEEN TO_NUMBER(ATTR_CTNT2) AND TO_NUMBER(ATTR_CTNT3) THEN 'Y' " ).append("\n"); 
		query.append("		    WHEN TO_NUMBER(@[vgm_wgt_qty]) < TO_NUMBER(ATTR_CTNT2) THEN 'MIN'" ).append("\n"); 
		query.append("			WHEN TO_NUMBER(@[vgm_wgt_qty]) > TO_NUMBER(ATTR_CTNT3) THEN 'MAX'" ).append("\n"); 
		query.append("		ELSE 'N' END FLG" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append(" WHERE HRD_CDG_ID ='VGM_MAX_MIN'" ).append("\n"); 
		query.append("    AND HRD.ATTR_CTNT1 = @[cntr_tp_sz]" ).append("\n"); 
		query.append("    AND HRD.ATTR_CTNT4 = DECODE(@[vgm_wgt_ut_cd],'KGM','KGS','LBR','LBS',@[vgm_wgt_ut_cd])" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 

	}
}