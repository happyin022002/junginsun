/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeMACAMDAmdCorrFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeMACAMDAmdCorrFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MACAMD Corr FlatFile
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeMACAMDAmdCorrFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kr_cstms_corr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOmakeMACAMDAmdCorrFlatFileRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    @[kr_cstms_corr_id]   ||'~'||                         /*  정정항목 부호               */" ).append("\n"); 
		query.append("    ''                    ||'~'||                         /*  운항정보 중 일괄 변경의 경우*//* 일괄정정후 내역 */" ).append("\n"); 
		query.append("	BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[crnt_ctnt1],1,35),'Y')    ||'~'||      /*  정정후 내역1      */" ).append("\n"); 
		query.append("	BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[crnt_ctnt1],36,35),'Y')   ||'~'||      /*  정정후 내역2      */" ).append("\n"); 
		query.append("	BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[crnt_ctnt1],71,35),'Y')   ||'~'||      /*  정정후 내역3      */" ).append("\n"); 
		query.append("    ''                    		                         /*  정정후 내역4                */" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}