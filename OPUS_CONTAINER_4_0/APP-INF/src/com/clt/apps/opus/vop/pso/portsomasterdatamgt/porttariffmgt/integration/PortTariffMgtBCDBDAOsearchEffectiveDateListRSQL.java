/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchEffectiveDateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchEffectiveDateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pso_yd_charge_xpr의 version정보를 조회한다.
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchEffectiveDateListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("combo1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchEffectiveDateListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.YD_CHG_NO" ).append("\n"); 
		query.append("     , TRIM(TO_CHAR(A.YD_CHG_VER_SEQ, '000')) VER" ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.CPLS_FLG" ).append("\n"); 
		query.append("     , A.ORG_VNDR_NM" ).append("\n"); 
		query.append("     , (SELECT DECODE(COUNT(D.ISS_CTY_CD),0,'','Y')" ).append("\n"); 
		query.append("          FROM PSO_CHG_DTL D" ).append("\n"); 
		query.append("         WHERE D.YD_CHG_NO = A.YD_CHG_NO" ).append("\n"); 
		query.append("           AND D.YD_CHG_VER_SEQ = A.YD_CHG_VER_SEQ) AS ISS_CTY_CD" ).append("\n"); 
		query.append("     , C.UPD_MNU_NO" ).append("\n"); 
		query.append("  FROM PSO_YD_CHG A" ).append("\n"); 
		query.append("     , PSO_YD_CHG_XPR B" ).append("\n"); 
		query.append("     , PSO_CHG_XPR C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.YD_CD              = @[port_cd] || @[combo1]" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append("#if(${acct_cd} == '')" ).append("\n"); 
		query.append("   AND A.LGS_COST_CD        = @[combo3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.YD_CHG_NO          = B.YD_CHG_NO" ).append("\n"); 
		query.append("   AND A.YD_CHG_VER_SEQ     = B.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("   AND C.CHG_XPR_NO         = B.CHG_XPR_NO" ).append("\n"); 
		query.append("#if(${year} != '')" ).append("\n"); 
		query.append("   AND A.EFF_DT <= TO_DATE(LPAD(${year}, 4, 0) || '1231', 'YYYYMMDD')    -- end_dt" ).append("\n"); 
		query.append("   AND A.EXP_DT >= TO_DATE(LPAD(${year}, 4, 0) || '0101', 'YYYYMMDD')    -- start_dt" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B.PSO_CHG_TP_CD      = 'B'" ).append("\n"); 
		query.append("   AND C.UPD_MNU_NO = DECODE(@[uid], '0002', 1, '0004', 2, C.UPD_MNU_NO)	-- 2016.11.22 Add 2번화면:1, 4번화면:2" ).append("\n"); 
		query.append(" ORDER BY 3 DESC, 2 DESC" ).append("\n"); 

	}
}