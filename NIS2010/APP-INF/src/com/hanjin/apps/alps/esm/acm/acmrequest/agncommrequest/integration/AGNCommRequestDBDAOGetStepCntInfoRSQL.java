/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetStepCntInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.01
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.01 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetStepCntInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetStepCntInfo
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetStepCntInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration ").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOGetStepCntInfoRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS STEP_CNT" ).append("\n"); 
		query.append("FROM  ACM_AGN_COMM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   BKG_NO    = @[bkg_no]" ).append("\n"); 
		query.append("AND   AGN_CD    = @[agn_cd]" ).append("\n"); 
		query.append("AND   IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND   AC_TP_CD  = @[ac_tp_cd]" ).append("\n"); 
		query.append("AND   AC_STS_CD IN ('CS','RS','AS','PS','IF')" ).append("\n"); 

	}
}