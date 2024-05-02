/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchFocFlgForBlMultiSndRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchFocFlgForBlMultiSndRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Us cargo release -TDC315 전송시에 multi로 BL을 보내기 위한 현 상태값을 가져온다. 
	  * 단순히 현 FOC 값을 가져와서 비교하고 TDC315를 보내기 위함
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchFocFlgForBlMultiSndRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchFocFlgForBlMultiSndRSQL").append("\n"); 
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
		query.append("SELECT MAX(B.FRT_CLT_FLG)  AS CRNT_FRT_CLT_FLG,     " ).append("\n"); 
		query.append("       MAX(B.OBL_RDEM_FLG) AS CRNT_OBL_RDEM_FLG,    " ).append("\n"); 
		query.append("       MAX(B.CSTMS_CLR_CD) AS CRNT_CSTMS_CLR_CD    " ).append("\n"); 
		query.append("  FROM BKG_CGO_RLSE A," ).append("\n"); 
		query.append("       BKG_CGO_RLSE_HIS B," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_BL C" ).append("\n"); 
		query.append(" WHERE A.BL_NO = @[bl_no]     /* 변수 치환 */" ).append("\n"); 
		query.append("   AND A.BL_NO = B.BL_NO(+)" ).append("\n"); 
		query.append("   AND B.HIS_SEQ = (SELECT DECODE(MAX(HIS_SEQ) - 1,0,1,MAX(HIS_SEQ) - 1)" ).append("\n"); 
		query.append("                      FROM BKG_CGO_RLSE_HIS" ).append("\n"); 
		query.append("                     WHERE BL_NO = @[bl_no]) /* 변수 치환 */" ).append("\n"); 
		query.append("   AND A.BL_NO  = C.BL_NO" ).append("\n"); 
		query.append("   AND C.CNT_CD = 'US'" ).append("\n"); 

	}
}