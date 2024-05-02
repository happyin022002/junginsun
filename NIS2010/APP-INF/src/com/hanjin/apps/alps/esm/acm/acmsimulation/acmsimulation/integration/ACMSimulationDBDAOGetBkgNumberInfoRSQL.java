/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSimulationDBDAOGetBkgNumberInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.12
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.12.12 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOGetBkgNumberInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getting BkgNumberInfo
	  * </pre>
	  */
	public ACMSimulationDBDAOGetBkgNumberInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration ").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOGetBkgNumberInfoRSQL").append("\n"); 
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
		query.append("SELECT D.BL_CVRD_TP_CD" ).append("\n"); 
		query.append("     , DECODE(NVL(D.BL_CVRD_TP_CD,'M'),'C',D.MST_CVRD_BL_NO,D.BKG_NO) AS MST_BKG_NO " ).append("\n"); 
		query.append(" 	 , B.BKG_STS_CD" ).append("\n"); 
		query.append("FROM BKG_BL_DOC D, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE D.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   D.BKG_NO = B.BKG_NO" ).append("\n"); 

	}
}