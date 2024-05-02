/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOmakeDiscHeadFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOmakeDiscHeadFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FlatFile Header 생성
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOmakeDiscHeadFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_cstms_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_dsch_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_cstms_prt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration").append("\n"); 
		query.append("FileName : Kor24CustomsTransmissionDBDAOmakeDiscHeadFlatFileRSQL").append("\n"); 
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
		query.append("        '9'   ||'~'||             /*  기능코드        */" ).append("\n"); 
		query.append("        @[mrn_no] ||'~'||         /*  MRN_NBR         */" ).append("\n"); 
		query.append("        'SMLM' ||'~'||            /*  SCAC            */" ).append("\n"); 
		query.append("        @[cstms_dsch_cd] ||'~'||  /*  선박 대리점 명  */" ).append("\n"); 
		query.append("        @[locl_cstms_cd] ||'~'||  /*  신고세관        */" ).append("\n"); 
		query.append("        @[locl_cstms_prt_cd]      /*  신고세관과      */" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}