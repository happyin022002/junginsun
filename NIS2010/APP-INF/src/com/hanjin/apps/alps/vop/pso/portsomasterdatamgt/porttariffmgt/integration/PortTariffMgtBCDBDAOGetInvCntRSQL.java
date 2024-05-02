/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOGetInvCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.13
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2014.03.13 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE YOUNJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOGetInvCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Delete 버튼 클릭 후 해당 row 의 Invoice 수를 체크한다.
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOGetInvCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOGetInvCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) INV_CNT " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT B.ISS_CTY_CD,B.SO_SEQ" ).append("\n"); 
		query.append("	  FROM PSO_YD_CHG A, PSO_CHARGE B, PSO_CHG_DTL C" ).append("\n"); 
		query.append("	 WHERE 1=1" ).append("\n"); 
		query.append("	   AND A.YD_CHG_NO      = @[yd_chg_no]" ).append("\n"); 
		query.append("	   AND A.YD_CHG_VER_SEQ = @[yd_chg_ver_seq]" ).append("\n"); 
		query.append("	   AND A.YD_CHG_NO      = C.YD_CHG_NO " ).append("\n"); 
		query.append("	   AND A.YD_CHG_VER_SEQ = C.YD_CHG_VER_SEQ " ).append("\n"); 
		query.append("	   AND C.ISS_CTY_CD     = B.ISS_CTY_CD" ).append("\n"); 
		query.append("	   AND C.SO_SEQ         = B.SO_SEQ" ).append("\n"); 
		query.append("	GROUP BY B.ISS_CTY_CD,B.SO_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}