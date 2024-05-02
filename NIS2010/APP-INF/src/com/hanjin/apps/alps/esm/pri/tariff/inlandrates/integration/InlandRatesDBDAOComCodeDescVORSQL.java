/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAOComCodeDescVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.14 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRatesDBDAOComCodeDescVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 공통코드 존재유무 체크
	  * </pre>
	  */
	public InlandRatesDBDAOComCodeDescVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration ").append("\n"); 
		query.append("FileName : InlandRatesDBDAOComCodeDescVORSQL").append("\n"); 
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
		query.append("SELECT INTG_CD_VAL_CTNT CD" ).append("\n"); 
		query.append("  	 , INTG_CD_VAL_DP_DESC NM" ).append("\n"); 
		query.append("  FROM NISADM.COM_INTG_CD_DTL" ).append("\n"); 
		query.append(" WHERE INTG_CD_ID = @[etc3]" ).append("\n"); 
		query.append("   AND INTG_CD_VAL_CTNT = @[cd]" ).append("\n"); 

	}
}