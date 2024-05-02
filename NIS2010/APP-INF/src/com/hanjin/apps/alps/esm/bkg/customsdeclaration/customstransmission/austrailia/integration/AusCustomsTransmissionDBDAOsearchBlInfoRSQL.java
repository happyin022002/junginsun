/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchBlInfoRSQL.java
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

public class AusCustomsTransmissionDBDAOsearchBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 호주 위험물 컨테이너 & bl 정보 조회
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchBlInfoRSQL(){
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
		query.append("FileName : AusCustomsTransmissionDBDAOsearchBlInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   BL_NO" ).append("\n"); 
		query.append("   , '' SHIPPING_REF" ).append("\n"); 
		query.append("   ,MAX(POL_CD) POL_CD" ).append("\n"); 
		query.append("   ,MAX(POD_CD) POD_CD" ).append("\n"); 
		query.append("   , @[d_type] AS D_TYPE" ).append("\n"); 
		query.append("   , @[vvd_cd] AS VVD_CD" ).append("\n"); 
		query.append("   , @[port_cd] AS PORT_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_DG A" ).append("\n"); 
		query.append("WHERE  A.DG_DECL_TP_CD  = @[d_type]" ).append("\n"); 
		query.append("AND   A.VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND   A.PORT_CD         =  @[port_cd]" ).append("\n"); 
		query.append("AND	  A.CNT_CD ='AU'" ).append("\n"); 
		query.append("GROUP BY BL_NO" ).append("\n"); 
		query.append("ORDER BY BL_NO   " ).append("\n"); 

	}
}