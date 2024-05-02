/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierRestrictionDBDAOCheckImdgTecNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.16 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierRestrictionDBDAOCheckImdgTecNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierRestrictionDBDAOCheckImdgTecNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration").append("\n"); 
		query.append("FileName : CarrierRestrictionDBDAOCheckImdgTecNmRSQL").append("\n"); 
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
		query.append("SELECT  'Y'" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO_ORG_RACT F" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("F.IMDG_TEC_NM IS NOT NULL" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '')" ).append("\n"); 
		query.append("AND F.IMDG_UN_NO     = @[imdg_un_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '')" ).append("\n"); 
		query.append("AND F.IMDG_UN_NO_SEQ =  @[imdg_un_no_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}