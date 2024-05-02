/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchFdaInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.03 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchFdaInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchFdaInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchFdaInfoRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN fda_ind_count > 0 THEN	'Y'" ).append("\n"); 
		query.append("ELSE	'N'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT NVL(SUM(DECODE(PRIOR_NTC_SND_FLG, 'Y', 1, 0)), 0) fda_ind_count" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_CNTR_MF" ).append("\n"); 
		query.append("WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}