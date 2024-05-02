/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDAOSearchMrnNoInKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.23 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOSearchMrnNoInKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMrnNoInKor
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOSearchMrnNoInKorRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT MRN_NO" ).append("\n"); 
		query.append(", MRN_CHK_NO" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", NVL(MAX(VVD_SEQ),0) VVD_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_VVD_SMRY" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append("AND PORT_CD = DECODE(@[in_bound], 'O', @[in_pol], @[in_pod])" ).append("\n"); 
		query.append("AND IO_BND_CD = @[in_bound]" ).append("\n"); 
		query.append("AND ((@[in_type] IN ('A','B','C','D') AND" ).append("\n"); 
		query.append("OB_DECL_TP_CD IN ('A','B','C','D')) OR" ).append("\n"); 
		query.append("(@[in_type] = 'N' AND OB_DECL_TP_CD = @[in_type]))" ).append("\n"); 
		query.append("GROUP BY MRN_NO, MRN_CHK_NO, IO_BND_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDAOSearchMrnNoInKorRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}