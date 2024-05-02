/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchEqInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusCustomsTransmissionDBDAOsearchEqInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 호주 위험물 세관 EQ정보 (컨테이너) 조회
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchEqInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration").append("\n"); 
		query.append("FileName : AusCustomsTransmissionDBDAOsearchEqInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append(" CNTR_NO AS EQ_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD AS EQ_TYPE" ).append("\n"); 
		query.append(",'5' FM_IND" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_CSTMS_DG " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("AND   VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND   PORT_CD         =  @[port_cd]" ).append("\n"); 
		query.append("AND	  CNT_CD ='AU'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CNTR_NO   " ).append("\n"); 

	}
}