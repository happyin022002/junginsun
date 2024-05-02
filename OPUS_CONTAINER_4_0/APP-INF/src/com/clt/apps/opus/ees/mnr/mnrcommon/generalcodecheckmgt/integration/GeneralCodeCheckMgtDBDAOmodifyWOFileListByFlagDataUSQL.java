/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyWOFileListByFlagDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.12.15 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungBuebKwon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyWOFileListByFlagDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 플레그에 의한 파일체크
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyWOFileListByFlagDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyWOFileListByFlagDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DAT_VRFY A" ).append("\n"); 
		query.append("#if (${dmg_flag} == 'Y')" ).append("\n"); 
		query.append("SET INP_MSG4 = 'AF'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SET INP_MSG4 = 'AU'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND   A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("AND  (A.TMP_SEQ,A.TMP_DTL_SEQ) IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT B.TMP_SEQ,B.TMP_DTL_SEQ" ).append("\n"); 
		query.append("FROM MNR_DAT_VRFY B,MNR_EQ_STS C" ).append("\n"); 
		query.append("WHERE B.INP_MSG1 = C.EQ_NO(+)" ).append("\n"); 
		query.append("AND B.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND C.EQ_KND_CD = @[eq_type]" ).append("\n"); 
		query.append("#if (${dmg_flag} == 'Y')" ).append("\n"); 
		query.append("AND C.MNR_DMG_FLG = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND C.MNR_DMG_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}