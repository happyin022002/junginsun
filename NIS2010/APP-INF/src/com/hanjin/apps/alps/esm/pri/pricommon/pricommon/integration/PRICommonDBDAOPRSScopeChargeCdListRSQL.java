/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAOPRSScopeChargeCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.10.12 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOPRSScopeChargeCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * scope 별 surcharge 리스트 조회
	  * </pre>
	  */
	public PRICommonDBDAOPRSScopeChargeCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOPRSScopeChargeCdListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A1.CHG_CD AS CD" ).append("\n"); 
		query.append(",      B1.CHG_NM AS NM" ).append("\n"); 
		query.append("FROM   PRI_SCG_PRF A1" ).append("\n"); 
		query.append(",      MDM_CHARGE B1" ).append("\n"); 
		query.append("WHERE  A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${etc1} != '')" ).append("\n"); 
		query.append("AND    A1.SVC_SCP_CD = @[etc1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    A1.CHG_CD IN ('BUC','BAF','FRC','IFC','IFM','IFR','PSC','PSS')" ).append("\n"); 
		query.append("AND    B1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER  BY A1.CHG_CD" ).append("\n"); 

	}
}