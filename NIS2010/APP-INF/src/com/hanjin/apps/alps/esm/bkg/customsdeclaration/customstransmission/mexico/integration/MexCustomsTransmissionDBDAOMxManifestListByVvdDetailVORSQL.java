/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOMxManifestListByVvdDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOMxManifestListByVvdDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MxManifestListByVvdDetailVO 생성을 위해 사용
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOMxManifestListByVvdDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration ").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOMxManifestListByVvdDetailVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("''POR_CD" ).append("\n"); 
		query.append(",''VSL_CD" ).append("\n"); 
		query.append(",''TS" ).append("\n"); 
		query.append(",''SND_DT" ).append("\n"); 
		query.append(",''BL_NO" ).append("\n"); 
		query.append(",''HOT_DE_FLG" ).append("\n"); 
		query.append(",''POL_CD" ).append("\n"); 
		query.append(",''USR_ID" ).append("\n"); 
		query.append(",''CPOD" ).append("\n"); 
		query.append(",''WGT_UT_CD" ).append("\n"); 
		query.append(",''PCK_QTY" ).append("\n"); 
		query.append(",''STWG_CD" ).append("\n"); 
		query.append(",''CPOL" ).append("\n"); 
		query.append(",''D" ).append("\n"); 
		query.append(",''FRT_TERM_CD" ).append("\n"); 
		query.append(",''DEL_CD" ).append("\n"); 
		query.append(",''SKD_VOY_NO" ).append("\n"); 
		query.append(",''SKD_DIR_CD" ).append("\n"); 
		query.append(",''ACT_WGT" ).append("\n"); 
		query.append(",''VVD" ).append("\n"); 
		query.append(",''POD_CD" ).append("\n"); 
		query.append(",''OFC_CD" ).append("\n"); 
		query.append(",''BKG_NO" ).append("\n"); 
		query.append(",''O_BL_NO" ).append("\n"); 
		query.append(",''R" ).append("\n"); 
		query.append(",''SEARCH_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}