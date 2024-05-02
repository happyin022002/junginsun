/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TMNL Agmt DTL seq. 생성 및 조회
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlSeqRSQL").append("\n"); 
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
		query.append("SELECT	NVL(MAX(DRFF_CHG_TRF_DTL_SEQ),0)+1 MAX_SEQ" ).append("\n"); 
		query.append("FROM	EAS_DRFF_CHG_TRF_DTL " ).append("\n"); 
		query.append("WHERE	DRFF_CHG_TRF_SEQ = @[drff_chg_trf_seq]" ).append("\n"); 
		query.append("and DRFF_CHG_TRF_VER_NO = @[drff_chg_ver_no]" ).append("\n"); 

	}
}