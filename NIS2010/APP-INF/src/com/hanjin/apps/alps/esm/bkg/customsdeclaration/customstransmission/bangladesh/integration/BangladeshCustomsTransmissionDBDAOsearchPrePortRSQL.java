/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BangladeshCustomsTransmissionDBDAOsearchPrePortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BangladeshCustomsTransmissionDBDAOsearchPrePortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 방글라데시 세관 신고용 Manifest Pre Port 정보를 조회한다.
	  * </pre>
	  */
	public BangladeshCustomsTransmissionDBDAOsearchPrePortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.integration").append("\n"); 
		query.append("FileName : BangladeshCustomsTransmissionDBDAOsearchPrePortRSQL").append("\n"); 
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
		query.append("SELECT NVL(VPS_PORT_CD, ' ') VPS_PORT_CD," ).append("\n"); 
		query.append("       NVL(TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD'),' ') VPS_ETD_DT,  --추가 요청으로 인한 수정" ).append("\n"); 
		query.append("       NVL(TO_CHAR(VPS_ETD_DT,'HH24:MI'),' ') VPS_ETD_TM   --추가 요청으로 인한 수정" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    CLPT_SEQ  = (SELECT  MAX(CLPT_SEQ) -1" ).append("\n"); 
		query.append("                    FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                    WHERE   VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("                    AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                    AND     SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("                    AND     VPS_PORT_CD    = @[pod_cd]" ).append("\n"); 
		query.append("                    AND     NVL(SKD_CNG_STS_CD,' ') <> 'S')" ).append("\n"); 

	}
}