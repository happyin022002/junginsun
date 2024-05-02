/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCopManageDBDAOModifyTroMapgByCopUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.11.06 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifyTroMapgByCopUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COP No 로 SCE_TRO_MAPG 에 존재하는 정보를 update 한다.(BOOKING 정보 만을 시도)
	  * </pre>
	  */
	public BkgCopManageDBDAOModifyTroMapgByCopUSQL(){
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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration ").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifyTroMapgByCopUSQL").append("\n"); 
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
		query.append("UPDATE SCE_TRO_MAPG A" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("BKG_NO = NVL(@[bkg_no], A.BKG_NO)" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("COP_NO = @[cop_no]" ).append("\n"); 

	}
}