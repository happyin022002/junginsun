/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOCheckNotPermitLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOCheckNotPermitLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MTY BKG 의 POL/POD 가 금지된 지역인지 확인
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOCheckNotPermitLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("load_disc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOCheckNotPermitLocationRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' " ).append("\n"); 
		query.append("                              ELSE 'N'" ).append("\n"); 
		query.append("       END CHK_RESULT " ).append("\n"); 
		query.append("FROM EQR_CTRL_ROUT_SET " ).append("\n"); 
		query.append("WHERE LODG_DCHG_DIV_CD = @[load_disc]" ).append("\n"); 
		query.append("AND   LOC_CD = ( SELECT LOC_CD FROM MDM_YARD WHERE YD_CD = @[yard_cd] AND ROWNUM=1 )" ).append("\n"); 
		query.append("#if(${load_disc} == 'L') -- LOAD" ).append("\n"); 
		query.append("AND MTY_BKG_DSABIL_FLG = 'Y'  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${load_disc} == 'D') -- DISC " ).append("\n"); 
		query.append("AND MTY_SPLIT_BKG_DSABIL_FLG ='Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   0 = (   -- TYPE SIZE 존재하면 MTY BKG 생성 허용된다" ).append("\n"); 
		query.append("              SELECT COUNT(1)" ).append("\n"); 
		query.append("              FROM EQR_CTRL_ROUT_SET_TP_SZ" ).append("\n"); 
		query.append("              WHERE LODG_DCHG_DIV_CD = @[load_disc]" ).append("\n"); 
		query.append("              AND   LOC_CD           = ( SELECT LOC_CD FROM MDM_YARD WHERE YD_CD = @[yard_cd] AND ROWNUM=1)" ).append("\n"); 
		query.append("          )" ).append("\n"); 

	}
}