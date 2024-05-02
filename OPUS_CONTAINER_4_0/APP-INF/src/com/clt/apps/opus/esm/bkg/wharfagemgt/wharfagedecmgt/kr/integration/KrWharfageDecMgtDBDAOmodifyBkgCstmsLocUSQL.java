/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOmodifyBkgCstmsLocUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.08.11 정재엽
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOmodifyBkgCstmsLocUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * U
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOmodifyBkgCstmsLocUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oun_loc_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("un_loc_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oloc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOmodifyBkgCstmsLocUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_LOC" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("LOC_CD     = @[loc_cd]," ).append("\n"); 
		query.append("UN_LOC_ID  = @[un_loc_id]," ).append("\n"); 
		query.append("UPD_USR_ID = @[cre_usr_id]," ).append("\n"); 
		query.append("UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CNT_CD       = 'KR'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID = 'WHF'" ).append("\n"); 
		query.append("AND LOC_CD    = @[oloc_cd]" ).append("\n"); 
		query.append("AND UN_LOC_ID = @[oun_loc_id]" ).append("\n"); 

	}
}