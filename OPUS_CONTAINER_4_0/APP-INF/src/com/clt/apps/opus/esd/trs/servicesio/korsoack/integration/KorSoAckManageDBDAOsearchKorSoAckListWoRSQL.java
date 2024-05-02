/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorSoAckManageDBDAOsearchKorSoAckListWoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.korsoack.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorSoAckManageDBDAOsearchKorSoAckListWoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조건에 해당하는 TRS_TRSP_WRK_ORD에 데이타 여부
	  * </pre>
	  */
	public KorSoAckManageDBDAOsearchKorSoAckListWoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.korsoack.integration ").append("\n"); 
		query.append("FileName : KorSoAckManageDBDAOsearchKorSoAckListWoRSQL").append("\n"); 
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
		query.append("SELECT COUNT(TRSP_WO_OFC_CTY_CD) FROM TRS_TRSP_WRK_ORD" ).append("\n"); 
		query.append("WHERE	TRSP_WO_OFC_CTY_CD	 = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND		TRSP_WO_SEQ	 		= @[trsp_wo_seq]" ).append("\n"); 

	}
}