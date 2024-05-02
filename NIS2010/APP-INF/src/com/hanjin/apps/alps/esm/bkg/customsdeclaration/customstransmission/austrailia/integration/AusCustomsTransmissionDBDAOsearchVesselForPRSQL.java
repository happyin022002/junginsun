/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AusCustomsTransmissionDBDAOsearchVesselForPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.22 
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

public class AusCustomsTransmissionDBDAOsearchVesselForPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 호주 항만청으로 전송할 Vessel 정보를 조회한다.
	  * </pre>
	  */
	public AusCustomsTransmissionDBDAOsearchVesselForPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_10",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.integration").append("\n"); 
		query.append("FileName : AusCustomsTransmissionDBDAOsearchVesselForPRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[pod_cd], 'AUSYD', DECODE( SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4), 'HNSF', SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,6,3)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'RWNB', SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,6,3)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'KSFL', SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,6,3)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'RXUB', SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,6,3)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD)," ).append("\n"); 
		query.append("'AUMEL', DECODE( SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4), 'HNSF', SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,6,3)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'RWNB', SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,6,3)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'KSFL', SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,6,3)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'RXUB', SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,6,3)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD)," ).append("\n"); 
		query.append("'AUBNE', DECODE( SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4), 'HNSF', SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,6,3)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'RWNB', SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,6,3)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'KSFL', SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,6,3)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'RXUB', SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,6,3)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD)," ).append("\n"); 
		query.append("DECODE( @[pol_cd], 'AUSYD' , DECODE( SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4),'HNSF',SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||(SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,5,2) + '5')||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,7,2)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'RWNB',SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||(SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,5,2) + '5')||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,7,2)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'KSFL',SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||(SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,5,2) + '5')||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,7,2)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'RXUB',SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||(SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,5,2) + '5')||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,7,2)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD)," ).append("\n"); 
		query.append("'AUMEL' , DECODE( SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4),'HNSF',SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||(SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,5,2) + '5')||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,7,2)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'RWNB',SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||(SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,5,2) + '5')||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,7,2)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'KSFL',SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||(SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,5,2) + '5')||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,7,2)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'RXUB',SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||(SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,5,2) + '5')||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,7,2)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD)," ).append("\n"); 
		query.append("'AUBNE' , DECODE( SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4),'HNSF',SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||(SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,5,2) + '5')||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,7,2)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'RWNB',SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||(SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,5,2) + '5')||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,7,2)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'KSFL',SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||(SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,5,2) + '5')||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,7,2)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("'RXUB',SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,1,4)||(SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,5,2) + '5')||SUBSTR(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD,7,2)||@[st_10]||@[st_9]," ).append("\n"); 
		query.append("VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD)," ).append("\n"); 
		query.append("VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD)) vvd_number" ).append("\n"); 
		query.append("FROM BKG_BOOKING B," ).append("\n"); 
		query.append("MDM_REP_CMDT COM," ).append("\n"); 
		query.append("MDM_COMMODITY CMD," ).append("\n"); 
		query.append("BKG_VVD VVD" ).append("\n"); 
		query.append("WHERE  VVD.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("AND VVD.POL_CD        = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '')" ).append("\n"); 
		query.append("AND VVD.POD_CD        = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.BKG_STS_CD           != 'X'" ).append("\n"); 
		query.append("AND B.BKG_STS_CD           != 'S'" ).append("\n"); 
		query.append("AND B.REP_CMDT_CD      = COM.REP_CMDT_CD(+)" ).append("\n"); 
		query.append("AND B.CMDT_CD 	= CMD.CMDT_CD(+)" ).append("\n"); 
		query.append("AND B.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 

	}
}