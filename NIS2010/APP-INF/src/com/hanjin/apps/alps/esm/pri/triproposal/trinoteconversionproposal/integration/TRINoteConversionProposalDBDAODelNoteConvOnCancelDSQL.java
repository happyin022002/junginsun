/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRINoteConversionProposalDBDAODelNoteConvOnCancelDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.12.15 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRINoteConversionProposalDBDAODelNoteConvOnCancelDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cancel시 해당 Note Conv 삭제
	  * </pre>
	  */
	public TRINoteConversionProposalDBDAODelNoteConvOnCancelDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.integration").append("\n"); 
		query.append("FileName : TRINoteConversionProposalDBDAODelNoteConvOnCancelDSQL").append("\n"); 
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
		query.append("DELETE PRI_TRI_NOTE_CONV A" ).append("\n"); 
		query.append("WHERE EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("FROM PRI_TRI_RT B" ).append("\n"); 
		query.append("WHERE B.NOTE_CONV_MAPG_ID = A.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("AND B.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append("AND B.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}