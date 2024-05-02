/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualCntrlMappDBDAOSearchCopMapgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.10.20 오현경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualCntrlMappDBDAOSearchCopMapgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCopMapgList
	  * </pre>
	  */
	public ManualCntrlMappDBDAOSearchCopMapgListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.integration").append("\n"); 
		query.append("FileName : ManualCntrlMappDBDAOSearchCopMapgListRSQL").append("\n"); 
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
		query.append("SELECT cop_no, bkg_no, cntr_no, cntr_tpsz_cd, TO_CHAR( upd_dt , 'YYYY/MM/DD HH24:MI:SS') upd_dt" ).append("\n"); 
		query.append("FROM sce_cop_hdr" ).append("\n"); 
		query.append("WHERE  (bkg_no, cntr_no, cntr_tpsz_cd) IN (( @[bkg_no], @[cntr_no], @[cntr_tpsz_cd]))" ).append("\n"); 

	}
}