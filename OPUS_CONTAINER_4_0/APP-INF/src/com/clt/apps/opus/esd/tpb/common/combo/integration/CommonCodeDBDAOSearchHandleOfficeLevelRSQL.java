/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonCodeDBDAOSearchHandleOfficeLevelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchHandleOfficeLevelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchHandleOfficeLevel
	  * </pre>
	  */
	public CommonCodeDBDAOSearchHandleOfficeLevelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchHandleOfficeLevelRSQL").append("\n"); 
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
		query.append("SELECT office_level, " ).append("\n"); 
		query.append("       ofc_cd, " ).append("\n"); 
		query.append("       rhq_cd, " ).append("\n"); 
		query.append("       ho_cd," ).append("\n"); 
		query.append("       DECODE( office_level, 'C', (SELECT DISTINCT A.n3pty_ofc_tp_cd FROM TPB_HNDL_OFC A WHERE A.ofc_cd = ofc_cd AND n3pty_ofc_tp_cd = 'T' AND delt_flg='N') ) AS priv_cd" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("       ----- HO - MDM -----" ).append("\n"); 
		query.append("       SELECT 'H' AS office_level, ofc_cd, NULL AS rhq_cd, ofc_cd AS ho_cd" ).append("\n"); 
		query.append("         FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND ofc_knd_cd = '1'" ).append("\n"); 
		query.append("          AND delt_flg = 'N'" ).append("\n"); 
		query.append("          AND ofc_cd = @[s_ofc_cd]" ).append("\n"); 
		query.append("       -----" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       ----- HO -----" ).append("\n"); 
		query.append("       SELECT n3pty_ofc_tp_cd AS office_level, ofc_cd, NULL AS rhq_cd, ofc_cd AS ho_cd" ).append("\n"); 
		query.append("         FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND n3pty_ofc_tp_cd IN ('H')" ).append("\n"); 
		query.append("          AND delt_flg = 'N'" ).append("\n"); 
		query.append("          AND ofc_cd = @[s_ofc_cd]" ).append("\n"); 
		query.append("       -----" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       ----- RHQ - R-----" ).append("\n"); 
		query.append("       SELECT n3pty_ofc_tp_cd AS office_level, ofc_cd, ofc_cd AS rhq_cd, ofc_cd AS ho_cd" ).append("\n"); 
		query.append("         FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND n3pty_ofc_tp_cd IN ('R')" ).append("\n"); 
		query.append("          AND delt_flg = 'N'" ).append("\n"); 
		query.append("          AND ofc_cd = @[s_ofc_cd]" ).append("\n"); 
		query.append("       -----" ).append("\n"); 
		query.append("--       UNION ALL" ).append("\n"); 
		query.append("       ----- RHQ - S  -----" ).append("\n"); 
		query.append("--       SELECT 'R' AS office_level, ofc_cd, rhq_cd AS rhq_cd, ofc_cd AS ho_cd" ).append("\n"); 
		query.append("--         FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("--        WHERE 1=1" ).append("\n"); 
		query.append("--          AND n3pty_ofc_tp_cd IN ('S')" ).append("\n"); 
		query.append("--          AND delt_flg = 'N'" ).append("\n"); 
		query.append("--		  AND ofc_cd = [s_ofc_cd]" ).append("\n"); 
		query.append("#if (${isIncludeControlOffice})" ).append("\n"); 
		query.append("       -----" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       ----- CONTROL -----" ).append("\n"); 
		query.append("       SELECT n3pty_ofc_tp_cd AS office_level, " ).append("\n"); 
		query.append("              ofc_cd," ).append("\n"); 
		query.append("              (SELECT rhq_cd FROM TPB_HNDL_OFC WHERE rhq_cd IS NOT NULL AND ofc_cd = HN.ofc_cd  AND delt_flg='N') AS rhq_cd," ).append("\n"); 
		query.append("              NULL AS ho_cd" ).append("\n"); 
		query.append("         FROM TPB_HNDL_OFC HN" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND n3pty_ofc_tp_cd = 'C'" ).append("\n"); 
		query.append("          AND delt_flg = 'N'" ).append("\n"); 
		query.append("          AND ofc_cd = @[s_ofc_cd]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("       -----" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       ----- TPB Office -----" ).append("\n"); 
		query.append("       SELECT n3pty_ofc_tp_cd AS office_level, " ).append("\n"); 
		query.append("              ofc_cd," ).append("\n"); 
		query.append("              rhq_cd," ).append("\n"); 
		query.append("              NULL AS ho_cd" ).append("\n"); 
		query.append("         FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND n3pty_ofc_tp_cd = 'T'" ).append("\n"); 
		query.append("          AND delt_flg = 'N'" ).append("\n"); 
		query.append("          AND ofc_cd = @[s_ofc_cd]" ).append("\n"); 
		query.append("       -----" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       ----- General Office -----" ).append("\n"); 
		query.append("       SELECT n3pty_ofc_tp_cd AS office_level, ofc_cd, rhq_cd, NULL AS ho_cd" ).append("\n"); 
		query.append("         FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND n3pty_ofc_tp_cd = 'G'" ).append("\n"); 
		query.append("          AND delt_flg = 'N'" ).append("\n"); 
		query.append("          AND ofc_cd = @[s_ofc_cd]" ).append("\n"); 
		query.append("       ) H" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append(" ORDER BY DECODE(office_level, 'H',1,'R',2,'S',3,'C',4,'T',5,'G',9)" ).append("\n"); 

	}
}