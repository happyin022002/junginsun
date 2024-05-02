/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOModifyTroMapgByNewSeqVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.30 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifyTroMapgByNewSeqVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking 에서 전달한 CombinedNewTroVO 로 SCE_TRO_MAPG 을 정리한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOModifyTroMapgByNewSeqVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifyTroMapgByNewSeqVOUSQL").append("\n"); 
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
		query.append("UPDATE SCE_TRO_MAPG" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("BKG_NO = @[new_bkg_no]," ).append("\n"); 
		query.append("TRO_SEQ = @[new_tro_seq]" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("BKG_NO = @[org_bkg_no]" ).append("\n"); 
		query.append("AND TRO_SEQ = @[org_tro_seq]" ).append("\n"); 

	}
}