/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOMakeFlatFileChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.03 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOMakeFlatFileChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MakeFlatFileChg
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOMakeFlatFileChgRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdata2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdata1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdata3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mcorr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT '{MODI_INFO'                           ||CHR(10)||    /*  Start of MODI Block       */" ).append("\n"); 
		query.append("'MODI_CORR_CD:' ||@[mcorr_cd]          ||CHR(10)||    /*  정정항목 부호                                      */" ).append("\n"); 
		query.append("'MODI_VVD:'     ||@[mdata1]            ||CHR(10)||    /*  운항정보 중 일괄 변경의 경우*/" ).append("\n"); 
		query.append("/* 일괄정정후 내역 */" ).append("\n"); 
		query.append("'MODI_FTX1:'    ||''                   ||CHR(10)||    /*  정정후 내역1                */" ).append("\n"); 
		query.append("'MODI_FTX2:'    ||FC2S(@[mdata2],'S')  ||CHR(10)||    /*  정정후 내역2                */" ).append("\n"); 
		query.append("'MODI_FTX3:'    ||FC2S(@[mdata3],'S')  ||CHR(10)||    /*  정정후 내역3                */" ).append("\n"); 
		query.append("'MODI_FTX4:'    ||''                   ||CHR(10)||    /*  정정후 내역4                */" ).append("\n"); 
		query.append("'}MODI_INFO'                           ||CHR(10) CORR_DATA" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customstransmission.korea.integration ").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOMakeFlatFileChgRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}