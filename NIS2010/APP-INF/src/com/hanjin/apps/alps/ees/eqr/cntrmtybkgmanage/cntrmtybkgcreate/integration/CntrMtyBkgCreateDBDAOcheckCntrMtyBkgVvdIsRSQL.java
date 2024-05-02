/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOcheckCntrMtyBkgVvdIsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.08.21 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOcheckCntrMtyBkgVvdIsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_EQR_1018 화면
	  * VSK_VSL_SKD 테이블에 해당 VVD 가 존재 하는지 체크함
	  * T: VVD 존재, F: VVD 미존재
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOcheckCntrMtyBkgVvdIsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration ").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOcheckCntrMtyBkgVvdIsRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("--  VVD 가 VSL SKD 에 존재하는지 확인" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--  변수 : vvd   (ANGN3309E)" ).append("\n"); 
		query.append("--  검색된 lane 을 그대로 vps_lane_cd 에 입력" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--  반환 : T: VVD 존재, F: VVD 미존재" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DECODE(COUNT(1),'0','F','T') VVD_IS" ).append("\n"); 
		query.append("FROM   VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD      = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("AND    SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND    SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 

	}
}